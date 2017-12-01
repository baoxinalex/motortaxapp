package com.company.injection;

import com.company.Controller;
import com.company.calculation.LorryCalcService;

public class LorryMenuInjector implements CalcMenuInjector{

    @Override
    public Controller getController() {
        return new Controller(new LorryCalcService());
    }
}
