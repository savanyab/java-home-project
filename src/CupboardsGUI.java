import javax.swing.*;
import java.awt.*;

public class CupboardsGUI extends JPanel {
    private Cupboards cupboards;
    private Employees employees;
    private Glass glass;
    private FurniturePanels panels;

    private JSlider cupboardProductionSlide;

    public CupboardsGUI(Cupboards cupboards, Employees employees, Glass glass, FurniturePanels panels) {
        this.cupboards = cupboards;
        this.employees = employees;
        this.glass = glass;
        this.panels = panels;


        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));
        cupboardProductionSlide = new JSlider(0, 100);

        JLabel askCupboardsToProduce = new JLabel("Mennyi szekrényt állítsunk elő?");
        JLabel askSellingQuantity = new JLabel("Mennyi szekrényt próbáljunk eladni?");
        JLabel askSellingPrice = new JLabel("Mennyi legyen az eladási ár?");

        JSlider cupboardSellSlide = new JSlider(0, 100);
        JSlider cupboardSellingPrice = new JSlider(0, 100);

        JButton acceptProduction = new JButton("OK");
        JButton acceptSell = new JButton("OK");

        JTextArea cupboardInfo = new JTextArea();

        askCupboardsToProduce.setBounds(10, 10, 300, 20);
        askSellingQuantity.setBounds(10, 100, 300, 20);
        askSellingPrice.setBounds(10, 190, 300, 20);

        cupboardProductionSlide.setBounds(10, 35, 300, 40);
        cupboardSellSlide.setBounds(10, 130, 300, 40);
        cupboardSellingPrice.setBounds(10, 220, 300, 40);

        acceptProduction.setBounds(320, 37, 60, 25);
        acceptSell.setBounds(320, 220, 60, 25);

        cupboardInfo.setBounds(390, 40, 270, 200);
        cupboardInfo.setEditable(false);

        cupboardSellingPrice.setValue(0);

        acceptSell.setEnabled(false);
        cupboardSellSlide.setEnabled(false);

        cupboardProductionSlide.setValue(0);
        cupboardSellSlide.setValue(0);

        cupboardProductionSlide.setMinorTickSpacing(5);
        cupboardProductionSlide.setMajorTickSpacing(10);
        cupboardProductionSlide.setPaintTicks(true);
        cupboardProductionSlide.setPaintLabels(true);
        cupboardProductionSlide.setLabelTable(cupboardProductionSlide.createStandardLabels(10));

        cupboardProductionSlide.addChangeListener(e -> {
            cupboards.produce(cupboardProductionSlide.getValue());
            cupboardInfo.setText("Előállítandó szekrények száma: " + cupboards.getProducedPerMonth() +
                    "\nSzekrény raktárkészlet: " + cupboards.getCupboardStock()
            );
        });

        acceptProduction.addActionListener(e -> {
            cupboards.increaseStock();
            cupboards.reduceRawMaterials(cupboardProductionSlide.getValue(), panels, glass);
            cupboardInfo.setText("Előállított szekrények száma: " + cupboards.getProducedPerMonth() +
                    "\nSzekrény raktárkészlet: " + cupboards.getCupboardStock());
            cupboardProductionSlide.setEnabled(false);
            acceptProduction.setEnabled(false);
            cupboardSellSlide.setMaximum(cupboards.getCupboardStock());
            cupboardSellingPrice.setMaximum(cupboards.setMaxSellingPrice(panels, glass));
            cupboardSellSlide.setEnabled(true);
            cupboardSellingPrice.setEnabled(true);
            acceptSell.setEnabled(true);
        });

        cupboardSellSlide.addChangeListener(e -> {

            cupboardInfo.setText("Előállított szekrények száma: " + cupboards.producedPerMonth +
                            "\nSzekrény raktárkészlet: " + cupboards.getCupboardStock() +
                            "\nEladásra küldendő mennyiség: " + cupboardSellSlide.getValue() +
                            "\nEladási ár: " + cupboardSellingPrice.getValue()
            );
        });

        cupboardSellSlide.setMinorTickSpacing(5);
        cupboardSellSlide.setMajorTickSpacing(10);
        cupboardSellSlide.setPaintTicks(true);
        cupboardSellSlide.setPaintLabels(true);
        cupboardSellSlide.setLabelTable(cupboardSellSlide.createStandardLabels(10));

        cupboardSellingPrice.addChangeListener(e -> {
            cupboardInfo.setText("Előállított szekrények száma: " + cupboards.producedPerMonth +
                    "\nSzekrény raktárkészlet: " + cupboards.getCupboardStock() +
                    "\nEladásra küldendő mennyiség: " + cupboardSellSlide.getValue() +
                    "\nEladási ár: " + cupboardSellingPrice.getValue());
        });

        acceptSell.addActionListener(e -> {
            cupboardSellSlide.setEnabled(false);
            cupboardSellingPrice.setEnabled(false);
            acceptSell.setEnabled(false);
        });

        cupboardSellingPrice.setMinorTickSpacing(1000);
        cupboardSellingPrice.setMajorTickSpacing(5000);
        cupboardSellingPrice.setPaintTicks(true);
        cupboardSellingPrice.setPaintLabels(true);
        cupboardSellingPrice.setLabelTable(cupboardSellingPrice.createStandardLabels(5000));
        cupboardSellingPrice.setEnabled(false);


        add(askCupboardsToProduce);
        add(cupboardProductionSlide);
        add(askSellingQuantity);
        add(cupboardSellSlide);
        add(askSellingPrice);
        add(cupboardSellingPrice);
        add(acceptProduction);
        add(acceptSell);
        add(cupboardInfo);
    }

    public void recalculate() {
        cupboardProductionSlide.setMaximum(cupboards.setMaximumProducts(panels, glass, employees));
    }
}
