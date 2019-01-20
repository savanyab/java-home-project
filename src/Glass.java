public class Glass extends RawMaterial {
    private int glassPurchasePrice;
    private int decidedStock;

    public int getPurchasePrice() {return glassPurchasePrice;}

    public int getDecidedStock() { return decidedStock; }

    public void setPurchasePrice(int purchasePrice) { glassPurchasePrice = purchasePrice; }

    public void setExpenses(int price, int quantity) {
        expenses = price * quantity;
        System.out.println("Üveg vásárlás költsége: " + expenses);
    }

    public void setGlassPurchasePrice(int a) { glassPurchasePrice = a; }

    public void increaseStock() {
        stock = decidedStock;
        System.out.println("Üveg mennyiség: " + stock);
    }

    public void purchase(int quantity) {
        purchasedQuantity = quantity;
        decidedStock = stock + quantity;
    }

    public void reduceGlassStock(int productQuantity, int glassPerProduct) {
        stock -= (productQuantity * glassPerProduct);
        System.out.println("Üveg készlet: " + stock);
    }

}
