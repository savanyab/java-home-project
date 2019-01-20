public class Cupboards extends Goods {
    private int cupboardStock;
    private int glassPerCupboard = 1;
    private int panelPerCupboard = 2;
    private int income;
    private int maxProducts;
    private double sellingRate;
    private int decidedStock;

    public double getSellingRate() { return sellingRate; }


    public int getCupboardStock() {return cupboardStock;}

    public int getDecidedStock() { return decidedStock; }

    public int getIncome() { return income; }

    public void produce(int quantity) {
        producedPerMonth = quantity;
        decidedStock = cupboardStock + producedPerMonth;
        System.out.println("Előállított szekrények: " + producedPerMonth);
    }

    public void increaseStock() {
        cupboardStock = decidedStock;
        System.out.println("Szekrény raktárkészlet: " + cupboardStock);
    }

    public void reduceRawMaterials(int quantity, FurniturePanels panels, Glass glass) {
        panels.reducePanelStock(quantity, panelPerCupboard);
        glass.reduceGlassStock(quantity, glassPerCupboard);
    }

    public int getProducedPerMonth() { return producedPerMonth; }


    public int setMaximumProducts(FurniturePanels panels, Glass glass, Employees employees) {
        int maxQuantityFromPanels = panels.getDecidedStock() / panelPerCupboard;
        int maxQuantityFromGlass = glass.getDecidedStock() / glassPerCupboard;
        int maxQuantityFromEmployees = employees.getMaxProductsByEmployees();

        int[] maximums = { maxQuantityFromPanels, maxQuantityFromGlass, maxQuantityFromEmployees};
        int max = maximums[0];
        for (int i = 0; i < maximums.length; i++) {
            if(maximums[i] < max) {
                max = maximums[i];
                System.out.println("panelek: " + panels.getDecidedStock() + "\nglass: " + glass.getDecidedStock() + "\nmax: " + max);
            }
        }
        maxProducts = max;
        System.out.println("max szekrény: " + maxProducts);
        return maxProducts;
    }

    public void reduceStock() {
        cupboardStock -= soldPerMonth;
        System.out.println("Raktáron lévő, később eladható szekrények: " + cupboardStock);
    }

    private double setSellingRate(Advertisement ad){
        double b = Math.random();
        double rate = b + ad.getAdCount() * 0.05;
        sellingRate = (rate < 1 ? rate : 1);
        System.out.println("randomszám: " + b);
        System.out.println("Eladási arány: " + sellingRate);
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
        int maxSellingPrice = (int) (productionCost * 2.5);
        return maxSellingPrice;
    }

    public int setMaxSellableQuantity() {
        return decidedStock;
    }

    public void receiveIncomeOfSoldGoods() {
        income = soldPerMonth * sellingPrice;
        System.out.println("Szekrény eladási ár: " + sellingPrice);
        System.out.println("Bevétel az eladott szekrényekből: " + income);
    }

    public String toString() {
        return "Előállított szekrények: " + producedPerMonth +
                "\nSzekrény raktárkészlet: " + cupboardStock +
                "\nSzekrény eladási ár: " + sellingPrice +
                "\nBevétel az eladott szekrényekből: " + income +
                "\nMaximum előállítható mennyiség: " + maxProducts;
    }
}
