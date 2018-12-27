import java.util.InputMismatchException;
import java.util.Scanner;

public class Employees extends Company{
    private final int WAGE = 50000;


    public void changeEmployeeCount() {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Hogyan változzon az alkalmazottak létszáma? " +
                    "Pozitív szám: munkaerő felvétel. Nulla: nem változik a létszám. Negatív szám: elbocsátás.");

            int i = Integer.parseInt(sc.next());
            if (employeeCount + i >= 0){
                employeeCount += i;
                productsPerMonth = employeeCount * 30;
                System.out.println("alkalmazottak: " + employeeCount);
            }else  {
                System.out.println("Alkalmazottak száma: " + employeeCount + ". Többet nem lehet elbocsátani.");
                changeEmployeeCount();
            }

        } catch(InputMismatchException | NumberFormatException e) {
            System.out.println("Pozitív egész számot vagy nullát írj be!");
            changeEmployeeCount();
        }
    }


    public void payWages() {
        capital -= employeeCount * WAGE;
        setExpenses(employeeCount * WAGE);
        System.out.println("bérfizetés: " + employeeCount * WAGE + " tőke: " + capital);
        System.out.println(" alkalmazottak expenses: " + getExpenses());
    }
}
