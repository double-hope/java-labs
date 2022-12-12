package org.java.labs.lab6;

/**
 * class MTS extends Tariff
 */
public class MTS extends Tariff {
    /**
     * constructor MTS
     *
     * @param cost
     * @param name
     * @param gigabytes
     * @param minutes
     * @param messages
     */
    public MTS(int cost, String name, int gigabytes, int minutes, int messages) {
        super(cost, name, gigabytes, minutes, messages);
    }
}