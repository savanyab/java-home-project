package com.flow.management;

public class Employees {
    private final int WAGE = 50000;
    private int employeeCount;
    private int employeeExpenses;
    private int maxProductsByEmployees;

    // region Getters
    public int getExpenses() { return employeeExpenses; }

    public int getMaxProductsByEmployees() { return maxProductsByEmployees; }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public int getWAGE() {return WAGE;}
    // endregion

    public void changeEmployeeCount(int i) {
        employeeCount = i;
    }

    public void setMaxProductByEmployees() {
        maxProductsByEmployees = employeeCount * 30;
    }

    public void payWages() {
        employeeExpenses = employeeCount * WAGE;
    }

    public String toString() {
        return String.format("Jelenleg alkalmazottak száma: %,2d"  +
                        "\nBérköltség: %,8d" +
                        "\nMaximum termelékenység: %,2d",
                employeeCount,
                WAGE * employeeCount,
                maxProductsByEmployees);
    }
}
