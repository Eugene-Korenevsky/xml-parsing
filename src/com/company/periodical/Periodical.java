package com.company.periodical;

import com.company.periodical.PeriodicalCharacteristics.PeriodicalCharacteristic;

import java.util.HashMap;

public class Periodical {
    private String identity;
    private PeriodicalType periodicalType;
    private HashMap<String, PeriodicalCharacteristic> hashMap = new HashMap<>();
    private String tittle;
    private boolean monthly;

    public boolean isMonthly() {
        return monthly;
    }

    public void setHashMap(HashMap<String, PeriodicalCharacteristic> hashMap) {
        this.hashMap = hashMap;
    }

    public HashMap<String, PeriodicalCharacteristic> getHashMap() {
        return hashMap;
    }

    public PeriodicalType getPeriodicalType() {
        return periodicalType;
    }

    public String getIdentity() {
        return identity;
    }

    public String getTittle() {
        return tittle;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    public void setPeriodicalType(PeriodicalType periodicalType) {
        this.periodicalType = periodicalType;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void addPeriodicalCharacteristic(PeriodicalCharacteristic periodicalCharacteristic, String key) {
        hashMap.put(key, periodicalCharacteristic);
    }

    public PeriodicalCharacteristic getPeriodicalCharacteristic(String key) {
        return hashMap.get(key);
    }

}
