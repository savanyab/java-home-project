public abstract class RawMaterial extends Company{
    protected int purchasePrice;
    protected int quantity;

    public RawMaterial(int purchasePrice, int quantity) {
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    public abstract void purchaseRawMaterial();
    public abstract void useRawMaterial();

}
