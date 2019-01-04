import java.util.InputMismatchException;
import java.util.Scanner;

public class RawMaterial {
    private int glassStock;
    private int panelStock;
    private int glassPurchasePrice = 3000;
    private int panelPurchasePrice = 4000;
    private int expenses;
    private Scanner sc = new Scanner(System.in);
    // region Getters
    public int getGlassStock() {
        return glassStock;
    }

    public int getPanelStock() {return panelStock;}

    public int getGlassPurchasePrice() {return glassPurchasePrice;}

    public int getPanelPurchasePrice() {return panelPurchasePrice;}

    public int getExpenses() { return expenses; }
    // endregion
    // region Setters
    public void setPanelStock(int a) {panelStock = a;}

    public void setGlassStock(int a) {glassStock = a;}
    // endregion

    public void purchaseGlass() {
        System.out.println("Mennyi üveget vegyünk?");
        try {
            int a = Integer.parseInt(sc.next());
            if (a >= 0) {
                glassStock += a;
                expenses += a * glassPurchasePrice;
                System.out.println("üveg mennyiség: " + glassStock);
                System.out.println("nyersanyag sumexpenses: " + expenses);
            } else {
                System.out.println("A vásárolt mennyiség nem lehet negatív");
                purchaseGlass();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
            purchaseGlass();
        }
    }

    public void purchasePanels() {
        System.out.println("Mennyi bútorlapot vegyünk?");
        try {
            int a = Integer.parseInt(sc.next());

            if (a >= 0) {
                panelStock += a;
                expenses += a * panelPurchasePrice;
                System.out.println("bútorlap mennyiség: " + panelStock);
                System.out.println("nyersanyag sumexpenses: " + expenses);
            } else {
                System.out.println("A vásárolt mennyiség nem lehet negatív");
                purchasePanels();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
        }
    }


    public String toString() {
        return "glassStock: " + glassStock + "panelStock: " + panelStock;
    }
}
