package com.Tour.Package.Management.dto;

import lombok.Getter;

@Getter
public class TourResponse {
    private Long id;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscountInPercentage() {
        return discountInPercentage;
    }

    public void setDiscountInPercentage(String discountInPercentage) {
        this.discountInPercentage = discountInPercentage;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String discountInPercentage;
    private String title;
    private String description;
    private String duration;
    private String actualPrice;
    private String discountedPrice;
    private String location;
    public TourResponse() {}

    public TourResponse(Long id, String image, String discountInPercentage, String title, String description, String duration, String actualPrice, String discountedPrice, String location) {
        this.id = id;
        this.image = image;
        this.discountInPercentage = discountInPercentage;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.actualPrice = actualPrice;
        this.discountedPrice = discountedPrice;
        this.location = location;
    }
}
