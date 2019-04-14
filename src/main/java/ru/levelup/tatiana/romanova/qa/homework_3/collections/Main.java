package ru.levelup.tatiana.romanova.qa.homework_3.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String args[]) {

        // TODO Закрытие потока ввода/вывода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // TODO new ArrayList<Sku>(); - указание Sku не обязательно
        List<Sku> skuList = new ArrayList<Sku>();
        String[] skuNameMas = new String[50];
        Random rnd = new Random();

        //генерируем имена товаров
        for (int i = 0; i < skuNameMas.length; i++) {
            skuNameMas[i] = "sku " + i;
        }

        try {

            System.out.println("Enter size of Sku list, max value -> " + skuNameMas.length + ":");
            int listSize = Integer.parseInt(reader.readLine());

            //заполнение листа объектов
            for (int i = 0; i < listSize; i++) {
                skuList.add(new Sku(skuNameMas[rnd.nextInt(skuNameMas.length)], rnd.nextInt(100)));
            }
            // лист в заданном диапазоне цен
            System.out.println("Enter min price: ");
            int minPrice = Integer.parseInt(reader.readLine());
            System.out.println("Enter max price: ");
            int maxPrice = Integer.parseInt(reader.readLine());
            System.out.println("List of sku with price between " + minPrice + " and " + maxPrice + ":");
            System.out.println(getSkuList_setRange(skuList, minPrice, maxPrice));

            // лист sku, возвращаюший товары > средней цены + 20
            int sumPrice = 0;
            for (Sku item : skuList) {
                sumPrice += item.getPrice();
            }
            double avgPrice = sumPrice / skuList.size();

            System.out.println("List of sku > avgPrice = " + avgPrice + " + 20 = " + (avgPrice + 20) + ":");
            System.out.println(getSkuList_avgPricePlus20(skuList, avgPrice));

            // имя товара заданной цены, если товаров несколько, возвращаем 2 товар
            System.out.println("Enter price: ");
            System.out.println(getSkuName_setPrice(skuList, Integer.parseInt(reader.readLine())));

        } catch (IOException e) {
            System.out.println("Error!" + e.getMessage());
            e.printStackTrace();
        }
    }

    // лист в заданном диапазоне цен
    // TODO Java code convention for the method naming
    public static List<Sku> getSkuList_setRange(List<Sku> inputData, int minPrice, int maxPrice) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku item : inputData) {
            if (item.getPrice() < maxPrice && item.getPrice() > minPrice) {
                result.add(item);
            }
        }
        return result;
    }

    // лист sku, возвращаюший товары > средней цены + 20
    // TODO Java code convention for the method naming
    public static List<Sku> getSkuList_avgPricePlus20(List<Sku> inputData, double avgPrice) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku item : inputData) {
            if (item.getPrice() > (avgPrice + 20)) {
                result.add(item);
            }
        }
        return result;
    }

    // метод, возвращающий имя товара заданной цены, если товаров несколько, возвращаем 2 товар
    // TODO Java code convention for the method naming
    public static String getSkuName_setPrice(List<Sku> inputData, int price) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku item : inputData) {
            if (item.getPrice() == price) {
                result.add(item);
            }
        }

        // TODO В можно заметить на тернарный оператор
        if (result.size() != 1) {
            return result.get(1).getName();
        } else {
            return result.get(0).getName();
        }
    }
}

