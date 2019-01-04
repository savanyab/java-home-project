import java.util.Scanner;

public class Cupboards extends Goods {
    private int cupboardStock;
    private double sellingRate;
    private int glassPerCupboard = 1;
    private int panelPerCupboard = 2;
    private int income;


    public Cupboards(FurniturePanels p, Glass g) {
        int costOfGlass = g.getPurchasePrice() * glassPerCupboard;
        int costOfPanels = p.getPurchasePrice() * panelPerCupboard;

        productionCost =  costOfGlass + costOfPanels;
        sellingPrice = (int) (productionCost * 2.5);
    }

    public int getCupboardStock() {return cupboardStock;}

    public int getIncome() { return income; }


    @Override
    public void produce(FurniturePanels panels, Glass glass, Employees employees) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi szekrényt állítsunk elő?");
        int a = sc.nextInt();
        if (canBeProduced(a, panels, glass, employees)) {
            cupboardStock += a;
            producedPerMonth = a;
            panels.setStock(panels.getStock() - (a * panelPerCupboard));
            glass.setStock(glass.getStock() - (a * glassPerCupboard));
            System.out.println("prodcost: " + productionCost);
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

    public boolean canBeProduced(int a, FurniturePanels panels, Glass glass, Employees employees) {
     return a <= employees.getMaxProductsByEmployees() && a * panelPerCupboard <= panels.getStock() && a * glassPerCupboard <= glass.getStock();
    }



    public void sellCupboards(Advertisement ad){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hány szekrényt próbáljunk meg eladni?");
        int a = sc.nextInt();
        double b = Math.random();
        sellingRate = setSellingRate(b, ad);
        soldPerMonth = (int) (sellingRate * a);
        cupboardStock -= soldPerMonth;
        income = ((int) (sellingRate * a) * sellingPrice);
        System.out.println("randomszám: " + b);
        System.out.println("sellingrate: " + sellingRate);
        System.out.println("soldcupboards: " + soldPerMonth);
        System.out.println("cupboardstock: " + cupboardStock);
        System.out.println("cupboard sellingprice: " + sellingPrice);
        System.out.println("cupboard income: " + income);
    }

    private double setSellingRate(double b, Advertisement a){
        double c = b + a.getAdCount() * 0.05;
        return sellingRate = c < 1 ? c : 1;
    }
}
