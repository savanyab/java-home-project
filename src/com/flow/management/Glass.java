package com.flow.management;

public class Glass extends RawMaterial {

    public void increaseStock() {
        stock = decidedStock;
    }

    public void purchase(int quantity) {
        purchasedQuantity = quantity;
        decidedStock = stock + quantity;
    }

    public void reduceGlassStock(int productQuantity, int glassPerProduct) {
        stock -= (productQuantity * glassPerProduct);
    }

    public String toString(int decision) {
        return String.format("Jelenlegi üvegkészlet: %,4d" +
                        "\nBeszerzési ár: %,5d" +
                        "\nVásárolni kívánt mennyiség: %,4d" +
                        "\nVásárlás utáni készlet: %,4d" +
                        "\nVásárlás költsége: %,5d",
                stock,
                purchasePrice,
                decision,
                decidedStock,
                expenses);
    }

}
