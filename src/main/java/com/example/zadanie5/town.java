package com.example.zadanie5;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class town {
    private SimpleStringProperty nameTown;
    private SimpleStringProperty monday;
    private SimpleStringProperty tuesday;
    private SimpleStringProperty wednesday;
    private SimpleStringProperty thursday;
    private SimpleStringProperty friday;
    private SimpleStringProperty saturday;
    private SimpleStringProperty sunday;

    public  town(String name, String d1, String d2, String d3, String d4, String d5, String d6,String d7)
    {
        nameTown = new SimpleStringProperty(name);
        monday = new SimpleStringProperty(d1);
        tuesday = new SimpleStringProperty(d2);
        wednesday = new SimpleStringProperty(d3);
        thursday = new SimpleStringProperty(d4);
        friday = new SimpleStringProperty(d5);
        saturday = new SimpleStringProperty(d6);
        sunday = new SimpleStringProperty(d7);
    }
    public String getNameTown() {
        return this.nameTown.get();
    }

    public void setNameTown(String name) {
        this.nameTown = new SimpleStringProperty(name);
    }
    public  String getMonday() {return this.monday.get();}

    public void setMonday(String monday) {
        this.monday.set(monday);
    }

    public String getTuesday() {
        return tuesday.get();
    }

    public void setTuesday(String tuesday) {
        this.tuesday.set(tuesday);
    }

    public String getThursday() {
        return thursday.get();
    }
    public void setThursday(String thursday) {
        this.thursday.set(thursday);
    }

    public String getWednesday() {
        return wednesday.get();
    }

    public void setWednesday(String wednesday) {
        this.wednesday.set(wednesday);
    }

    public String getFriday() {
        return friday.get();
    }

    public void setFriday(String friday) {
        this.friday.set(friday);
    }

    public String getSaturday() {
        return saturday.get();
    }

    public void setSaturday(String saturday) {
        this.saturday.set(saturday);
    }

    public String getSunday() {
        return sunday.get();
    }

    public void setSunday(String sunday) {
        this.sunday.set(sunday);
    }
}
