import java.awt.*;

public class Main {
    private static final int TARGET_CAPITAL = 2000000;

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Window window = new Window();
            window.setVisible(true);
        });
    }
}
