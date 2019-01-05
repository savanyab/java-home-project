import java.util.InputMismatchException;
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
        System.out.println("Jelenleg " + adCount + " reklámunk van. Hogyan változzon a számuk?");
        Scanner sc = new Scanner(System.in);
        try {
            int i = Integer.parseInt(sc.next());
            if (adCount + i < 0){
                System.out.println("Reklámok száma: " + adCount + ". Többet nem lehet lemondani.");
                changeAdCount();
            }else  {
                adCount += i;
                adExpenses = adCount * adPrice;
                System.out.println("Havi reklámköltség: " + adExpenses);
            }
        } catch(InputMismatchException | NumberFormatException e) {
            System.out.println("Egész számot írj be!");
            changeAdCount();
        }

    }

    public double setSellingRate(){
        double b = Math.random();
        double sellingRate = b + adCount * 0.05;
        System.out.println("randomszám: " + b);
        System.out.println("Eladási arány: " + sellingRate);
        return sellingRate < 1 ? sellingRate : 1;
    }
}
