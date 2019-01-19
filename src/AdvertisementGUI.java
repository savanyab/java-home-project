import javax.swing.*;
import java.awt.*;

public class AdvertisementGUI extends JPanel {
    private Window window;
    private JSlider adCountSlide;
    private JButton acceptAdCount;
    private JTextArea adInfo;

    public AdvertisementGUI( Window window, Advertisement ad) {
        this.window = window;
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askAdCount = new JLabel();
        adCountSlide = new JSlider(0, 20);
        adInfo = new JTextArea();
        acceptAdCount = new JButton("OK");

        askAdCount.setText("Mennyi reklámot kérjünk a hónapban?");
        askAdCount.setBounds(10, 10, 300, 20);

        acceptAdCount.setBounds(320, 50, 60, 25);
        acceptAdCount.addActionListener((e) -> {
            adCountSlide.setEnabled(false);
            acceptAdCount.setEnabled(false);
            window.increaseDecisionCount();
        });

        adInfo.setBounds(390, 10, 270, 80);
        adInfo.setEditable(false);
        adInfo.setText("Jelenleg a reklámok száma: " + ad.getAdCount() +
                "\nHavi reklámköltség: " + ad.getAdCount() * ad.getAdPrice() +
                "\nAz eladási arányt maximum " + ad.getAdCount() * 5 + "%-kal növeli.");


        adCountSlide.setMinorTickSpacing(1);
        adCountSlide.setMajorTickSpacing(5);
        adCountSlide.setPaintTicks(true);
        adCountSlide.setPaintLabels(true);
        adCountSlide.setBounds(10, 50, 300, 40);
        adCountSlide.setValue(ad.getAdCount());
        adCountSlide.addChangeListener((e) -> {
            ad.changeAdCount(adCountSlide.getValue());
            adInfo.setText("Reklámok száma: " + ad.getAdCount() +
                    "\nHavi reklámköltség: " + ad.getAdCount() * ad.getAdPrice() +
                    "\nAz eladási arányt maximum " + ad.getAdCount() * 5 + "%-kal növeli.");
        });


        add(askAdCount);
        add(adCountSlide);
        add(adInfo);
        add(acceptAdCount);
    }

    public void  enableDecisions() {
        adCountSlide.setEnabled(true);
        acceptAdCount.setEnabled(true);
        adInfo.setText("");
    }

}
