import java.util.Scanner;

public class Cupboards extends Goods {
    private static int cupboardStock;

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
        int b = (int) (a * Math.random()); // 5%-os növekedést még belerakni!!!
        System.out.println(Advertisement.getAdCount());
        cupboardStock -= b;
        setIncome(b * sellingPrice);
        capital += getIncome();
        System.out.println("b: " + b);
        System.out.println("cupboardstock: " + cupboardStock);
        System.out.println("cupboard sellingprice: " + sellingPrice);
        System.out.println("cupboard income: " + getIncome());
    }
}
