package com.android.cs.project.eforest;

public class Crop {
    String time,description,croploss_desc,crop_nature,area,amount,name,place;

    public Crop() {
    }

    public Crop(String time, String description, String croploss_desc, String crop_nature, String area, String amount, String name, String place) {
        this.time = time;
        this.description = description;
        this.croploss_desc = croploss_desc;
        this.crop_nature = crop_nature;
        this.area = area;
        this.amount = amount;
        this.name = name;
        this.place = place;
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

    public String getCroploss_desc() {
        return croploss_desc;
    }

    public void setCroploss_desc(String croploss_desc) {
        this.croploss_desc = croploss_desc;
    }

    public String getCrop_nature() {
        return crop_nature;
    }

    public void setCrop_nature(String crop_nature) {
        this.crop_nature = crop_nature;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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
