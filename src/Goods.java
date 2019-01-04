public abstract class Goods extends Company {
    protected int productionCost;
    protected int sellingPrice;
    protected int producedGoodsPerMonth;
    protected int soldGoodsPerMonth;
    protected int maxProductsByEmployees;

    public abstract void produce();
}
