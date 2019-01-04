public class Main {
    private static final int TARGET_CAPITAL = 2000000;

    public static void main(String[] args) {

        Company company = new Company();
        RawMaterial rawMaterial = new RawMaterial();
        Employees employees = new Employees();
        Cupboards cupboards = new Cupboards(rawMaterial);
        Advertisement ad = new Advertisement();

        while(Company.getCapital() < TARGET_CAPITAL ) {
                company.setIncome(0);
                company.setExpenses(0);
                System.out.println(company.getRound() + ". hónap eleje: " + company.toString(employees, cupboards, rawMaterial, ad));
                employees.decideEmployeeCount();
                rawMaterial.purchasePanels();
                rawMaterial.purchaseGlass();
                ad.changeAdCount();
                cupboards.produce(rawMaterial, employees);
                cupboards.sellCupboards(ad);
                employees.payWages();
                company.setExpenses(employees.getExpenses() + rawMaterial.getExpenses() + ad.getExpenses());
                company.setIncome(cupboards.getIncome());
                company.nextRound();
                System.out.println(company.getRound()-1 + ". hónap vége: " + company.toString(employees, cupboards, rawMaterial, ad));
        }


    }




}
