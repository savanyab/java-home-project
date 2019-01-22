public class Cupboards extends Goods {
    private int cupboardStock;
    private int glassPerCupboard;
    private int panelPerCupboard;
    private int income;
    private double sellingRate;
    private int decidedStock;

    public Cupboards() {
        this.glassPerCupboard = 1;
        this.panelPerCupboard = 2;
    }

    public double getSellingRate() { return sellingRate; }

    public int getCupboardStock() {return cupboardStock;}

    public int getIncome() { return income; }

    public void produce(int quantity) {
        producedPerMonth = quantity;
        decidedStock = cupboardStock + producedPerMonth;
    }

    public void increaseStock() {
        cupboardStock = decidedStock;
    }

    public void reduceRawMaterials(int quantity, FurniturePanels panels, Glass glass) {
        panels.reducePanelStock(quantity, panelPerCupboard);
        glass.reduceGlassStock(quantity, glassPerCupboard);
    }

    public int setMaximumProducts(FurniturePanels panels, Glass glass, Employees employees) {
        int maxQuantityFromPanels = panels.getDecidedStock() / panelPerCupboard;
        int maxQuantityFromGlass = glass.getDecidedStock() / glassPerCupboard;
        int maxQuantityFromEmployees = employees.getMaxProductsByEmployees();

        int[] maximums = { maxQuantityFromPanels, maxQuantityFromGlass, maxQuantityFromEmployees};
        int max = maximums[0];
        for (int maximum : maximums) {
            if (maximum < max) {
                max = maximum;
            }
        }
        return max;
    }

    public void reduceStock() {
        cupboardStock -= soldPerMonth;
    }

    private double setSellingRate(Advertisement ad){
        double b = Math.random();
        double rate = b + ad.getAdCount() * 0.05;
        sellingRate = (rate < 1 ? rate : 1);
        System.out.println("randomszám: " + b);
        return sellingRate;
    }

    public void setSoldQuantity(int quantity, Advertisement ad) {
        soldPerMonth = (int) (quantity * setSellingRate(ad));
    }

    public void decideSellingPrice(int price) {
       sellingPrice = price;
    }

    public int setMaxSellingPrice(FurniturePanels panels, Glass glass) {
        int costOfGlass = glass.getPurchasePrice() * glassPerCupboard;
        int costOfPanels = panels.getPurchasePrice() * panelPerCupboard;
        productionCost =  costOfGlass + costOfPanels;
        return (int) (productionCost * 2.5);
    }

    public int setMaxSellableQuantity() {
        return decidedStock;
    }

    public void receiveIncomeOfSoldGoods() {
        income = soldPerMonth * sellingPrice;
    }

    public String toString(int decision) {
        return String.format("Előállított szekrények száma: %,4d" +
                        "\nSzekrény raktárkészlet: %,5d"  +
                        "\nEladásra küldendő mennyiség: %,5d"  +
                        "\nEladási ár: %,5d",
                producedPerMonth, decidedStock, decision, sellingPrice);
    }
}
