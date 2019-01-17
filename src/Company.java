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

    private void setExpenses(int expenses) { this.expenses = expenses;}

    private void setIncome(int income) {
        this.income = income;
    }

    // endregion

    public void nextRound(Employees employees, Advertisement ad, FurniturePanels panels, Glass glass, Cupboards cupboards) {
        employees.payWages();
        ad.setAdExpenses();
        setExpenses(employees.getExpenses() + ad.getExpenses() + panels.getExpenses() + glass.getExpenses());
        setIncome(cupboards.getIncome());
        capital += income - expenses;
        round++;
    }

    public String toString(Employees e, Cupboards c, FurniturePanels p, Glass g, Advertisement a) {
        return round + ". hónap kezdeti fő adatai: " +
                "\nTőke: " + capital
                + ", alkalmazottak száma: " + e.getEmployeeCount()
                + ", bevétel: " + income
                + ", kiadások: " + expenses
                + ",\n szekrény készlet: " + c.getCupboardStock()
                + ", üveg készlet: " + g.getStock()
                + ", bútorlap készlet: " + p.getStock()
                + ", reklámok száma: " + a.getAdCount();
    }


}
