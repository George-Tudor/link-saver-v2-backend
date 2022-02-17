package com.georgetudor.linksaverv2backend.controllers;

import com.georgetudor.linksaverv2backend.services.LinkPreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ConsumeWebServiceController {

    @Autowired
    private LinkPreviewService linkPreviewService;

//    @ResponseBody
//    @RequestMapping(value = "/link-data")
//    public LinkPreview getLinkInfo(@RequestParam Link url) {
//        System.out.println("working");
//        return linkPreviewService.getLinkInfo(url);
//    }
}
