package com.georgetudor.linksaverv2backend.models;

import javax.persistence.*;
import java.util.List;

public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000)
    private String tag;

    @OneToMany(mappedBy = "tag")
    private List<LinkTag> linkTag;

}
