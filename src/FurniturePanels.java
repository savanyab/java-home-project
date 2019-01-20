public class FurniturePanels extends RawMaterial {
    private int panelPurchasePrice;
    private int decidedStock;

    public int getPurchasePrice() {return panelPurchasePrice;}

    public void setPurchasePrice(int purchasePrice) { panelPurchasePrice = purchasePrice; }

    public void setExpenses(int price, int quantity) {
        expenses = price * quantity;
        System.out.println("Bútorlap vásárlás költsége: " + expenses);
    }

    public int getDecidedStock() { return decidedStock; }

    public int getExpenses() { return expenses; }

    public void purchase(int a) {
        purchasedQuantity = a;
        decidedStock = stock + purchasedQuantity;
        System.out.println("Bútorlap vásárolt mennyiség: " + purchasedQuantity + "\ndecidedStock: " + decidedStock + "\nstock: " + stock);
    }

    public void increaseStock() {
        stock = decidedStock;
    }

    public void reducePanelStock(int productQuantity, int panelPerProduct) {
        stock -= (productQuantity * panelPerProduct);
        System.out.println("Bútorlap készlet: " + stock);
    }
}
