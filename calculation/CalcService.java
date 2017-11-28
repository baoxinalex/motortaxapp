package com.company.calculation;

import com.company.entities.Vehicle;

/**
 * Created by BaoX on 24/11/2017.
 */
public interface CalcService {


    public <T extends Vehicle> double calculateTax(T t);
}
