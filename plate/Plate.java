package com.company.plate;

public class Plate {
    private int regYear;
    private String countyCode;

    public Plate(int regYear, String countyCode) {
        this.regYear = regYear;
        this.countyCode = countyCode;
    }

    public int getRegYear() {
        return regYear;
    }

    public void setRegYear(int regYear) {
        this.regYear = regYear;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }
}
