import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class FurniturePanelsGUI extends JPanel {
    private ChangeListener changeListener;
    private Window window;
    private JSlider panelsPriceSlide;
    private JSlider panelsQuantitySlide;
    private JButton acceptPurchase;
    private JTextArea purchaseInfo;

    public FurniturePanelsGUI(Window window, FurniturePanels panels) {
        this.window = window;
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askPanelPurchasePrice = new JLabel();
        panelsPriceSlide = new JSlider(3000, 6000);
        JLabel askPanelsToBuy = new JLabel();
        panelsQuantitySlide = new JSlider(0, 100);
        purchaseInfo = new JTextArea();
        acceptPurchase = new JButton("Vásárlás jóváhagyása");

        panels.setPurchasePrice(panelsPriceSlide.getValue());


        askPanelPurchasePrice.setText("Milyen áron szerezzük be a bútorlapokat?");
        askPanelPurchasePrice.setBounds(10, 10, 300, 20);

        panelsQuantitySlide.setValue(0);

        purchaseInfo.setText("Jelenlegi bútorlapkészlet: " + panels.getStock() +
                "\nBeszerzési ár: " + panelsPriceSlide.getValue() +
                "\nVásárolni kívánt mennyiség: " + panelsQuantitySlide.getValue() +
                "\nVásárlás költsége: " + (panels.getExpenses()));
        purchaseInfo.setEditable(false);
        purchaseInfo.setBounds(390, 10, 270, 80);
        
        changeListener = e -> {
            panels.purchase(panelsQuantitySlide.getValue());
            panels.setPurchasePrice(panelsPriceSlide.getValue());
            panels.setExpenses(panelsPriceSlide.getValue() * panelsQuantitySlide.getValue());
            purchaseInfo.setText("Jelenlegi bútorlapkészlet: " + panels.getStock() +
                    "\nBeszerzési ár: " + panels.getPurchasePrice() +
                    "\nVásárolni kívánt mennyiség: " + panelsQuantitySlide.getValue() +
                    "\nVásárlás költsége: " + panels.getExpenses());
        };


        panelsPriceSlide.setMinorTickSpacing(100);
        panelsPriceSlide.setMajorTickSpacing(1000);
        panelsPriceSlide.setPaintTicks(true);
        panelsPriceSlide.setPaintLabels(true);
        panelsPriceSlide.setLabelTable(panelsPriceSlide.createStandardLabels(1000));
        panelsPriceSlide.setBounds(10, 50, 300, 40);

        panelsPriceSlide.addChangeListener(changeListener);


        askPanelsToBuy.setText("Mennyi bútorlapot vegyünk?");
        askPanelsToBuy.setBounds(10, 120, 300, 40);

        panelsQuantitySlide.setMinorTickSpacing(5);
        panelsQuantitySlide.setMajorTickSpacing(10);
        panelsQuantitySlide.setPaintTicks(true);
        panelsQuantitySlide.setPaintLabels(true);
        panelsQuantitySlide.setLabelTable(panelsQuantitySlide.createStandardLabels(10));
        panelsQuantitySlide.setBounds(10, 180, 300, 40);

        panelsQuantitySlide.addChangeListener(changeListener);

        acceptPurchase.setBounds(390, 200, 200, 30);
        acceptPurchase.addActionListener((e) -> {
            window.increaseDecisionCount();
            panelsQuantitySlide.setEnabled(false);
            panelsPriceSlide.setEnabled(false);
            acceptPurchase.setEnabled(false);
            panels.setStock();
            purchaseInfo.setText(
                    "Bútorlap készlet: " + panels.getStock() +
                            "\nBeszerzési ár: " + panels.getPurchasePrice() +
                    "\nVásárolt mennyiség: " + panels.getPurchasedQuantity() +
                    "\nVásárlás költsége: " + panels.getExpenses()
            );
        });



        add(askPanelPurchasePrice);
        add(panelsPriceSlide);
        add(purchaseInfo);
        add(askPanelsToBuy);
        add(panelsQuantitySlide);
        add(acceptPurchase);

    }

    public void enableDecisions() {
        panelsPriceSlide.setEnabled(true);
        panelsQuantitySlide.setEnabled(true);
        acceptPurchase.setEnabled(true);
        purchaseInfo.setText("");
    }
}
