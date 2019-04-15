package ru.levelup.tatiana.romanova.qa.homework_2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double lowCalories;
        double highCalories;
        List<Product> borsch = new ArrayList<>();
        List<Product> salad = new ArrayList<>();
        Meat beef = new Meat("beef", 250,3,3);
        Meat chicken = new Meat("chicken", 135,2,0.8);
        Drink water = new Drink("Water", 0,2,2);
        Spice pepper = new Spice("Pepper",40,2,"Hot spices");
        Spice salt = new Spice("Salt",0,2,"Other");
        Spice parsley = new Spice("Parsley", 36,2,"Herbs");
        Vegetable beet = new Vegetable("beet",43,5,0.5);
        Vegetable potato = new Vegetable("potato",77,6,1.2);
        Vegetable cucumber = new Vegetable("cucumber",77,4,0.3);
        Vegetable tomato = new Vegetable("tomato",24,6,0.2);
        Vegetable cabbage = new Vegetable("cabbage", 25,3,1.0);
        Vegetable onion = new Vegetable("onion",39.67,3,0.08);

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
        salad.sort(Comparator.comparing(Product::getCalories));
        System.out.println();
        System.out.println("Sort salad by calories:\n" + salad);
        System.out.println();
        salad.sort(Comparator.comparing(Product::getAmount));
        System.out.println("Sort salad by amount:\n" + salad);

        System.out.println("getProductsInRange");
        System.out.println("Enter low calories:");
        lowCalories = in.nextDouble();
        System.out.println("Enter high calories:");
        highCalories = in.nextDouble();
        System.out.println(getProductsInRange(borsch, lowCalories, highCalories));
    }

    public static double countCaloriesBorsch(List<Product> borsch) {
        double cal = 0.0;
        for (Product item : borsch) {
            cal += item.getCalories();
        }
        return cal;
    }

    public static List<Product> getProductsInRange(List<Product> inputData, double lowCalories, double highCalories) {
        List<Product> results = new ArrayList<>();
        for (Product item : inputData) {
            if (item.getCalories() < highCalories && item.getCalories() > lowCalories) {
                results.add(item);
            }
        }
        return results;
    }
}
