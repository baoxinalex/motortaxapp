package com.company.plate;

import java.time.LocalDate;


public abstract class PlateValidator {
    public abstract boolean plateValidation();

    public boolean countyCodeValidation(String cc){
        for (CountyCode c: CountyCode.values()){
            if(c.equals(cc))
                return true;
        }
        return false;
    }

    public boolean regYearValidation(String ry){
        int currentYear = LocalDate.now().getYear()-2000;
        int regYear= Integer.parseInt(ry);
        if (regYear<=currentYear || (regYear>87&&regYear<100)){
            return true;
        }
        else
            return false;
    }
    //missing senario: in the current year, 1 or 2 depends on the current month, if it's before July then
    public boolean halfYearValidation(String hy, String ry){
        int regYear=Integer.parseInt(ry);
        int currentYear = LocalDate.now().getYear()-2000;
        if(regYear>=13 && regYear<=currentYear) {
            if (hy == "1" || hy == "2")
                return true;
        }
        return false;
    }
}
