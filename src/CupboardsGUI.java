import javax.swing.*;
import java.awt.*;

public class CupboardsGUI extends JPanel {

    public CupboardsGUI() {

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        Cupboards cupboards = new Cupboards();

        JLabel askCupboardsToProduce = new JLabel("Mennyi szekrényt állítsunk elő?");
        JLabel askSellingQuantity = new JLabel("Mennyi szekrényt próbáljunk eladni?");
        JLabel askSellingPrice = new JLabel("Mennnyi legyen az eladási ár?");
        JSlider cupboardProductionSlide = new JSlider(0, 100);
        JSlider cupboardSellSlide = new JSlider(0, 100);
        JSlider cupboardSellingPrice = new JSlider(0, 100);


        askCupboardsToProduce.setBounds(10, 10, 300, 20);
        askSellingQuantity.setBounds(10, 90, 300, 20);
        askSellingPrice.setBounds(10, 190, 300, 20);
        cupboardProductionSlide.setBounds(10, 35, 300, 40);
        cupboardSellSlide.setBounds(10, 130, 300, 40);
        cupboardSellingPrice.setBounds(10, 210, 300, 40);

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

        add(askCupboardsToProduce);
        add(cupboardProductionSlide);
        add(askSellingQuantity);
        add(cupboardSellSlide);
        add(askSellingPrice);
        add(cupboardSellingPrice);
    }


}
