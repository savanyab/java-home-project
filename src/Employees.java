import java.util.InputMismatchException;
import java.util.Scanner;

public class Employees extends Company{
    private final int WAGE = 50000;
    private static int employeeCount;

    public static int getEmployeeCount() {
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

    public void changeEmployeeCount(int i) {
        int a = employeeCount + i;
        int b = a * 50000;
        employeeCount += i;
        maxProductsByEmployees = employeeCount * 30;
        System.out.println("alkalmazottak száma: " + employeeCount);

    }



    public void payWages() {
        capital -= employeeCount * WAGE;
        setExpenses(employeeCount * WAGE);
        System.out.println("alkalmazottak expenses: " + getExpenses());
    }
}
