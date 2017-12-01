package com.company.plate;

import java.time.LocalDate;

import static com.company.MenuValidator.view;


public class PlateValidator {

    int currentYear = LocalDate.now().getYear()-2000;

    public boolean generalValidation(String plateNum){
        if (plateNum.matches("^[0-9]{2,3}?(?:1)?(?:2)?-[A-Za-z]{1,2}-[1-9][0-9]{0,5}$")){
            return true;
        }
        else return false;
    }

    public boolean countyCodeValidation(String cc){
        for (CountyCode c: CountyCode.values()){
            if(c.toString().equals(cc.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean regYearValidation(String regy){
      int regYear= Integer.parseInt(regy);
        if ((regYear<=currentYear&&regYear>=0) || (regYear>87&&regYear<100)){
            return true;
        }
        else
            return false;
    }
    //if halfy is not null -> regyear between 13 - current year, then true, else false; if null, regyaer between 13-current false, else true;
    public boolean halfYearValidation(String halfy, String regy){
        int regYear=Integer.parseInt(regy);
        if(halfy!=null) {
            if (regYear >= 13 && regYear <= currentYear) {
                    return true;
            }
            return false;
        }
        else{
            if(regYear >= 13 && regYear <= currentYear){
                return false;
            }
            return true;
        }
    }
    //contains hyphen, contains 2 hyphen, follow the format of xx-xx-xxxx



    public Plate plateTransformer(String plateNum){
        Plate plate;

        //by default validated is false, it will be true after validation
        boolean validated=false;
        //split the plateString into several strings, each string is a parameter for plate object
        String[] plateString = plateNum.split("-");
        //if the first string has three character such as 151, then further spilt it to 15 and 1
        if(plateString[0].length()==3){
            String regYear=plateString[0].substring(0,2);
            String halfYear=plateString[0].substring(2);
            plate = new Plate(regYear,halfYear, plateString[1], plateString[2],validated);
            return plate;
        }
        else {
            plate = new Plate(plateString[0],plateString[1],plateString[2],validated);
            return plate;
        }

    }

    public boolean plateObjValidation(Plate plate){
        if(countyCodeValidation(plate.getCountyCode())&&regYearValidation(plate.getRegYear())&&halfYearValidation(plate.getRegHalfYear(),plate.getRegYear())){
            return true;
        }
        return false;
    }

    public Plate plateValidated(Plate plate) {
        plate.setValidated(true);
        return plate;
    }
}
