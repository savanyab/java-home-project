public class Glass extends RawMaterial {
    private int glassPurchasePrice;

    public int getPurchasePrice() {return glassPurchasePrice;}

    public void setPurchasePrice(int purchasePrice) { glassPurchasePrice = purchasePrice; }

    public void setExpenses(int a) {
        expenses = a;
        System.out.println("Üveg vásárlás költsége: " + expenses);
    }

    public void setGlassPurchasePrice(int a) { glassPurchasePrice = a; }

    public void setStock() {
        stock += purchasedQuantity;
        System.out.println("Üveg mennyiség: " + stock);
    }

    public void purchase(int a) {
        purchasedQuantity = a;
    }

    public void reduceGlassStock(int productQuantity, int glassPerProduct) {
        stock -= (productQuantity * glassPerProduct);
        System.out.println("Üveg készlet: " + stock);
    }

}
