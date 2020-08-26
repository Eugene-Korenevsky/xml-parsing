package com.company.periodical.PeriodicalCharacteristics;

public class Pages extends PeriodicalCharacteristic {
    private int pages;

    public Pages() {
        super("pages");
    }

    @Override
    public void setValue(String value) {
        pages = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(pages);
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
