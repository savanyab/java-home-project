import java.util.Scanner;

public class Cupboards extends Goods {
    private int cupboardStock;
    private double sellingRate;
    private int glassPerCupboard = 1;
    private int panelPerCupboard = 2;


    public Cupboards(RawMaterial r) {
        productionCost = r.getGlassPurchasePrice() * glassPerCupboard + r.getPanelPurchasePrice() * panelPerCupboard;
        sellingPrice = (int) (productionCost * 2.5);
    }

    public int getCupboardStock() {return cupboardStock;}


    @Override
    public void produce(RawMaterial r, Employees e) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi szekrényt állítsunk elő?");
        int a = sc.nextInt();
        maxProductsByEmployees = e.getEmployeeCount() * 30;
        if (a <= maxProductsByEmployees && a * panelPerCupboard <= r.getPanelStock() && a * glassPerCupboard <= r.getGlassStock()) {
            cupboardStock += a;
            producedGoodsPerMonth = a;
            r.setPanelStock(r.getPanelStock() - (a * panelPerCupboard));
            r.setGlassStock(r.getGlassStock() - (a * glassPerCupboard));
            System.out.println("prodcost: " + productionCost);
            System.out.println("producedCupboards: " + producedGoodsPerMonth);
            System.out.println("panelStock: " + r.getPanelStock());
            System.out.println("glassStock: " + r.getGlassStock());
        } else {
            System.out.println("Nincs elég erőforrás ennyihez");
            System.out.println("glassStock: " + r.getGlassStock());
            System.out.println("panelStock: " + r.getPanelStock());
            System.out.println("maxProductsByEmployees" + maxProductsByEmployees);
            produce(r, e);
        }
    }



    public void sellCupboards(Advertisement ad){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány szekrényt próbáljunk meg eladni?");
        int a = sc.nextInt();
        double b = Math.random();
        sellingRate = setSellingRate(b, ad);
        soldGoodsPerMonth = (int) (sellingRate * a);
        cupboardStock -= soldGoodsPerMonth;
        setIncome((int) (sellingRate * a) * sellingPrice);
        System.out.println("randomszám: " + b);
        System.out.println("sellingrate: " + sellingRate);
        System.out.println("soldcupboards: " + soldGoodsPerMonth);
        System.out.println("cupboardstock: " + cupboardStock);
        System.out.println("cupboard sellingprice: " + sellingPrice);
        System.out.println("cupboard income: " + getIncome());
    }

    private double setSellingRate(double b, Advertisement a){
        double c = b + a.getAdCount() * 0.05;
        return sellingRate = c < 1 ? c : 1;
    }
}
