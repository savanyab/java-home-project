public class Cupboards extends Goods {
    private int cupboardStock;
    private int glassPerCupboard = 1;
    private int panelPerCupboard = 2;
    private int income;
    private int maxSellingPrice;
    private int maxProducts;
    private double sellingRate;

    public double getSellingRate() { return sellingRate; }


    public int getCupboardStock() {return cupboardStock;}

    public int getIncome() { return income; }

    public void produce(int quantity) {
        producedPerMonth = quantity;
        System.out.println("Előállított szekrények: " + producedPerMonth);
    }

    public void increaseStock() {
        cupboardStock += producedPerMonth;
        System.out.println("Szekrény raktárkészlet: " + cupboardStock);
    }

    public void reduceRawMaterials(int quantity, FurniturePanels panels, Glass glass) {
        panels.reducePanelStock(quantity, panelPerCupboard);
        glass.reduceGlassStock(quantity, glassPerCupboard);
    }

    public int getProducedPerMonth() { return producedPerMonth; }


    public int setMaximumProducts(FurniturePanels panels, Glass glass, Employees employees) {
        int maxQuantityFromPanels = panels.getStock() / panelPerCupboard;
        int maxQuantityFromGlass = glass.getStock() / glassPerCupboard;
        int maxQuantityFromEmployees = employees.getMaxProductsByEmployees();

        int[] maximums = { maxQuantityFromPanels, maxQuantityFromGlass, maxQuantityFromEmployees};
        int max = maximums[0];
        for (int i = 0; i < maximums.length; i++) {
            if(maximums[i] < max) {
                max = maximums[i];
                System.out.println("panelek: " + panels.getStock() + "\nglass: " + glass.getStock() + "\nmax: " + max);
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

    public int setMaxSellingPrice(FurniturePanels p, Glass g) {
        int costOfGlass = g.getPurchasePrice() * glassPerCupboard;
        int costOfPanels = p.getPurchasePrice() * panelPerCupboard;
        productionCost =  costOfGlass + costOfPanels;
        maxSellingPrice = (int) (productionCost * 2.5);
        return maxSellingPrice;
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
