import java.util.InputMismatchException;
import java.util.Scanner;

public class Employees {
    private final int WAGE = 50000;
    private int employeeCount;
    private int employeeExpenses;
    private int maxProductsByEmployees;

    // region Getters
    public int getExpenses() { return employeeExpenses; }

    public int getMaxProductsByEmployees() { return maxProductsByEmployees; }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public int getWAGE() {return WAGE;}
    // endregion

    public void changeEmployeeCount(int i) {
        employeeCount = i;
        System.out.println("Alkalmazottak száma: " + employeeCount);
    }

    public void setMaxProductByEmployees() {
        maxProductsByEmployees = employeeCount * 30;
        System.out.println("Maximum " + maxProductsByEmployees + " egység terméket tudnak előállítani a hónapban.");
    }

    public void payWages() {
        employeeExpenses = employeeCount * WAGE;
        System.out.println("bérköltség: " + employeeExpenses);
    }
}
