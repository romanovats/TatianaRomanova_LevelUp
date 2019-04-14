package ru.levelup.tatiana.romanova.qa.homework_2;

// TODO Лучше было бы разделить эти два класса
public class VegetablesFruits extends Products {

    private String ripeningSeason; //сезон созревания

    public void setRipeningSeason(String ripeningSeason) {

        this.ripeningSeason = ripeningSeason;
    }

    public String getRipeningSeason() {

        return ripeningSeason;
    }

}
