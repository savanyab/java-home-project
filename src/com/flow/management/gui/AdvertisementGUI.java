package com.flow.management.gui;

import com.flow.management.Advertisement;

import javax.swing.*;
import java.awt.*;

public class AdvertisementGUI extends JPanel {
    private JSlider adCountSlide;
    private JTextArea adInfo;
    private Advertisement ad;

    public AdvertisementGUI(Window window, Advertisement ad) {
        this.ad = ad;

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askAdCount = new JLabel();
        adCountSlide = new JSlider(0, 20);
        adInfo = new JTextArea();

        askAdCount.setText("Mennyi reklámot kérjünk a hónapban?");
        askAdCount.setBounds(10, 10, 300, 20);
        askAdCount.setToolTipText("Minden reklám 5%-kal növeli a havi eladási arányt. Ára: " + ad.getAdPrice() + "/db.");

        adInfo.setBounds(390, 10, 270, 80);
        adInfo.setEditable(false);

        adCountSlide.setMinorTickSpacing(1);
        adCountSlide.setMajorTickSpacing(5);
        adCountSlide.setPaintTicks(true);
        adCountSlide.setPaintLabels(true);
        adCountSlide.setBounds(10, 50, 300, 40);

        adCountSlide.addChangeListener((e) -> {
            window.setAllInfos();
            ad.changeAdCount(adCountSlide.getValue());
            adInfo.setText(infoText());
        });


        add(askAdCount);
        add(adCountSlide);
        add(adInfo);
    }

    public void startMonth() {
        adCountSlide.setValue(ad.getAdCount());
        adInfo.setText(infoText());
    }

    public String infoText() {
        return String.format("Reklámok száma: %,2d"  +
                        "\nHavi reklámköltség: %,6d"  +
                        "\nAz eladási arányt maximum %,2d",
                ad.getAdCount(),
                ad.getAdCount() * ad.getAdPrice(),
                ad.getAdCount() * 5) +"%-kal növeli.";
    }

}
