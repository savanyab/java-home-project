public abstract class RawMaterial extends Company{
    protected int purchasePrice;
    //protected int rawMaterialStock;


    public RawMaterial(int purchasePrice) {
        this.purchasePrice = purchasePrice;

    }


    public abstract void purchaseRawMaterial();
    public abstract void useRawMaterial();

}
