import javax.swing.*;
import java.awt.*;

public class AdvertisementGUI extends JPanel {

    public AdvertisementGUI() {
        Advertisement ad = new Advertisement();

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askAdCount = new JLabel();
        JSlider adCountSlide = new JSlider(0, 20);
        JTextArea adInfo = new JTextArea();

        askAdCount.setText("Mennyi reklámot kérjünk a hónapban?");
        askAdCount.setBounds(10, 10, 300, 20);

        adCountSlide.setMinorTickSpacing(1);
        adCountSlide.setMajorTickSpacing(5);
        adCountSlide.setPaintTicks(true);
        adCountSlide.setPaintLabels(true);
        adCountSlide.setBounds(10, 50, 300, 40);
        adCountSlide.addChangeListener((e) -> {
            ad.changeAdCount(adCountSlide.getValue());
            adInfo.setText("Reklámok száma: " + ad.getAdCount() + "\nHavi reklámköltség: " + ad.getAdCount() * ad.getAdPrice() + "\nAz eladási arányt maximum " + ad.getAdCount() * 5 + "%-kal növeli.");
        });

        adInfo.setBounds(350, 10, 250, 80);
        adInfo.setEditable(false);

        add(askAdCount);
        add(adCountSlide);
        add(adInfo);
    }

}
