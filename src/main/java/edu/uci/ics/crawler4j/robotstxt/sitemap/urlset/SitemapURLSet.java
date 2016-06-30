package edu.uci.ics.crawler4j.robotstxt.sitemap.urlset;

import edu.uci.ics.crawler4j.robotstxt.sitemap.AbstractSitemapObject;
import edu.uci.ics.crawler4j.robotstxt.sitemap.urlset.SitemapURL;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by michael_schnitzler on 13.06.2016.
 */
public class SitemapURLSet extends AbstractSitemapObject {

    private final Set<SitemapURL> urlset = new HashSet<>();

    public void add(SitemapURL url) {
        urlset.add(url);
    }

    public Set<SitemapURL> getURLSet() {
        return urlset;
    }
}
