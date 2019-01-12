import javax.swing.*;
import java.awt.*;

public class FurniturePanelsGUI extends JPanel {

    FurniturePanels panels = new FurniturePanels();

    public FurniturePanelsGUI() {
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askPanelPurchasePrice = new JLabel();
        JSlider panelsPriceSlide = new JSlider(3000, 6000);
        JLabel askPanelsToBuy = new JLabel();
        JSlider panelsQuantitySlide = new JSlider(0, 100);
        JTextArea purchaseInfo = new JTextArea();


        askPanelPurchasePrice.setText("Milyen áron szerezzük be a bútorlapokat?");
        askPanelPurchasePrice.setBounds(10, 10, 300, 20);

        purchaseInfo.setText("Jelenlegi bútorlapkészlet: " + panels.getStock());

        panelsPriceSlide.setMinorTickSpacing(100);
        panelsPriceSlide.setMajorTickSpacing(1000);
        panelsPriceSlide.setPaintTicks(true);
        panelsPriceSlide.setPaintLabels(true);
        panelsPriceSlide.setLabelTable(panelsPriceSlide.createStandardLabels(1000));
        panelsPriceSlide.setBounds(10, 50, 300, 40);
        panelsPriceSlide.addChangeListener((e) -> {
            panels.setPanelPurchasePrice(panelsPriceSlide.getValue());
            purchaseInfo.setText("Jelenlegi bútorlapkészlet: " + panels.getStock() + "\n Beszerzési ár: " + panels.getPurchasePrice());

        });

        purchaseInfo.setBounds(10, 100, 610, 60);

        askPanelsToBuy.setText("Mennyi bútorlapot vegyünk?");
        askPanelsToBuy.setBounds(350, 10, 300, 20);

        panelsQuantitySlide.setMinorTickSpacing(5);
        panelsQuantitySlide.setMajorTickSpacing(10);
        panelsQuantitySlide.setPaintTicks(true);
        panelsQuantitySlide.setPaintLabels(true);
        panelsQuantitySlide.setLabelTable(panelsQuantitySlide.createStandardLabels(10));
        panelsQuantitySlide.setBounds(350, 50, 300, 40);

        add(askPanelPurchasePrice);
        add(panelsPriceSlide);
        add(purchaseInfo);
        add(askPanelsToBuy);
        add(panelsQuantitySlide);

    }
}
