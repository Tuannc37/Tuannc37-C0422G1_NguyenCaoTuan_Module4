package com.model;

import javax.persistence.*;

@Entity
@Table(name = "list_music")
public class Listen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "list_name")
    private String listenName;
    private String artist;
    private String category;

    public Listen() {
    }

    public Listen(int id, String listenName, String artist, String category, String pathFile) {
        this.id = id;
        this.listenName = listenName;
        this.artist = artist;
        this.category = category;
    }

    public Listen(String listenName, String artist, String category, String pathFile) {
        this.listenName = listenName;
        this.artist = artist;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListenName() {
        return listenName;
    }

    public void setListenName(String listenName) {
        this.listenName = listenName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
