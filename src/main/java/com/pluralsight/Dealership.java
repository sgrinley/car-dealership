package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

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

    // Generate Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }

    // Add and Remove
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
    // Search Methods
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) results.add(v);
        }
        return results;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }
}
