import javax.swing.*;

public class Window extends JFrame {

    private Company company = new Company();
    private Advertisement ad = new Advertisement();
    private Glass glass = new Glass();
    private Employees employees = new Employees();
    private FurniturePanels panels = new FurniturePanels();
    private Cupboards cupboards = new Cupboards();
    private static int decisionCount;
    private JButton acceptChanges;

    public Window() {
        setTitle("FurnitureFactory");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        EmployeeGUI employeeGUI = new EmployeeGUI(this, employees);
        AdvertisementGUI advertisementGUI = new AdvertisementGUI(this, ad);
        FurniturePanelsGUI furniturePanelsGUI = new FurniturePanelsGUI(this, panels);
        GlassGUI glassGUI = new GlassGUI(this, glass);
        CupboardsGUI cupboardsGUI = new CupboardsGUI(this, cupboards, employees, glass, panels);

        JTextArea companyInfo = new JTextArea();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Reklám", advertisementGUI);
        tabbedPane.add("Alkalmazottak", employeeGUI);
        tabbedPane.addTab("Bútorlapok", furniturePanelsGUI);
        tabbedPane.addTab("Üveg", glassGUI);

        tabbedPane.addTab("Szekrények", cupboardsGUI);
        tabbedPane.addChangeListener(e -> {cupboardsGUI.recalculate();});

        companyInfo.setText(company.toString(employees, cupboards, panels, glass, ad));
        companyInfo.setBounds(0, 350, 700, 50);

        acceptChanges = new JButton("Jóváhagyás");
        acceptChanges.setEnabled(false);

        acceptChanges.addActionListener(e -> {

        });

        tabbedPane.setBounds(0, 20, 700, 320);
        acceptChanges.setBounds(280, 420, 110, 25);

        add(companyInfo);
        add(tabbedPane);
        add(acceptChanges);
    }

    public void increaseDecisionCount() { decisionCount++; }

    public void enableAcceptChanges() {
       if (decisionCount == 6) {
           acceptChanges.setEnabled(true);
       }
    }

}
