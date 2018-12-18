import java.util.Scanner;

public class Glass extends RawMaterial {
    private int purchasePrice = 85;
    private int quantity;


    public void purchaseRawMaterial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi üveget vegyünk?");
        int a = sc.nextInt();
        capital -= a * purchasePrice;
        quantity += a;
        expenses += a * purchasePrice;
    }
}
