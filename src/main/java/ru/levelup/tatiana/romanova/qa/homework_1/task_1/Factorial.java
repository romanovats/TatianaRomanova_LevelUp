package ru.levelup.tatiana.romanova.qa.homework_1.task_1;

public class Factorial {

    public long calcFactorial(long num) {
        long result = 1;
        for (int i = 1; i < num + 1; i++) {
            result *= i;
        }
        return result;
    }

    public int calcFactorial(int num) {
        int result = 1;
        for (int i = 1; i < num + 1; i++) {
            result *= i;
        }
        return result;
    }
}
