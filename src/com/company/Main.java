package com.company;

import com.company.PeriodicalSorts.PeriodicalComparators.TittleComparator;
import com.company.PeriodicalSorts.SortByComparator;
import com.company.parsers.*;
import com.company.periodical.Periodical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PeriodicalsXmlValidator periodicalsXMLValidator = new PeriodicalsXmlValidator();
        File input = new File("src" + File.separator + "com" + File.separator + "company" +
                File.separator + "resource" + File.separator + "periodicals.xml");
        File output = new File("src" + File.separator + "com" + File.separator + "company" +
                File.separator + "resource" + File.separator + "myFile.xml");
        File xsd = new File("src" + File.separator + "com" + File.separator + "company" +
                File.separator + "resource" + File.separator + "periodicals.xsd");

        try {
            FileInputStream fileInputStream = new FileInputStream(input);
            FileOutputStream fileOutputStream=new FileOutputStream(output);
            PeriodicalsXmlReader periodicalsXmlReader = new PeriodicalsXmlReader();
            PeriodicalsXmlWriter periodicalsXmlWriter = new PeriodicalsXmlWriter();
            Comparator comparator = new TittleComparator();
            SortByComparator sortByPages = new SortByComparator(comparator);

            List<Periodical> periodicals = new ArrayList<>();
            if (periodicalsXMLValidator.validate(input, xsd)) {
                periodicals = periodicalsXmlReader.read(fileInputStream);
            }
            periodicals = sortByPages.sort((ArrayList) periodicals);
            periodicalsXmlWriter.write(periodicals, fileOutputStream);
            if (periodicalsXMLValidator.validate(output, xsd)) {
                FileInputStream fileInputStream1 = new FileInputStream(output);
                periodicalsXmlReader.read(fileInputStream1);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
