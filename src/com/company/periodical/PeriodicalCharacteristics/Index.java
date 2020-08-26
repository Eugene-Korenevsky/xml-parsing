package com.company.periodical.PeriodicalCharacteristics;

public class Index extends PeriodicalCharacteristic {
    private long index;

    public Index() {
        super("index");
    }

    @Override
    public void setValue(String value) {
        index = Long.parseLong(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(index);
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
