import javax.swing.*;

import java.awt.*;

public class Window extends JFrame {

    Company company = new Company();
    FurniturePanels panels = new FurniturePanels();
    Glass glass = new Glass();

    Cupboards cupboards = new Cupboards();

    public Window() {
        setTitle("FurnitureFactory");
        setSize(800, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 1));



        JPanel furniturePanels = new JPanel();
        furniturePanels.setLayout(new GridLayout(2,2));
        JLabel askPanelPurchasePrice = new JLabel();
        askPanelPurchasePrice.setText("Milyen áron szerezzük be a bútorlapokat?");

        JSlider changePanelPurchasePrice = new JSlider(3000, 6000);
        changePanelPurchasePrice.setMinorTickSpacing(100);
        changePanelPurchasePrice.setMajorTickSpacing(1000);
        changePanelPurchasePrice.setPaintTicks(true);
        changePanelPurchasePrice.setPaintLabels(true);
        changePanelPurchasePrice.setLabelTable(changePanelPurchasePrice.createStandardLabels(1000));

        JLabel askPanelsToBuy = new JLabel("Mennyi bútorlapot vegyünk?");
        JSlider setPanelQuantity = new JSlider(0, 100);
        setPanelQuantity.setMinorTickSpacing(5);
        setPanelQuantity.setMajorTickSpacing(10);
        setPanelQuantity.setPaintTicks(true);
        setPanelQuantity.setPaintLabels(true);
        setPanelQuantity.setLabelTable(setPanelQuantity.createStandardLabels(10));

        JPanel glassPanel = new JPanel();
        glassPanel.setLayout(new GridLayout(2, 2));
        JLabel askGlassPurchasePrice = new JLabel("Milyen áron szerezzünk be üveget?");
        JSlider changeGlassPurchasePrice = new JSlider(2500, 5000);
        changeGlassPurchasePrice.setMinorTickSpacing(100);
        changeGlassPurchasePrice.setMajorTickSpacing(1000);
        changeGlassPurchasePrice.setPaintTicks(true);
        changeGlassPurchasePrice.setPaintLabels(true);
        changeGlassPurchasePrice.setLabelTable(changePanelPurchasePrice.createStandardLabels(1000));

        JLabel askGlassToBuy = new JLabel("Mennyi üveget vegyünk?");
        JSlider setGlassQuantity = new JSlider(0, 100);
        setGlassQuantity.setMinorTickSpacing(5);
        setGlassQuantity.setMajorTickSpacing(10);
        setGlassQuantity.setPaintTicks(true);
        setGlassQuantity.setPaintLabels(true);
        setGlassQuantity.setLabelTable(setPanelQuantity.createStandardLabels(10));

        JPanel cupboardPanel = new JPanel();
        cupboardPanel.setLayout(new GridLayout(2, 2));
        JLabel askCupboardsToProduce = new JLabel("Mennyi szekrényt állítsunk elő?");
        JSlider setCupboardQuantity = new JSlider(0, 100);
        setCupboardQuantity.setMinorTickSpacing(5);
        setCupboardQuantity.setMajorTickSpacing(10);
        setCupboardQuantity.setPaintTicks(true);
        setCupboardQuantity.setPaintLabels(true);
        setCupboardQuantity.setLabelTable(setPanelQuantity.createStandardLabels(10));

        JLabel askSellingPrice = new JLabel("Mennyi szekrényt próbáljunk eladni?");
        JSlider setSellingPrice = new JSlider(0, 100);
        setSellingPrice.setMinorTickSpacing(5);
        setSellingPrice.setMajorTickSpacing(10);
        setSellingPrice.setPaintTicks(true);
        setSellingPrice.setPaintLabels(true);
        setSellingPrice.setLabelTable(setPanelQuantity.createStandardLabels(10));

        EmployeeGUI employeeGUI = new EmployeeGUI();
        add(employeeGUI);

        AdvertisementGUI advertisementGUI = new AdvertisementGUI();
        add(advertisementGUI);


        add(furniturePanels);
        add(glassPanel);
        add(cupboardPanel);

        furniturePanels.add(askPanelPurchasePrice);
        furniturePanels.add(changePanelPurchasePrice);
        furniturePanels.add(askPanelsToBuy);
        furniturePanels.add(setPanelQuantity);

        glassPanel.add(askGlassPurchasePrice);
        glassPanel.add(changeGlassPurchasePrice);
        glassPanel.add(askGlassToBuy);
        glassPanel.add(setGlassQuantity);

        cupboardPanel.add(askCupboardsToProduce);
        cupboardPanel.add(setCupboardQuantity);
        cupboardPanel.add(askSellingPrice);
        cupboardPanel.add(setSellingPrice);

        JButton accept = new JButton("Jóváhagyás");
        add(accept);

    }


}
