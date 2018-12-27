import java.util.Scanner;

public class Employees extends Company{
    private final int WAGE = 50000;


    public void hire() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány alkalmazottat vegyünk fel?");
        int a = sc.nextInt();
        employeeCount += a;
        productsPerMonth = employeeCount * 30;
        System.out.println("alkalmazottak: " + employeeCount);
        setExpenses(employeeCount * WAGE);
        System.out.println("alkalmazottak expenses: " + getExpenses());
    }

    public void dismiss() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány alkalmazottat bocsássunk el?");
        int a = sc.nextInt();
        employeeCount -= a;
        productsPerMonth = employeeCount * 30;
    }

    public void payWages() {
        capital -= employeeCount * WAGE;
        setExpenses(employeeCount * WAGE);
        System.out.println("bérfizetés: " + employeeCount * WAGE + " tőke: " + capital);
        System.out.println(" alkalmazottak expenses: " + getExpenses());
    }
}
