package org.java.labs.lab6;
/**
 * class Kyivstar extends Tariff
 */
public class Kyivstar extends Tariff {
    /**
     * constructor Kyivstar
     *
     * @param cost
     * @param name
     * @param gigabytes
     * @param minutes
     * @param messages
     */
    public Kyivstar(int cost, String name, int gigabytes, int minutes, int messages) {
        super(cost, name, gigabytes, minutes, messages);
    }
}