package com.georgetudor.linksaverv2backend.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000)
    private String tag;

    @ManyToMany
    @JoinTable(
            name="link_tag",
            joinColumns ={@JoinColumn(name="link_id")},
            inverseJoinColumns = {@JoinColumn(name="tag_id")}
    )
    private List<Link> link;

}
