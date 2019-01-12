import javax.swing.*;
import java.awt.*;

public class GlassGUI extends JPanel {

    public GlassGUI() {

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askGlassPurchasePrice = new JLabel("Milyen áron szerezzünk be üveget?");
        JSlider glassPriceSlide = new JSlider(2500, 5000);
        JLabel askGlassToBuy = new JLabel("Mennyi üveget vegyünk?");
        JSlider glassQuantitySlide = new JSlider(0, 100);
        JTextArea purchaseInfo = new JTextArea();
        JTextArea stockInfo = new JTextArea();

        Glass glass = new Glass(glassPriceSlide.getValue());

        askGlassPurchasePrice.setBounds(10, 10, 300, 20);

        askGlassToBuy.setBounds(350, 10, 300, 20);

        purchaseInfo.setText("Jelenlegi üvegkészlet: " + glass.getStock() + "\n Beszerzési ár: " + glassPriceSlide.getValue());
        purchaseInfo.setEditable(false);
        purchaseInfo.setBounds(10, 100, 300, 60);

        stockInfo.setBounds(350, 100, 300, 60);
        stockInfo.setEditable(false);

        glassPriceSlide.setMinorTickSpacing(100);
        glassPriceSlide.setMajorTickSpacing(1000);
        glassPriceSlide.setPaintTicks(true);
        glassPriceSlide.setPaintLabels(true);
        glassPriceSlide.setLabelTable(glassPriceSlide.createStandardLabels(1000));
        glassPriceSlide.setBounds(10, 50, 300, 40);

        glassPriceSlide.addChangeListener((e) -> {
            glass.setGlassPurchasePrice(glassPriceSlide.getValue());
            purchaseInfo.setText("Jelenlegi üvegkészlet: " + glass.getStock() + "\nBeszerzési ár: " + glass.getPurchasePrice());

        });

        glassQuantitySlide.setMinorTickSpacing(5);
        glassQuantitySlide.setMajorTickSpacing(10);
        glassQuantitySlide.setPaintTicks(true);
        glassQuantitySlide.setPaintLabels(true);
        glassQuantitySlide.setLabelTable(glassQuantitySlide.createStandardLabels(10));
        glassQuantitySlide.setBounds(350, 50, 300, 40);

        glassQuantitySlide.addChangeListener((e) -> {
            glass.purchase(glassQuantitySlide.getValue());
            glass.setExpenses(glassQuantitySlide.getValue());
            stockInfo.setText("Vásárolt mennyiség: " + glass.getPurchasedQuantity() + "\nVásárlás költsége: " + glass.getExpenses());
        });

        add(askGlassPurchasePrice);
        add(glassPriceSlide);
        add(askGlassToBuy);
        add(glassQuantitySlide);
        add(purchaseInfo);
        add(stockInfo);


    }

}
