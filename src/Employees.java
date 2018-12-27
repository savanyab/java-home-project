import java.util.InputMismatchException;
import java.util.Scanner;

public class Employees extends Company{
    private final int WAGE = 50000;


    public void decideEmployeeCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hogyan változzon az alkalmazottak létszáma? " + '\n' +
                "Pozitív szám: munkaerő felvétel. " + '\n' +
                "Nulla: nem változik a létszám." + '\n' +
                "Negatív szám: elbocsátás.");

        try {
            int i = Integer.parseInt(sc.next());
            if (employeeCount + i < 0){
                System.out.println("Alkalmazottak száma: " + employeeCount + ". Többet nem lehet elbocsátani.");
                decideEmployeeCount();
            }else  {
                changeEmployeeCount(i);
            }

        } catch(InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
            decideEmployeeCount();
        }
    }

    public void changeEmployeeCount(int i) {
        int a = employeeCount + i;
        int b = a * 50000;
        if (capital - b >= 0) {
            employeeCount += i;
            productsPerMonth = employeeCount * 30;
            System.out.println("alkalmazottak száma: " + employeeCount);
        } else {
            System.out.println("A rendelkezésre álló tőke " + capital + ". "
                    + i + " alkalmazott felvétele után " + b + " összeget kellene bérként fizetni hónap végén. " +
                    "Kevesebb alkalmazottat vegyél fel!");
            decideEmployeeCount();
        }
    }



    public void payWages() {
        capital -= employeeCount * WAGE;
        setExpenses(employeeCount * WAGE);
        System.out.println("bérfizetés: " + employeeCount * WAGE + " tőke: " + capital);
        System.out.println("alkalmazottak expenses: " + getExpenses());
    }
}
