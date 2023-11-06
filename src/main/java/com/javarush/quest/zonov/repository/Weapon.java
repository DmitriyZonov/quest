package com.javarush.quest.zonov.repository;

public enum Weapon {
    SWORD("меч"), STAFF("посох"), AXE("топор"), BOW("лук"), STICK("палка");
    private String weapon;

    Weapon(String weapon){
        this.weapon = weapon;
    }
    public String getNameOfWeapon() {
        return weapon;
    }

}
