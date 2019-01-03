public class Main {
    private static final int TARGET_CAPITAL = 2000000;

    public static void main(String[] args) {

        Company company = new Company();
        RawMaterial rawMaterial = new RawMaterial();
        Employees employees = new Employees();
        Cupboards cupboards = new Cupboards();
        Advertisement ad = new Advertisement();

        while(Company.capital < TARGET_CAPITAL ) {
                company.setIncome(0);
                company.setExpenses(0);
                System.out.println(company.getRound() + ". hónap eleje: " + company);
                employees.decideEmployeeCount();
                rawMaterial.purchasePanels();
                rawMaterial.purchaseGlass();
                ad.changeAdCount();
                cupboards.produceGoods();
                cupboards.sellCupboards();
                employees.payWages();
                company.setExpenses(employees.getExpenses() + rawMaterial.getExpenses() + ad.getExpenses());
                company.setIncome(cupboards.getIncome());
                System.out.println(company.getRound() + ". hónap vége: " + company);
                company.nextRound();
        }


    }




}
