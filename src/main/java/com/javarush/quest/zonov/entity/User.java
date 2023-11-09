package com.javarush.quest.zonov.entity;

import com.javarush.quest.zonov.repository.Race;
import com.javarush.quest.zonov.util.StringLegacyChecker;

import static com.javarush.quest.zonov.constants.ExceptionConstants.RACE_NOT_NULL;
import static java.util.Objects.isNull;

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
        if (new StringLegacyChecker(name).check()) {
            this.name = name;
        }
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        if (isNull(race)) {
            throw new IllegalArgumentException(RACE_NOT_NULL);
        }
        this.race = race;
    }
}
