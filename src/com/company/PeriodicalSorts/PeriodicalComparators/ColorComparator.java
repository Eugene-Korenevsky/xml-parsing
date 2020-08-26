package com.company.PeriodicalSorts.PeriodicalComparators;

import com.company.periodical.Periodical;

import java.util.Comparator;

public class ColorComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return Boolean.compare(Boolean.parseBoolean((((Periodical) o2).getPeriodicalCharacteristic("color").getValue())),
                Boolean.parseBoolean((((Periodical) o1).getPeriodicalCharacteristic("color").getValue())));
    }
}
