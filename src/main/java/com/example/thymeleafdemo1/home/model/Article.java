package com.example.thymeleafdemo1.home.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Getter
public class Article {

    private String title;
    private String content;
    private String author;
    private Date date;
    private String linkUrl;
    private String imageUrl;
    private String category;
    private int views;
    private int likes;
    private String buttonText;

    public Article(String title, String content, String author, Date date, String linkUrl, String imageUrl, String category, int views, int likes, String buttonText) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
        this.category = category;
        this.views = views;
        this.likes = likes;
        this.buttonText = buttonText;
    }
}
