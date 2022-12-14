package org.java.labs.lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * class Tariff
 */
public abstract class Tariff {
    /**
     * fields
     */
    private final int cost;
    private final String name;
    private final int gigabytes;
    private final int minutes;
    private final int messages;
    private final List<Client> clients = new ArrayList<>();

    /**
     * constructor Tariff
     *
     * @param cost
     * @param name
     * @param gigabytes
     * @param minutes
     * @param messages
     */
    public Tariff(int cost, String name, int gigabytes, int minutes, int messages){
        this.cost = cost;
        this.name = name;
        this.gigabytes = gigabytes;
        this.minutes = minutes;
        this.messages = messages;
    }

    /**
     * getters and setters
     */
    public int getCost() {
        return cost;
    }

    public String getName(){
        return name;
    }
    public int getGigabytes() {
        return gigabytes;
    }
    public int getMinutes() {
        return minutes;
    }
    public int getMessages() {
        return messages;
    }
    public List<Client> getClients() {
        return clients;
    }

    /**
     * method addClient
     * adding Client to Tariff
     *
     * @param client
     */
    public void addClient(Client client){
        this.clients.add(client);
    }
}
