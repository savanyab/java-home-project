import java.util.Scanner;

public class Cupboards extends Goods {
    private static int cupboardStock;
    private double sellingRate;

    public static int getCupboardStock() {return cupboardStock;}

    public Cupboards() {
        super();
    }


    @Override
    public void produceGoods() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi szekrényt állítsunk elő?");
        int a = sc.nextInt();
        if (a <= maxProductsByEmployees && a * 4 <= RawMaterial.getPanelStock() && a * 2 <= RawMaterial.getGlassStock()) {
            cupboardStock += a;
            producedGoodsPerMonth = a;
            RawMaterial.setPanelStock(- (a * 4));
            RawMaterial.setGlassStock(- (a * 2));
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
        cupboardStock -= (int)(sellingRate * a);
        setIncome((int) (sellingRate * a) * sellingPrice);
        capital += getIncome();
        System.out.println("randomszám: " + b);
        System.out.println("sellingrate: " + sellingRate);
        System.out.println("cupboardstock: " + cupboardStock);
        System.out.println("cupboard sellingprice: " + sellingPrice);
        System.out.println("cupboard income: " + getIncome());
    }

    private double setSellingRate(double b){
        double c = b + Advertisement.getAdCount() * 0.05;
        if (c < 1) {
            sellingRate = c;
        } else {
            sellingRate = 1;
        }
        return sellingRate;
    }
}
