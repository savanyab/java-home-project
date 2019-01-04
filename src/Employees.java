import java.util.InputMismatchException;
import java.util.Scanner;

public class Employees {
    private final int WAGE = 50000;
    private int employeeCount;
    private int employeeExpenses;

    public int getExpenses() { return employeeExpenses; }


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



    public void payWages() {
        employeeExpenses = employeeCount * WAGE;
        System.out.println("alkalmazottak expenses: " + employeeExpenses);
    }
}
