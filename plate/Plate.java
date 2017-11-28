package com.company.plate;

public class Plate {
    private String regYear;
    private String regaHalfYear;
    private String countyCode;
    private String seqNum;
    private boolean validated;

    public Plate(String regYear, String countyCode, String seqNum, boolean validated) {
        this.regYear = regYear;
        this.countyCode = countyCode;
        this.seqNum = seqNum;
        this.validated = validated;
    }

    public Plate(String regYear, String regaHalfYear, String countyCode, String seqNum, boolean validated) {
        this.regYear = regYear;
        this.regaHalfYear = regaHalfYear;
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

    public String getRegaHalfYear() {
        return regaHalfYear;
    }

    public void setRegaHalfYear(String regaHalfYear) {
        this.regaHalfYear = regaHalfYear;
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
}
