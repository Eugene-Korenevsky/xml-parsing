package com.company.periodical.PeriodicalCharacteristics;

public abstract class PeriodicalCharacteristic {
    public String name;

    public PeriodicalCharacteristic(String name) {
        this.name = name;
    }

    public abstract void setValue(String value);

    public abstract String getValue();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
