package com.company.parsers;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class PeriodicalsXmlValidator extends DefaultHandler {
    private StringBuilder error = new StringBuilder();

    public PeriodicalsXmlValidator() {
    }

    private StringBuilder getErrorInfo(SAXException e) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.getMessage()).append("\n");
        return stringBuilder;
    }

    public void warning(SAXParseException e)  {
        error.append("WARNING: ");
        error.append(getErrorInfo(e));
    }

    public void error(SAXParseException e)  {
        error.append("ERROR: ");
        error.append(getErrorInfo(e));
    }

    public void fatalError(SAXParseException e)  {
        error.append("FATAL ERROR: ");
        error.append(getErrorInfo(e));
    }

    public String getError() {
        if (error.length() > 0) {
            return error.toString();
        } else
            return null;
    }

    public boolean validate(File fileName,File xsd) throws IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.setErrorHandler(this);
            validator.validate(new StreamSource(fileName));
            return getError() == null;
        } catch (SAXException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
