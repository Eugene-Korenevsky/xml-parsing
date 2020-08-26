package com.company.PeriodicalSorts.PeriodicalComparators;

import com.company.periodical.Periodical;

import java.util.Comparator;

public class PagesComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return Integer.parseInt((((Periodical) o1).getPeriodicalCharacteristic("pages").getValue())) -
                Integer.parseInt(((Periodical) o2).getPeriodicalCharacteristic("pages").getValue());
    }
}
