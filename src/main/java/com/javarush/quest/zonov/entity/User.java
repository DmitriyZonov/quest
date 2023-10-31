package com.javarush.quest.zonov.entity;

public class User {
    private String name;

    private Race race;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Race getRace() {
        return race;
    }
}
