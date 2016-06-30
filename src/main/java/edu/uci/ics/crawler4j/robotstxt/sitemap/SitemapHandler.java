package edu.uci.ics.crawler4j.robotstxt.sitemap;

import edu.uci.ics.crawler4j.robotstxt.sitemap.index.Sitemap;
import edu.uci.ics.crawler4j.robotstxt.sitemap.index.SitemapIndex;
import edu.uci.ics.crawler4j.robotstxt.sitemap.urlset.ChangeFrequency;
import edu.uci.ics.crawler4j.robotstxt.sitemap.urlset.SitemapURL;
import edu.uci.ics.crawler4j.robotstxt.sitemap.urlset.SitemapURLSet;
import edu.uci.ics.crawler4j.url.WebURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Date;

/**
 * Created by michael_schnitzler on 10.06.2016.
 */
public class SitemapHandler extends DefaultHandler {

    private static final Logger logger = LoggerFactory.getLogger(SitemapHandler.class);

    private boolean isSitemapIndex, isSitemap, isUrlSet, isUrl, isLoc, isLastmod, isChangefreq, isPriority ;

    private SitemapIndex sitemapIndex;

    private Sitemap sitemap;

    private SitemapURLSet sitemapURLSet;

    private SitemapURL sitemapURL;

    private String characters;

    private StringBuffer charactersBuf;

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        charactersBuf = new StringBuffer();

        if (qName.equals("sitemapindex")) {
            isSitemapIndex = true;
            sitemapIndex = new SitemapIndex();
        }
        if (qName.equals("sitemap")) {
            isSitemap = true;
            sitemap = new Sitemap();
        }
        if (qName.equals("urlset")) {
            isUrlSet = true;
            sitemapURLSet = new SitemapURLSet();
        }
        if (qName.equals("url")) {
            isUrl = true;
            sitemapURL = new SitemapURL();
        }
        if (qName.equals("loc")) {
            isLoc = true;
        };
        if (qName.equals("lastmod")) {
            isLastmod = true;
        };
        if (qName.equals("changefreq")) {
            isChangefreq = true;
        };
        if (qName.equals("priority")) {
            isPriority = true;
        };
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if (qName.equals("sitemapindex")) {
            isSitemapIndex = false;
        }
        if (qName.equals("sitemap")) {
            sitemapIndex.add(sitemap);
            isSitemap = false;
        }
        if (qName.equals("urlset")) {
            isUrlSet = false;
        }
        if (qName.equals("url")) {
            sitemapURLSet.add(sitemapURL);
            isUrl = false;
        }
        if (qName.equals("loc")) {
            WebURL url = new WebURL();
            url.setURL(charactersBuf.toString());
            if (isUrl) {
                sitemapURL.setLocation(url);
            }
            if (isSitemap) {
                sitemap.setLocation(url);
            }
            isLoc = false;
        }
        if (qName.equals("lastmod")) {
            if (isUrl) {
                sitemapURL.setLastmod(new Date()); // TODO: parse date
            }
            if (isSitemap) {
                sitemap.setLastmod(new Date()); // TODO: parse date
            }
            isLastmod = false;
        }
        if (qName.equals("changefreq")) {
            String sChangeFreq = charactersBuf.toString();
            try {
                ChangeFrequency changeFreq = ChangeFrequency.valueOf(sChangeFreq.toUpperCase());
                sitemapURL.setChangeFreq(changeFreq);
            }
            catch(IllegalArgumentException e) {
                logger.warn("Illegal changefreq value: {}. Valid values are: always, hourly, daily, weekly, monthly, yearly, never.");
            }
            isChangefreq = false;
        }
        if (qName.equals("priority")) {
            String sPriority = charactersBuf.toString();
            try {
                float priority = Float.parseFloat(sPriority);
                sitemapURL.setPriority(priority);
            }
            catch (NumberFormatException e) {
                logger.warn("Illegal URL priority: {}. Valid values range from 0.0 to 1.0.");
            }
            isPriority = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        characters = new String(ch, start, length);
        charactersBuf.append(characters);
    }

    public AbstractSitemapObject getAbstractSitemapObject() {
        if (sitemapIndex != null) {
            return sitemapIndex;
        }
        else {
            return sitemapURLSet;
        }
    }
}
