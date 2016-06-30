package edu.uci.ics.crawler4j.robotstxt.sitemap.urlset;

import edu.uci.ics.crawler4j.url.WebURL;

import java.util.Date;

/**
 * http://www.sitemaps.org/protocol.html
 *
 * This class corresponds to the <url> element.
 *
 *
 * Created by michael_schnitzler on 10.06.2016.
 */
public class SitemapURL {

    private WebURL location;

    private Date lastmod;

    private ChangeFrequency changeFreq;

    private float priority;

    public WebURL getLocation() {
        return location;
    }

    public void setLocation(WebURL location) {
        this.location = location;
    }

    public Date getLastmod() {
        return lastmod;
    }

    public void setLastmod(Date lastmod) {
        this.lastmod = lastmod;
    }

    public ChangeFrequency getChangeFreq() {
        return changeFreq;
    }

    public void setChangeFreq(ChangeFrequency changeFreq) {
        this.changeFreq = changeFreq;
    }

    public float getPriority() {
        return priority;
    }

    public void setPriority(float priority) {
        this.priority = priority;
    }
}
