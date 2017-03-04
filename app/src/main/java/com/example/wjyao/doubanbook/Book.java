package com.example.wjyao.doubanbook;

import android.text.TextUtils;

/**
 * Created by wjyao on 3/4/17.
 */
public class Book {
    private String title;
    private String image;
    private String author;
    private String publisher;
    private String publishDate;
    private String summary;
    private double rating;

    public Book(String title, String image, String author, String publisher, String publishDate, String summary, double rating) {
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.summary = summary;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getSummary() {
        return summary;
    }

    public double getRating() {
        return rating;
    }

    public String getInformation() {
        return TextUtils.join(" / ", new String[]{getAuthor(), getPublisher(), getPublishDate()});
    }
}
