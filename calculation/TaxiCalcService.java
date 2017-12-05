package com.company.calculation;

import com.company.entities.Taxi;
import com.company.entities.Vehicle;
import com.company.plate.Plate;


public class TaxiCalcService implements CalcService {

    @Override
    public double calculateTax(Vehicle taxi) {
        double result = -1;
        //needs to replaced by try catch method to printout error message
        if (taxi instanceof Taxi) {
            Taxi taxi1 = (Taxi) taxi;
            if (taxi1.getPassengerNum() >= 1 && taxi1.getPassengerNum() <= 10) {
                result = 0.1 * taxi1.getEngineCapacityinCC() + 10 * taxi1.getPassengerNum();
                return result;
            }
        }
        return result;
    }
}
