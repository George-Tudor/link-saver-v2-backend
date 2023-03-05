package com.georgetudor.linksaverv2backend.services;

import com.georgetudor.linksaverv2backend.models.Link;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebsiteMetadataService {
    public static Link getMetaData(Link link) throws IOException {
        Document doc = Jsoup.connect(String.valueOf(link.getUrl())).get();
        String title = doc.title();
        link.setTitle(title);
        String description = doc.select("meta[name=description]").attr("content");
        link.setDescription(description);
        String imageUrl = null;
        Elements imageElements = doc.select("meta[name=twitter:image]");
        if (!imageElements.isEmpty()) {
            imageUrl = imageElements.attr("content");
            link.setImageUrl(imageUrl);
        }

        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Image URL: " + imageUrl);
        return link;
    }
}
