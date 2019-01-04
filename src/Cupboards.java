import java.util.Scanner;

public class Cupboards extends Goods {
    private int cupboardStock;
    private double sellingRate;
    private int glassPerCupboard = 1;
    private int panelPerCupboard = 2;
    private int income;


    public Cupboards(FurniturePanels p, Glass g) {
        productionCost = g.getPurchasePrice() * glassPerCupboard + p.getPurchasePrice() * panelPerCupboard;
        sellingPrice = (int) (productionCost * 2.5);
    }

    public int getCupboardStock() {return cupboardStock;}

    public int getIncome() { return income; }


    @Override
    public void produce(FurniturePanels p, Glass g, Employees e) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi szekrényt állítsunk elő?");
        int a = sc.nextInt();
        if (a <= e.getMaxProductsByEmployees() && a * panelPerCupboard <= p.getStock() && a * glassPerCupboard <= g.getStock()) {
            cupboardStock += a;
            producedGoodsPerMonth = a;
            p.setStock(p.getStock() - (a * panelPerCupboard));
            g.setStock(g.getStock() - (a * glassPerCupboard));
            System.out.println("prodcost: " + productionCost);
            System.out.println("producedCupboards: " + producedGoodsPerMonth);
            System.out.println("panelStock: " + p.getStock());
            System.out.println("glassStock: " + g.getStock());
        } else {
            System.out.println("Nincs elég erőforrás ennyihez");
            System.out.println("glassStock: " + g.getStock());
            System.out.println("panelStock: " + p.getStock());
            System.out.println("maxProductsByEmployees" + e.getMaxProductsByEmployees());
            produce(p, g, e);
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
        income = ((int) (sellingRate * a) * sellingPrice);
        System.out.println("randomszám: " + b);
        System.out.println("sellingrate: " + sellingRate);
        System.out.println("soldcupboards: " + soldGoodsPerMonth);
        System.out.println("cupboardstock: " + cupboardStock);
        System.out.println("cupboard sellingprice: " + sellingPrice);
        System.out.println("cupboard income: " + income);
    }

    private double setSellingRate(double b, Advertisement a){
        double c = b + a.getAdCount() * 0.05;
        return sellingRate = c < 1 ? c : 1;
    }
}
