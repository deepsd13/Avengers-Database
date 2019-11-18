package com.rishabh_deep.rishabh_deep_a2.model;

import java.io.Serializable;

/**
 * Avenger model class that implements Serializable interface
 * @author Rishabh
 * @author Deep
 */
public class Avenger implements Serializable{

    //data fields
    private int id;
    private String name;
    private String description;
    private PowerSource powerSource;

    //constructor - used to add data from database to avenger arraylist
    public Avenger(int id, String name, String description, PowerSource powerSource) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.powerSource = powerSource;
    }

    //overloaded constructor
    public Avenger(String name, String description, PowerSource powerSource) {
        this.name = name;
        this.description = description;
        this.powerSource = powerSource;
    }

    //default constructor for use of java bean
    public Avenger() {
    }

    /*
        * Getters and Setters for Avenger Model Class 
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

}
