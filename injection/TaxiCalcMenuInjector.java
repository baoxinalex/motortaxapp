package com.company.injection;

import com.company.Controller;
import com.company.calculation.CalcService;
import com.company.calculation.TaxiCalcService;


public class TaxiCalcMenuInjector implements CalcMenuInjector{

    @Override
    public Controller getController() {
        return new Controller(new TaxiCalcService());
    }
}
