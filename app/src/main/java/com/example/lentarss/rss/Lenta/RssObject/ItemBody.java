package com.example.lentarss.rss.Lenta.RssObject;

import org.simpleframework.xml.Element;

public class ItemBody {

    @Element(name = "title")
    private String title;

    @Element(name = "guid", required = false)
    private String guid;

    @Element(name = "link", required = false)
    private String link;

    @Element(name = "description", required = false)
    private String description;

    @Element(name = "pubDate", required = false)
    private String pubDate;

    @Element(name = "enclosure", required = false)
    private String enclosure;

    @Element(name = "category", required = false)
    private String category;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
