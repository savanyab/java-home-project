import java.util.Scanner;

public class Cupboards extends Goods {
    private int cupboardStock;
    private int glassPerCupboard = 1;
    private int panelPerCupboard = 2;
    private int income;
    private int maxSellingPrice;
    private Scanner sc = new Scanner(System.in);

    public int getCupboardStock() {return cupboardStock;}

    public int getIncome() { return income; }


    @Override
    public void produce(FurniturePanels panels, Glass glass, Employees employees) {
        System.out.println("Mennyi szekrényt állítsunk elő?");
        int a = sc.nextInt();
        if (canBeProduced(a, panels, glass, employees)) {
            cupboardStock += a;
            producedPerMonth = a;
            panels.setStock(panels.getStock() - (a * panelPerCupboard));
            glass.setStock(glass.getStock() - (a * glassPerCupboard));
            System.out.println("producedCupboards: " + producedPerMonth);
            System.out.println("panelStock: " + panels.getStock());
            System.out.println("glassStock: " + glass.getStock());
        } else {
            System.out.println("Nincs elég erőforrás ennyihez");
            System.out.println("glassStock: " + glass.getStock());
            System.out.println("panelStock: " + panels.getStock());
            System.out.println("maxProductsByEmployees: " + employees.getMaxProductsByEmployees());
            produce(panels, glass, employees);
        }
    }

    private boolean canBeProduced(int a, FurniturePanels panels, Glass glass, Employees employees) {
     return a <= employees.getMaxProductsByEmployees() && a * panelPerCupboard <= panels.getStock() && a * glassPerCupboard <= glass.getStock();
    }

    public void sellCupboards(Advertisement ad, FurniturePanels p, Glass g){
        System.out.println("Hány szekrényt próbáljunk meg eladni? ( " + cupboardStock + " van raktáron).");
        int a = sc.nextInt();
        decideSellingPrice(p, g);
        soldPerMonth = (int) (ad.setSellingRate() * a);
        cupboardStock -= soldPerMonth;
        System.out.println("Eladott szekrények: " + soldPerMonth);
        receiveIncomeOfSoldGoods(p, g);
        System.out.println("Raktáron lévő, később eladható szekrények: " + cupboardStock);
    }


    private void decideSellingPrice(FurniturePanels p, Glass g) {
        System.out.println("Mennyi legyen a szekrények eladási ára?\n " +
                "Maximum " + setMaxSellingPrice(p, g) + " Ft. Ez az előállítási költség (" + productionCost + ") 250%-a.");
        int a = sc.nextInt();
        if (a > maxSellingPrice) {
            sellingPrice = maxSellingPrice;
        } else {
            sellingPrice = a;
        }

    }

    private int setMaxSellingPrice(FurniturePanels p, Glass g) {
        int costOfGlass = g.getPurchasePrice() * glassPerCupboard;
        int costOfPanels = p.getPurchasePrice() * panelPerCupboard;
        productionCost =  costOfGlass + costOfPanels;
        maxSellingPrice = (int) (productionCost * 2.5);
        return maxSellingPrice;
    }

    private void receiveIncomeOfSoldGoods(FurniturePanels p, Glass g) {
        setMaxSellingPrice(p, g);
        income = soldPerMonth * sellingPrice;
        System.out.println("Szekrény eladási ár: " + sellingPrice);
        System.out.println("Bevétel az eladott szekrényekből: " + income);
    }

}
