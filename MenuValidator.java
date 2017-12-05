package com.company;

import java.text.DecimalFormat;

public class MenuValidator{

    public boolean platePatternVld(String plateNum){
        String pattern="^(8[789]|(9[0-9]|0[0-9]|1[0-2]|1[3-7][12]))[?:-]?[C|CE|CN|CW|D|DL|G|KE|KK|KY|L|LD|LH|LK|LM|LS|MH|MN|MO|OY|RN|SO|TN|TS|W|WD|WH|WX|WW|c|ce|cn|cw|d|dl|g|ke|kk|ky|l|ld|lh|lk|lm|ls|mh|mn|mo|oy|rn|so|tn|ts|w|wd|wh|wx|ww]?[?:-]?[1-9][0-9]{0,5}$";
        if(plateNum.matches(pattern)){
            return true;
        }
        System.out.println("The plate you entered is not valid, please double check and enter again.");
        return false;
    }

    public boolean engineCapacityCCVld(double cc) {
        if (cc >= 1000)
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