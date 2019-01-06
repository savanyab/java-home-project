import java.util.InputMismatchException;
import java.util.Scanner;

public class FurniturePanels extends RawMaterial {
    private int panelPurchasePrice = 4000;

    public int getPurchasePrice() {return panelPurchasePrice;}

    public void purchase() {
        System.out.println("Mennyi bútorlapot vegyünk? (" + stock + " van raktáron. Ára " + panelPurchasePrice + " Ft/egység. Egy egység szekrényhez 2 egység bútorlap szükséges.)");
        Scanner sc = new Scanner(System.in);
        try {
            int a = Integer.parseInt(sc.next());

            if (a >= 0) {
                stock += a;
                expenses += a * panelPurchasePrice;
                System.out.println("Bútorlap mennyiség: " + stock);
                System.out.println("Bútorlap vásárlás költsége: " + expenses);
            } else {
                System.out.println("A vásárolt mennyiség nem lehet negatív");
                purchase();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
        }
    }
}
