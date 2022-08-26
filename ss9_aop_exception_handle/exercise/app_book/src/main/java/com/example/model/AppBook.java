package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "app_book")
public class AppBook {
    @Id
    private int id;

    @Column(name = "name_story")
    private String nameStory;
    private String content;
    @Column(name = "amount_remaining")
    private int amountRemaining;
    @Column(name = "original_quantity")
    private int originalQuantity;

    public AppBook() {
    }

    public AppBook(int id, String nameStory, String content, int amountRemaining, int originalQuantity) {
        this.id = id;
        this.nameStory = nameStory;
        this.content = content;
        this.amountRemaining = amountRemaining;
        this.originalQuantity = originalQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStory() {
        return nameStory;
    }

    public void setNameStory(String nameStory) {
        this.nameStory = nameStory;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(int amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    public int getOriginalQuantity() {
        return originalQuantity;
    }

    public void setOriginalQuantity(int originalQuantity) {
        this.originalQuantity = originalQuantity;
    }
}
