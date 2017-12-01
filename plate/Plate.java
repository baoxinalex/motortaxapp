package com.company.plate;

import java.time.LocalDate;

public class Plate {
    private String regYear;
    private String regHalfYear;
    private String countyCode;
    private String seqNum;
    private boolean validated;

    public Plate(String regYear, String countyCode, String seqNum, boolean validated) {
        this.regYear = regYear;
        this.countyCode = countyCode;
        this.seqNum = seqNum;
        this.validated = validated;
    }

    public Plate(String regYear, String regHalfYear, String countyCode, String seqNum, boolean validated) {
        this.regYear = regYear;
        this.regHalfYear = regHalfYear;
        this.countyCode = countyCode;
        this.seqNum = seqNum;
        this.validated = validated;
    }

    public String getRegYear() {
        return regYear;
    }

    public void setRegYear(String regYear) {
        this.regYear = regYear;
    }

    public String getRegHalfYear() {
        return regHalfYear;
    }

    public void setRegHalfYear(String regaHalfYear) {
        this.regHalfYear = regaHalfYear;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(String seqNum) {
        this.seqNum = seqNum;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    //validation conditions should be replaced with platevalidator, also plates should be validated before passing calculation.
    @Override
    public String toString() {
        int regYearInteger = Integer.parseInt(this.getRegYear());
        String plateNum = null;
        if (regYearInteger >= 13 && regYearInteger < LocalDate.now().getYear()) {
            plateNum = this.getRegYear() + this.getRegHalfYear() +"-"+ this.getCountyCode() +"-"+ this.getSeqNum();
            return plateNum;
        }
        else if(regYearInteger<=12 || regYearInteger>87 && regYearInteger<100){
            plateNum = this.getRegYear()+"-"+this.getCountyCode()+"-"+this.getSeqNum();
            return plateNum;
        }
        else{
            return "unvalidated_plate";
        }

    }

}
