package com.company.calculation;

import com.company.entities.Lorry;
import com.company.entities.Vehicle;
import com.company.plate.Plate;


public class LorryCalcService implements CalcService {

    @Override
    public double calculateTax(Vehicle lorry) {
        double result=-1;

        if(lorry instanceof Lorry) {
            Lorry lorry1 = (Lorry) lorry;
            int wheelNum = lorry1.getWheelNum();
            if (wheelNum % 2 == 0 && wheelNum >= 4 && wheelNum <= 12 && lorry1.getUnloadedWeight() > 0) {
                result = 0.1 * lorry.getEngineCapacityinCC() + 100 * wheelNum + 4 * lorry1.getUnloadedWeight();
                return result;
            }
        }
        return result;
    }
}
