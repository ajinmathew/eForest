package com.android.cs.project.eforest;

public class Person {

    String crime,Compensation_reson,ploice_station,Doctor,Reg_doctor,description,app_name,place;

    public Person() {
    }

    public Person(String crime, String compensation_reson, String ploice_station, String doctor, String reg_doctor, String description, String app_name, String place) {
        this.crime = crime;
        Compensation_reson = compensation_reson;
        this.ploice_station = ploice_station;
        Doctor = doctor;
        Reg_doctor = reg_doctor;
        this.description = description;
        this.app_name = app_name;
        this.place = place;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getCompensation_reson() {
        return Compensation_reson;
    }

    public void setCompensation_reson(String compensation_reson) {
        Compensation_reson = compensation_reson;
    }

    public String getPloice_station() {
        return ploice_station;
    }

    public void setPloice_station(String ploice_station) {
        this.ploice_station = ploice_station;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String doctor) {
        Doctor = doctor;
    }

    public String getReg_doctor() {
        return Reg_doctor;
    }

    public void setReg_doctor(String reg_doctor) {
        Reg_doctor = reg_doctor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
