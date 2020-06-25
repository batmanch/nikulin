package com.company;

public class Main {

    public static void main(String[] args) {
        HotGun gun1 = new HotGun("ak47", 19);
        HotGun gun2 = new HotGun("m16", 20);
        ColdWeapon coldweapon = new ColdWeapon ("nozh", 12);
        GunsPalata conf = new GunsPalata();
        conf.addGun(gun1);
        conf.addGun(gun2);
        conf.addGun(coldweapon);
        conf.countingGun();
        conf.countingcoldweapon();
        conf.printGunsPalata();

    }
}
