public class Company {
    private int capital = 1000000;
    private int employeeCount;
    private int productsPerMonth;
    private int roundCount;

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

    public int getRoundCount() {return roundCount;}
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
}
