import java.awt.*;
import java.util.Scanner;

public class Main {
    private static final int TARGET_CAPITAL = 2000000;

    public static void main(String[] args) {
        //game();
        //exitOrRestart();

        EventQueue.invokeLater(() -> {
            Window window = new Window();
            window.setVisible(true);
        });
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
            company.setExpenses(employees.getExpenses() + panels.getExpenses() + glass.getExpenses() + ad.getExpenses());
            company.setIncome(cupboards.getIncome());
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
