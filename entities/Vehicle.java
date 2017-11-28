package com.company.entities;

import com.company.plate.Plate;

/**
 * Created by BaoX on 24/11/2017.
 */
public class Vehicle {
    public Plate plate;
    public double engineCapacityinCC;
    public double engineCapacityinL;
    public String type;

    public Vehicle(Plate plate, double engineCapacityinCC, String type) {
        this.plate = plate;
        this.engineCapacityinCC = engineCapacityinCC;
        this.type = type;
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

    public double getEngineCapacityinL() {
        return engineCapacityinCC/1000;
    }

    public void setEngineCapacityinL(double engineCapacityinL) {
        this.engineCapacityinL= engineCapacityinCC/1000;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
