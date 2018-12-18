import java.util.Scanner;

public class Employees extends Company{
    private final int wage = 50000;

    public void hire() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány alkalmazottat vegyünk fel?");
        int a = sc.nextInt();
        employeeCount += a;
    }

    public void dismiss() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány alkalmazottat bocsássunk el?");
        int a = sc.nextInt();
        employeeCount -= a;
    }

    public void payWages() {
        capital -= employeeCount * wage;
    }
}
