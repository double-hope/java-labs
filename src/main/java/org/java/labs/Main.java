package org.java.labs;

import org.java.labs.lab6.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Tariff mts1 = new MTS(125, "All for you", 10_000, 100, 100);
        Tariff mts2 = new MTS(150, "More Internet", 15_000, 150, 100);
        Tariff mts3 = new MTS(175, "Your premium", 20_000, 200, 100);

        Tariff kyivstar1 = new Kyivstar(50, "Your enough", 4_000, 50, 0);
        Tariff kyivstar2 = new Kyivstar(100, "More gigabytes", 10_000, 75, 20);
        Tariff kyivstar3 = new Kyivstar(150, "Your optimum", 15_000, 100, 50);

        Tariff life1 = new Life(90, "Your life", 8_000, 100, 20);
        Tariff life2 = new Life(100, "LOVE UA", 10_000, 100, 30);
        Tariff life3 = new Life(110, "Your maximum", 12_000, 100, 40);

        MobileCompany mobileCompany = new MobileCompany(List.of(mts1, mts2, mts3, kyivstar1, kyivstar2, kyivstar3, life1, life2, life3));
        MobileCompanyManager mobileCompanyManager = new MobileCompanyManager(mobileCompany);

        mts1.addClient(new Client("Masha"));
        mts1.addClient(new Client("Vitya"));
        kyivstar3.addClient(new Client("Sasha"));
        kyivstar3.addClient(new Client("Vova"));
        kyivstar3.addClient(new Client("Vlad"));
        kyivstar3.addClient(new Client("Ira"));
        life2.addClient(new Client("Kira"));
        life1.addClient(new Client("Eugene"));

        System.out.println(mobileCompanyManager.getClientsCount());
        List<Tariff> sortedTariffs = mobileCompanyManager.sortTariffsByCosts();

        System.out.println("Sorted tariffs:");
        for (Tariff tariff: sortedTariffs) {
            System.out.println(tariff.getName() + " --- " + tariff.getCost());
        }

        Tariff chosenTariff = mobileCompanyManager.getTariffByCost(40, 90);

        System.out.println(chosenTariff == null ? "No such tariff" : chosenTariff.getName() + " --- " + chosenTariff.getCost());

    }
}
