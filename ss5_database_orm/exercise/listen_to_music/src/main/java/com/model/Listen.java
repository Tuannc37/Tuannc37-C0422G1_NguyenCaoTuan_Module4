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

    @Column(name = "path_file")
    private String pathFile;

    public Listen() {
    }

    public Listen(int id, String listenName, String artist, String category, String pathFile) {
        this.id = id;
        this.listenName = listenName;
        this.artist = artist;
        this.category = category;
        this.pathFile = pathFile;
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

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
