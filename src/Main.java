public class Main {
    private static final int TARGET_CAPITAL = 2000000;

    public static void main(String[] args) {

        Company company = new Company();
        FurniturePanels panels = new FurniturePanels();
        Glass glass = new Glass();
        Employees employees = new Employees();
        Cupboards cupboards = new Cupboards(panels, glass);
        Advertisement ad = new Advertisement();

        while(company.getCapital() < TARGET_CAPITAL ) {
                employees.decideEmployeeCount();
                panels.purchase();
                glass.purchase();
                ad.changeAdCount();
                cupboards.produce(panels, glass, employees);
                cupboards.sellCupboards(ad);
                employees.payWages();
                company.setExpenses(employees.getExpenses() + panels.getExpenses() + glass.getExpenses() + ad.getExpenses());
                company.setIncome(cupboards.getIncome());
                company.nextRound();
                System.out.println(company.getRound()-1 + ". hónap vége: " + company.toString(employees, cupboards, panels, glass, ad));
        }


    }




}
