import java.util.Scanner;

public class Advertisement extends Company {
    private int adPrice;
    private int adCount;

    public Advertisement() {
        adPrice = 5000;
    }

    public int getAdCount() {
        return adCount;
    }

    public void changeAdCount(){
        System.out.println("Hogyan változzon a reklámok száma?");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        adCount += a;
        setExpenses(adCount * adPrice);
        System.out.println("ad * price: " + adCount * adPrice);
    }
}
