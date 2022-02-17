package com.georgetudor.linksaverv2backend.services;

import com.georgetudor.linksaverv2backend.models.Link;
import com.georgetudor.linksaverv2backend.models.LinkPreviewAPI.LinkPreview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LinkPreviewService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${apikey}")
    public String key;

    public LinkPreview getLinkInfo(Link url) {

        return restTemplate.getForEntity("https://api.linkpreview.net/?key=" + key + "&q=" + url, LinkPreview.class).getBody();
    }

}

