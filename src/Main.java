public class Main {
    private static final int TARGET_CAPITAL = 2000000;

    public static void main(String[] args) {
        Company company = new Company();
        System.out.println(company);

        FurniturePanels panels = new FurniturePanels();
        Glass glass = new Glass();
        Employees employees = new Employees();

        while(Company.capital > 800000) {
            panels.purchaseRawMaterial();
            glass.purchaseRawMaterial();
            employees.hire();
            employees.payWages();
            company.nextRound();
            System.out.println(company);
        }


    }
}
