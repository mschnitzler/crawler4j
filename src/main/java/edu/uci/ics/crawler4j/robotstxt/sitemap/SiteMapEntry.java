package edu.uci.ics.crawler4j.robotstxt.sitemap;

import edu.uci.ics.crawler4j.url.WebURL;

import java.util.Date;

/**
 * Created by michael_schnitzler on 10.06.2016.
 */
public class SiteMapEntry {

    private final WebURL location;

    private Date lastmod;

    private ChangeFrequency changeFreq;

    private float priority;

    public SiteMapEntry(WebURL location) {
        this.location = location;
    }
}
