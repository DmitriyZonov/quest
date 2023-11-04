package com.javarush.quest.zonov.entity;

public class User {

    private static volatile User user;
    private String name;
    private Race race;
    private User(){
    }
    public static User getInstance(){
        User local = user;
        if(local == null) {
            synchronized (User.class) {
                local = user;
                if (local == null) {
                    user = local = new User();
                }
            }
        }
        return local;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
