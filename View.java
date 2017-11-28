package com.company;

import java.util.Map;
import java.util.Scanner;

public class View {

    static Scanner scanner = new Scanner(System.in);

    public String vehicleType(){
        Map<Integer,String > vehicleTypeMap = null;
        vehicleTypeMap.put(1,"Private Car");
        vehicleTypeMap.put(2,"Lorry");
        vehicleTypeMap.put(3,"Taxi");
        String vehicleType = vehicleTypeMap.get(vehicleTypeOption());
        return vehicleType;
    }

    public int vehicleTypeOption(){
        System.out.println("Please enter vehicleType with 1, 2, 3");
        Integer option = scanner.nextInt();
        return option;
    }

    public String plate(){
        System.out.println("Please enter plate number");
        String plate = scanner.next();
        return plate;
    }

    public int menuEngineOption (){
        System.out.println("Please select the way to enter engine size, 1 for cc, 2 for liter");
        Integer optionCCL = scanner.nextInt();
        return optionCCL;
    }

    public Double engineCC(){
        System.out.println("Engine size:");
        Double engineInCC = scanner.nextDouble();
        return engineInCC;
    }

    public Double engineLiter(){
        System.out.println("Engine size:");
        Double engineInLiter = scanner.nextDouble();
        return engineInLiter;
    }

    public Boolean privateCarRegTime(){
        System.out.println("Was the car registered before July 2008");
        Boolean regBeforeJuly = scanner.nextBoolean();
        return regBeforeJuly;
    }

    public int privateCarEmission(){
        System.out.println("Please enter the CO2 emission of your car in g/km, this should be a positive whole number");
        Integer emission = scanner.nextInt();
        return emission;
    }

    public int lorryWheelNum(){
        System.out.println("Please enter the max number of fixed wheel on your lorry");
        Integer wheelNum = scanner.nextInt();
        return wheelNum;
    }

    public float lorryUnloadedWeight(){
        System.out.println("What's the unloaded weight in tonnes? Please enter maximum 2 decimals");
        Float unloadedWeight = scanner.nextFloat();
        return unloadedWeight;
    }

    public int taxiPassengerNum(){
        System.out.println("What's the maximum number of passnger for your taxi?");
        Integer passengerNum = scanner.nextInt();
        return passengerNum;
    }
    
}
