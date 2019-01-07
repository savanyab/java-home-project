import java.util.InputMismatchException;
import java.util.Scanner;

public class Glass extends RawMaterial {
    private int glassPurchasePrice = 3000;

    public int getPurchasePrice() {return glassPurchasePrice;}

    public void purchase() {
        System.out.println("Mennyi üveget vegyünk? (" + stock + " van raktáron. Egy egység ára " + glassPurchasePrice+ " .Egy egység szekrényhez 1 egység üveg szükséges.)" );
        Scanner sc = new Scanner(System.in);
        try {
            int a = Integer.parseInt(sc.next());
            if (a >= 0) {
                stock += a;
                expenses += a * glassPurchasePrice;
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
