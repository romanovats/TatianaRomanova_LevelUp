package ru.levelup.tatiana.romanova.qa.homework_2;

public abstract class Products {

    private String name;
    private double calories;
    private int amount;

    public void setName(String name) {

        this.name = name;
    }

    public void setCalories(double calories) {

        this.calories = calories;
    }

    public void setAmount(int amount) {

        this.amount = amount;
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

    @Override
    public String toString() {
        return "\n Products {" +
                "name=" + name +
                ", calories=" + calories + ", amount=" + amount;
    }

}
