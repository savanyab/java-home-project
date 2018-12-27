import java.util.Scanner;

public class FurniturePanels extends RawMaterial{

    public FurniturePanels() {super(100, 0);}

    public void purchaseRawMaterial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi bútorlapot vegyünk?");
        int a = sc.nextInt();
        //capital -= a * purchasePrice;
        setCapital(getCapital() - a * purchasePrice);
        quantity += a;
        System.out.println("bútorlap mennyiség: " + quantity);
        // expenses += a * purchasePrice;
        setExpenses(a * purchasePrice);
        System.out.println("bútorlap expenses: " + getExpenses());
    }

    @Override
    public void useRawMaterial() {

    }

}
