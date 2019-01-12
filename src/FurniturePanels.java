public class FurniturePanels extends RawMaterial {
    private int panelPurchasePrice;


    public FurniturePanels(int panelPurchasePrice) {
        this.panelPurchasePrice = panelPurchasePrice;
    }

    public int getPurchasePrice() {return panelPurchasePrice;}

    public void setPanelPurchasePrice(int a) { panelPurchasePrice = a; }

    public void setExpenses(int a) {
        expenses = a * panelPurchasePrice;
        System.out.println("Bútorlap vásárlás költsége: " + expenses);
    }

    public int getExpenses() { return expenses; }

    public void purchase(int a) {
        purchasedQuantity = a;
        System.out.println("Bútorlap mennyiség: " + (stock + purchasedQuantity));
    }

    public void setStock() {
        stock += purchasedQuantity;
    }

    public void reducePanelStock(int productQuantity, int panelPerProduct) {
        stock -= (productQuantity * panelPerProduct);
        System.out.println("Bútorlap készlet: " + stock);
    }
}
