import java.awt.*;

public class Main {
    
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Window window = new Window();
            window.setVisible(true);
        });
    }
}
