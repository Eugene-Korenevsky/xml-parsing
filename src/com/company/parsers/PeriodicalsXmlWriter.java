package com.company.parsers;

import com.company.periodical.Periodical;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.util.List;

public class PeriodicalsXmlWriter {
    public void write(List<Periodical> periodicals, FileOutputStream fileOutputStream) {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            writer = factory.createXMLStreamWriter(fileOutputStream, "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("periodicals");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xmlns", "http://www.example.org/periodicals");
            for (Periodical periodical : periodicals) {
                writer.writeStartElement("periodical");
                writer.writeAttribute("id", periodical.getIdentity());
                writer.writeStartElement("type");
                String periodicalType = periodical.getPeriodicalType().getName();
                if (periodicalType.equals("newspaper")) {
                    writer.writeStartElement("newspaper");
                    writer.writeStartElement("index");
                    writer.writeCharacters(periodical.getPeriodicalCharacteristic("index").getValue());
                    writer.writeEndElement();
                    writer.writeEndElement();
                } else if (periodicalType.equals("journal")) {
                    writer.writeStartElement("journal");
                    writer.writeStartElement("index");
                    writer.writeCharacters(periodical.getPeriodicalCharacteristic("index").getValue());
                    writer.writeEndElement();
                    writer.writeEndElement();
                } else {
                    writer.writeStartElement("booklet");
                    writer.writeCharacters(periodicalType);
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeStartElement("title");
                writer.writeCharacters(periodical.getTittle());
                writer.writeEndElement();
                writer.writeStartElement("monthly");
                writer.writeCharacters(String.valueOf(periodical.isMonthly()));
                writer.writeEndElement();
                writer.writeStartElement("chars");
                writer.writeStartElement("color");
                writer.writeCharacters(periodical.getPeriodicalCharacteristic("color").getValue());
                writer.writeEndElement();
                writer.writeStartElement("pages");
                writer.writeCharacters(periodical.getPeriodicalCharacteristic("pages").getValue());
                writer.writeEndElement();
                writer.writeStartElement("glossy");
                writer.writeCharacters(periodical.getPeriodicalCharacteristic("glossy").getValue());
                writer.writeEndElement();
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();

        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
