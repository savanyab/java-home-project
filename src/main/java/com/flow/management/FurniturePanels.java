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
        return String.format("Jelenlegi bútorlapkészlet: %,15d" +
                        "\nBeszerzési ár: %,32d" +
                        "\nVásárolni kívánt mennyiség: %,7d" +
                        "\nVásárlás utáni készlet: %,17d" +
                        "\nVásárlás költsége: %,20d",
                        stock,
                        purchasePrice,
                        decision,
                        decidedStock,
                        expenses);
    }
}