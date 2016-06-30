package edu.uci.ics.crawler4j.robotstxt.sitemap;

import edu.uci.ics.crawler4j.robotstxt.sitemap.index.Sitemap;
import edu.uci.ics.crawler4j.robotstxt.sitemap.index.SitemapIndex;
import edu.uci.ics.crawler4j.robotstxt.sitemap.urlset.SitemapURLSet;

import java.util.HashSet;
import java.util.Set;

/**
 * http://www.sitemaps.org/protocol.html
 *
 * The robot's sitemap can either consist of sitemaps or sitemap index files.
 *
 * Created by michael_schnitzler on 13.06.2016.
 */
public class RobotsSitemap {

    private final Set<SitemapIndex> sitemapIndices = new HashSet<>();

    private final Set<SitemapURLSet> sitemapURLSets = new HashSet<>();

    public void add(SitemapURLSet sitemapURLSet) {
        this.sitemapURLSets.add(sitemapURLSet);
    }

    public void add(SitemapIndex sitemapIndex) {
        this.sitemapIndices.add(sitemapIndex);
    }

    public Set<SitemapIndex> getSitemapIndices() {
        return sitemapIndices;
    }

    public Set<SitemapURLSet> getSitemaps() { return sitemapURLSets; }
}
