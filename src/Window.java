import javax.swing.*;

public class Window extends JFrame {

    private Company company = new Company();
    private Advertisement ad = new Advertisement();
    private Glass glass = new Glass();
    private Employees employees = new Employees();
    private FurniturePanels panels = new FurniturePanels();
    private Cupboards cupboards = new Cupboards();


    public Window() {
        setTitle("FurnitureFactory");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        EmployeeGUI employeeGUI = new EmployeeGUI(employees);
        AdvertisementGUI advertisementGUI = new AdvertisementGUI(ad);
        FurniturePanelsGUI furniturePanelsGUI = new FurniturePanelsGUI(panels);
        GlassGUI glassGUI = new GlassGUI(glass);
        CupboardsGUI cupboardsGUI = new CupboardsGUI(cupboards, employees, glass, panels);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Reklám", advertisementGUI);
        tabbedPane.add("Alkalmazottak", employeeGUI);
        tabbedPane.addTab("Bútorlapok", furniturePanelsGUI);
        tabbedPane.addTab("Üveg", glassGUI);
        tabbedPane.addTab("Szekrények", cupboardsGUI);

        JButton acceptChanges = new JButton("Jóváhagyás");
        acceptChanges.setEnabled(false);

        tabbedPane.setBounds(0, 20, 700, 320);
        acceptChanges.setBounds(280, 420, 110, 25);

        add(tabbedPane);
        add(acceptChanges);
    }


}
