import java.util.InputMismatchException;
import java.util.Scanner;

public class Employees {
    private final int WAGE = 50000;
    private int employeeCount;
    private int employeeExpenses;
    private int maxProductsByEmployees;

    public int getExpenses() { return employeeExpenses; }

    public int getMaxProductsByEmployees() { return maxProductsByEmployees; }


    public int getEmployeeCount() {
        return employeeCount;
    }

    public void decideEmployeeCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hogyan változzon az alkalmazottak létszáma? ");

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
            System.out.println("Egész számot vagy nullát írj be!");
            decideEmployeeCount();
        }
    }

    private void changeEmployeeCount(int i) {
        employeeCount += i;
        System.out.println("alkalmazottak száma: " + employeeCount);
    }

    private void setMaxProductByEmployees() {
        maxProductsByEmployees = employeeCount * 30;
    }

    public void payWages() {
        employeeExpenses = employeeCount * WAGE;
        System.out.println("alkalmazottak expenses: " + employeeExpenses);
    }
}
