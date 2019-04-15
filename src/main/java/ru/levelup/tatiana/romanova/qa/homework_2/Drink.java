package ru.levelup.tatiana.romanova.qa.homework_2;

public class Drink extends Product{

    protected double volume;

    public Drink(String name, double calories, int amount, double volume) {
        super(name, calories, amount);
        this.volume=volume;
    }

    @Override
    public String toString() {
        return "\n Drinks {" +
                "name=" + name +
                ", calories=" + calories + ", amount=" + amount + ", volume="+volume;
    }

    public double getVolume() {
        return volume;
    }
}
