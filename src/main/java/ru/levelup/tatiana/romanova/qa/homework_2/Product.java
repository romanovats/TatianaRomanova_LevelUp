package ru.levelup.tatiana.romanova.qa.homework_2;

// TODO Как правило классы носят единственное число в названии
public abstract class Product {

    // TODO Обязательно ли, чтобы поля были private?
    protected String name;
    protected double calories;
    protected int amount;

    public Product(String name, double calories, int amount){
        this.name = name;
        this.calories = calories;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\n Products {" +
                "name=" + name +
                ", calories=" + calories + ", amount=" + amount;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public int getAmount() {
        return amount;
    }
}
