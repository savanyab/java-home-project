public class FurniturePanels extends RawMaterial {

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