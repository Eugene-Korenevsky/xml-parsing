package com.company.parsers;

import com.company.periodical.Periodical;
import com.company.periodical.PeriodicalCharacteristics.Glossy;
import com.company.periodical.PeriodicalCharacteristics.Index;
import com.company.periodical.PeriodicalCharacteristics.IsColor;
import com.company.periodical.PeriodicalCharacteristics.Pages;
import com.company.periodical.PeriodicalType;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class PeriodicalsXmlReader {
    private Periodical periodical;
    public List<Periodical> read(FileInputStream fileInputStream) {
        XMLStreamReader reader = null;
        try {
            String value;
            List<Periodical> periodicals = new ArrayList<>();
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(fileInputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamReader.START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("periodical".equals(tagName)) {
                            periodical = new Periodical();
                            value = reader.getAttributeValue(null, "id");
                            periodical.setIdentity(value);
                        } else if ("journal".equals(tagName)) {
                            periodical.setPeriodicalType(PeriodicalType.valueOf("journal"));
                        } else if ("index".equals(tagName)) {
                            value = reader.getElementText();
                            Index index = new Index();
                            index.setValue(value);
                            periodical.addPeriodicalCharacteristic(index, "index");
                        } else if ("newspaper".equals(tagName)) {
                            periodical.setPeriodicalType(PeriodicalType.valueOf("newspaper"));
                        } else if ("booklet".equals(tagName)) {
                            value = reader.getElementText();
                            periodical.setPeriodicalType(PeriodicalType.valueOf(value));
                        } else if ("title".equals(tagName)) {
                            value = reader.getElementText();
                            periodical.setTittle(value);
                        } else if ("monthly".equals(tagName)) {
                            value = reader.getElementText();
                            periodical.setMonthly(Boolean.parseBoolean(value));
                        } else if ("color".equals(tagName)) {
                            value = reader.getElementText();
                            IsColor isColor = new IsColor();
                            isColor.setValue(value);
                            periodical.addPeriodicalCharacteristic(isColor, "color");
                        } else if ("pages".equals(tagName)) {
                            value = reader.getElementText();
                            Pages pages = new Pages();
                            pages.setValue(value);
                            periodical.addPeriodicalCharacteristic(pages, "pages");
                        } else if ("glossy".equals(tagName)) {
                            value = reader.getElementText();
                            Glossy glossy = new Glossy();
                            glossy.setValue(value);
                            periodical.addPeriodicalCharacteristic(glossy, "glossy");
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("periodical".equals(tagName)) {
                            periodicals.add(periodical);
                        }
                        break;
                    }
                }
            }
            return periodicals;
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
