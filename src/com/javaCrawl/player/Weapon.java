package com.javaCrawl.player;

public class Weapon {

    private String name;

    private int weaponDamage;

    public Weapon(String name, int weaponDamage) {
        this.name = name;
        this.weaponDamage = weaponDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
