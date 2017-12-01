package com.company;

import com.company.plate.Plate;
import com.company.plate.PlateValidator;

import java.text.DecimalFormat;
//to be completed
public class MenuValidator{
    public static View view = new View();

    public static boolean engineCapacityCCVld(double cc) {
        if (cc >= 1000)
            return true;
        else
            return false;
    }

    public static boolean engineCapacityLrVld(double lr) {
        if (lr >0)
            return true;
        else
            return false;
    }

    public boolean emissionVld(int emission) {
        try {
            if (emission > 0)
                return true;
        }
        catch (NumberFormatException e){
            System.out.println("Please enter a whole number for emission");
        }
        return false;
    }

    public boolean lorryWheelNumVld(int wheelNum) {
        try {
            if (wheelNum >= 4 && wheelNum < 12 && wheelNum % 2 == 0)
                return true;
        }
        catch (NumberFormatException e){
            System.out.println("Please enter an even number value between 4 and 12");
        }
        return false;
    }

    //not completed
    public boolean lorryUnloadedWeightVld(double unloadedWeight) {
        //auto convert numbers more than 2 decimal to 2 decimals
        DecimalFormat df = new DecimalFormat("#.00");
        try {
            double i = Double.parseDouble(df.format(unloadedWeight));
            if (i > 0)
                return true;
        }
        catch (Exception e) {
            System.out.println("Please enter a number");
        }
        return false;
    }

    public boolean taxiPassnumVlid(int passNum){
        try{
            if(passNum<=10 && passNum>0){
            return true;
            }
        }
        catch (NumberFormatException e){
            System.out.println("Please enter an integer value");
        }
        return false;
    }

    public boolean menuOptionWithinRange(int range, String input){
        try{
            if(Integer.parseInt(input)>0&&Integer.parseInt(input)<=range){
            return true;
        }
        }catch (NumberFormatException e){
            System.out.println("Please enter an integer value");
        }
        return false;
    }

}