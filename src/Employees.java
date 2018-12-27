import java.util.Scanner;

public class Employees extends Company{
    private final int WAGE = 50000;

    public void changeEmployeeCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Változtassunk-e az alkalmazottak létszámán?");
        if (sc.next() == "y") {
            hire();
            dismiss();
        }
    }

    public void hire() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány alkalmazottat vegyünk fel?");
        int a = sc.nextInt();
        employeeCount += a;
        setProductsPerMonth(employeeCount);
        System.out.println("alkalmazottak: " + employeeCount);
        setExpenses(employeeCount * WAGE);
        System.out.println("alkalmazottak expenses: " + getExpenses());
    }

    public void dismiss() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány alkalmazottat bocsássunk el?");
        int a = sc.nextInt();
        employeeCount -= a;
        setProductsPerMonth(employeeCount);
    }

    public void payWages() {
        capital -= employeeCount * WAGE;
        setExpenses(employeeCount * WAGE);
        System.out.println("bérfizetés: " + employeeCount * WAGE + " tőke: " + capital);
        System.out.println(" alkalmazottak expenses: " + getExpenses());
    }
}
