package ru.levelup.tatiana.romanova.qa.homework_2;

public class Vegetable extends Product {

    protected double weight;

    public Vegetable(String name, double calories, int amount, double weight) {
        super(name, calories, amount);
        this.weight = weight;
    }

    public String toString() {
        return "\n Vegetables {" +
                "name=" + name +
                ", calories=" + calories + ", amount=" + amount + ", weight="+weight;
    }

    public double getWeight() {
        return weight;
    }
}

