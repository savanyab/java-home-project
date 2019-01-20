import javax.swing.*;
import java.awt.*;

public class EmployeeGUI extends JPanel{
    private JSlider employeeSlide;
    private JTextArea employeeInfo;
    private Employees employees;
    private Window window;

    public EmployeeGUI(Window window, Employees employees) {
        this.employees = employees;
        this.window = window;

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.gray));
        JLabel askEmployeeCount = new JLabel();
        employeeSlide = new JSlider(0, 20);
        employeeInfo = new JTextArea();

        askEmployeeCount.setText("Hány alkalmazottat foglalkoztassunk a hónapban?");
        askEmployeeCount.setBounds(10, 10, 300, 20);
        askEmployeeCount.setToolTipText("Egy alkalmazott foglalkozatásának költsége havi " + employees.getWAGE() +
                ". A termelékenységet egy fő 30 egységgel növeli.");

        employeeInfo.setBounds(390, 10, 270, 80);
        employeeInfo.setEditable(false);

        employeeSlide.setMinorTickSpacing(1);
        employeeSlide.setMajorTickSpacing(5);
        employeeSlide.setPaintTicks(true);
        employeeSlide.setPaintLabels(true);
        employeeSlide.setLabelTable(employeeSlide.createStandardLabels(5));
        employeeSlide.setBounds(10, 50, 300, 40);

        employeeSlide.addChangeListener((e) -> {
            window.setAllInfos();
            employees.changeEmployeeCount(employeeSlide.getValue());
            employees.setMaxProductByEmployees();
            employeeInfo.setText("Alkalmazottak száma: " + employees.getEmployeeCount() +
                    "\nBérköltség: " + employees.getWAGE() * employees.getEmployeeCount() +
                    "\nMaximum termelékenység: " + employees.getMaxProductsByEmployees());
        });

        add(employeeInfo);
        add(askEmployeeCount);
        add(employeeSlide);

    }

    public void startMonth() {
        employeeSlide.setValue(employees.getEmployeeCount());
        employeeInfo.setText("Jelenleg alkalmazottak száma: " + employees.getEmployeeCount() +
                "\nBérköltség: " + employees.getWAGE() * employees.getEmployeeCount() +
                "\nMaximum termelékenység: " + employees.getMaxProductsByEmployees());
    }
}
