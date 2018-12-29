import java.util.Scanner;

public class Advertisement extends Company {
    private int price;
    private static int adCount;

    public Advertisement() {
        price = 5000;
    }

    public static int getAdCount() {
        return adCount;
    }

    public void changeAdCount(){
        System.out.println("Hogyan változzon a reklámok száma?");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        adCount += a;
        capital -= adCount * price;
        System.out.println("capital: " + capital);
        System.out.println("ad * price: " + adCount * price);
    }
}
