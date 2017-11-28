package com.company;

import com.company.calculation.CalcService;
import com.company.entities.Lorry;
import com.company.entities.PrivateCar;
import com.company.entities.Taxi;
import com.company.entities.Vehicle;
import com.company.plate.Plate;

public class Controller {
    static Plate plate;
    static PrivateCar privateCar;
    static Lorry lorry;
    static Taxi taxi;
    static View menusvc = new View();
    static MenuValidator validator = new MenuValidator();
    private CalcService calcService;

    public Controller (CalcService calcService){
        this.calcService = calcService;
    }

    //switch back to public static void main after the testing is done
    public void mainMenu(String[] args) {


        //plate creation should be validated
        menusvc.plate();
        //engine size based on cc or liter
        switch (menusvc.menuEngineOption()){
            case 1:
                do{menusvc.engineCC();}
                while (validator.engineCapacityVld());
                break;
            case 2:
                menusvc.engineLiter();
                break;
            default:
                System.out.println("Please select 1 or 2 only");
        }
        //get vehicle type and relevant details, create the objects
        switch(menusvc.vehicleTypeOption()){
            case 1:
                menusvc.privateCarRegTime();
                menusvc.privateCarEmission();
                break;
            case 2:
                menusvc.lorryWheelNum();
                menusvc.lorryUnloadedWeight();
                break;
            case 3:
                menusvc.taxiPassengerNum();
                break;
            default:
                System.out.println("Unrecognised input, please enter 1, 2 or 3 only.");
        }

        //here should display the plate number and calculated tax amount.
        System.out.println("The motor tax for "+"is");
    }

    public static PrivateCar PrivateCar(){
        privateCar = new PrivateCar(validator.plateTransformer(), menusvc.engineCC(), menusvc.vehicleType(), menusvc.privateCarEmission(), menusvc.privateCarRegTime());
        return privateCar;
    }

    public static Lorry lorry(){
        lorry = new Lorry(validator.plateTransformer(), menusvc.engineCC(), menusvc.vehicleType(), menusvc.lorryWheelNum(),menusvc.lorryUnloadedWeight());
        return lorry;
    }

    public static Taxi taxi(){
        taxi = new Taxi(validator.plateTransformer(), menusvc.engineCC(), menusvc.vehicleType(), menusvc.taxiPassengerNum());
        return taxi;
    }

    public void calculate(){
        this.calcService.calculateTax(taxi);
    }
}
