package org.java.labs.lab6;

import java.util.List;

/**
 * class MobileCompany
 */
public class MobileCompany {
    /**
     * field
     */
    List<Tariff> tariffs;

    /**
     * constructor MobileCompany
     *
     * @param tariffs
     */

    public MobileCompany(List<Tariff> tariffs){
        this.tariffs = tariffs;
    }

    /**
     * method addTariff
     * adding a Tariff to MobileCompany tariffs
     *
     * @param tariff
     */
    public void addTariff(Tariff tariff){
        tariffs.add(tariff);
    }
}
