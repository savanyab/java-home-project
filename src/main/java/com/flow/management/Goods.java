package com.flow.management;

public abstract class Goods {
    int productionCost;
    int sellingPrice;
    int producedPerMonth;
    int soldPerMonth;

    public int getProducedPerMonth() { return producedPerMonth; }

    public int getSoldPerMonth() { return soldPerMonth; }

}
