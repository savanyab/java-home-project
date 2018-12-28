import java.util.Scanner;

public class Advertisement extends Company {
    private int price;
    private int adCount;

    public Advertisement() {
        price = 5000;
    }

    public void changeAdCount(){
        System.out.println("Hogyan változzon a reklámok száma?");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        adCount += a;
    }
}
