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
    private JTextArea allInfos = new JTextArea();

    public Window() {
        setTitle("FurnitureFactory");
        setSize(950, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        employeeGUI = new EmployeeGUI(this, employees);
        advertisementGUI = new AdvertisementGUI(this, ad);
        furniturePanelsGUI = new FurniturePanelsGUI(this, panels);
        glassGUI = new GlassGUI(this, glass);
        cupboardsGUI = new CupboardsGUI(this, cupboards, employees, glass, panels);

        startMonth();

        allInfos.setBounds(715, 40, 205, 300);
        allInfos.setEditable(false);

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
        companyInfo.setEditable(false);

        JButton acceptChanges = new JButton("Jóváhagyás");

        acceptChanges.addActionListener(e -> {
            increaseStocks();
            reduceStocks();
            cupboards.receiveIncomeOfSoldGoods();
            company.nextRound(employees, ad, panels, glass, cupboards);
            companyInfo.setText(company.toString(employees, cupboards, panels, glass, ad));
            if (company.getCapital() <= 0 || company.getCapital() >= 2000000) {
                endGame();
            } else {
                startMonth();
            }
        });

        tabbedPane.setBounds(0, 20, 700, 320);
        acceptChanges.setBounds(760, 370, 110, 25);

        add(companyInfo);
        add(tabbedPane);
        add(allInfos);
        add(acceptChanges);
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

    private void increaseStocks() {
        panels.increaseStock();
        glass.increaseStock();
        cupboards.increaseStock();
    }

    private void reduceStocks() {
        cupboards.setSoldQuantity(cupboardsGUI.getSellingQuantity(), ad);
        cupboards.reduceStock();
        cupboards.reduceRawMaterials(cupboards.producedPerMonth, panels, glass);
    }

    private void startMonth() {
        employeeGUI.startMonth();
        advertisementGUI.startMonth();
        cupboardsGUI.startMonth();
        glassGUI.startMonth();
        furniturePanelsGUI.startMonth();
        allInfos.setText("Döntések alapján várható költségek:" +
                "\n\nBérköltség: " +  employees.getWAGE() * employees.getEmployeeCount() +
                "\nReklámköltség: " + ad.getAdCount() * ad.getAdPrice() +
                "\nBútorlap vásárlás: " + 0 +
                "\nÜveg vásárlás: " + 0 +
                "\n\nÖsszesen: " + (employees.getWAGE() * employees.getEmployeeCount() + ad.getAdCount() * ad.getAdPrice()) +
                "\n\n\nMaximum bevétel: " + cupboardsGUI.showMaximumIncome());
    }

    public void setAllInfos() {
        int employeeExpenses = employees.getWAGE() * employees.getEmployeeCount();
        int adExpenses = ad.getAdCount() * ad.getAdPrice();
        int panelsExpenses = panels.getExpenses();
        int glassExpenses = glass.getExpenses();
        allInfos.setText("Döntések alapján várható költségek:" +
                "\n\nBérköltség: " +  + employeeExpenses +
                "\nReklámköltség: " + adExpenses +
                "\nBútorlap vásárlás: " + panelsExpenses +
                "\nÜveg vásárlás: " + glassExpenses +
                "\n\nÖsszesen: " + (employeeExpenses + adExpenses + panelsExpenses + glassExpenses) +
                "\n\n\nMaximum bevétel: " + cupboardsGUI.showMaximumIncome());
    }
}
