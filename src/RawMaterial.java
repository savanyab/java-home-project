public abstract class RawMaterial extends Company{
    protected int purchasePrice;


    public RawMaterial(int purchasePrice) {
        this.purchasePrice = purchasePrice;

    }

    public abstract void purchaseRawMaterial();


}
