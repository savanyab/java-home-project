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
            adInfo.setText("Reklámok száma: " + ad.getAdCount() +
                    "\nHavi reklámköltség: " + ad.getAdCount() * ad.getAdPrice() +
                    "\nAz eladási arányt maximum " + ad.getAdCount() * 5 + "%-kal növeli.");
        });


        add(askAdCount);
        add(adCountSlide);
        add(adInfo);
    }

    public void startMonth() {
        adCountSlide.setValue(ad.getAdCount());
        adInfo.setText("Jelenleg a reklámok száma: " + ad.getAdCount() +
                "\nHavi reklámköltség: " + ad.getAdCount() * ad.getAdPrice() +
                "\nAz eladási arányt maximum " + ad.getAdCount() * 5 + "%-kal növeli.");
    }

}
