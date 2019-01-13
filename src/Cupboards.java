import java.util.InputMismatchException;
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

    public void produce(FurniturePanels panels, Glass glass, Employees employees) {
        int a = decideQuantityToProduce(panels, glass, employees);
        cupboardStock += a;
        producedPerMonth = a;
        System.out.println("Előállított szekrények: " + producedPerMonth);
        System.out.println("Szekrény raktárkészlet: " + cupboardStock);
        panels.reducePanelStock(a, panelPerCupboard);
        glass.reduceGlassStock(a, glassPerCupboard);
    }

    private boolean canBeProduced(int a, FurniturePanels panels, Glass glass, Employees employees) {
     return a <= employees.getMaxProductsByEmployees() &&
             a * panelPerCupboard <= panels.getStock() &&
             a * glassPerCupboard <= glass.getStock();
    }

    private int decideQuantityToProduce(FurniturePanels panels, Glass glass, Employees employees) {
        System.out.println("Mennyi szekrényt állítsunk elő? Az üvegkészletből maximum " +
                (glass.getStock() / glassPerCupboard)
                + ", a bútorlapkészletből maximum " + (panels.getStock() / panelPerCupboard)
                + " egység állítható elő. Az alkalmazottak maximum " + employees.getMaxProductsByEmployees()
                + " egység előállítására képesek.");
        try {
            int a = Integer.parseInt(sc.next());
            if (canBeProduced(a, panels, glass, employees)) {
                return a;
            } else {
                System.out.println("Nincs elég erőforrás ennyihez");
                produce(panels, glass, employees);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot írj be!");
            decideQuantityToProduce(panels, glass, employees);
        }
        return 1;
    }



    public void sellCupboards(Advertisement ad, FurniturePanels p, Glass g){
        decideSellingPrice(p, g);
        int a = decideQuantityToSell();
        setSoldQuantity(a, ad);
        cupboardStock -= soldPerMonth;
        System.out.println("Eladott szekrények: " + soldPerMonth);
        receiveIncomeOfSoldGoods(p, g);
        System.out.println("Raktáron lévő, később eladható szekrények: " + cupboardStock);

    }

    private int decideQuantityToSell() {
        System.out.println("Hány szekrényt próbáljunk meg eladni? (" + cupboardStock + " van raktáron).");
        try {
            int a = Integer.parseInt(sc.next());
            if (a >= 0 && a <= cupboardStock) {
                return a;
            } else if (a > 0){
                System.out.println("Több szekrényt nem tudunk eladni, mint a raktáron lévő mennyiség!");
                decideQuantityToSell();
            } else {
                System.out.println("Negatív mennyiséget nem lehet eladni!");
                decideQuantityToSell();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot írj be!");
            decideQuantityToSell();
        }
        return 1;
    }

    private double setSellingRate(Advertisement ad){
        double b = Math.random();
        double rate = b + ad.getAdCount() * 0.05;
        double sellingRate = (rate < 1 ? rate : 1);
        System.out.println("randomszám: " + b);
        System.out.println("Eladási arány: " + sellingRate);
        return sellingRate;
    }

    private void setSoldQuantity(int a, Advertisement ad) {
        soldPerMonth = (int) (a * setSellingRate(ad));
    }

    private void decideSellingPrice(FurniturePanels p, Glass g) {
        System.out.println("Mennyi legyen a szekrények eladási ára? Maximum " + setMaxSellingPrice(p, g) + " Ft lehet. Ez az előállítási költség (" + productionCost + ") 250%-a.");
        try {
            int a = Integer.parseInt(sc.next());
            if (a >= 0 && a <= maxSellingPrice) {
                sellingPrice = a;
            } else if (a > maxSellingPrice) {
                System.out.println("Túl magas árrés!");
                decideSellingPrice(p, g);
            } else {
                System.out.println("Az eladási ár nem lehet negatív!");
                decideSellingPrice(p, g);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Egész számot írj be!");
            decideSellingPrice(p, g);
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
