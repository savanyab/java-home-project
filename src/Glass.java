import java.util.Scanner;

public class Glass extends RawMaterial {

    public Glass(){super(85, 0);}

    public void purchaseRawMaterial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mennyi üveget vegyünk?");
        int a = sc.nextInt();
        capital -= a * purchasePrice;
        //setCapital(getCapital() - a * purchasePrice);
        quantity += a;
        System.out.println("üveg mennyiség: " + quantity);
        //expenses += a * purchasePrice;
        setExpenses(a * purchasePrice);
        System.out.println("üveg expenses: " + getExpenses());
    }

    @Override
    public void useRawMaterial() {

    }
}
