package ru.levelup.tatiana.romanova.qa.homework_1.task_1;

// TODO Java Code Convention (ctrl + alt + L)
public class Power {

    public long calcPower(long num, int power) {
        long result = 1;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }

    public int calcPower(int num, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }

    public double calcPower(double num, int power) {
        double result = 1.0;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }
}
