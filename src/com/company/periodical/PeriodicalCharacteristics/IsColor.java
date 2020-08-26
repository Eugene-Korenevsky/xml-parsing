package com.company.periodical.PeriodicalCharacteristics;

public class IsColor extends PeriodicalCharacteristic {
    private boolean color;

    public IsColor() {
        super("is color");
    }

    @Override
    public void setValue(String value) {
        color = Boolean.parseBoolean(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(color);
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
