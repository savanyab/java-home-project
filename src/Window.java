import javax.swing.*;

import java.awt.*;

public class Window extends JFrame {

    Company company = new Company();



    public Window() {
        setTitle("FurnitureFactory");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        EmployeeGUI employeeGUI = new EmployeeGUI();
        AdvertisementGUI advertisementGUI = new AdvertisementGUI();
        FurniturePanelsGUI furniturePanelsGUI = new FurniturePanelsGUI();
        GlassGUI glassGUI = new GlassGUI();
        CupboardsGUI cupboardsGUI = new CupboardsGUI();

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
