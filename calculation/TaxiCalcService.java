package com.company.calculation;

import com.company.entities.Taxi;
import com.company.entities.Vehicle;
import com.company.plate.Plate;


public class TaxiCalcService implements CalcService {


    @Override
    public <T extends Vehicle> double calculateTax(T t) {
        Taxi taxi = (Taxi) t;
        Plate plate = taxi.getPlate();
        double result = -1;
        //needs to replaced by try catch method to printout error message
        if (plate.isValidated()) {
            if (taxi.getPassengerNum() >= 1 && taxi.getPassengerNum() <= 10) {
                result = 0.1 * taxi.engineCapacityinCC + 10 * taxi.getPassengerNum();
                return result;
            }
        }
        return result;
    }
}
