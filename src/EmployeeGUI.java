import javax.swing.*;
import java.awt.*;

public class EmployeeGUI extends JPanel{

    private Employees employees = new Employees();

    public EmployeeGUI() {
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));

        JLabel askEmployeeCount = new JLabel();
        JSlider changeEmployeeCount = new JSlider(0, 20);
        JTextArea employeeInfo = new JTextArea();

        askEmployeeCount.setText("Hány alkalmazottat foglalkoztassunk a hónapban?");
        askEmployeeCount.setBounds(10, 10, 300, 20);

        changeEmployeeCount.setMinorTickSpacing(1);
        changeEmployeeCount.setMajorTickSpacing(5);
        changeEmployeeCount.setPaintTicks(true);
        changeEmployeeCount.setPaintLabels(true);
        changeEmployeeCount.setLabelTable(changeEmployeeCount.createStandardLabels(5));
        changeEmployeeCount.setBounds(10, 50, 300, 40);
        changeEmployeeCount.setValue(employees.getEmployeeCount());
        changeEmployeeCount.addChangeListener((e) -> {
            employees.changeEmployeeCount(changeEmployeeCount.getValue());
            employees.setMaxProductByEmployees();
            employeeInfo.setText("Alkalmazottak száma: " + employees.getEmployeeCount() + "\nBérköltség: " + employees.getWAGE() * employees.getEmployeeCount() + "\nMaximum termelékenység: " + employees.getMaxProductsByEmployees());
        });

        employeeInfo.setBounds(350, 10, 250, 80);
        employeeInfo.setEditable(false);

        add(employeeInfo);
        add(askEmployeeCount);
        add(changeEmployeeCount);


    }

}
