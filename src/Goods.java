public class Goods extends Company {
    protected int stock;
    protected int rawMaterialRate;

    public Goods(int stock, int rawMaterialRate) {
        this.stock = stock;
        this.rawMaterialRate = rawMaterialRate;
    }
}
