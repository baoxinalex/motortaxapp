package com.company.entities;

import com.company.plate.Plate;

/**
 * Created by BaoX on 24/11/2017.
 */
public class Lorry extends Vehicle {
    private int wheelNum;
    private double unloadedWeight;

    public Lorry(Plate plate, double engineCapacityinCC, int wheelNum, double unloadedWeight) {
        super(plate, engineCapacityinCC);
        this.unloadedWeight= unloadedWeight;
        this.wheelNum=wheelNum;
    }

    public int getWheelNum() {
        return wheelNum;
    }

    public void setWheelNum(int wheelNum) {
        this.wheelNum = wheelNum;
    }

    public double getUnloadedWeight() {
        return unloadedWeight;
    }

    public void setUnloadedWeight(float unloadedWeight) {
        this.unloadedWeight = unloadedWeight;
    }
}
