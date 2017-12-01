package com.company.injection;

import com.company.Controller;
import com.company.calculation.TesterCalcService;


public class TesterMenuInjector {
    public Controller controller;
    public Controller getController(){
        return new Controller(new TesterCalcService());
    }
}
