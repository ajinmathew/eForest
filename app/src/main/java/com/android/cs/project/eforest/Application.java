package com.android.cs.project.eforest;

public class Application {
    String id,mobile,date,nameApplicant,currntPerson,typeApplication,relationofApplicant,addressApplicant,pincode,dob,income,forest_division,forest_range,place_accident,nature_of_accident,compensation_amount;

    public Application() {
    }

    public Application(String id, String mobile, String date, String nameApplicant, String currntPerson, String typeApplication, String relationofApplicant, String addressApplicant, String pincode, String dob, String income, String forest_division, String forest_range, String place_accident, String nature_of_accident, String compensation_amount) {
        this.id = id;
        this.mobile = mobile;
        this.date = date;
        this.nameApplicant = nameApplicant;
        this.currntPerson = currntPerson;
        this.typeApplication = typeApplication;
        this.relationofApplicant = relationofApplicant;
        this.addressApplicant = addressApplicant;
        this.pincode = pincode;
        this.dob = dob;
        this.income = income;
        this.forest_division = forest_division;
        this.forest_range = forest_range;
        this.place_accident = place_accident;
        this.nature_of_accident = nature_of_accident;
        this.compensation_amount = compensation_amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNameApplicant() {
        return nameApplicant;
    }

    public void setNameApplicant(String nameApplicant) {
        this.nameApplicant = nameApplicant;
    }

    public String getCurrntPerson() {
        return currntPerson;
    }

    public void setCurrntPerson(String currntPerson) {
        this.currntPerson = currntPerson;
    }

    public String getTypeApplication() {
        return typeApplication;
    }

    public void setTypeApplication(String typeApplication) {
        this.typeApplication = typeApplication;
    }

    public String getRelationofApplicant() {
        return relationofApplicant;
    }

    public void setRelationofApplicant(String relationofApplicant) {
        this.relationofApplicant = relationofApplicant;
    }

    public String getAddressApplicant() {
        return addressApplicant;
    }

    public void setAddressApplicant(String addressApplicant) {
        this.addressApplicant = addressApplicant;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getForest_division() {
        return forest_division;
    }

    public void setForest_division(String forest_division) {
        this.forest_division = forest_division;
    }

    public String getForest_range() {
        return forest_range;
    }

    public void setForest_range(String forest_range) {
        this.forest_range = forest_range;
    }

    public String getPlace_accident() {
        return place_accident;
    }

    public void setPlace_accident(String place_accident) {
        this.place_accident = place_accident;
    }

    public String getNature_of_accident() {
        return nature_of_accident;
    }

    public void setNature_of_accident(String nature_of_accident) {
        this.nature_of_accident = nature_of_accident;
    }

    public String getCompensation_amount() {
        return compensation_amount;
    }

    public void setCompensation_amount(String compensation_amount) {
        this.compensation_amount = compensation_amount;
    }
}
