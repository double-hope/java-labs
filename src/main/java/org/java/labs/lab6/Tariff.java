package org.java.labs.lab6;

public class Tariff {
    private final int cost;
    private final String name;
    private final int gigabytes;
    private final int minutes;
    private final int messages;
    public Tariff(int cost, String name, int gigabytes, int minutes, int messages){
        this.cost = cost;
        this.name = name;
        this.gigabytes = gigabytes;
        this.minutes = minutes;
        this.messages = messages;
    }
}
