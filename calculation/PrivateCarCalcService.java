package com.company.calculation;

import com.company.entities.PrivateCar;
import com.company.entities.Vehicle;
import com.company.plate.Plate;

public class PrivateCarCalcService implements CalcService {

    @Override
    public double calculateTax(Vehicle privateCar) {


        double result=-1;
        if (privateCar instanceof PrivateCar) {
            PrivateCar privateCar1 = (PrivateCar) privateCar;
            if (privateCar1.getRegAfterJuly08()) {
                if (privateCar.getEngineCapacityinCC() > 2000) {
                    result = taxOnEmission(privateCar1) * 1.2;
                    return result;
                } else {
                    result = taxOnEmission(privateCar1);
                    return result;
                }
            } else {
                if (privateCar1.getEngineCapacityinCC() > 2000) {
                    result = taxOnEngine(privateCar1) * 1.2;
                    return result;
                } else {
                    result = taxOnEngine(privateCar1);
                    return result;
                }

            }
        }
        return result;
    }

    public double taxOnEmission(PrivateCar privateCar){

        int emission = privateCar.getEmission();

        if(emission>=0) {
            if (emission == 0)
                return 120;
            else if (emission > 0 && emission <= 80)
                return 170;
            else if (emission > 80 && emission <= 100)
                return 180;
            else if (emission > 100 && emission <= 110)
                return 190;
            else if (emission > 110 && emission <= 120)
                return 200;
            else if (emission > 120 && emission <= 130)
                return 270;
            else if (emission > 130 && emission <= 140)
                return 280;
            else if (emission > 140 && emission <= 155)
                return 390;
            else if (emission > 155 && emission <= 170)
                return 570;
            else if (emission > 170 && emission <= 190)
                return 750;
            else if (emission > 190 && emission <= 225)
                return 1200;
            else
                return 2350;
        }
        return 0;
    }

    public double taxOnEngine(PrivateCar privateCar){
        double engine = privateCar.getEngineCapacityinCC();

        if(engine>=1000) {
            if (engine == 1000)
                return 199;
            else if (engine > 1000 && engine <= 1100)
                return 299;
            else if (engine > 1100 && engine <= 1200)
                return 330;
            else if (engine > 1200 && engine <= 1300)
                return 358;
            else if (engine > 1300 && engine <= 1400)
                return 385;
            else if (engine > 1400 && engine <= 1500)
                return 413;
            else if (engine > 1500 && engine <= 1600)
                return 514;
            else if (engine > 1600 && engine <= 1700)
                return 544;
            else if (engine > 1700 && engine <= 1800)
                return 636;
            else if (engine > 1800 && engine <= 1900)
                return 673;
            else if (engine > 1900 && engine <= 2000)
                return 710;
            else if (engine > 2000 && engine <= 2100)
                return 906;
            else if (engine > 2100 && engine <= 2200)
                return 951;
            else if (engine > 2200 && engine <= 2300)
                return 994;
            else if (engine > 2300 && engine <= 2400)
                return 1034;
            else if (engine > 2400 && engine <= 2500)
                return 1080;
            else if (engine > 2500 && engine <= 2600)
                return 1294;
            else if (engine > 2600 && engine <= 2700)
                return 1345;
            else if (engine > 2700 && engine <= 2800)
                return 1391;
            else if (engine > 2800 && engine <= 2900)
                return 1443;
            else if (engine > 2900 && engine <= 3000)
                return 1494;
            else
                return 1809;
        }
        return 0;
    }
}
