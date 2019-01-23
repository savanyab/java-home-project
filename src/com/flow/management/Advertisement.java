package com.flow.management;

public class Advertisement {
    private int price;
    private int count;
    private int expenses;

    public Advertisement() {
        price = 50000;
    }

    public int getCount() {
        return count;
    }

    int getExpenses() { return expenses; }

    public int getPrice() { return price; }

    void setExpenses() {expenses = count * price;}

    public void changeCount(int count){
        this.count = count;
    }

    public String toString() {
        return String.format("Reklámok száma: %,2d"  +
                        "\nHavi reklámköltség: %,6d"  +
                        "\nAz eladási arányt maximum %,2d",
                        count,
                        count * price,
                        count * 5) +"%-kal növeli.";
    }
}
