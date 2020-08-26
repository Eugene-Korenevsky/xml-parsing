package com.company.PeriodicalSorts;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByComparator {
    private Comparator comparator;

    public SortByComparator(Comparator comparator){
        this.comparator=comparator;
    }

    public ArrayList sort(ArrayList arrayList){
        arrayList.sort(comparator);
        return arrayList;
    }
}
