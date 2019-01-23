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

}
