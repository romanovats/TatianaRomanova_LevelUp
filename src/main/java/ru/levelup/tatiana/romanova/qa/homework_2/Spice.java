package ru.levelup.tatiana.romanova.qa.homework_2;

public class Spice extends Product {

    protected String kindOfFlavors;

    public Spice(String name, double calories, int amount, String kindOfFlavors) {
        super(name, calories, amount);
        this.kindOfFlavors = kindOfFlavors;
    }

    @Override
    public String toString() {
        return "\n Spices {" +
                "name=" + name +
                ", calories=" + calories + ", amount=" + amount + ", kindOfFlavors="+kindOfFlavors;
    }

    public String getKindOfFlavors() {
        return kindOfFlavors;
    }
}
