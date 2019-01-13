import javax.swing.*;

import java.awt.*;

public class Window extends JFrame {

    Company company = new Company();



    public Window() {
        setTitle("FurnitureFactory");
        setSize(700, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        EmployeeGUI employeeGUI = new EmployeeGUI();
        AdvertisementGUI advertisementGUI = new AdvertisementGUI();
        FurniturePanelsGUI furniturePanelsGUI = new FurniturePanelsGUI();
        GlassGUI glassGUI = new GlassGUI();
        CupboardsGUI cupboardsGUI = new CupboardsGUI();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Bútorlapok", furniturePanelsGUI);
        tabbedPane.addTab("Üveg", glassGUI);
        tabbedPane.addTab("Szekrények", cupboardsGUI);


        employeeGUI.setBounds(0, 0, 800, 100);
        advertisementGUI.setBounds(0, 100, 800, 100);
        tabbedPane.setBounds(0, 200, 800, 400);

        add(employeeGUI);
        add(advertisementGUI);
        add(tabbedPane);



        JButton accept = new JButton("Jóváhagyás");
        //add(accept);

    }


}
