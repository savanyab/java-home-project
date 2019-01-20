import javax.swing.*;

public class Window extends JFrame {

    private Company company = new Company();
    private Advertisement ad = new Advertisement();
    private Glass glass = new Glass();
    private Employees employees = new Employees();
    private FurniturePanels panels = new FurniturePanels();
    private Cupboards cupboards = new Cupboards();
    private EmployeeGUI employeeGUI;
    private AdvertisementGUI advertisementGUI;
    private FurniturePanelsGUI furniturePanelsGUI;
    private GlassGUI glassGUI;
    private CupboardsGUI cupboardsGUI;

    public Window() {
        setTitle("FurnitureFactory");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        employeeGUI = new EmployeeGUI(employees);
        advertisementGUI = new AdvertisementGUI(ad);
        furniturePanelsGUI = new FurniturePanelsGUI(panels);
        glassGUI = new GlassGUI(glass);
        cupboardsGUI = new CupboardsGUI(cupboards, employees, glass, panels, ad);

        JTextArea companyInfo = new JTextArea();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Reklám", advertisementGUI);
        tabbedPane.add("Alkalmazottak", employeeGUI);
        tabbedPane.add("Bútorlapok", furniturePanelsGUI);
        tabbedPane.add("Üveg", glassGUI);

        tabbedPane.add("Szekrények", cupboardsGUI);
        tabbedPane.addChangeListener(e -> {cupboardsGUI.recalculate();});

        companyInfo.setText(company.toString(employees, cupboards, panels, glass, ad));
        companyInfo.setBounds(0, 350, 700, 50);

        JButton acceptChanges = new JButton("Jóváhagyás");

        acceptChanges.addActionListener(e -> {
            panels.increaseStock();
            glass.increaseStock();
            company.nextRound(employees, ad, panels, glass, cupboards);
            companyInfo.setText(company.toString(employees, cupboards, panels, glass, ad));
            if (company.getCapital() <= 0 || company.getCapital() >= 2000000) {
                endGame();
            } else {
                enableDecisions();
            }
        });

        tabbedPane.setBounds(0, 20, 700, 320);
        acceptChanges.setBounds(280, 420, 110, 25);

        add(companyInfo);
        add(tabbedPane);
        add(acceptChanges);
    }

    private void enableDecisions() {
        employeeGUI.enableDecisions();
        cupboardsGUI.enableDecisions();
        furniturePanelsGUI.enableDecisions();
        glassGUI.enableDecisions();
        advertisementGUI.enableDecisions();
    }

    private int exitOrRestart() {
        String[] options = {"Igen", "Nem"};
        return JOptionPane.showOptionDialog(null,
                "Szeretnél új játékot kezdeni?",
                "Játék vége",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options, null);
    }

    private void endGame() {
        int decision = exitOrRestart();
        if (decision == 1) {
            dispose();
        } else {
            dispose();
            Company.setRound(1);
            Window window = new Window();
            window.setVisible(true);
        }
    }
}
