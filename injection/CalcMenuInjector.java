package com.company.injection;

import com.company.Controller;
import com.company.calculation.CalcService;
import com.company.calculation.PrivateCarCalcService;

public interface CalcMenuInjector {
    public Controller getController();

}
