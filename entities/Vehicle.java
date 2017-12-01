package com.company.entities;

import com.company.plate.Plate;

/**
 * Created by BaoX on 24/11/2017.
 */
public class Vehicle {

    //engine capacity in L is removed as it's not used for calculation and it's automatically converted into cc during the controller.
    public Plate plate;
    public double engineCapacityinCC;
    //public double engineCapacityinL;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equals(VehicleType.values()) ) {
            this.type = type;
        }
    }
}
