import java.util.Scanner;

public class Cupboards extends Goods {
    private static int cupboardStock;
    private double sellingRate;
    private int glassPerCupboard = 1;
    private int panelPerCupboard = 2;


    public Cupboards() {
        productionCost = RawMaterial.getGlassPurchasePrice() * glassPerCupboard + RawMaterial.getPanelPurchasePrice() * panelPerCupboard;
        sellingPrice = (int) (productionCost * 2.5);
        maxProductsByEmployees = Employees.getEmployeeCount() * 30;
    }

    public static int getCupboardStock() {return cupboardStock;}


    @Override
    public void produceGoods() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi szekrényt állítsunk elő?");
        int a = sc.nextInt();
        if (a <= maxProductsByEmployees && a * panelPerCupboard <= RawMaterial.getPanelStock() && a * glassPerCupboard <= RawMaterial.getGlassStock()) {
            cupboardStock += a;
            producedGoodsPerMonth = a;
            RawMaterial.setPanelStock(- (a * panelPerCupboard));
            RawMaterial.setGlassStock(- (a * glassPerCupboard));
            System.out.println("prodcost: " + productionCost);
            System.out.println("producedCupboards: " + producedGoodsPerMonth);
            System.out.println("panelStock: " + RawMaterial.getPanelStock());
            System.out.println("glassStock: " + RawMaterial.getGlassStock());
        }
    }



    public void sellCupboards(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány szekrényt próbáljunk meg eladni?");
        int a = sc.nextInt();
        double b = Math.random();
        sellingRate = setSellingRate(b);
        soldGoodsPerMonth = (int) (sellingRate * a);
        cupboardStock -= (int)(sellingRate * a);
        setIncome((int) (sellingRate * a) * sellingPrice);
        System.out.println("randomszám: " + b);
        System.out.println("sellingrate: " + sellingRate);
        System.out.println("soldcupboards: " + soldGoodsPerMonth);
        System.out.println("cupboardstock: " + cupboardStock);
        System.out.println("cupboard sellingprice: " + sellingPrice);
        System.out.println("cupboard income: " + getIncome());
    }

    private double setSellingRate(double b){
        double c = b + Advertisement.getAdCount() * 0.05;
        return sellingRate = c < 1 ? c : 1;
    }
}
