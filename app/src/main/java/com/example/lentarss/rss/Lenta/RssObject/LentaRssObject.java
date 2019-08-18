package com.example.lentarss.rss.Lenta.RssObject;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "rss", strict = false)
public class LentaRssObject {

    @Path("channel")
    @ElementList(entry = "item", inline = true)
    public List<ItemBody> item;

    public List<ItemBody> getLentaItem() {
        return item;
    }

    public void setLentaItem(List<ItemBody> item) {
        this.item = item;
    }
}


