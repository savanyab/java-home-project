package com.flow.management;

public abstract class Goods {
    protected int productionCost;
    protected int sellingPrice;
    protected int producedPerMonth;
    protected int soldPerMonth;

    public int getProducedPerMonth() { return producedPerMonth; }

    public int getSoldPerMonth() { return soldPerMonth; }

}
