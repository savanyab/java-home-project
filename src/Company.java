import java.util.Scanner;

public class Company {
    private int capital;
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
            capital += income - expenses;
            round++;
        }
    }

    public String toString(Employees e, Cupboards c, FurniturePanels p, Glass g, Advertisement a) {
        return "capital: " + capital
                + ", employeeCount: " + e.getEmployeeCount()
                + ", income: " + income
                + ", expenses: " + expenses
                + ", cupboardStock: " + c.getCupboardStock()
                + ", glassStock: " + g.getStock()
                + ", panelStock: " + p.getStock()
                + ", adCount: " + a.getAdCount();
    }


}
