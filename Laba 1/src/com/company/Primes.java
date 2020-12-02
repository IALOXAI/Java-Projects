package com.company;

public class Primes {
    // Класс для нахождения простых чисел
    public static void main(String[] args) {
        System.out.println("Простые числа в диапазоне от 2 до 100:\n");
        for (int number = 2; number < 100; number++){
            if (Is_Prime(number)){
                System.out.println(number);
            }
        }
    }

    public static boolean Is_Prime(int number){
        boolean result;
        result = true;
        for (int i = 2; i < number; i++){ // Поиск делителя перебором всех чисел меньше его и больше двух
            if (number % i == 0) {
                result = false; // Делитель найден, число не простое
                break;
            }
        }
        return result;
    }
}
