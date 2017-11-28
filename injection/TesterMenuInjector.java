package com.company.injection;

import com.company.Controller;
import com.company.calculation.TesterCalcService;
import static com.company.Controller.taxi;


public class TesterMenuInjector {
    public Controller controller;
    public Controller getController(){
        return new Controller(new TesterCalcService());
    }
}
