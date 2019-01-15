public class FurniturePanels extends RawMaterial {
    private int panelPurchasePrice;

    public int getPurchasePrice() {return panelPurchasePrice;}

    public void setPurchasePrice(int purchasePrice) { panelPurchasePrice = purchasePrice; }

    public void setExpenses(int a) {
        expenses = a;
        System.out.println("Bútorlap vásárlás költsége: " + expenses);
    }

    public int getExpenses() { return expenses; }

    public void purchase(int a) {
        purchasedQuantity = a;
        System.out.println("Bútorlap vásárolt mennyiség: " + purchasedQuantity);
    }

    public void setStock() {
        stock += purchasedQuantity;
    }

    public void reducePanelStock(int productQuantity, int panelPerProduct) {
        stock -= (productQuantity * panelPerProduct);
        System.out.println("Bútorlap készlet: " + stock);
    }
}
