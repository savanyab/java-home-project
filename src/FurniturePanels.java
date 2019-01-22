public class FurniturePanels extends RawMaterial {
    private int panelPurchasePrice;
    private int decidedStock;

    public int getPurchasePrice() {return panelPurchasePrice;}

    public void setPurchasePrice(int purchasePrice) { panelPurchasePrice = purchasePrice; }

    public void setExpenses(int price, int quantity) {
        expenses = price * quantity;
    }

    public int getDecidedStock() { return decidedStock; }

    public int getExpenses() { return expenses; }

    public void purchase(int quantity) {
        purchasedQuantity = quantity;
        decidedStock = stock + purchasedQuantity;
    }

    public void increaseStock() {
        stock = decidedStock;
    }

    public void reducePanelStock(int productQuantity, int panelPerProduct) {
        stock -= (productQuantity * panelPerProduct);
    }
}