import java.util.Scanner;

public class Main {
    private static final int TARGET_CAPITAL = 2000000;

    public static void main(String[] args) {
        System.out.println("Kedves Cégvezető!\nGratulálok szekrénygyárad bejegyzéséhez! A cég kezdő tőkéje 1.000.000 Ft, ennek megduplázása a cél a következő hónapokban." +
                "\nEgy hónap során változtathatod az alkalmazottak létszámát, eldöntheted, mennyi nyersanyagot vásárolsz a gyártáshoz és milyen áron. " +
                "\nAz alkalmazottak számától és a nyersanyagok mennyiségétől függően elrendelheted, mennyi terméket állítsunk elő, ezekből mennyit próbáljunk eladni. " +
                "\nReklámokat is rendelhetsz, ezek az eladási arányt növelik (minden darab 5%-kal).\nSok sikert a cég vezetéséhez! ");
        game();
        exitOrRestart();
    }

    private static void game() {
        Company company = new Company();
        FurniturePanels panels = new FurniturePanels();
        Glass glass = new Glass();
        Employees employees = new Employees();
        Cupboards cupboards = new Cupboards();
        Advertisement ad = new Advertisement();

        while(company.getCapital() < TARGET_CAPITAL && company.getCapital() > 0) {
            employees.decideEmployeeCount();
            panels.purchase();
            glass.purchase();
            ad.changeAdCount();
            cupboards.produce(panels, glass, employees);
            cupboards.sellCupboards(ad, panels, glass);
            employees.payWages();
            company.setExpenses(employees, panels, glass, ad);
            company.setIncome(cupboards);
            company.changeCapital();
            company.nextRound();
            System.out.println(company.getRound()-1 + ". hónap vége: " + company.toString(employees, cupboards, panels, glass, ad));
        }

        if (company.getCapital() <= 0) {
            System.out.println("Tönkrement a cég :(");
        } else {
            System.out.println("Gratulálok, nyertél!");
        }
    }

    private static void exitOrRestart() {
        System.out.println("Szeretnél újra játszani?");
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if (!a.equals("nem")) {
            game();
        } else {
            System.exit(0);
        }
    }
}
