package org.java.labs.lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * class MobileCompanyManager
 * manage functions of MobileCompany
 */
public class MobileCompanyManager {
    /**
     * field mobileCompany
     */
    MobileCompany mobileCompany;

    /**
     * constructor MobileCompanyManager
     *
     * @param mobileCompany
     */
    public MobileCompanyManager(MobileCompany mobileCompany){
        this.mobileCompany = mobileCompany;
    }

    /**
     * method getClientsCount
     * returns amount of clients
     *
     * @return
     */
    public int getClientsCount(){
        int count = 0;
        for (Tariff tariff : mobileCompany.tariffs) {
            count += tariff.getClients().size();
        }

        return count;
    }

    /**
     * method sortTariffsByCosts
     * sorting tariffs from min value to max value
     *
     * @return
     */
    public List<Tariff> sortTariffsByCosts(){
        List<Tariff> tariffs = new ArrayList<>(this.mobileCompany.tariffs);
        boolean isSorted = false;
        Tariff exchanger;

        while (!isSorted){
            for (int i = 0; i < tariffs.size(); i++) {
                for (int j = 0; j < tariffs.size(); j++) {
                    if (tariffs.get(i).getCost() < tariffs.get(j).getCost()) {
                        exchanger = tariffs.get(j);
                        tariffs.set(j, tariffs.get(i));
                        tariffs.set(i, exchanger);
                        isSorted = false;
                    } else {
                        isSorted = true;
                    }
                }
            }
        }

        return tariffs;
    }

    /**
     * method getTariffByCost
     * returns Tariff with cost in the range of minCost and maxCost or null
     *
     * @param minCost
     * @param maxCost
     * @return
     */
    public Tariff getTariffByCost(int minCost, int maxCost){
        for (Tariff tariff: this.mobileCompany.tariffs) {
            if(tariff.getCost() >= minCost && tariff.getCost() <= maxCost) {
                return tariff;
            }
        }

        return null;
    }
}