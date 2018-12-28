import java.util.InputMismatchException;
import java.util.Scanner;

public class Glass  extends RawMaterial{
    public static int glassStock;

    public static int getGlassStock() {
        return glassStock;
    }

    public Glass(){super(4000);}

    public void purchaseRawMaterial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi üveget vegyünk?");

        try {
            int a = Integer.parseInt(sc.next());
            if (a >= 0 && a * purchasePrice <= capital) {
                capital -= a * purchasePrice;
                glassStock += a;
                System.out.println("üveg mennyiség: " + glassStock);
                setExpenses(a * purchasePrice);
                System.out.println("üveg expenses: " + getExpenses());
            } else if (a * purchasePrice > capital) {
                System.out.println("A rendelkezésre álló tőke " + capital + ". " +
                        a + " egység üveg beszerzése " + a * purchasePrice + " összegbe kerülne. Kevesebb üveget rendelj!");
                purchaseRawMaterial();
            } else {
                System.out.println("A mennyiség nem lehet negatív");
                purchaseRawMaterial();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
            purchaseRawMaterial();
        }



    }

}
