package com.company.injection;


import com.company.Controller;
import com.company.calculation.PrivateCarCalcService;

public class PrivateCarCalcMenuInjector implements CalcMenuInjector{
    @Override
    public Controller getController() {
        return new Controller(new PrivateCarCalcService());
    }
}
