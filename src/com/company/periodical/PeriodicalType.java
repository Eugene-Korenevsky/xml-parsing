package com.company.periodical;

public enum PeriodicalType {
    journal("journal"), newspaper("newspaper"), booklet("booklet");
    private String name;


    PeriodicalType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
