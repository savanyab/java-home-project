public abstract class Goods {
    protected int productionCost;
    protected int sellingPrice;
    protected int producedGoodsPerMonth;
    protected int soldGoodsPerMonth;
    protected int maxProductsByEmployees;

    public abstract void produce(RawMaterial r, Employees e);
}
