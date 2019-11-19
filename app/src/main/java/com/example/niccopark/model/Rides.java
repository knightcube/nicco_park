package com.example.niccopark.model;

public class Rides {

    private String title;
    private String description;
    private String imageUrl;
    private int category;
    // 1 for Family
    // 2 for Kids
    // 3 for Thrill

    public Rides(String title, String description, String imageUrl,int category) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getCategory() {
        return category;
    }
}
