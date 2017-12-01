package com.company.entities;

import java.util.ArrayList;

public enum  VehicleType {
    PRIVATE_CAR("Private Car"), LORRY("Lorry"), TAXI("Taxi");

    private String type;
    VehicleType(String type){
        this.type = type;
    }
    public String type(){
        return type;
    }
}
