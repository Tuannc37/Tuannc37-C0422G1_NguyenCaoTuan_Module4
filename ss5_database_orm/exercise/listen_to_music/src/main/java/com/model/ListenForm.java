package com.model;

import org.springframework.web.multipart.MultipartFile;

public class ListenForm {
    private int id;
    private String listenName;
    private String artist;
    private String category;
    private MultipartFile pathFile;


    public ListenForm() {
    }

    public ListenForm(int id, String listenName, String artist, String category, MultipartFile pathFile) {
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

    public MultipartFile getPathFile() {
        return pathFile;
    }

    public void setPathFile(MultipartFile pathFile) {
        this.pathFile = pathFile;
    }
}
