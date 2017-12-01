package com.company;

import com.company.calculation.CalcService;
import com.company.calculation.LorryCalcService;
import com.company.calculation.PrivateCarCalcService;
import com.company.calculation.TaxiCalcService;
import com.company.entities.Lorry;
import com.company.entities.PrivateCar;
import com.company.entities.Taxi;
import com.company.plate.Plate;
import com.company.plate.PlateValidator;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class Controller {

    private static CalcService calcService;

    public Controller (CalcService calcService){
        this.calcService = calcService;
    }

    //switch back to public static void main after the testing is done
    public static void main(String[] args) {
        View menusvc = new View();
        String option;
        double result = -1;
        double engineCC=0;
        double engineLr;
        int emission;
        String type;

        PrivateCar privateCar;
        Lorry lorry;
        Taxi taxi;

        MenuValidator menuValidator = new MenuValidator();


        Plate plate;
        Plate plateToValidate; //after validation plateToValidate will be plate
        String plateNum;
        PlateValidator plateValidator = new PlateValidator();

        //plate creation should be validated

        do{
            //platenum should match with the basic format before transforming
            do {
                plateNum = menusvc.plateNum();
            }
            while (!plateValidator.generalValidation(plateNum));

            plateToValidate = plateValidator.plateTransformer(plateNum);


        }
        //after transforming to objects, the plate object should be validated. This should stay in the loop until input is all correct
        while(!plateValidator.plateObjValidation(plateToValidate));

        plate = plateValidator.plateValidated(plateToValidate);
        //engine size based on cc or liter
        //switch has to be in the loop
        do {
            option=menusvc.menuEngineOption();
            switch (option) {
                //validation algorithm should be updated in order to update the engineCC, in do while loop, the engineCC value cannot be read outside the loop
                case "1":
                    do {
                            engineCC = menusvc.engineCC();
                    }
                    while (!menuValidator.engineCapacityCCVld(engineCC));
                    break;
                case "2":
                    do {
                        engineLr = menusvc.engineLiter();
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
        //switch has to be in the loop

        do {
            option = menusvc.vehicleTypeOption();
            switch (option) {
                case "1":
                    boolean regAfterJuly08;
                    calcService = new PrivateCarCalcService();
                    if(Integer.parseInt(plate.getRegYear())>8 && Integer.parseInt(plate.getRegYear())< LocalDate.now().getYear()){
                        regAfterJuly08=true;
                    }
                    else if (Integer.parseInt(plate.getRegYear())==8) {
                        regAfterJuly08 = menusvc.privateCarRegTime();
                    }
                    else {
                        regAfterJuly08=false;
                    }

                    do {
                        emission = menusvc.privateCarEmission();
                    }
                    while(!menuValidator.emissionVld(emission));

                    type = menusvc.vehicleType("1");
                    privateCar = new PrivateCar(plate, engineCC, type, emission, regAfterJuly08);
                    //new privateCarCalcService object has to be created to work, otherwise it will throw NullPointerException, however this creates hard dependencies
                    result = calcService.calculateTax(privateCar);
                    break;
                case "2":
                    int wheelNum;
                    double unloadedWeight;
                    calcService = new LorryCalcService();

                    do {
                        wheelNum = menusvc.lorryWheelNum();
                    }
                    while(!menuValidator.lorryWheelNumVld(wheelNum));

                    do {
                        unloadedWeight = menusvc.lorryUnloadedWeight();
                    }
                    while(!menuValidator.lorryUnloadedWeightVld(unloadedWeight));

                    type = menusvc.vehicleType("2");
                    lorry = new Lorry(plate, engineCC, type, wheelNum, unloadedWeight);
                    result = calcService.calculateTax(lorry);
                    break;
                case "3":
                    int passNum;
                    calcService = new TaxiCalcService();
                    do {
                        passNum = menusvc.taxiPassengerNum();
                    }
                    while(!menuValidator.taxiPassnumVlid(passNum));
                    type = menusvc.vehicleType("3");
                    taxi = new Taxi(plate, engineCC, type, passNum);
                    result = calcService.calculateTax(taxi);
                    break;
                default:
                    System.out.println("Unrecognised input, please enter 1, 2 or 3 only.");
            }
        }
        while(!menuValidator.menuOptionWithinRange(3,option));

        //here should display the plate number and calculated tax amount.
        System.out.println("The motor tax for "+plate.toString()+" is "+result);
    }

}
