package com.georgetudor.linksaverv2backend.services;

import com.georgetudor.linksaverv2backend.models.LinkPreviewAPI.LinkPreview;
import com.georgetudor.linksaverv2backend.models.LinkPreviewAPI.LinkPreviewSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class LinkPreviewService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${apikey}")
    public String key;

    public ArrayList<LinkPreview> getLinkInfo(String url) {

        return restTemplate.getForEntity("http://api.linkpreview.net/?key=" + key + "&q=" + url, LinkPreviewSearchResponse.class).getBody().getResults();
    }

}
