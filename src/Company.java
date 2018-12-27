import java.util.Scanner;

public class Company {
    protected static int capital;
    protected static int employeeCount;
    protected static int productsPerMonth;
    private int income;
    private int expenses;
    private static int round = 1;

    public Company() {
        capital = 1000000;
    }


    // region Getters
    public int getCapital() {
        return capital;
    }

    public int getExpenses() {return expenses; }

    public int getRound() {return round;}
    // endregion

    // region Setters

    public void setExpenses(int expenses) { this.expenses = expenses;}

    public void setRound() {

        round++;
    }
    // endregion

    public void nextRound() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Léphetünk a következő körre?");
        String a = sc.next();
        if (a.equals("y")) {
            round++;
        }
    }

    public String toString() {
        return "capital: " + capital
                + ", employeeCount: " + employeeCount
                + ", productsPerMonth: " + productsPerMonth
                + ", income: " + income
                + ", expenses: " + expenses;
    }
}
