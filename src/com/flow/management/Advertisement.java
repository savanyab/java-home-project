package com.flow.management;

public class Advertisement {
    private int price;
    private int count;
    private int expenses;

    public Advertisement() {
        price = 50000;
    }

    public int getAdCount() {
        return count;
    }

    public int getExpenses() { return expenses; }

    public int getAdPrice() { return price; }

    public void setExpenses() {expenses = count * price;}

    public void changeAdCount(int i){
        count = i;
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
