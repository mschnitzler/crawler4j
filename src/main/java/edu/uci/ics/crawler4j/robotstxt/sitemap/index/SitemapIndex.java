package edu.uci.ics.crawler4j.robotstxt.sitemap.index;

import edu.uci.ics.crawler4j.robotstxt.sitemap.AbstractSitemapObject;
import edu.uci.ics.crawler4j.robotstxt.sitemap.index.Sitemap;

import java.util.HashSet;
import java.util.Set;

/**
 * http://www.sitemaps.org/protocol.html
 *
 * A sitemap index holds multiple sitemap files.
 *
 * Created by michael_schnitzler on 13.06.2016.
 */
public class SitemapIndex extends AbstractSitemapObject {

    public final Set<Sitemap> sitemaps = new HashSet<>();

    public void add(Sitemap sitemap) {
        this.sitemaps.add(sitemap);
    }

    public Set<Sitemap> getSitemaps() {
        return sitemaps;
    }
}
