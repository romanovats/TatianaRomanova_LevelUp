package ru.levelup.tatiana.romanova.qa.homework_2;

public class Fruit extends Product {

    protected String ripeningSeason; //сезон созревания

    public Fruit(String name, double calories, int amount, String ripeningSeason){
        super(name, calories, amount);
        this.ripeningSeason=ripeningSeason;
    }

    public String toString() {
        return "\n Fruits {" +
                "name=" + name +
                ", calories=" + calories + ", amount=" + amount + ", ripeningSeason="+ripeningSeason;
    }

    public String getRipeningSeason() {
        return ripeningSeason;
    }
}
