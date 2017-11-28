package com.company.calculation;

import com.company.entities.Lorry;
import com.company.entities.Vehicle;
import com.company.plate.Plate;


public class LorryCalcService implements CalcService {

    @Override
    public <T extends Vehicle> double calculateTax(T t) {
        double result=-1;
        Lorry lorry = (Lorry) t;
        Plate plate = lorry.getPlate();
        int wheelNum = lorry.getWheelNum();
        if(plate.isValidated()){
            if(wheelNum%2==0&&wheelNum>=4&&wheelNum<=12&&lorry.getUnloadedWeight()>0){
                result = 0.1*lorry.getEngineCapacityinCC()+100*wheelNum+4*lorry.getUnloadedWeight();
                return result;
            }
        }
        return result;
    }
}
