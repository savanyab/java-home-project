import java.util.Scanner;

public class Cupboards extends Goods {
    public static int cupboardStock;
    public Cupboards() {
        super();
    }

       @Override
    public void produceGoods() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi szekrényt állítsunk elő?");
        int a = sc.nextInt();
        if (a <= maxProductsByEmployees && a * 4 <= FurniturePanels.panelStock) {
            //goodsStock += a;
            cupboardStock += a;
            producedGoodsPerMonth = a;
            FurniturePanels.panelStock -= a * 4;
            System.out.println("producedCupboards: " + producedGoodsPerMonth);
            System.out.println("panelStock: " + FurniturePanels.panelStock);
        }
    }



    public void sellCupboards(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány szekrényt próbáljunk meg eladni?");
        int a = sc.nextInt();
        int b = (int) (a * Math.random());
        cupboardStock -= b;
        setIncome(b * sellingPrice);
        capital += getIncome();
        System.out.println("b: " + b);
        System.out.println("cupboardstock: " + cupboardStock);
        System.out.println("cupboard sellingprice: " + sellingPrice);
        System.out.println("cupboard income: " + getIncome());
    }
}
