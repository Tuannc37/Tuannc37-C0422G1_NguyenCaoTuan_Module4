package com.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ListenDto implements Validator {
    private int id;
    @NotBlank(message = "Vui lòng nhập vào !")
    @Size(max = 800,message = "Tên bài hát không vượt quá 800 kí tự!")
    @Pattern(regexp = "^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ0-9]+" +
            "( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ0-9]*)+$",
            message = "Bạn nhập không đúng định dạng")
    private String listenName;

    @NotBlank(message = "Vui lòng nhập vào !")
    @Pattern(regexp = "^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ0-9]+" +
            "( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ0-9]*)+$",
            message = "Bạn nhập không đúng định dạng")
    @Size(max = 300,message = "Tên tác giả không vượt quá 300 kí tự!")
    private String artist;

    @NotBlank(message = "Vui lòng nhập vào !")

    @Pattern(regexp = "^[A-ZĐ,][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ,]+" +
            "( [A-ZĐ,][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ,]*)+$",
            message = "Bạn nhập không đúng định dạng")
    @Size(max = 1000,message = "Thể loại nhạc không vượt quá 1000 kí tự!")
    private String category;

    public ListenDto() {
    }

    public ListenDto(int id, String listenName, String artist, String category) {
        this.id = id;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
