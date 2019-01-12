import javax.swing.*;
import java.awt.*;

public class FurniturePanelsGUI extends JPanel {

    public FurniturePanelsGUI() {
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askPanelPurchasePrice = new JLabel();
        JSlider panelsPriceSlide = new JSlider(3000, 6000);
        JLabel askPanelsToBuy = new JLabel();
        JSlider panelsQuantitySlide = new JSlider(0, 100);
        JTextArea purchaseInfo = new JTextArea();
        JTextArea stockInfo = new JTextArea();
        JButton acceptPrice = new JButton("Ár jóváhagyása");
        JButton acceptQuantity = new JButton("Mennyiség jóváhagyása");
        FurniturePanels panels = new FurniturePanels(panelsPriceSlide.getValue());



        askPanelPurchasePrice.setText("Milyen áron szerezzük be a bútorlapokat?");
        askPanelPurchasePrice.setBounds(10, 10, 300, 20);


        purchaseInfo.setText("Jelenlegi bútorlapkészlet: " + panels.getStock() + "\n Beszerzési ár: " + panelsPriceSlide.getValue());
        purchaseInfo.setEditable(false);
        purchaseInfo.setBounds(10, 100, 300, 60);

        panelsPriceSlide.setMinorTickSpacing(100);
        panelsPriceSlide.setMajorTickSpacing(1000);
        panelsPriceSlide.setPaintTicks(true);
        panelsPriceSlide.setPaintLabels(true);
        panelsPriceSlide.setLabelTable(panelsPriceSlide.createStandardLabels(1000));
        panelsPriceSlide.setBounds(10, 50, 300, 40);

        panelsPriceSlide.addChangeListener((e) -> {
            panels.setPanelPurchasePrice(panelsPriceSlide.getValue());
            purchaseInfo.setText("Jelenlegi bútorlapkészlet: " + panels.getStock() + "\nBeszerzési ár: " + panels.getPurchasePrice());

        });


        askPanelsToBuy.setText("Mennyi bútorlapot vegyünk?");
        askPanelsToBuy.setBounds(350, 10, 300, 20);

        stockInfo.setBounds(350, 100, 300, 60);
        stockInfo.setEditable(false);

        panelsQuantitySlide.setMinorTickSpacing(5);
        panelsQuantitySlide.setMajorTickSpacing(10);
        panelsQuantitySlide.setPaintTicks(true);
        panelsQuantitySlide.setPaintLabels(true);
        panelsQuantitySlide.setLabelTable(panelsQuantitySlide.createStandardLabels(10));
        panelsQuantitySlide.setBounds(350, 50, 300, 40);


        panelsQuantitySlide.addChangeListener((e) -> {
            panels.purchase(panelsQuantitySlide.getValue());
            panels.setExpenses(panelsQuantitySlide.getValue());
            stockInfo.setText("Vásárolt mennyiség: " + panels.getPurchasedQuantity() + "\nVásárlás költsége: " + panels.getExpenses());
        });

        acceptPrice.setBounds(10, 200, 200, 30);
        acceptPrice.addActionListener((e) -> {
            panelsPriceSlide.setEnabled(false);
            acceptPrice.setEnabled(false);
        });

        acceptQuantity.setBounds(350, 200, 200, 30);
        acceptQuantity.addActionListener((e) -> {
            panelsQuantitySlide.setEnabled(false);
            acceptQuantity.setEnabled(false);
            panels.setStock();
            stockInfo.setText("Vásárolt mennyiség: " + panels.getPurchasedQuantity() + "\nVásárlás költsége: " + panels.getExpenses() + "\nBútorlap készlet: " + panels.getStock());
        });



        add(askPanelPurchasePrice);
        add(panelsPriceSlide);
        add(purchaseInfo);
        add(askPanelsToBuy);
        add(stockInfo);
        add(panelsQuantitySlide);
        add(acceptPrice);
        add(acceptQuantity);

    }
}
