import javax.swing.*;

import java.awt.*;

public class Window extends JFrame {

    Company company = new Company();
    FurniturePanels panels = new FurniturePanels();
    Glass glass = new Glass();
    Employees employees = new Employees();
    Cupboards cupboards = new Cupboards();
    Advertisement ad = new Advertisement();

    public Window() {
        setTitle("FurnitureFactory");
        setSize(800, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 1));

        JLabel companyInfo = new JLabel();
        companyInfo.setText(company.toString(employees, cupboards, panels, glass, ad));

        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(new GridLayout(2, 2));

        JLabel askEmployeeCount = new JLabel();
        askEmployeeCount.setText("Hogyan változzon a létszám?");
        JSlider employeeCount = new JSlider(-employees.getEmployeeCount(), 20);
        employeeCount.setMinorTickSpacing(1);
        employeeCount.setMajorTickSpacing(5);
        employeeCount.setPaintTicks(true);
        employeeCount.setPaintLabels(true);
        employeeCount.setLabelTable(employeeCount.createStandardLabels(1));
        JButton confirmChange = new JButton("Jóváhagyás");

        JPanel adPanel = new JPanel();
        adPanel.setLayout(new GridLayout(2, 2));
        JLabel askAdCount = new JLabel();
        askAdCount.setText("Hogyan változzon a reklámok száma?");
        JSlider adCountChange = new JSlider(-ad.getAdCount(), 20);
        adCountChange.setMinorTickSpacing(1);
        adCountChange.setMajorTickSpacing(5);
        adCountChange.setPaintTicks(true);
        adCountChange.setPaintLabels(true);
        adCountChange.setLabelTable(employeeCount.createStandardLabels(1));
        JButton confirmAdChange = new JButton("Jóváhagyás");

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
        JButton confirmPanelPurchasePrice = new JButton("Jóváhagyás");

        JLabel askPanelsToBuy = new JLabel("Mennyi bútorlapot vegyünk?");
        JSlider setPanelQuantity = new JSlider(0, 100);
        setPanelQuantity.setMinorTickSpacing(5);
        setPanelQuantity.setMajorTickSpacing(10);
        setPanelQuantity.setPaintTicks(true);
        setPanelQuantity.setPaintLabels(true);
        setPanelQuantity.setLabelTable(setPanelQuantity.createStandardLabels(10));
        JButton confirmPanelQuantity = new JButton("Jóváhagyás");


        JPanel glassPanel = new JPanel();
        glassPanel.setLayout(new GridLayout(2, 2));
        JLabel askGlassPurchasePrice = new JLabel("Milyen áron szerezzünk be üveget?");
        JSlider changeGlassPurchasePrice = new JSlider(2500, 5000);
        changeGlassPurchasePrice.setMinorTickSpacing(100);
        changeGlassPurchasePrice.setMajorTickSpacing(1000);
        changeGlassPurchasePrice.setPaintTicks(true);
        changeGlassPurchasePrice.setPaintLabels(true);
        changeGlassPurchasePrice.setLabelTable(changePanelPurchasePrice.createStandardLabels(1000));
        JButton confirmGlassPurchasePrice = new JButton("Jóváhagyás");

        JPanel cupboardPanel = new JPanel();

        add(companyInfo);
        add(employeePanel);
        add(adPanel);
        add(furniturePanels);
        add(glassPanel);
        add(cupboardPanel);

        employeePanel.add(askEmployeeCount);
        employeePanel.add(employeeCount);
        employeePanel.add(confirmChange);

        adPanel.add(askAdCount);
        adPanel.add(adCountChange);
        adPanel.add(confirmAdChange);

        furniturePanels.add(askPanelPurchasePrice);
        furniturePanels.add(changePanelPurchasePrice);
        furniturePanels.add(confirmPanelPurchasePrice);
        furniturePanels.add(askPanelsToBuy);
        furniturePanels.add(setPanelQuantity);
        furniturePanels.add(confirmPanelQuantity);

        glassPanel.add(askGlassPurchasePrice);
        glassPanel.add(changeGlassPurchasePrice);
        glassPanel.add(confirmGlassPurchasePrice);
    }


}
