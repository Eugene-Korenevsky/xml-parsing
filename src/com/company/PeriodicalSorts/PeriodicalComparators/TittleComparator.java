package com.company.PeriodicalSorts.PeriodicalComparators;

import com.company.periodical.Periodical;

import java.util.Comparator;

public class TittleComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return (((Periodical) o1).getTittle()).compareTo((((Periodical) o2).getTittle()));
    }
}
