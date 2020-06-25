package com.company;

import java.util.ArrayList;

class Guns
{
    private String name;
    private int guns;
    public void setName(String nazv) {
        name = nazv;
    }
    public void setCount(int count) {
        guns = count;
    }
    public String getName()
    {
        return name;
    }
    public int getCount()
    {
        return guns;
    }
    public Guns(String nazv, int count)
    {
        name = nazv;
        guns = count;
    }

}

class ColdWeapon extends Guns {
    public ColdWeapon(String nazv, int count) {
        super(nazv, count);
    }
    public String toString()
    {
        return getName() + " " + getCount();
    }
}

class HotGun extends Guns {
    public HotGun(String nazv, int count) {
        super(nazv, count);
    }
    public String toString()
    {
        return getName() + " " + getCount();
    }

}

class GunsPalata
{
    private ArrayList<Guns> weapons = new ArrayList<Guns>();
    public void addGun(Guns x)
    {
        weapons.add(x);
    }
    public void CLearner(ArrayList<Guns> n)
    {
        weapons = n;
    }
    public void printGunsPalata()
    {
        System.out.println("В оружейной палате: ");
        for(Guns a: weapons)
        {
            System.out.println("\t"+a.toString());
        }
    }
    public void countingGun() {
        int n = 0;
        for (Guns a : weapons) {
            if (a instanceof HotGun) {
                n++;
            }
        }
        System.out.println(n + " вида огнестрельных оружий");
    }
    public void countingcoldweapon() {
        int k = 0;
        for (Guns a : weapons) {
            if (a instanceof ColdWeapon) {
                k++;
            }
        }
        System.out.println(k + " вида холодных оружий");
    }
}
