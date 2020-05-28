package com.android.cs.project.eforest;

public class Property {
    String reason,type,time,description,losesrate,name,place;

    public Property() {
    }

    public Property(String reason, String type, String time, String description, String losesrate, String name, String place) {
        this.reason = reason;
        this.type = type;
        this.time = time;
        this.description = description;
        this.losesrate = losesrate;
        this.name = name;
        this.place = place;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLosesrate() {
        return losesrate;
    }

    public void setLosesrate(String losesrate) {
        this.losesrate = losesrate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
