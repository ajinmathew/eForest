package com.android.cs.project.eforest;

public class Cattle {

    String dateAccident,natureofAnimal,no_animal,description,name_applicant,place,certificateuUrl;

    public Cattle() {
    }

    public Cattle(String dateAccident, String natureofAnimal, String no_animal, String description, String name_applicant, String place, String certificateuUrl) {
        this.dateAccident = dateAccident;
        this.natureofAnimal = natureofAnimal;
        this.no_animal = no_animal;
        this.description = description;
        this.name_applicant = name_applicant;
        this.place = place;
        this.certificateuUrl = certificateuUrl;
    }

    public String getDateAccident() {
        return dateAccident;
    }

    public void setDateAccident(String dateAccident) {
        this.dateAccident = dateAccident;
    }

    public String getNatureofAnimal() {
        return natureofAnimal;
    }

    public void setNatureofAnimal(String natureofAnimal) {
        this.natureofAnimal = natureofAnimal;
    }

    public String getNo_animal() {
        return no_animal;
    }

    public void setNo_animal(String no_animal) {
        this.no_animal = no_animal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName_applicant() {
        return name_applicant;
    }

    public void setName_applicant(String name_applicant) {
        this.name_applicant = name_applicant;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCertificateuUrl() {
        return certificateuUrl;
    }

    public void setCertificateuUrl(String certificateuUrl) {
        this.certificateuUrl = certificateuUrl;
    }
}
