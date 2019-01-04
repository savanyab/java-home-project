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
        System.out.println("Hogyan változzon a reklámok száma?");
        Scanner sc = new Scanner(System.in);
        try {
            int i = Integer.parseInt(sc.next());
            if (adCount + i < 0){
                System.out.println("Reklámok száma: " + adCount + ". Többet nem lehet lemondani.");
                changeAdCount();
            }else  {
                adCount += i;
                adExpenses = adCount * adPrice;
                System.out.println("ad expenses: " + adExpenses);
            }
        } catch(InputMismatchException | NumberFormatException e) {
            System.out.println("Egész számot vagy nullát írj be!");
            changeAdCount();
        }

    }
}
