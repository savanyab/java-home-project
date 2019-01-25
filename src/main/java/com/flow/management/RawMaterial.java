package com.flow.management;

public abstract class RawMaterial {

    int stock;
    int expenses;
    int purchasedQuantity;
    int purchasePrice;
    int decidedStock;

    int getPurchasePrice() {return purchasePrice;}

    public int getDecidedStock() { return decidedStock; }

    int getStock() { return stock; }

    public int getExpenses() { return expenses; }

    public void setPurchasePrice(int price) { purchasePrice = price; }

    public void setExpenses(int price, int quantity) {
        expenses = price * quantity;
    }

}