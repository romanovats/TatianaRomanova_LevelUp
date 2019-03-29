package ru.levelup.tatiana.romanova.qa.homework_1.task_1;

import java.util.Scanner;

public class Calculator {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.calculate();
    }

    public void calculate() {

        Numbers num = new Numbers();
        Numbers pow = new Numbers();

        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Multiplication multiplication = new Multiplication();
        Factorial factorial = new Factorial();
        Power power = new Power();

        System.out.println("Enter number 1:");
        if (in.hasNextInt()) {
            num.setNumOne(in.nextInt());
        } else {
            if (in.hasNextDouble()) {
                num.setNumOne(in.nextDouble());
            } else {
                num.setNumOne(in.nextLong());
            }
        }

        System.out.println("Enter number 2:");
        if (in.hasNextInt()) {
            num.setNumTwo(in.nextInt());
        } else {
            if (in.hasNextDouble()) {
                num.setNumTwo(in.nextDouble());
            } else {
                num.setNumTwo(in.nextLong());
            }
        }

        System.out.println("enter type of operation: \n + addition \n - subtraction \n * multiplication \n f factorial \n p pow");

        switch (in.next()) {
            case "+":
                System.out.println("Addition: ");
                if (num.getIntNumOne() != 0 && num.getIntNumTwo() != 0) {
                    System.out.println(addition.calcAddition(num.getIntNumOne(), num.getIntNumTwo()));
                } else {
                    if (num.getDoubleNumOne() != 0.0 && num.getDoubleNumTwo() != 0.0) {
                        System.out.println(addition.calcAddition(num.getDoubleNumOne(), num.getDoubleNumTwo()));
                    } else {
                        System.out.println(addition.calcAddition(num.getLongNumOne(), num.getLongNumTwo()));
                    }
                }
                break;
            case "-":
                System.out.println("Subtraction: ");
                if (num.getIntNumOne() != 0 && num.getIntNumTwo() != 0) {
                    System.out.println(subtraction.calcSubtraction(num.getIntNumOne(), num.getIntNumTwo()));
                } else {
                    if (num.getDoubleNumOne() != 0.0 && num.getDoubleNumTwo() != 0.0) {
                        System.out.println(subtraction.calcSubtraction(num.getDoubleNumOne(), num.getDoubleNumTwo()));
                    } else {
                        System.out.println(subtraction.calcSubtraction(num.getLongNumOne(), num.getLongNumTwo()));
                    }
                }
                break;
            case "*":
                System.out.println("Multiplication: ");
                if (num.getIntNumOne() != 0 && num.getIntNumTwo() != 0) {
                    System.out.println(multiplication.calcMultiplication(num.getIntNumOne(), num.getIntNumTwo()));
                } else {
                    if (num.getDoubleNumOne() != 0.0 && num.getDoubleNumTwo() != 0.0) {
                        System.out.println(multiplication.calcMultiplication(num.getDoubleNumOne(),
                                                                             num.getDoubleNumTwo()));
                    } else {
                        System.out.println(multiplication.calcMultiplication(num.getLongNumOne(),
                                                                             num.getLongNumTwo()));
                    }
                }
                break;
            case "f":
                System.out.println("Factorial: ");
                if (num.getIntNumOne() != 0 && num.getIntNumTwo() != 0) {
                    System.out.println(factorial.calcFactorial(num.getIntNumOne()));
                    System.out.println(factorial.calcFactorial(num.getIntNumTwo()));
                } else {
                    if (num.getDoubleNumOne() != 0.0 && num.getDoubleNumTwo() != 0.0) {
                        System.out.println("Only Integer!");
                    } else {
                        System.out.println(factorial.calcFactorial(num.getLongNumOne()));
                        System.out.println(factorial.calcFactorial(num.getLongNumTwo()));
                    }
                }
                break;
            case "p":
                System.out.println("Enter a power:");
                num.setPower(in.nextInt());
                if (num.getIntNumOne() != 0 && num.getIntNumTwo() != 0) {
                    System.out.println(power.calcPower(num.getIntNumOne(), num.getPower()));
                    System.out.println(power.calcPower(num.getIntNumTwo(), num.getPower()));
                } else {
                    if (num.getDoubleNumOne() != 0.0 && num.getDoubleNumTwo() != 0.0) {
                        System.out.println(power.calcPower(num.getDoubleNumOne(), num.getPower()));
                        System.out.println(power.calcPower(num.getDoubleNumTwo(), num.getPower()));
                    } else {
                        System.out.println(power.calcPower(num.getLongNumOne(), num.getPower()));
                        System.out.println(power.calcPower(num.getLongNumTwo(), num.getPower()));
                    }
                }
                break;
        }
    }
}
