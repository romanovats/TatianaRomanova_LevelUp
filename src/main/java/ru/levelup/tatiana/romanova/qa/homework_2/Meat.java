package ru.levelup.tatiana.romanova.qa.homework_2;

public class Meat extends Product {

    protected double age;

    public Meat(String name, double calories, int amount, double age) {
        super(name, calories, amount);
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n Meats {" +
                "name=" + name +
                ", calories=" + calories + ", amount=" + amount + ", age="+age;
    }

    public double getAge() {
        return age;
    }
}
