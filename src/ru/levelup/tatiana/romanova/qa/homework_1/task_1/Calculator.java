package ru.levelup.tatiana.romanova.qa.homework_1.task_1;
import java.util.Scanner;

public class Calculator {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.calculate();
    }

    public void calculate(){

            Numbers num = new Numbers();
            Numbers pow = new Numbers();

            Addition addition = new Addition();
            Subtraction subtraction = new Subtraction();
            Multiplication multiplication = new Multiplication();
            Factorial factorial = new Factorial();
            Power power = new Power();

            System.out.println("Enter number 1:");
            if (in.hasNextInt()) {
                num.setNum_one(in.nextInt());
            } else {
                if (in.hasNextDouble()) {
                    num.setNum_one(in.nextDouble());
                } else {
                    num.setNum_one(in.nextLong());
                }
            }

            System.out.println("Enter number 2:");
            if (in.hasNextInt()) {
                num.setNum_two(in.nextInt());
            } else {
                if (in.hasNextDouble()) {
                    num.setNum_two(in.nextDouble());
                } else {
                    num.setNum_two(in.nextLong());
                }
            }

            System.out.println("enter type of operation: \n + addition \n - subtraction \n * multiplication \n f factorial \n p pow");

                switch (in.next()) {
                    case "+":
                        System.out.println("Addition: ");
                        if (num.getInt_num_one() != 0 && num.getInt_num_two() != 0) {
                            System.out.println(addition.calcAddition(num.getInt_num_one(), num.getInt_num_two()));
                        } else {
                            if (num.getDouble_num_one() != 0.0 && num.getDouble_num_two() != 0.0) {
                                System.out.println(addition.calcAddition(num.getDouble_num_one(), num.getDouble_num_two()));
                            } else {
                                System.out.println(addition.calcAddition(num.getLong_num_one(), num.getLong_num_two()));
                            }
                        }
                        break;
                    case "-":
                        System.out.println("Subtraction: ");
                        if (num.getInt_num_one() != 0 && num.getInt_num_two() != 0) {
                            System.out.println(subtraction.calcSubtraction(num.getInt_num_one(), num.getInt_num_two()));
                        } else {
                            if (num.getDouble_num_one() != 0.0 && num.getDouble_num_two() != 0.0) {
                                System.out.println(subtraction.calcSubtraction(num.getDouble_num_one(), num.getDouble_num_two()));
                            } else {
                                System.out.println(subtraction.calcSubtraction(num.getLong_num_one(), num.getLong_num_two()));
                            }
                        }
                        break;
                    case "*":
                        System.out.println("Multiplication: ");
                        if (num.getInt_num_one() != 0 && num.getInt_num_two() != 0) {
                            System.out.println(multiplication.calcMultiplication(num.getInt_num_one(), num.getInt_num_two()));
                        } else {
                            if (num.getDouble_num_one() != 0.0 && num.getDouble_num_two() != 0.0) {
                                System.out.println(multiplication.calcMultiplication(num.getDouble_num_one(), num.getDouble_num_two()));
                            } else {
                                System.out.println(multiplication.calcMultiplication(num.getLong_num_one(), num.getLong_num_two()));
                            }
                        }
                        break;
                    case "f":
                        System.out.println("Factorial: ");
                        if (num.getInt_num_one() != 0 && num.getInt_num_two() != 0) {
                            System.out.println(factorial.calcFactorial(num.getInt_num_one()));
                            System.out.println(factorial.calcFactorial(num.getInt_num_two()));
                        } else {
                            if (num.getDouble_num_one() != 0.0 && num.getDouble_num_two() != 0.0) {
                                System.out.println("Only Integer!");
                            } else {
                                System.out.println(factorial.calcFactorial(num.getLong_num_one()));
                                System.out.println(factorial.calcFactorial(num.getLong_num_two()));
                            }
                        }
                        break;
                    case "p":
                        System.out.println("Enter a power:");
                        num.setPower(in.nextInt());
                        if (num.getInt_num_one() != 0 && num.getInt_num_two() != 0) {
                            System.out.println(power.calcPower(num.getInt_num_one(), num.getPower()));
                            System.out.println(power.calcPower(num.getInt_num_two(), num.getPower()));
                        } else {
                            if (num.getDouble_num_one() != 0.0 && num.getDouble_num_two() != 0.0) {
                                System.out.println(power.calcPower(num.getDouble_num_one(), num.getPower()));
                                System.out.println(power.calcPower(num.getDouble_num_two(), num.getPower()));
                            } else {
                                System.out.println(power.calcPower(num.getLong_num_one(), num.getPower()));
                                System.out.println(power.calcPower(num.getLong_num_two(), num.getPower()));
                            }
                        }
                        break;
                }
    }
}
