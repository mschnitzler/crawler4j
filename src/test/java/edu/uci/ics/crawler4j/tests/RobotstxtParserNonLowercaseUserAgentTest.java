package edu.uci.ics.crawler4j.tests;

import edu.uci.ics.crawler4j.robotstxt.HostDirectives;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtParser;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RobotstxtParserNonLowercaseUserAgentTest {

  @Test
  public void testParseWithNonLowercaseUserAgent() {
    String userAgent = "testAgent";
    String content = "User-agent: " + userAgent + "\n"
                     + "Disallow: /test/path/\n";
    HostDirectives hostDirectives = RobotstxtParser.parse(content, userAgent);
    assertNotNull("parsed HostDirectives is null", hostDirectives);
    assertFalse("HostDirectives should not allow path: '/test/path/'", hostDirectives.allows("/test/path/"));
  }

  @Test
  public void testParseSitemapUrl() {
    String userAgent = "testAgent";
    String content = "Sitemap: http://localhost/sitemap.xml\n";
    HostDirectives hostDirectives = RobotstxtParser.parse(content, userAgent);
    assertNotNull("parsed HostDirectives is null", hostDirectives);
    assertTrue("Sitemap URL should not be empty", hostDirectives.getSitemaps().size() == 1);
  }

  @Test
  public void testParseMalformedSitemapUrl() {
    String userAgent = "testAgent";
    String content = "Sitemap: httpx://localhost/sitemap.xml\n";
    HostDirectives hostDirectives = RobotstxtParser.parse(content, userAgent);
    assertNotNull("parsed HostDirectives is null", hostDirectives);
    assertTrue("Sitemap URL should be empty", hostDirectives.getSitemaps().size() == 0);
  }

}
