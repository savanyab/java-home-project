import javax.swing.*;

import java.awt.*;

public class Window extends JFrame {

    Company company = new Company();

    Glass glass = new Glass();

    Cupboards cupboards = new Cupboards();

    public Window() {
        setTitle("FurnitureFactory");
        setSize(700, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);



        JPanel glassPanel = new JPanel();
        glassPanel.setLayout(new GridLayout(2, 2));
        JLabel askGlassPurchasePrice = new JLabel("Milyen áron szerezzünk be üveget?");
        JSlider changeGlassPurchasePrice = new JSlider(2500, 5000);
        changeGlassPurchasePrice.setMinorTickSpacing(100);
        changeGlassPurchasePrice.setMajorTickSpacing(1000);
        changeGlassPurchasePrice.setPaintTicks(true);
        changeGlassPurchasePrice.setPaintLabels(true);
        changeGlassPurchasePrice.setLabelTable(changeGlassPurchasePrice.createStandardLabels(1000));

        JLabel askGlassToBuy = new JLabel("Mennyi üveget vegyünk?");
        JSlider setGlassQuantity = new JSlider(0, 100);
        setGlassQuantity.setMinorTickSpacing(5);
        setGlassQuantity.setMajorTickSpacing(10);
        setGlassQuantity.setPaintTicks(true);
        setGlassQuantity.setPaintLabels(true);
        setGlassQuantity.setLabelTable(setGlassQuantity.createStandardLabels(10));

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


        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Bútorlapok", furniturePanelsGUI);

        employeeGUI.setBounds(0, 0, 800, 100);
        advertisementGUI.setBounds(0, 100, 800, 100);
        tabbedPane.setBounds(0, 200, 800, 300);
        add(employeeGUI);
        add(advertisementGUI);
        //add(furniturePanelsGUI);
        add(tabbedPane);


        //add(glassPanel);
        //add(cupboardPanel);



        glassPanel.add(askGlassPurchasePrice);
        glassPanel.add(changeGlassPurchasePrice);
        glassPanel.add(askGlassToBuy);
        glassPanel.add(setGlassQuantity);

        cupboardPanel.add(askCupboardsToProduce);
        cupboardPanel.add(setCupboardQuantity);
        cupboardPanel.add(askSellingPrice);
        cupboardPanel.add(setSellingPrice);

        JButton accept = new JButton("Jóváhagyás");
        //add(accept);

    }


}
