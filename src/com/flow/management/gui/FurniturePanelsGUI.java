package com.flow.management.gui;

import com.flow.management.FurniturePanels;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class FurniturePanelsGUI extends JPanel {
    private JSlider panelsPriceSlide;
    private JSlider panelsQuantitySlide;
    private JTextArea purchaseInfo;
    private FurniturePanels panels;

    public FurniturePanelsGUI(Window window, FurniturePanels panels) {
        this.panels = panels;
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askPanelPurchasePrice = new JLabel();
        panelsPriceSlide = new JSlider(3000, 6000);
        JLabel askPanelsToBuy = new JLabel();
        panelsQuantitySlide = new JSlider(0, 1000);
        purchaseInfo = new JTextArea();

        panels.setPurchasePrice(panelsPriceSlide.getValue());


        askPanelPurchasePrice.setText("Milyen áron szerezzük be a bútorlapokat?");
        askPanelPurchasePrice.setBounds(10, 10, 300, 20);
        askPanelPurchasePrice.setToolTipText("A beszerzési ár a bútorok előállítási költségén keresztül befolyásolja a maximum eladási árat.");

        panelsQuantitySlide.setValue(0);

        purchaseInfo.setText(panels.toString(panelsQuantitySlide.getValue()));

        purchaseInfo.setEditable(false);
        purchaseInfo.setBounds(390, 10, 270, 80);
        
        ChangeListener changeListener = e -> {
            window.setAllInfos();
            int decidedQuantity = panelsQuantitySlide.getValue();
            int decidedPrice = panelsPriceSlide.getValue();
            panels.purchase(decidedQuantity);
            panels.setPurchasePrice(decidedPrice);
            panels.setExpenses(decidedPrice, decidedQuantity);
            purchaseInfo.setText(panels.toString(panelsQuantitySlide.getValue()));
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
        askPanelsToBuy.setToolTipText("Egy egység szekrény előállításához 2 egység bútorlap szükséges.");

        panelsQuantitySlide.setMinorTickSpacing(100);
        panelsQuantitySlide.setMajorTickSpacing(500);
        panelsQuantitySlide.setPaintTicks(true);
        panelsQuantitySlide.setPaintLabels(true);
        panelsQuantitySlide.setLabelTable(panelsQuantitySlide.createStandardLabels(100));
        panelsQuantitySlide.setBounds(10, 180, 300, 40);

        panelsQuantitySlide.addChangeListener(changeListener);


        add(askPanelPurchasePrice);
        add(panelsPriceSlide);
        add(purchaseInfo);
        add(askPanelsToBuy);
        add(panelsQuantitySlide);

    }

    public void startMonth() {
        panelsPriceSlide.setValue(0);
        panelsQuantitySlide.setValue(0);
        purchaseInfo.setText(panels.toString(panelsQuantitySlide.getValue()));
    }
}
