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
    public static void setRound(int a) { round = a;}

    private void setExpenses(int expenses) { this.expenses = expenses;}

    private void setIncome(int income) {
        this.income = income;
    }

    // endregion

    public void nextRound(Employees employees, Advertisement ad, FurniturePanels panels, Glass glass, Cupboards cupboards) {
        employees.payWages();
        ad.setExpenses();
        setExpenses(employees.getExpenses() + ad.getExpenses() + panels.getExpenses() + glass.getExpenses());
        setIncome(cupboards.getIncome());
        capital += income - expenses;
        round++;
    }

    public String toString(Employees e, Cupboards c, FurniturePanels p, Glass g, Advertisement a) {
        return String.format(round + ". hónap kezdeti fő adatai: " +
                "\nTőke: %,8d alkalmazottak száma: %,2d  bevétel: %,8d kiadások: %,8d%n szekrény készlet: %,4d"
                + ", üveg készlet: %,4d"
                + ", bútorlap készlet: %,5d"
                + ", reklámok száma: %,2d",
                capital,
                e.getEmployeeCount(),
                income,
                expenses,
                c.getCupboardStock(),
                g.getStock(),
                p.getStock(),
                a.getAdCount());
    }


}
