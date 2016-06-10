package edu.uci.ics.crawler4j.robotstxt.sitemap;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by michael_schnitzler on 10.06.2016.
 */
public class SitemapParser {

    public static void parse(String xml) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        DefaultHandler handler = new SitemapHandler();
        saxParser.parse(new InputSource(new StringReader(xml)), handler);
    }
}
