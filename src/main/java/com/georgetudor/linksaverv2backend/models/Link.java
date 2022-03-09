package com.georgetudor.linksaverv2backend.models;

import javax.persistence.*;

@Entity
@Table(name = "links")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 1000)
    private String title;

    @Column(length = 2083)
    private String url;

    @Column(length = 2083)
    private String description;

    @Column(length = 2083)
    private String imageUrl;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Link() {}

    public Link(long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public Link(long id, User user, String title, String url, String description, String imageUrl) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.url = url;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Link(long id, String title, String url, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
