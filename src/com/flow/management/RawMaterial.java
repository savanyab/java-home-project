package com.flow.management;

public abstract class RawMaterial {

    protected int stock;
    protected int expenses;
    protected int purchasedQuantity;
    protected int purchasePrice;
    protected int decidedStock;

    public int getPurchasePrice() {return purchasePrice;}

    public int getDecidedStock() { return decidedStock; }

    public int getStock() { return stock; }

    public int getExpenses() { return expenses; }

    public void setPurchasePrice(int price) { purchasePrice = price; }

    public void setExpenses(int price, int quantity) {
        expenses = price * quantity;
    }

}