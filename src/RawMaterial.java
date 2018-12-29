import java.util.InputMismatchException;
import java.util.Scanner;

public class RawMaterial extends Company{
    private static int glassStock;
    private static int panelStock;
    private int glassPurchasePrice;
    private int panelPurchasePrice;

    public RawMaterial() {
        glassPurchasePrice = 3000;
        panelPurchasePrice = 4000;
    }


    public static int getGlassStock() {
        return glassStock;
    }

    public static int getPanelStock() {return panelStock;}

    public static void setPanelStock(int a) {panelStock += a;}

    public static void setGlassStock(int a) {glassStock += a;}


    public void purchaseGlass() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi üveget vegyünk?");

        try {
            int a = Integer.parseInt(sc.next());
            if (a >= 0 && a * glassPurchasePrice <= capital) {
                capital -= a * glassPurchasePrice;
                glassStock += a;
                System.out.println("üveg mennyiség: " + glassStock);
                setExpenses(getExpenses() + a * glassPurchasePrice);
                System.out.println("nyersanyag sumexpenses: " + getExpenses());
            } else if (a * glassPurchasePrice > capital) {
                System.out.println("A rendelkezésre álló tőke " + capital + ". " +
                        a + " egység üveg beszerzése " + a * glassPurchasePrice + " összegbe kerülne. Kevesebb üveget rendelj!");
                purchaseGlass();
            } else {
                System.out.println("A mennyiség nem lehet negatív");
                purchaseGlass();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
            purchaseGlass();
        }
    }

    public void purchasePanels() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi bútorlapot vegyünk?");

        try {
            int a = Integer.parseInt(sc.next());

            if (a >= 0 && a * panelPurchasePrice <= capital) {
                capital -= a * panelPurchasePrice;
                panelStock += a;
                System.out.println("bútorlap mennyiség: " + panelStock);
                setExpenses(a * panelPurchasePrice);
                System.out.println("nyersanyag sumexpenses: " + getExpenses());
            } else if (a * panelPurchasePrice > capital) {
                System.out.println("A rendelkezésre álló tőke " + capital + ". " +
                        a + " egység bútorlap beszerzése " + a * panelPurchasePrice + " összegbe kerülne. Kevesebb bútorlapot rendelj!");
                purchasePanels();
            } else {
                System.out.println("A mennyiség nem lehet negatív");
                purchasePanels();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
        }
    }



}
