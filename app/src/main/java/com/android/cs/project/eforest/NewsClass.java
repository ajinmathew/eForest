package com.android.cs.project.eforest_office;

public class NewsClass {
    String time,heading,description,imageurl;

    public NewsClass() {
    }

    public NewsClass(String time, String heading, String description, String imageurl) {
        this.time = time;
        this.heading = heading;
        this.description = description;
        this.imageurl = imageurl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
