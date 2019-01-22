import javax.swing.*;

public class ShowSellingInfo extends JDialog {

    public ShowSellingInfo(Company company, Cupboards cupboards) {
        JPanel panel = new JPanel();
        JTextArea textarea = new JTextArea();
        JButton button = new JButton("OK");
        setLayout(null);
        panel.setLayout(null);

        setSize(300, 200);
        setTitle("Havi eladási adatok");
        setLocationRelativeTo(null);

        panel.setBounds(0, 0, 300, 200);
        textarea.setBounds(10, 10, 260, 80);
        button.setBounds(110, 110, 60, 30);

        textarea.setEditable(false);

        button.addActionListener(e -> {
            dispose();
        });

        add(panel);
        panel.add(textarea);
        panel.add(button);

        textarea.setText(String.format(company.getRound()-1 + ". hónap vége: \nEladási arány: %.2f"  +
                "\nEladott szekrények száma: " + cupboards.soldPerMonth +
                "\nBevétel az eladás után: %,8d%n"  +
                "\nTőke: %,8d%n", cupboards.getSellingRate(), cupboards.getIncome(), company.getCapital()));

        setVisible(true);
    }

}
