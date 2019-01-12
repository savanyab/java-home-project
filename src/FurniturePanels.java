import java.util.InputMismatchException;
import java.util.Scanner;

public class FurniturePanels extends RawMaterial {
    private int panelPurchasePrice;
    private Scanner sc = new Scanner(System.in);

    public int getPurchasePrice() {return panelPurchasePrice;}

    public void setPanelPurchasePrice(int a) { panelPurchasePrice = a; }

    private void decidePanelPurchasePrice() {
        System.out.println("Milyen áron vegyünk bútorlapot? A piacon 3000 és 6000 Ft között árulják.");
        try {
            int a = Integer.parseInt(sc.next());
            if (a >= 3000 && a <= 6000) {
                panelPurchasePrice = a;
            } else {
                System.out.println("3000 és 6000 Ft közti összeget adj meg!");
                decidePanelPurchasePrice();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
            decidePanelPurchasePrice();
        }
    }

    public void purchase() {
        decidePanelPurchasePrice();
        System.out.println("Mennyi bútorlapot vegyünk? (" + stock + " van raktáron. Ára " + panelPurchasePrice + " Ft/egység. Egy egység szekrényhez 2 egység bútorlap szükséges.)");
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

    public void reducePanelStock(int productQuantity, int panelPerProduct) {
        stock -= (productQuantity * panelPerProduct);
        System.out.println("Bútorlap készlet: " + stock);
    }
}
