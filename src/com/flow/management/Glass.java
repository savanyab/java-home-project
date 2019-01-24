package com.flow.management;

public class Glass extends RawMaterial {

    public void increaseStock() {
        stock = decidedStock;
    }

    public void purchase(int quantity) {
        purchasedQuantity = quantity;
        decidedStock = stock + quantity;
    }

    void reduceGlassStock(int productQuantity, int glassPerProduct) {
        stock -= (productQuantity * glassPerProduct);
    }

    public String toString(int decision) {
        return String.format("Jelenlegi üvegkészlet: %,22d" +
                        "\nBeszerzési ár: %,35d" +
                        "\nVásárolni kívánt mennyiség: %,12d" +
                        "\nVásárlás utáni készlet: %,22d" +
                        "\nVásárlás költsége: %,25d",
                stock,
                purchasePrice,
                decision,
                decidedStock,
                expenses);
    }

}
