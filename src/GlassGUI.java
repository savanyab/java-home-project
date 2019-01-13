import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GlassGUI extends JPanel {
    private ChangeListener changeListener;

    public GlassGUI() {

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askGlassPurchasePrice = new JLabel("Milyen áron szerezzünk be üveget?");
        JSlider glassPriceSlide = new JSlider(2500, 5000);
        JLabel askGlassToBuy = new JLabel("Mennyi üveget vegyünk?");
        JSlider glassQuantitySlide = new JSlider(0, 100);
        JTextArea purchaseInfo = new JTextArea();
        JButton acceptPurchase = new JButton("Vásárlás jóváhagyása");

        Glass glass = new Glass(glassPriceSlide.getValue());

        changeListener = e -> {
            glass.purchase(glassQuantitySlide.getValue());
            glass.setGlassPurchasePrice(glassPriceSlide.getValue());
            glass.setExpenses(glassPriceSlide.getValue() * glassQuantitySlide.getValue());
            purchaseInfo.setText("Jelenlegi üvegkészlet: " + glass.getStock() +
                    "\nBeszerzési ár: " + glass.getPurchasePrice() +
                    "\nVásárolni kívánt mennyiség: " + glassQuantitySlide.getValue() +
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
        purchaseInfo.setBounds(350, 10, 270, 80);

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

        acceptPurchase.setBounds(380, 200, 200, 30);
        acceptPurchase.addActionListener((e) -> {
            glassQuantitySlide.setEnabled(false);
            glassPriceSlide.setEnabled(false);
            acceptPurchase.setEnabled(false);
            glass.setStock();
            purchaseInfo.setText(
                    "Üveg készlet: " + glass.getStock() +
                            "\nBeszerzési ár: " + glass.getPurchasePrice() +
                            "\nVásárolt mennyiség: " + glass.getPurchasedQuantity() +
                            "\nVásárlás költsége: " + glass.getExpenses()
            );
        });

        add(askGlassPurchasePrice);
        add(glassPriceSlide);
        add(askGlassToBuy);
        add(glassQuantitySlide);
        add(purchaseInfo);
        add(acceptPurchase);



    }

}
