package br.com.guaraba.wally.android.util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import br.com.guaraba.wally.android.exception.XMLParserException;

public final class XMLUtils {

    public static Document getDocument(final String xml) throws XMLParserException {

    	Document doc = null;

    	try {

    		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    		DocumentBuilder db = dbf.newDocumentBuilder();
    		doc = db.parse(new InputSource(new StringReader(xml)));

    	} catch (Exception e) {

    		throw new XMLParserException("Ocorreu um no processamento do xml de retorno. ".concat(e != null && !StringUtils.isNullOrEmpty(e.getMessage()) ? "Erro:".concat(e.getMessage()) : "" ));
    	}

    	return doc;
    }
}