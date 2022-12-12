package org.java.labs.lab6;

import java.util.List;

public class MobileCompany {
    List<Tariff> tariffs;

    public MobileCompany(List<Tariff> tariffs){
        this.tariffs = tariffs;
    }

    public void addTariff(Tariff tariff){
        tariffs.add(tariff);
    }
}
