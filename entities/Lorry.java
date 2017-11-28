package com.company.entities;

import com.company.plate.Plate;

/**
 * Created by BaoX on 24/11/2017.
 */
public class Lorry extends Vehicle {
    private int wheelNum;
    private float unloadedWeight;

    public Lorry(Plate plate, double engineCapacityinCC, String type, int wheelNum, float unloadedWeight) {
        super(plate, engineCapacityinCC, type);
        this.unloadedWeight= unloadedWeight;
        this.wheelNum=wheelNum;
    }

    public int getWheelNum() {
        return wheelNum;
    }

    public void setWheelNum(int wheelNum) {
        this.wheelNum = wheelNum;
    }

    public float getUnloadedWeight() {
        return unloadedWeight;
    }

    public void setUnloadedWeight(float unloadedWeight) {
        this.unloadedWeight = unloadedWeight;
    }
}
