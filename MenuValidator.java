package com.company;

import com.company.plate.Plate;

import java.text.DecimalFormat;
//to be completed
public class MenuValidator {
    static View view = new View();

    public static boolean engineCapacityVld() {
        if (view.engineCC() >= 1000)
            return false;
        else
            return true;
    }

    public boolean emissionVld() {
        if (view.privateCarEmission() > 0)
            return false;
        else
            return true;
    }

    public boolean lorryWheelNumVld() {
        int i = view.lorryWheelNum();
        if (i > 4 && i < 12 && i % 2 == 0)
            return false;
        else
            return true;
    }

    public boolean lorryUnloadedWeightVld() {
        double i = view.lorryUnloadedWeight();
        DecimalFormat decimalFormat = new DecimalFormat();
        if (i>0)
            return false;
        else
            return true;
    }

    public Plate plateTransformer(){
        Plate plate;
        String plateNum= view.plate();
        //by default validated is false, it will be true after validation
        boolean validated=false;
        //split the plateString into several strings, each string is a parameter for plate object
        String[] plateString = plateNum.split("-");
        //if the first string has three character such as 151, then further spilt it to 15 and 1
        if(plateString[0].length()==3){
            String regYear=plateString[0].substring(0,2).toString();
            String halfYear=plateString[0].substring(2).toString();
            plate = new Plate(regYear,halfYear, plateString[1], plateString[2],validated);
            return plate;
        }
        else {
            plate = new Plate(plateString[0],plateString[1],plateString[2],validated);
            return plate;
        }

    }
}