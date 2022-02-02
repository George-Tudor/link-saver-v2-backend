package com.georgetudor.linksaverv2backend.models.LinkPreviewAPI;

import java.io.Serializable;
import java.util.ArrayList;

public class LinkPreviewSearchResponse implements Serializable {
    private ArrayList<LinkPreview> results = new ArrayList<>();

    public ArrayList<LinkPreview> getResults() {
        return results;
    }

    public void setResults(ArrayList<LinkPreview> results) {
        this.results = results;
    }
}
