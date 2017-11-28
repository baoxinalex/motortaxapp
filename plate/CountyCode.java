package com.company.plate;

public enum CountyCode {
    CW("CW"),
    D("D"),
    KE("KE"),
    KK("KK"),
    LS("LS"),
    LD("LD"),
    LH("LH"),
    MH("MH"),
    OY("OY"),
    WH("WH"),
    WX("WX"),
    WW("WW"),
    CE("CE"),
    C("C"),
    KY("KY"),
    L("L"),
    T("T"),
    W("W"),
    G("G"),
    LM("LM"),
    MO("MO"),
    RN("RN"),
    SO("SO"),
    CN("CN"),
    DL("DL"),
    MN("MN");

    private String cc;
    CountyCode(String cc) {
        this.cc = cc;
    }
    public String cc(){
        return cc;
    }
}
