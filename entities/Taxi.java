package com.company.entities;

import com.company.plate.Plate;

/**
 * Created by BaoX on 24/11/2017.
 */
public class Taxi extends Vehicle{
    private int passengerNum;

    public Taxi(Plate plate, double engineCapacityinCC, int passengerNum) {
        super(plate, engineCapacityinCC);
        this.passengerNum=passengerNum;
    }

    public int getPassengerNum() {
        return passengerNum;
    }

    public void setPassengerNum(int passengerNum) {
        this.passengerNum = passengerNum;
    }
}
