package com.flow.management.gui;

import com.flow.management.*;

import javax.swing.*;

public class Window extends JFrame {

    private Company company = new Company();
    private Advertisement ad = new Advertisement();
    private Glass glass = new Glass();
    private Employees employees = new Employees();
    private FurniturePanels panels = new FurniturePanels();
    private Cupboards cupboards = new Cupboards();

    private EmployeeGUI employeeGUI;
    private AdvertisementGUI advertisementGUI;
    private FurniturePanelsGUI furniturePanelsGUI;
    private GlassGUI glassGUI;
    private CupboardsGUI cupboardsGUI;

    private JTextArea allInfos = new JTextArea();
    private ShowSellingInfo sellingInfo;
    private Rules gameRules;

    public Window() {
        setTitle("FurnitureFactory");
        setSize(950, 470);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JButton rules = new JButton("Játékszabályok");
        employeeGUI = new EmployeeGUI(this, employees);
        advertisementGUI = new AdvertisementGUI(this, ad);
        furniturePanelsGUI = new FurniturePanelsGUI(this, panels);
        glassGUI = new GlassGUI(this, glass);
        cupboardsGUI = new CupboardsGUI(this, cupboards, employees, glass, panels);

        startMonth();

        allInfos.setBounds(725, 30, 205, 300);
        allInfos.setEditable(false);

        JTextArea companyInfo = new JTextArea();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Reklám", advertisementGUI);
        tabbedPane.add("Alkalmazottak", employeeGUI);
        tabbedPane.add("Bútorlapok", furniturePanelsGUI);
        tabbedPane.add("Üveg", glassGUI);

        tabbedPane.add("Szekrények", cupboardsGUI);
        tabbedPane.addChangeListener(e -> cupboardsGUI.recalculate());

        companyInfo.setText(company.toString(employees, cupboards, panels, glass, ad));
        companyInfo.setBounds(10, 340, 700, 50);
        companyInfo.setEditable(false);

        JButton acceptChanges = new JButton("Jóváhagyás");

        acceptChanges.addActionListener(e -> {
            increaseStocks();
            reduceStocks();
            cupboards.receiveIncomeOfSoldGoods();
            company.nextRound(employees, ad, panels, glass, cupboards);
            sellingInfo = new ShowSellingInfo(company, cupboards);
            companyInfo.setText(company.toString(employees, cupboards, panels, glass, ad));
            if (company.getCapital() <= 0 || company.getCapital() >= 2000000) {
                endGame();
            } else {
                startMonth();
            }
        });

        rules.addActionListener(e -> gameRules = new Rules());

        rules.setBounds(800, 5, 130, 20);
        tabbedPane.setBounds(10, 10, 700, 320);
        acceptChanges.setBounds(760, 350, 130, 35);

        add(companyInfo);
        add(tabbedPane);
        add(allInfos);
        add(acceptChanges);
        add(rules);
    }

    private int exitOrRestart() {
        String[] options = {"Igen", "Nem"};
        return JOptionPane.showOptionDialog(null,
                "Szeretnél új játékot kezdeni?",
                "Játék vége",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options, null);
    }

    private void endGame() {
        int decision = exitOrRestart();
        sellingInfo.dispose();
        if (decision == 1) {
            dispose();
        } else {
            dispose();
            Company.setRound(1);
            Window window = new Window();
            window.setVisible(true);
        }
    }

    private void increaseStocks() {
        panels.increaseStock();
        glass.increaseStock();
        cupboards.increaseStock();
    }

    private void reduceStocks() {
        cupboards.setSoldQuantity(cupboardsGUI.getSellingQuantity(), ad);
        cupboards.reduceStock();
        cupboards.reduceRawMaterials(cupboards.getProducedPerMonth(), panels, glass);
    }

    private void startMonth() {
        employeeGUI.startMonth();
        advertisementGUI.startMonth();
        cupboardsGUI.startMonth();
        glassGUI.startMonth();
        furniturePanelsGUI.startMonth();
        allInfos.setText(String.format("Döntések alapján várható költségek:" +
                "\n\nBérköltség: %,8d%n" +
                "\nReklámköltség: %,8d%n" +
                "\nBútorlap vásárlás: 0\n" +
                "\nÜveg vásárlás: 0\n" +
                "\n\nÖsszesen: %,8d%n" +
                "\n\nMaximum bevétel: %,8d%n",
                employees.getWAGE() * employees.getEmployeeCount(),
                ad.getCount() * ad.getPrice(),
                (employees.getWAGE() * employees.getEmployeeCount() + ad.getCount() * ad.getPrice()),
                cupboardsGUI.showMaximumIncome())
        );
    }

    void setAllInfos() {
        int employeeExpenses = employees.getWAGE() * employees.getEmployeeCount();
        int adExpenses = ad.getCount() * ad.getPrice();
        int panelsExpenses = panels.getExpenses();
        int glassExpenses = glass.getExpenses();
        allInfos.setText(String.format("Döntések alapján várható költségek:" +
                "\n\nBérköltség: %,8d%n" +
                "\nReklámköltség: %,8d%n" +
                "\nBútorlap vásárlás: %,8d%n" +
                "\nÜveg vásárlás: %,8d%n" +
                "\n\nÖsszesen: %,8d%n"  +
                "\n\n\nMaximum bevétel: %,8d%n",
                employeeExpenses,
                adExpenses,
                panelsExpenses,
                glassExpenses,
                (employeeExpenses + adExpenses + panelsExpenses + glassExpenses),
                cupboardsGUI.showMaximumIncome()));
    }

}
