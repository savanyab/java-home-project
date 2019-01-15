import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;
import java.awt.*;

public class CupboardsGUI extends JPanel {

    public CupboardsGUI(Cupboards cupboards) {

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askCupboardsToProduce = new JLabel("Mennyi szekrényt állítsunk elő?");
        JLabel askSellingQuantity = new JLabel("Mennyi szekrényt próbáljunk eladni?");
        JLabel askSellingPrice = new JLabel("Mennyi legyen az eladási ár?");

        JSlider cupboardProductionSlide = new JSlider(0, 100);
        JSlider cupboardSellSlide = new JSlider(0, 100);
        JSlider cupboardSellingPrice = new JSlider(0, 100);

        JButton acceptProduction = new JButton("OK");
        JButton acceptSellingQuantity = new JButton("OK");
        JButton acceptSellingPrice = new JButton("OK");

        JTextArea cupboardInfo = new JTextArea();


        askCupboardsToProduce.setBounds(10, 10, 300, 20);
        askSellingQuantity.setBounds(10, 100, 300, 20);
        askSellingPrice.setBounds(10, 190, 300, 20);

        cupboardProductionSlide.setBounds(10, 35, 300, 40);
        cupboardSellSlide.setBounds(10, 130, 300, 40);
        cupboardSellingPrice.setBounds(10, 220, 300, 40);

        acceptProduction.setBounds(320, 37, 60, 25);
        acceptSellingQuantity.setBounds(320, 130, 60, 25);
        acceptSellingPrice.setBounds(320, 220, 60, 25);

        cupboardInfo.setBounds(390, 40, 270, 200);
        cupboardInfo.setEditable(false);

        cupboardSellingPrice.setValue(0);

        acceptSellingPrice.setEnabled(false);
        cupboardSellSlide.setEnabled(false);
        acceptSellingQuantity.setEnabled(false);

        cupboardProductionSlide.setValue(0);
        cupboardSellSlide.setValue(0);

        cupboardProductionSlide.setMinorTickSpacing(5);
        cupboardProductionSlide.setMajorTickSpacing(10);
        cupboardProductionSlide.setPaintTicks(true);
        cupboardProductionSlide.setPaintLabels(true);
        cupboardProductionSlide.setLabelTable(cupboardProductionSlide.createStandardLabels(10));

        cupboardSellSlide.setMinorTickSpacing(5);
        cupboardSellSlide.setMajorTickSpacing(10);
        cupboardSellSlide.setPaintTicks(true);
        cupboardSellSlide.setPaintLabels(true);
        cupboardSellSlide.setLabelTable(cupboardSellSlide.createStandardLabels(10));


        cupboardSellingPrice.setMinorTickSpacing(5);
        cupboardSellingPrice.setMajorTickSpacing(10);
        cupboardSellingPrice.setPaintTicks(true);
        cupboardSellingPrice.setPaintLabels(true);
        cupboardSellingPrice.setLabelTable(cupboardSellingPrice.createStandardLabels(10));
        cupboardSellingPrice.setEnabled(false);


        add(askCupboardsToProduce);
        add(cupboardProductionSlide);
        add(askSellingQuantity);
        add(cupboardSellSlide);
        add(askSellingPrice);
        add(cupboardSellingPrice);
        add(acceptProduction);
        add(acceptSellingQuantity);
        add(acceptSellingPrice);
        add(cupboardInfo);
    }


}
