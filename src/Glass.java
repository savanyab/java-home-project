import java.util.InputMismatchException;
import java.util.Scanner;

public class Glass extends RawMaterial {
    private int glassPurchasePrice;
    private Scanner sc = new Scanner(System.in);

    public int getPurchasePrice() {return glassPurchasePrice;}

    private void decideGlassPurchasePrice() {
        System.out.println("Milyen áron vegyünk üveget? A piacon 2500 és 5000 Ft között érhető el.");
        try {
            int a = Integer.parseInt(sc.next());
            if (a >= 2500 && a <= 5000) {
               glassPurchasePrice = a;
            } else {
                System.out.println("2500 és 5000 Ft közti összeget adj meg!");
                decideGlassPurchasePrice();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
            decideGlassPurchasePrice();
        }
    }

    public void purchase() {
        decideGlassPurchasePrice();
        System.out.println("Mennyi üveget vegyünk? (" + stock + " van raktáron. Egy egység ára " + glassPurchasePrice+ " .Egy egység szekrényhez 1 egység üveg szükséges.)" );
        try {
            int a = Integer.parseInt(sc.next());
            if (a >= 0) {
                stock += a;
                expenses = a * glassPurchasePrice;
                System.out.println("Üveg mennyiség: " + stock);
                System.out.println("Üveg vásárlás költsége: " + expenses);
            } else {
                System.out.println("A vásárolt mennyiség nem lehet negatív");
                purchase();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
            purchase();
        }
    }

    public void reduceGlassStock(int productQuantity, int glassPerProduct) {
        stock -= (productQuantity * glassPerProduct);
        System.out.println("Üveg készlet: " + stock);
    }

}
