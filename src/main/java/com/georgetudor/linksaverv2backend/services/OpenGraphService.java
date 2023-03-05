package com.georgetudor.linksaverv2backend.services;

import com.georgetudor.linksaverv2backend.models.Link;
import com.github.siyoon210.ogparser4j.OgParser;
import com.github.siyoon210.ogparser4j.OpenGraph;

public class OpenGraphService {
    public static Link getOpenGraphInfo(Link link) {
        OgParser ogParser = new OgParser();
        OpenGraph openGraph = ogParser.getOpenGraphOf(String.valueOf(link.getUrl()));
        OpenGraph.Content image = openGraph.getContentOf("image");
        link.setImageUrl(image.getValue());
        OpenGraph.Content description = openGraph.getContentOf("description");
        link.setDescription(description.getValue());
        OpenGraph.Content title = openGraph.getContentOf("title");
        link.setTitle(title.getValue());
        return link;
    }
}
