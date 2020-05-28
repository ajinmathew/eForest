package com.android.cs.project.eforest;

public class Image {
    String imageUrl;
    String imageHeading;
    String uploadTime;
    String imageDescription;

    public Image() {
    }

    public Image(String imageUrl, String imageHeading, String uploadTime, String imageDescription) {
        this.imageUrl = imageUrl;
        this.imageHeading = imageHeading;
        this.uploadTime = uploadTime;
        this.imageDescription = imageDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageHeading() {
        return imageHeading;
    }

    public void setImageHeading(String imageHeading) {
        this.imageHeading = imageHeading;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }
}
