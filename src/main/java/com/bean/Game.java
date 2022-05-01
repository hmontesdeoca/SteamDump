package com.bean;

public class Game {
    
    private String name;
    private double hours;

    //constructor
    public Game(String name, double hours) {
        this.name = name;
        this.hours = hours;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHours() {
        return (Long) Math.round(hours);
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString(){
        return "Game Title: " + this.name +"\n" +
        "Hours Played: " + this.hours;
    }
}
