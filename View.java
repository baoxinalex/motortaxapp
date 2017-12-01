package com.company;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class View {

    static Scanner scanner = new Scanner(System.in);


    public String vehicleTypeOption(){
        System.out.println("Please enter vehicleType with 1, 2, 3");
        String option = scanner.next();
        return option;
    }

    //This one is breaking the menu flow, throws NullPointerException
    public String vehicleType(String option){
        Map<String,String> vehicleTypeMap = new HashMap<>();
        vehicleTypeMap.put("1","Private Car");
        vehicleTypeMap.put("2","Lorry");
        vehicleTypeMap.put("3","Taxi");
        //option = this.vehicleTypeOption();
        String vehicleType = vehicleTypeMap.get(option);
        return vehicleType;
    }

    public String plateNum() {
        System.out.println("Please enter plate number");
        String plateNum = scanner.next();
        return plateNum;
    }

    public String menuEngineOption (){
        System.out.println("Please select the way to enter engine size, 1 for cc, 2 for liter");
        String optionCCL = scanner.next();
        return optionCCL;
    }

    public Double engineCC(){
        System.out.println("Engine size:");
        Double engineInCC=0.00;
        try {
            engineInCC = scanner.nextDouble();
            return engineInCC;
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number value, no charaters are allowed.");
            scanner.next();
        }
        return 0.0;
    }

    public Double engineLiter(){
        System.out.println("Engine size:");
        Double engineInLiter;
        try {
            engineInLiter = scanner.nextDouble();
            return engineInLiter;
        }catch(InputMismatchException e){
            System.out.println("Please enter a whole or decimal number, no characters allowed");
            scanner.next();
        }
        return engineLiter();
    }

    public Boolean privateCarRegTime(){
        System.out.println("Was the car registered after July 2008");
        Boolean regAfterJuly = null;
        try {
            regAfterJuly = scanner.nextBoolean();
            return regAfterJuly;
        }catch (Exception e){
            System.out.println("Please enter true or false only");
            scanner.next();
        }
        return regAfterJuly;
    }

    public int privateCarEmission(){
        System.out.println("Please enter the CO2 emission of your car in g/km, this should be a positive whole number");
        Integer emission=0;
        try {
            emission = scanner.nextInt();
            return emission;
        } catch (InputMismatchException e) {
            System.out.println("Please enter a whole number, no characters are allowed.");
            scanner.next();
        }
        return emission;
    }

    public int lorryWheelNum(){
        System.out.println("Please enter the max number of fixed wheel on your lorry");
        Integer wheelNum=0;
        try {
            wheelNum = scanner.nextInt();
            return wheelNum;
        } catch (InputMismatchException e) {
            System.out.println("Please enter a whole number between 4 and 10.");
            scanner.next();
        }
        return wheelNum;
    }

    public double lorryUnloadedWeight(){
        System.out.println("What's the unloaded weight in tonnes? Please enter maximum 2 decimals");
        double unloadedWeight=0.00;
        try {
            unloadedWeight = scanner.nextFloat();
            return unloadedWeight;
        }catch(InputMismatchException e){
            System.out.println("Please enter a value maximum 2 decimals, no characters are allowed");
            scanner.next();
        }
        return unloadedWeight;
    }

    public int taxiPassengerNum(){
        System.out.println("What's the maximum number of passnger for your taxi?");
        Integer passengerNum=0;
        try {
            passengerNum = scanner.nextInt();
            return passengerNum;
        }catch(InputMismatchException e){
            System.out.println("Please enter a whole number between 4 and 10");
            scanner.next();
        }
        return passengerNum;
    }
    
}
