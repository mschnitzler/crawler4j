package edu.uci.ics.crawler4j.robotstxt.sitemap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by michael_schnitzler on 10.06.2016.
 */
public class SitemapHandler extends DefaultHandler {

    private boolean isLoc, isLastmod, isChangefreq, isPriority;

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        if (qName.equals("loc")) { isLoc = true; };
        if (qName.equals("lastmod")) { isLastmod = true; };
        if (qName.equals("changefreq")) { isChangefreq = true; };
        if (qName.equals("priority")) { isPriority = true; };
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if (qName.equals("loc")) { isLoc = false; };
        if (qName.equals("lastmod")) { isLastmod = false; };
        if (qName.equals("changefreq")) { isChangefreq = false; };
        if (qName.equals("priority")) { isPriority = false; };
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);

        if (isLoc) {
            System.out.println("loc: " + s);
        }
        else if (isLastmod) {
            System.out.println("lastmod: " + s);
        }
        else if (isChangefreq) {
            System.out.println("changefreq: " + s);
        }
        if (isPriority) {
            System.out.println("priority: " + s);
        }
    }
}
