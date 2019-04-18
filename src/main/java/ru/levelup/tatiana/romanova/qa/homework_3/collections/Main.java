package ru.levelup.tatiana.romanova.qa.homework_3.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String args[]) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Sku> skuList = new ArrayList();
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
            System.out.println(getSkuListSetRange(skuList, minPrice, maxPrice));

            // лист sku, возвращаюший товары > средней цены + 20
            int sumPrice = 0;
            for (Sku item : skuList) {
                sumPrice += item.getPrice();
            }
            double avgPrice = sumPrice / skuList.size();

            System.out.println("List of sku > avgPrice = " + avgPrice + " + 20 = " + (avgPrice + 20) + ":");
            System.out.println(getSkuListAvgPricePlus20(skuList, avgPrice));

            // имя товара заданной цены, если товаров несколько, возвращаем 2 товар
            System.out.println("Enter price: ");
            System.out.println(getSkuNameSetPrice(skuList, Integer.parseInt(reader.readLine())));

            // TODO Как правильно закрывать потоки ввода и вывода?
            // TODO Из каких конструкций состоит блок try
            reader.close();

        } catch (IOException e) {
            System.out.println("Error!" + e.getMessage());
            e.printStackTrace();
        }
    }

    // лист в заданном диапазоне цен
    public static List<Sku> getSkuListSetRange(List<Sku> inputData, int minPrice, int maxPrice) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku item : inputData) {
            if (item.getPrice() < maxPrice && item.getPrice() > minPrice) {
                result.add(item);
            }
        }
        return result;
    }

    // лист sku, возвращаюший товары > средней цены + 20
    public static List<Sku> getSkuListAvgPricePlus20(List<Sku> inputData, double avgPrice) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku item : inputData) {
            if (item.getPrice() > (avgPrice + 20)) {
                result.add(item);
            }
        }
        return result;
    }

    // метод, возвращающий имя товара заданной цены, если товаров несколько, возвращаем 2 товар
    public static String getSkuNameSetPrice(List<Sku> inputData, int price) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku item : inputData) {
            if (item.getPrice() == price) {
                result.add(item);
            }
        }

        // TODO Можжно убрать присваивание пременной значения
        // TODO IDEA отсаляет за собой подсказки, иногда на них нужно обращать внимание)
        String nameRez = result.size() != 1 ? result.get(1).getName() : result.get(0).getName();
        return nameRez;
    }
}

