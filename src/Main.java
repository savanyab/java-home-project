import java.util.Scanner;

public class Main {
    private static final int TARGET_CAPITAL = 2000000;

    public static void main(String[] args) {

        Company company = new Company();
        FurniturePanels panels = new FurniturePanels();
        Glass glass = new Glass();
        Employees employees = new Employees();


        while(company.getCapital() > 0) {
            System.out.println(company.getRound() + ". hónap eleje: " + company);
            panels.purchaseRawMaterial();
            glass.purchaseRawMaterial();
            employees.hire();
            employees.dismiss();
            employees.payWages();
            company.setExpenses(panels.getExpenses() + glass.getExpenses() + employees.getExpenses());
            System.out.println(company.getRound() + ". hónap vége: " + company);
            company.nextRound();

        }


    }




}
