package com.georgetudor.linksaverv2backend.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "link")
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

    @ManyToMany
    @JoinTable(
            name="link_tag",
            joinColumns ={@JoinColumn(name="link_id")},
            inverseJoinColumns = {@JoinColumn(name="tag_id")}
    )
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tag) {
        this.tags = tag;
    }

    public Link() {

    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Link(List<Tag> tags) {
        this.tags = tags;
    }


    public Link(long id, String title, String url, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.tags = tags;
    }

    public Link(long id, User user, String title, String url, String description, String imageUrl, List<Tag> tags) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.url = url;
        this.description = description;
        this.imageUrl = imageUrl;
        this.tags = tags;
    }

    public Link(long id, String title, String url, String description, String imageUrl, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.imageUrl = imageUrl;
        this.tags = tags;
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
