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
    // endregion

    public void decideEmployeeCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Jelenleg " + employeeCount + " fő alkalmazottunk van. Hogyan változzon a létszám?");

        try {
            int i = Integer.parseInt(sc.next());
            if (employeeCount + i < 0){
                System.out.println("Alkalmazottak száma: " + employeeCount + ". Többet nem lehet elbocsátani.");
                decideEmployeeCount();
            }else  {
                changeEmployeeCount(i);
                setMaxProductByEmployees();
            }

        } catch(InputMismatchException | NumberFormatException e) {
            System.out.println("Egész számot írj be!");
            decideEmployeeCount();
        }
    }

    private void changeEmployeeCount(int i) {
        employeeCount += i;
        System.out.println("Alkalmazottak száma: " + employeeCount);
    }

    private void setMaxProductByEmployees() {
        maxProductsByEmployees = employeeCount * 30;
        System.out.println("Maximum " + maxProductsByEmployees + " egység terméket tudnak előállítani a hónapban.");
    }

    public void payWages() {
        employeeExpenses = employeeCount * WAGE;
        System.out.println("alkalmazottak expenses: " + employeeExpenses);
    }
}
