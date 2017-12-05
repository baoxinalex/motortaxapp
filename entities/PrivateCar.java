package com.company.entities;

import com.company.plate.Plate;

/**
 * Created by BaoX on 24/11/2017.
 */
public class PrivateCar extends Vehicle {
    private int emission;
    private boolean regAfterJuly08;

    public PrivateCar(Plate plate, double engineCapacityinCC, int emission, boolean regAfterJuly08) {
        super(plate, engineCapacityinCC);
        this.emission= emission;
        this.regAfterJuly08=regAfterJuly08;
    }

    public int getEmission() {
        return emission;
    }

    public void setEmission(int emission) {
        this.emission = emission;
    }

    public boolean getRegAfterJuly08() {
        return regAfterJuly08;
    }

    public void setRegAfterJuly(boolean regAfterJuly08) {
        this.regAfterJuly08 = regAfterJuly08;
    }
}
