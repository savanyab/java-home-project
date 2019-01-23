package com.flow.management;

public class FurniturePanels extends RawMaterial {

    public void purchase(int quantity) {
        purchasedQuantity = quantity;
        decidedStock = stock + purchasedQuantity;
    }

    public void increaseStock() {
        stock = decidedStock;
    }

    void reducePanelStock(int productQuantity, int panelPerProduct) {
        stock -= (productQuantity * panelPerProduct);
    }

    public String toString(int decision) {
        return String.format("Jelenlegi bútorlapkészlet: %,5d" +
                        "\nBeszerzési ár: %,6d" +
                        "\nVásárolni kívánt mennyiség: %,5d" +
                        "\nVásárlás utáni készlet: %,5d" +
                        "\nVásárlás költsége: %,6d",
                        stock,
                        purchasePrice,
                        decision,
                        decidedStock,
                        expenses);
    }
}