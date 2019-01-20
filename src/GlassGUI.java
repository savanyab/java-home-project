import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GlassGUI extends JPanel {
    private JSlider glassPriceSlide;
    private JSlider glassQuantitySlide;
    private JTextArea purchaseInfo;


    public GlassGUI(Glass glass) {

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askGlassPurchasePrice = new JLabel("Milyen áron szerezzünk be üveget?");
        glassPriceSlide = new JSlider(2500, 5000);
        JLabel askGlassToBuy = new JLabel("Mennyi üveget vegyünk?");
        glassQuantitySlide = new JSlider(0, 100);
        purchaseInfo = new JTextArea();

        glass.setPurchasePrice(glassPriceSlide.getValue());

        ChangeListener changeListener = e -> {
            int decidedQuantity = glassQuantitySlide.getValue();
            int decidedPrice = glassPriceSlide.getValue();
            glass.purchase(decidedQuantity);
            glass.setGlassPurchasePrice(decidedPrice);
            glass.setExpenses(decidedPrice, decidedQuantity);
            purchaseInfo.setText("Jelenlegi üvegkészlet: " + glass.getStock() +
                    "\nBeszerzési ár: " + glass.getPurchasePrice() +
                    "\nVásárolni kívánt mennyiség: " + glassQuantitySlide.getValue() +
                    "\nVásárlás utáni készlet:" + glass.getDecidedStock() +
                    "\nVásárlás költsége: " + glass.getExpenses());
        };

        glassQuantitySlide.setValue(0);
        askGlassPurchasePrice.setBounds(10, 10, 300, 20);
        askGlassToBuy.setBounds(10, 120, 300, 40);

        purchaseInfo.setText("Jelenlegi üvegkészlet: " + glass.getStock() +
                "\nBeszerzési ár: " + glassPriceSlide.getValue() +
                "\nVásárolni kívánt mennyiség: " + glassQuantitySlide.getValue() +
                "\nVásárlás költsége: " + (glass.getExpenses()));
        purchaseInfo.setEditable(false);
        purchaseInfo.setBounds(390, 10, 270, 80);

        glassPriceSlide.setMinorTickSpacing(100);
        glassPriceSlide.setMajorTickSpacing(1000);
        glassPriceSlide.setPaintTicks(true);
        glassPriceSlide.setPaintLabels(true);
        glassPriceSlide.setLabelTable(glassPriceSlide.createStandardLabels(1000));
        glassPriceSlide.setBounds(10, 50, 300, 40);

        glassPriceSlide.addChangeListener(changeListener);

        glassQuantitySlide.setMinorTickSpacing(5);
        glassQuantitySlide.setMajorTickSpacing(10);
        glassQuantitySlide.setPaintTicks(true);
        glassQuantitySlide.setPaintLabels(true);
        glassQuantitySlide.setLabelTable(glassQuantitySlide.createStandardLabels(10));
        glassQuantitySlide.setBounds(10, 180, 300, 40);

        glassQuantitySlide.addChangeListener(changeListener);

        add(askGlassPurchasePrice);
        add(glassPriceSlide);
        add(askGlassToBuy);
        add(glassQuantitySlide);
        add(purchaseInfo);

    }

}
