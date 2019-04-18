package ru.levelup.tatiana.romanova.qa.homework_3.collections;

public class Sku {

    private String name;
    private int price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public Sku(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
