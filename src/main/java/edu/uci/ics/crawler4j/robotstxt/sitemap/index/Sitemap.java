package edu.uci.ics.crawler4j.robotstxt.sitemap.index;

import edu.uci.ics.crawler4j.robotstxt.sitemap.urlset.SitemapURLSet;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.Date;

/**
 * http://www.sitemaps.org/protocol.html
 *
 *
 *
 *
 * Created by michael_schnitzler on 10.06.2016.
 */
public class Sitemap {

    private WebURL location;

    private Date lastmod;

    private SitemapURLSet urlSet;

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

    public SitemapURLSet getUrlSet() {
        return urlSet;
    }

    public void setUrlSet(SitemapURLSet urlSet) {
        this.urlSet = urlSet;
    }
}
