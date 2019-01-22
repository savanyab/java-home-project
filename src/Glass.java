public class Glass extends RawMaterial {
    private int glassPurchasePrice;
    private int decidedStock;

    public int getPurchasePrice() {return glassPurchasePrice;}

    public int getDecidedStock() { return decidedStock; }

    public void setPurchasePrice(int purchasePrice) { glassPurchasePrice = purchasePrice; }

    public void setExpenses(int price, int quantity) {
        expenses = price * quantity;
    }

    public void setGlassPurchasePrice(int a) { glassPurchasePrice = a; }

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
