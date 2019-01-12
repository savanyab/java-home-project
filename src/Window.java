import javax.swing.*;

import java.awt.*;

public class Window extends JFrame {

    Company company = new Company();

    Cupboards cupboards = new Cupboards();

    public Window() {
        setTitle("FurnitureFactory");
        setSize(700, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        JPanel cupboardPanel = new JPanel();
        cupboardPanel.setLayout(new GridLayout(2, 2));
        JLabel askCupboardsToProduce = new JLabel("Mennyi szekrényt állítsunk elő?");
        JSlider setCupboardQuantity = new JSlider(0, 100);
        setCupboardQuantity.setMinorTickSpacing(5);
        setCupboardQuantity.setMajorTickSpacing(10);
        setCupboardQuantity.setPaintTicks(true);
        setCupboardQuantity.setPaintLabels(true);
        setCupboardQuantity.setLabelTable(setCupboardQuantity.createStandardLabels(10));

        JLabel askSellingPrice = new JLabel("Mennyi szekrényt próbáljunk eladni?");
        JSlider setSellingPrice = new JSlider(0, 100);
        setSellingPrice.setMinorTickSpacing(5);
        setSellingPrice.setMajorTickSpacing(10);
        setSellingPrice.setPaintTicks(true);
        setSellingPrice.setPaintLabels(true);
        setSellingPrice.setLabelTable(setSellingPrice.createStandardLabels(10));

        EmployeeGUI employeeGUI = new EmployeeGUI();
        AdvertisementGUI advertisementGUI = new AdvertisementGUI();
        FurniturePanelsGUI furniturePanelsGUI = new FurniturePanelsGUI();
        GlassGUI glassGUI = new GlassGUI();


        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Bútorlapok", furniturePanelsGUI);
        tabbedPane.addTab("Üveg", glassGUI);


        employeeGUI.setBounds(0, 0, 800, 100);
        advertisementGUI.setBounds(0, 100, 800, 100);
        tabbedPane.setBounds(0, 200, 800, 300);
        add(employeeGUI);
        add(advertisementGUI);
        add(tabbedPane);

        cupboardPanel.add(askCupboardsToProduce);
        cupboardPanel.add(setCupboardQuantity);
        cupboardPanel.add(askSellingPrice);
        cupboardPanel.add(setSellingPrice);

        JButton accept = new JButton("Jóváhagyás");
        //add(accept);

    }


}
