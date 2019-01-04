public abstract class Goods {
    protected int productionCost;
    protected int sellingPrice;
    protected int producedGoodsPerMonth;
    protected int soldGoodsPerMonth;

    public abstract void produce(FurniturePanels p, Glass g, Employees e);
}
