package ru.levelup.tatiana.romanova.qa.homework_2;

// TODO Как правило классы носят единственное число в названии
public abstract class Products {

    // TODO Обязательно ли, чтобы поля были private?
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
