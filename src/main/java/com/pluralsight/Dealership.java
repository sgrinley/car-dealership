package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

//    Add: Data Fields
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


//    Generate Constructor
    public Dealership(String name, String address, String phone) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.inventory = new ArrayList<>(); // Initialized list
    }
}
