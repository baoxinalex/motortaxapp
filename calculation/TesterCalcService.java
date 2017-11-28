package com.company.calculation;

import com.company.Controller;
import com.company.entities.Taxi;
import com.company.entities.Vehicle;

public class TesterCalcService implements CalcService {



//    public TesterCalcService(Taxi taxi){
//        this.taxi = taxi;
//    }

//    @Override
//    public double calculateTax() {
//        double result =-1;
//        if(taxi.getPassengerNum()>=1&&taxi.getPassengerNum()<=10){
//            result = 0.1*taxi.engineCapacityinCC+10*taxi.getPassengerNum();
//            return result;
//        }
//
//        return result;
//    }

//    @Override
//    public double calculateTax(Taxi taxi) {
//        double result;
//
//            result = 0.1*taxi.engineCapacityinCC+10*taxi.getPassengerNum();
//            return result;
//    }

    @Override
    public <T extends Vehicle> double calculateTax(T t) {
        Taxi taxi = (Taxi) t;

        double result =-1;
        //try catch method to printout error message
        if(taxi.getPassengerNum()>=1&&taxi.getPassengerNum()<=10){
            result = 0.1*taxi.engineCapacityinCC+10*taxi.getPassengerNum();
            return result;
        }

        return result;
    }
}
