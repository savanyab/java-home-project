import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GlassGUI extends JPanel {
    private JSlider glassPriceSlide;
    private JSlider glassQuantitySlide;
    private JTextArea purchaseInfo;
    private Glass glass;

    public GlassGUI(Window window, Glass glass) {
        this.glass = glass;
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askGlassPurchasePrice = new JLabel("Milyen áron szerezzünk be üveget?");
        glassPriceSlide = new JSlider(2500, 5000);
        JLabel askGlassToBuy = new JLabel("Mennyi üveget vegyünk?");
        glassQuantitySlide = new JSlider(0, 1000);
        purchaseInfo = new JTextArea();

        glass.setPurchasePrice(glassPriceSlide.getValue());

        ChangeListener changeListener = e -> {
            window.setAllInfos();
            int decidedQuantity = glassQuantitySlide.getValue();
            int decidedPrice = glassPriceSlide.getValue();
            glass.purchase(decidedQuantity);
            glass.setPurchasePrice(decidedPrice);
            glass.setExpenses(decidedPrice, decidedQuantity);
            purchaseInfo.setText(infoText());
        };

        askGlassPurchasePrice.setBounds(10, 10, 300, 20);
        askGlassToBuy.setBounds(10, 120, 300, 40);

        askGlassPurchasePrice.setToolTipText("A beszerzési ár a bútorok előállítási költségén keresztül befolyásolja a maximum eladási árat.");
        askGlassToBuy.setToolTipText("Egy egység szekrény előállításához 1 egység üveg szükséges.");
        purchaseInfo.setText(infoText());
        purchaseInfo.setEditable(false);
        purchaseInfo.setBounds(390, 10, 270, 80);

        glassPriceSlide.setMinorTickSpacing(100);
        glassPriceSlide.setMajorTickSpacing(1000);
        glassPriceSlide.setPaintTicks(true);
        glassPriceSlide.setPaintLabels(true);
        glassPriceSlide.setLabelTable(glassPriceSlide.createStandardLabels(1000));
        glassPriceSlide.setBounds(10, 50, 300, 40);

        glassPriceSlide.addChangeListener(changeListener);

        glassQuantitySlide.setMinorTickSpacing(100);
        glassQuantitySlide.setMajorTickSpacing(500);
        glassQuantitySlide.setPaintTicks(true);
        glassQuantitySlide.setPaintLabels(true);
        glassQuantitySlide.setLabelTable(glassQuantitySlide.createStandardLabels(100));
        glassQuantitySlide.setBounds(10, 180, 300, 40);

        glassQuantitySlide.addChangeListener(changeListener);

        add(askGlassPurchasePrice);
        add(glassPriceSlide);
        add(askGlassToBuy);
        add(glassQuantitySlide);
        add(purchaseInfo);

    }

    private String infoText() {
        return String.format("Jelenlegi üvegkészlet: %,4d" +
                "\nBeszerzési ár: %,5d" +
                "\nVásárolni kívánt mennyiség: %,4d" +
                "\nVásárlás utáni készlet: %,4d" +
                "\nVásárlás költsége: %,5d",
                glass.getStock(),
                glass.getPurchasePrice(),
                glassQuantitySlide.getValue(),
                glass.getDecidedStock(),
                glass.getExpenses());
    }

    public void startMonth() {
        glassQuantitySlide.setValue(0);
        glassPriceSlide.setValue(0);
        purchaseInfo.setText(infoText());
    }
}
