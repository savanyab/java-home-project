import java.util.InputMismatchException;
import java.util.Scanner;

public class FurniturePanels extends RawMaterial{

    public FurniturePanels() {super(3500, 0);}

    public void purchaseRawMaterial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi bútorlapot vegyünk?");

        try {
            int a = Integer.parseInt(sc.next());
            purchasePanels(a);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
            purchaseRawMaterial();
        }
    }

    public void purchasePanels(int a) {
        if (a >= 0 && a * purchasePrice <= capital) {
            capital -= a * purchasePrice;
            quantity += a;
            System.out.println("bútorlap mennyiség: " + quantity);
            setExpenses(a * purchasePrice);
            System.out.println("bútorlap expenses: " + getExpenses());
        } else if (a * purchasePrice > capital) {
            System.out.println("A rendelkezésre álló tőke " + capital + ". " +
                    a + " egység bútorlap beszerzése " + a * purchasePrice + " összegbe kerülne. Kevesebb bútorlapot rendelj!");
            purchaseRawMaterial();
        } else {
            System.out.println("A mennyiség nem lehet negatív");
            purchaseRawMaterial();
        }
    }



    @Override
    public void useRawMaterial() {

    }

}
