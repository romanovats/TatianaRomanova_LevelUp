package ru.levelup.tatiana.romanova.qa.homework_3.quadratic_equation;

import java.io.*;

public class MainClass {

    public static void main(String args[]) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] x = new double[2];

        try {
            System.out.print("Введите a: ");
            double a = Double.parseDouble(reader.readLine());
            System.out.print("Введите b: ");
            double b = Double.parseDouble(reader.readLine());
            System.out.print("Введите c: ");
            double c = Double.parseDouble(reader.readLine());

            System.out.print("Уравнение: " + a + "*x^2 + " + b + "*x + " + c + " = 0");

            System.out.println("");
            solution(a, b, c);
        } catch (IOException e) {
            System.out.println("Error!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static double discriminant(double a, double b, double c) {

        return Math.pow(b, 2) - 4 * a * c;
    }

    public static void solution(double a, double b, double c) {

        double D = discriminant(a, b, c);

        double[] x = new double[2];

        if (D > 0.0) {
            x[0] = (-b + Math.sqrt(D)) / (2 * a);
            x[1] = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println(String.format("x1 = %s, x2 = %s", (Math.round(x[0] * 100.0)) / 100.0,
                    (Math.round(x[1] * 100.0)) / 100.0));
        } else if (D == 0.0) {
            x[0] = (-b) / (2 * a);
            x[1] = (-b) / (2 * a);
            System.out.println("x1 = " + ((Math.round(x[0] * 100.0)) / 100.0));
            System.out.println("x2 = " + ((Math.round(x[1] * 100.0)) / 100.0));
        } else {
            System.out.println("Нет корней!");
        }
    }

}
