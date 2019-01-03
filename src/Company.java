import java.util.Scanner;

public class Company {
    protected static int capital;
    protected static int maxProductsByEmployees;
    private int income;
    private int expenses;
    private static int round = 1;


    public Company() {
        capital = 1000000;
    }


    // region Getters
    public static int getCapital() {
        return capital;
    }

    public int getExpenses() {return expenses; }

    public int getRound() {return round;}

    public int getIncome() {return income;}
    // endregion

    // region Setters

    public void setExpenses(int expenses) { this.expenses = expenses;}

    public void setIncome(int income) {
        this.income = income;
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
                + ", employeeCount: " + Employees.getEmployeeCount()
                + ", maxProductsByEmployees: " + maxProductsByEmployees
                + ", income: " + income
                + ", expenses: " + expenses
                + ", cupboardStock: " + Cupboards.getCupboardStock()
                + ", glassStock: " + RawMaterial.getGlassStock()
                + ", panelStock: " + RawMaterial.getPanelStock()
                + ", adCount: " + Advertisement.getAdCount();
    }


}
