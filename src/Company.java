import java.util.Scanner;

public class Company {
    protected static int capital;
    protected static int employeeCount;
    protected static int productsPerMonth;
    protected static int income;
    protected static int expenses;
    protected static int round = 1;


    // region Getters
    public int getCapital() {
        return capital;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public int getProductsPerMonth() {
        return productsPerMonth;
    }
    // endregion

    // region Setters
    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setProductsPerMonth(int productsPerMonth) {
        this.productsPerMonth = productsPerMonth;
    }
    // endregion

    public Company() {
        capital = 1000000;
        productsPerMonth = employeeCount * 30;
    }

    public void nextRound() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Léphetünk a következő körre?");
        String a = sc.next();
        if (a.equals("y")) {
            round++;
        }
    }

    public String toString() {
        return round + ". round. " + "capital: " + capital + ", employeeCount: " + employeeCount + ", productsPerMonth: " + productsPerMonth + ", income: " + income + ", expenses: " + expenses;
    }
}
