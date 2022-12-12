package org.java.labs.lab6;

import java.util.ArrayList;
import java.util.List;

public class MobileCompanyManager {
    MobileCompany mobileCompany;

    public MobileCompanyManager(MobileCompany mobileCompany){
        this.mobileCompany = mobileCompany;
    }

    public int getClientsCount(){
        int count = 0;
        for (Tariff tariff : mobileCompany.tariffs) {
            count += tariff.getClients().size();
        }

        return count;
    }

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

    public Tariff getTariffByCost(int minCost, int maxCost){
        for (Tariff tariff: this.mobileCompany.tariffs) {
            if(tariff.getCost() >= minCost && tariff.getCost() <= maxCost) {
                return tariff;
            }
        }

        return null;
    }
}