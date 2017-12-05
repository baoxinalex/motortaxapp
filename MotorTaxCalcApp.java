package com.company;

import com.company.calculation.CalcService;
import com.company.calculation.LorryCalcService;
import com.company.calculation.PrivateCarCalcService;
import com.company.calculation.TaxiCalcService;
import com.company.entities.Lorry;
import com.company.entities.PrivateCar;
import com.company.entities.Taxi;
import com.company.plate.Plate;
import com.company.plate.PlateTransformer;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MotorTaxCalcApp {

    private CalcService calcService;

    public void startApp() {
        Scanner scanner = new Scanner(System.in);
        String option;
        double result = -1;
        double engineCC=0;
        double engineLr=0;
        int emission = 0;

        PrivateCar privateCar;
        Lorry lorry;
        Taxi taxi;

        MenuValidator menuValidator = new MenuValidator();

        Plate plate;
        String plateNum=null;
        PlateTransformer plateTransformer = new PlateTransformer();

        //platenum should match with the basic format before transforming


        do{
            System.out.println("Please enter plate number");
            try {
                plateNum= scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid plate");
                //scanner.skip(".*");
                scanner.next();
            }
        }while(!menuValidator.platePatternVld(plateNum));
        plate = plateTransformer.transform(plateNum);

        //engine size based on cc or liter
        do {
            System.out.println("Please select the way to enter engine size, 1 for cc, 2 for liter");
            option = scanner.next();
            switch (option) {
                //validation algorithm should be updated in order to update the engineCC, in do while loop, the engineCC value cannot be read outside the loop
                case "1":
                    do {
                        System.out.println("Engine size:");
                        try {
                            engineCC = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a number value, no charaters are allowed.");
                            scanner.next();
                        }
                    }
                    while (!menuValidator.engineCapacityCCVld(engineCC));
                    break;
                case "2":
                    do {
                        System.out.println("Engine size:");
                        try {
                            engineLr = scanner.nextDouble();
                        }catch(InputMismatchException e){
                            System.out.println("Please enter a whole or decimal number, no characters allowed");
                            scanner.next();
                        }
                        engineCC = engineLr * 1000;
                    }
                    while (!menuValidator.engineCapacityCCVld(engineCC));
                    break;
                default:
                    System.out.println("Please select 1 or 2 only");
            }
        }
        while(!menuValidator.menuOptionWithinRange(2,option));
        //get vehicle type and relevant details, create the objects

        do {
            System.out.println("Please select Vehicle Type 1.Private car, 2.Lorry, 3.Taxi");
            option = scanner.next();
            switch (option) {
                case "1":
                    boolean regAfterJuly08=false;
                    calcService = new PrivateCarCalcService();
                    if(plate.getRegYear()>8 && plate.getRegYear()< LocalDate.now().getYear()){
                        regAfterJuly08=true;
                    }
                    else if (plate.getRegYear()==8) {
                        System.out.println("Was the car registered after July 2008");
                        try {
                            regAfterJuly08 = scanner.nextBoolean();
                        }catch (Exception e){
                            System.out.println("Please enter true or false only");
                            scanner.next();
                        }
                    }
                    else {
                        regAfterJuly08=false;
                    }

                    do {
                        System.out.println("Please enter the CO2 emission of your car in g/km, this should be a positive whole number");
                        try {
                            emission = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a whole number, no characters are allowed.");
                            scanner.next();
                        }
                    }
                    while(!menuValidator.emissionVld(emission));

                    privateCar = new PrivateCar(plate, engineCC, emission, regAfterJuly08);
                    //new privateCarCalcService object has to be created to work, otherwise it will throw NullPointerException, however this creates hard dependencies
                    result = calcService.calculateTax(privateCar);
                    break;
                case "2":
                    int wheelNum=0;
                    double unloadedWeight=0;
                    calcService = new LorryCalcService();

                    do {
                        System.out.println("Please enter the max number of fixed wheel on your lorry");
                        try {
                            wheelNum = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a whole number between 4 and 10.");
                            scanner.next();
                        }
                    }
                    while(!menuValidator.lorryWheelNumVld(wheelNum));

                    do {
                        System.out.println("What's the unloaded weight in tonnes? Please enter maximum 2 decimals");
                        try {
                            unloadedWeight = scanner.nextFloat();
                        }catch(InputMismatchException e){
                            System.out.println("Please enter a value maximum 2 decimals, no characters are allowed");
                            scanner.next();
                        }
                    }
                    while(!menuValidator.lorryUnloadedWeightVld(unloadedWeight));

                    lorry = new Lorry(plate, engineCC, wheelNum, unloadedWeight);
                    result = calcService.calculateTax(lorry);
                    break;
                case "3":
                    int passNum=0;
                    calcService = new TaxiCalcService();
                    do {
                        System.out.println("What's the maximum number of passenger for your taxi?");
                        try {
                            passNum = scanner.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("Please enter a whole number between 4 and 10");
                            scanner.next();
                        }
                    }
                    while(!menuValidator.taxiPassnumVlid(passNum));
                    taxi = new Taxi(plate, engineCC, passNum);
                    result = calcService.calculateTax(taxi);
                    break;
                default:
                    System.out.println("Unrecognised input, please enter 1, 2 or 3 only.");
            }
        }
        while(!menuValidator.menuOptionWithinRange(3,option));

        //here should display the plate number and calculated tax amount.
        if (result != -1 ) {
            System.out.println("The motor tax for " + plateNum + " is " + result);
        }else{
            System.out.println("One of the above information you entered is incorrect, please try again.");
        }
    }
}