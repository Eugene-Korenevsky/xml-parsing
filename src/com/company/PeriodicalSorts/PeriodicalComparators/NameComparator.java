package com.company.PeriodicalSorts.PeriodicalComparators;

import com.company.periodical.Periodical;

import java.util.Comparator;

public class NameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return (((Periodical) o1).getPeriodicalType().getName()).compareTo
                ((((Periodical) o2).getPeriodicalType().getName()));
    }
}
