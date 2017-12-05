package com.company.plate;

import java.lang.reflect.Array;
import java.time.LocalDate;


public class PlateTransformer {
    String countyCode;
    int regYear;

    public Plate transform(String plateNum) {
        Plate plate;
        //if the input as hypen, remove it

        if(plateNum.length()>4) {

            if(plateNum.contains("-")){
            plateNum = plateNum.replace("-","");
            }
            regYear = Integer.parseInt(plateNum.substring(0, 2));
            if (plateNum.substring(2, 3) == "1" || plateNum.substring(2, 3) == "2") {
                String c = plateNum.substring(4);
                if (c.matches("[A-Z]")) {
                    countyCode = plateNum.substring(3, 5);
                } else {
                    countyCode = plateNum.substring(3, 4);
                }
            }

            plate = new Plate(regYear, countyCode);
            return plate;
        }

        return null;
    }
}
