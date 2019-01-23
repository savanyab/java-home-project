package com.flow.management.gui;

import com.flow.management.Advertisement;

import javax.swing.*;
import java.awt.*;

class AdvertisementGUI extends JPanel {
    private JSlider adCountSlide;
    private JTextArea adInfo;
    private Advertisement ad;

    AdvertisementGUI(Window window, Advertisement ad) {
        this.ad = ad;

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askAdCount = new JLabel();
        adCountSlide = new JSlider(0, 20);
        adInfo = new JTextArea();

        askAdCount.setText("Mennyi reklámot kérjünk a hónapban?");
        askAdCount.setBounds(10, 10, 300, 20);
        askAdCount.setToolTipText("Minden reklám 5%-kal növeli a havi eladási arányt. Ára: " + ad.getPrice() + "/db.");

        adInfo.setBounds(390, 10, 270, 80);
        adInfo.setEditable(false);

        adCountSlide.setMinorTickSpacing(1);
        adCountSlide.setMajorTickSpacing(5);
        adCountSlide.setPaintTicks(true);
        adCountSlide.setPaintLabels(true);
        adCountSlide.setBounds(10, 50, 300, 40);

        adCountSlide.addChangeListener((e) -> {
            window.setAllInfos();
            ad.changeCount(adCountSlide.getValue());
            adInfo.setText(ad.toString());
        });

        JLabel imgLabel = new JLabel(new ImageIcon("E:\\Flow\\java\\management\\src\\com\\flow\\management\\pictures\\rsz_advertisement.png"));
        imgLabel.setBounds(10, 130, 650, 120);
        imgLabel.setOpaque(false);

        add(askAdCount);
        add(adCountSlide);
        add(adInfo);
        add(imgLabel);
    }

    void startMonth() {
        adCountSlide.setValue(ad.getCount());
        adInfo.setText(ad.toString());
    }

}
