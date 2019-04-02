package ru.levelup.tatiana.romanova.qa.homework_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<Products> borsch = new ArrayList<Products>();
        List<Products> salad = new ArrayList<Products>();
        Meat beef = new Meat();
        Meat chicken = new Meat();
        Drinks water = new Drinks();
        Spices salt = new Spices();
        Spices pepper = new Spices();
        Spices parsley = new Spices();
        VegetablesFruits beet = new VegetablesFruits();
        VegetablesFruits potato = new VegetablesFruits();
        VegetablesFruits cucumber = new VegetablesFruits();
        VegetablesFruits tomato = new VegetablesFruits();
        VegetablesFruits cabbage = new VegetablesFruits();
        VegetablesFruits onion = new VegetablesFruits();
        double lowCalories;
        double highCalories;

        chicken.setName("сhicken");
        chicken.setAmount(2);
        chicken.setCalories(135);
        chicken.setAge(0.8);

        beef.setName("beef");
        beef.setAmount(3);
        beef.setCalories(250);
        beef.setAge(3);

        water.setName("Water");
        water.setAmount(2);
        water.setCalories(0);
        water.setVolume(2);

        pepper.setName("Pepper");
        pepper.setAmount(2);
        pepper.setCalories(40);
        pepper.setKindOfFlavors("Hot spices");

        parsley.setName("Parsley");
        parsley.setAmount(2);
        parsley.setCalories(36);
        parsley.setKindOfFlavors("Herbs");

        salt.setName("salt");
        salt.setAmount(2);
        salt.setCalories(0);
        salt.setKindOfFlavors("Other");

        beet.setName("beet");
        beet.setCalories(43);
        beet.setAmount(5);
        beet.setRipeningSeason("August");

        potato.setName("potato");
        potato.setCalories(77);
        potato.setAmount(6);
        potato.setRipeningSeason("September");

        cucumber.setName("cucumber");
        cucumber.setCalories(77);
        cucumber.setAmount(4);
        cucumber.setRipeningSeason("August");

        tomato.setName("tomato");
        tomato.setCalories(24);
        tomato.setAmount(6);
        tomato.setRipeningSeason("August");

        onion.setName("onion");
        onion.setCalories(39.67);
        onion.setAmount(3);
        onion.setRipeningSeason("July");

        cabbage.setName("cabbage");
        cabbage.setCalories(25);
        cabbage.setAmount(3);
        cabbage.setRipeningSeason("May");

        borsch.add(beet);
        borsch.add(potato);
        borsch.add(onion);
        borsch.add(cabbage);
        borsch.add(beef);
        borsch.add(water);
        borsch.add(pepper);
        borsch.add(salt);

        salad.add(cucumber);
        salad.add(tomato);
        salad.add(salt);
        salad.add(pepper);

        System.out.println("Calories of borsch: " + countCaloriesBorsch(borsch));
        salad.sort(Comparator.comparing(Products::getCalories));
        System.out.println();
        System.out.println("Sort salad by calories:\n" + salad);
        System.out.println();
        salad.sort(Comparator.comparing(Products::getAmount));
        System.out.println("Sort salad by amount:\n" + salad);

        System.out.println("getProductsInRange");
        System.out.println("Enter low calories:");
        lowCalories = in.nextDouble();
        System.out.println("Enter high calories:");
        highCalories = in.nextDouble();
        System.out.println(getProductsInRange(borsch, lowCalories, highCalories));
    }

    public static double countCaloriesBorsch(List<Products> borsch) {
        double cal = 0.0;
        for (Products item : borsch) {
            cal += item.getCalories();
        }
        return cal;
    }

    public static List<Products> getProductsInRange(List<Products> inputData, double lowCalories, double highCalories) {
        List<Products> results = new ArrayList<Products>();
        for (Products item : inputData) {
            if (item.getCalories() < highCalories && item.getCalories() > lowCalories) {
                results.add(item);
            }
        }
        return results;
    }
}
