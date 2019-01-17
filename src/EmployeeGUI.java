import javax.swing.*;
import java.awt.*;

public class EmployeeGUI extends JPanel{
    private Window window;

    public EmployeeGUI(Window window, Employees employees) {
        this.window = window;
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));
        JLabel askEmployeeCount = new JLabel();
        JSlider employeeSlide = new JSlider(0, 20);
        JTextArea employeeInfo = new JTextArea();
        JButton acceptEmployeeCount = new JButton("OK");

        askEmployeeCount.setText("Hány alkalmazottat foglalkoztassunk a hónapban?");
        askEmployeeCount.setBounds(10, 10, 300, 20);

        employeeInfo.setBounds(390, 10, 270, 80);
        employeeInfo.setEditable(false);
        employeeInfo.setText("Jelenleg alkalmazottak száma: " + employees.getEmployeeCount() +
                "\nBérköltség: " + employees.getWAGE() * employees.getEmployeeCount() +
                "\nMaximum termelékenység: " + employees.getMaxProductsByEmployees());

        acceptEmployeeCount.setBounds(320, 50, 60, 25);
        acceptEmployeeCount.addActionListener((e) -> {
            window.increaseDecisionCount();
            acceptEmployeeCount.setEnabled(false);
            employeeSlide.setEnabled(false);
        });

        employeeSlide.setMinorTickSpacing(1);
        employeeSlide.setMajorTickSpacing(5);
        employeeSlide.setPaintTicks(true);
        employeeSlide.setPaintLabels(true);
        employeeSlide.setLabelTable(employeeSlide.createStandardLabels(5));
        employeeSlide.setBounds(10, 50, 300, 40);
        employeeSlide.setValue(employees.getEmployeeCount());

        employeeSlide.addChangeListener((e) -> {
            employees.changeEmployeeCount(employeeSlide.getValue());
            employees.setMaxProductByEmployees();
            employeeInfo.setText("Alkalmazottak száma: " + employees.getEmployeeCount() +
                    "\nBérköltség: " + employees.getWAGE() * employees.getEmployeeCount() +
                    "\nMaximum termelékenység: " + employees.getMaxProductsByEmployees());
        });

        add(employeeInfo);
        add(askEmployeeCount);
        add(employeeSlide);
        add(acceptEmployeeCount);

    }

}
