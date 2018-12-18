import java.util.Scanner;

public class FurniturePanels extends RawMaterial{
        private int purchasePrice = 100;
        private int quantity = 0;

    public void purchaseRawMaterial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi bútorlapot vegyünk?");
        int a = sc.nextInt();
        capital -= a * purchasePrice;
        quantity += a;
        expenses += a * purchasePrice;
    }

}
