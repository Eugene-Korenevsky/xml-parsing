package com.company.PeriodicalSorts.PeriodicalComparators;

import com.company.periodical.Periodical;

import java.util.Comparator;

public class IndexComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int i1, i2;
        try {
            i1 = Integer.parseInt((((Periodical) o1).getPeriodicalCharacteristic("index").getValue()));
        } catch (NullPointerException e) {
            i1 = -1;
        }
        try {
            i2 = Integer.parseInt((((Periodical) o2).getPeriodicalCharacteristic("index").getValue()));
        } catch (NullPointerException e) {
            i2 = -1;
        }
        return i2 - i1;
    }
}
