package com.georgetudor.linksaverv2backend.models;

import javax.persistence.*;

@Entity
@Table(name = "link_tag_user")
public class LinkTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "link_id")
    private Link link;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

}
