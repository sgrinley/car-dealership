package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class DealershipFileManager {
    public Dealership getDealership() throws FileNotFoundException {
        Dealership dealership = null;
        try (Scanner scanner = new Scanner(new File("inventory.csv"))) {
            if (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("\\|");
                dealership = new Dealership(parts[0], parts[1], parts[2]);
            }
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("\\|");
                Vehicle v = new Vehicle(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5],
                        Integer.parseInt(parts[6]),
                        Double.parseDouble(parts[7]));
                dealership.addVehicle(v);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: inventory.csv not found.");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventory.csv"))) {
            // Write Dealership Info
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();
            // Write Vehicles
            for (Vehicle v : dealership.getAllVehicles()) {
                bw.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" +
                        v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving dealership: " + e.getMessage());
        }
    }
}