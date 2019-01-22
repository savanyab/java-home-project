import javax.swing.*;
import java.awt.*;

public class CupboardsGUI extends JPanel {
    private Cupboards cupboards;
    private Employees employees;
    private Glass glass;
    private FurniturePanels panels;

    private JSlider cupboardProductionSlide;
    private JSlider cupboardSellSlide;
    private JSlider cupboardSellingPrice;
    private JTextArea cupboardInfo;


    public CupboardsGUI(Window window, Cupboards cupboards, Employees employees, Glass glass, FurniturePanels panels) {
        this.cupboards = cupboards;
        this.employees = employees;
        this.glass = glass;
        this.panels = panels;

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));
        int maxProducts = cupboards.setMaximumProducts(panels, glass, employees);
        cupboardProductionSlide = new JSlider(0, maxProducts);

        JLabel askCupboardsToProduce = new JLabel("Mennyi szekrényt állítsunk elő?");
        JLabel askSellingQuantity = new JLabel("Mennyi szekrényt próbáljunk eladni?");
        JLabel askSellingPrice = new JLabel("Mennyi legyen az eladási ár?");

        cupboardSellSlide = new JSlider(0, 100);
        cupboardSellingPrice = new JSlider(0, 100);

        cupboardInfo = new JTextArea();

        askCupboardsToProduce.setBounds(10, 10, 300, 20);
        askSellingQuantity.setBounds(10, 100, 300, 20);
        askSellingPrice.setBounds(10, 190, 300, 20);

        askCupboardsToProduce.setToolTipText("Az alkalmazottak számától és a nyersanyagok mennyiségétől függ a maximum előállítható mennyiség.");
        askSellingQuantity.setToolTipText("Az aktuális hónapban előállított mennyiségen túl a régebbi készlet is árulható.");
        askSellingPrice.setToolTipText("Maximum eladási ár az előállítási költség 250%-a.");

        cupboardProductionSlide.setBounds(10, 35, 300, 40);
        cupboardSellSlide.setBounds(10, 130, 300, 40);
        cupboardSellingPrice.setBounds(10, 220, 300, 40);

        cupboardInfo.setBounds(390, 40, 270, 200);
        cupboardInfo.setEditable(false);

        cupboardProductionSlide.setMinorTickSpacing(10);
        cupboardProductionSlide.setMajorTickSpacing(50);
        cupboardProductionSlide.setPaintTicks(true);
        cupboardProductionSlide.setPaintLabels(true);
        cupboardProductionSlide.setLabelTable(cupboardProductionSlide.createStandardLabels(50));

        cupboardProductionSlide.addChangeListener(e -> {
            cupboardSellSlide.setMaximum(cupboards.setMaxSellableQuantity());
            cupboards.produce(cupboardProductionSlide.getValue());
            cupboardInfo.setText(infoText());
        });

        cupboardSellSlide.addChangeListener(e -> {
            window.setAllInfos();
            cupboardInfo.setText(infoText());
        });

        cupboardSellSlide.setMinorTickSpacing(10);
        cupboardSellSlide.setMajorTickSpacing(50);
        cupboardSellSlide.setPaintTicks(true);
        cupboardSellSlide.setPaintLabels(true);
        cupboardSellSlide.setLabelTable(cupboardSellSlide.createStandardLabels(50));

        cupboardSellingPrice.addChangeListener(e -> {
            window.setAllInfos();
            cupboards.decideSellingPrice(cupboardSellingPrice.getValue());
            cupboardInfo.setText(infoText());
        });

        cupboardSellingPrice.setMinorTickSpacing(1000);
        cupboardSellingPrice.setMajorTickSpacing(5000);
        cupboardSellingPrice.setPaintTicks(true);
        cupboardSellingPrice.setPaintLabels(true);
        cupboardSellingPrice.setLabelTable(cupboardSellingPrice.createStandardLabels(10000));


        add(askCupboardsToProduce);
        add(cupboardProductionSlide);
        add(askSellingQuantity);
        add(cupboardSellSlide);
        add(askSellingPrice);
        add(cupboardSellingPrice);
        add(cupboardInfo);
    }

    public void recalculate() {
        cupboardProductionSlide.setMaximum(cupboards.setMaximumProducts(panels, glass, employees));
        cupboardSellingPrice.setMaximum(cupboards.setMaxSellingPrice(panels, glass));
        cupboardSellSlide.setMaximum(cupboards.setMaxSellableQuantity());
    }

    public int getSellingQuantity() { return cupboardSellSlide.getValue(); }

    public void startMonth() {
        cupboardProductionSlide.setValue(0);
        cupboardSellSlide.setValue(0);
        cupboardSellingPrice.setValue(0);
        cupboardInfo.setText(infoText());
    }

    private String infoText() {
        return String.format("Előállított szekrények száma: %,4d" +
                "\nSzekrény raktárkészlet: %,5d"  +
                "\nEladásra küldendő mennyiség: %,5d"  +
                "\nEladási ár: %,5d",
                cupboards.producedPerMonth, cupboards.getDecidedStock(), cupboardSellSlide.getValue(), cupboards.sellingPrice);
    }

    public int showMaximumIncome() {
        return cupboardSellSlide.getValue() * cupboardSellingPrice.getValue();
    }
}
