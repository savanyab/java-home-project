public abstract class Goods extends Company {
    protected int productionCost;
    protected int sellingPrice;
    protected int producedGoodsPerMonth;


    public Goods(){
        productionCost = 7000;
        sellingPrice = (int) (productionCost * 2.5);
    }

    public abstract void produceGoods();
}
