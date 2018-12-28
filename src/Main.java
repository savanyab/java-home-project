import java.util.Scanner;

public class Main {
    private static final int TARGET_CAPITAL = 2000000;

    public static void main(String[] args) {

        Company company = new Company();
        FurniturePanels panels = new FurniturePanels();
        Glass glass = new Glass();
        Employees employees = new Employees();
        Cupboards cupboards = new Cupboards();

        while(company.getCapital() > 0) {
            System.out.println(company.getRound() + ". hónap eleje: " + company);
            employees.decideEmployeeCount();
            panels.purchaseRawMaterial();
            glass.purchaseRawMaterial();
            cupboards.produceGoods();
            cupboards.sellCupboards();
            employees.payWages();
            company.setExpenses(panels.getExpenses() + glass.getExpenses() + employees.getExpenses());
            company.setIncome(cupboards.getIncome());
            System.out.println(company.getRound() + ". hónap vége: " + company);
            company.nextRound();

        }


    }




}
