package com.rishabh_deep.rishabh_deep_a2.model;

import java.io.Serializable;

/**
 * PowerSource model class that implements Serializable Interface
 *
 * @author Rishabh
 * @author Deep
 */
public class PowerSource implements Serializable {

    //instantiating data fields
    private int id;
    private String description;

    //parameterised constructor
    public PowerSource(int id, String description) {
        this.id = id;
        this.description = description;
    }

    //default constructor for java bean
    public PowerSource() {
    }

    /*
         * Getters and Setters for PowerSource class
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
