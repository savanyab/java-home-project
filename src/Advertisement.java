import java.util.Scanner;

public class Advertisement {
    private int adPrice;
    private int adCount;
    private int adExpenses;

    public Advertisement() {
        adPrice = 5000;
    }

    public int getAdCount() {
        return adCount;
    }

    public int getExpenses() { return adExpenses; }

    public void changeAdCount(){
        System.out.println("Hogyan változzon a reklámok száma?");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        adCount += a;
        adExpenses = adCount * adPrice;
        System.out.println("ad * price: " + adCount * adPrice);
    }
}
