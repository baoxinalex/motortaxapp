package com.company.entities;

import com.company.plate.Plate;

public class Vehicle {

    //engine capacity in L is removed as it's not used for calculation and it's automatically converted into cc during the controller.
    private Plate plate;
    private double engineCapacityinCC;

    public Vehicle(Plate plate, double engineCapacityinCC) {
        this.plate = plate;
        this.engineCapacityinCC = engineCapacityinCC;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public double getEngineCapacityinCC() {
        return engineCapacityinCC;
    }

    public void setEngineCapacityinCC(double engineCapacityinCC) {
        this.engineCapacityinCC = engineCapacityinCC;
    }
}
