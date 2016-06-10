package edu.uci.ics.crawler4j.robotstxt.sitemap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by michael_schnitzler on 10.06.2016.
 */
public class Sitemap {

    private final Set<SiteMapEntry> siteMapEntries = new HashSet<>();

    public void add(SiteMapEntry entry) {
        siteMapEntries.add(entry);
    }


}
