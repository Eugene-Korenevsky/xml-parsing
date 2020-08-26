package com.company.periodical.PeriodicalCharacteristics;

public class Glossy extends PeriodicalCharacteristic {
    private boolean glossy;

    public Glossy() {
        super("glossy");
    }

    @Override
    public void setValue(String value) {
        glossy = Boolean.parseBoolean(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(glossy);
    }

    public boolean isGlossy() {
        return glossy;
    }

    public void setGlossy(boolean glossy) {
        this.glossy = glossy;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
