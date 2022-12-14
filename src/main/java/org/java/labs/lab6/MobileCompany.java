package org.java.labs.lab6;

import org.java.labs.lab7.LinkedList;

import java.util.List;

/**
 * class MobileCompany
 */
public class MobileCompany {
    /**
     * field
     */
    LinkedList<Tariff> tariffs;

    /**
     * constructor MobileCompany
     *
     * @param tariffs
     */

    public MobileCompany(LinkedList<Tariff> tariffs){
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
