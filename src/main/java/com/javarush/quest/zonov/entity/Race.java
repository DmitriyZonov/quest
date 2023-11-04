package com.javarush.quest.zonov.entity;

public enum Race {
    ELF("Эльф"), DWARF("Гном"), WIZARD("Чародей"), WARRIOR("Воин");

    private final String race;

    Race(String race){
        this.race = race;
    }

    public String getNameOfRace() {
        return race;
    }
}
