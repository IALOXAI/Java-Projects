package com.company;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Результат 1.1: " + Remainder_Of_Division(scan));
        System.out.println("Результат 1.2: " + Area_Of_a_Triangle(scan));
        System.out.println("Результат 1.3: " + Animal_Legs(scan));
        System.out.println("Результат 1.4: " + Profitable_Gamble(scan));
        System.out.println("Результат 1.5: " + Operation(scan));
        System.out.println("Результат 1.6: " + CtoA(scan));
        System.out.println("Результат 1.7: " + Add_Up_To(scan));
        System.out.println("Результат 1.8: " + Next_Edge(scan));
        System.out.println("Результат 1.9: " + Sum_Of_Cubes(scan));
        System.out.println("Результат 1.10: " + abc_Math(scan));
        scan.close();
    }

    public static double Remainder_Of_Division(Scanner scanner) {
        System.out.println("\nЗадача 1.1\nВведите делимое и делитель");
        float x = scanner.nextFloat();
        float y = scanner.nextFloat();
        return x % y;
    }

    public static double Area_Of_a_Triangle(Scanner scanner) {
        System.out.println("\nЗадача 1.2\nВведите длину основания и высоту треугольника");
        float base = scanner.nextFloat();
        float height = scanner.nextFloat();
        return base * height * 0.5;
    }

    public static int Animal_Legs(Scanner scanner) {
        int chicken_legs = 2;
        int cow_legs = 4;
        int pig_legs = 4;
        System.out.println("\nЗадача 1.3\nВведите количество кур, коров и свиней");
        int chickens = scanner.nextInt();
        int cows = scanner.nextInt();
        int pigs = scanner.nextInt();
        return chicken_legs * chickens + cow_legs * cows + pig_legs * pigs;
    }

    public static boolean Profitable_Gamble(Scanner scanner) {
        System.out.println("\nЗадача 1.4\nВведите prob, prize и pay");
        float prob = scanner.nextFloat();
        float prize = scanner.nextFloat();
        float pay = scanner.nextFloat();
        return prob * prize > pay;
    }

    public static String Operation(Scanner scanner) {
        System.out.println("\nЗадача 1.5\nВведите три целых числа");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int N = scanner.nextInt();
        String result;
        if (a + b == N) {
            result = "Сложение";
        } else if (a - b == N) {
            result = "Вычитание";
        } else if (a * b == N) {
            result = "Умножение";
        } else if (a / b == N) {
            result = "Деление";
        } else {
            result = "none";
        }
        return result;
    }

    public static int CtoA(Scanner scanner) {
        System.out.println("\nЗадача 1.6\nВведите любой символ");
        char simvol = scanner.next().charAt(0);
        return (int) simvol;
    }

    public static int Add_Up_To(Scanner scanner) {
        System.out.println("\nЗадача 1.7\nВведите целое число");
        int last_number = scanner.nextInt();
        return IntStream.range(0, last_number + 1).sum();
    }

    public static int Next_Edge(Scanner scanner) {
        System.out.println("\nЗадача 1.8\nВведите длины двух ребер (целые числа)");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        return a + b - 1;
    }

    public static int Sum_Of_Cubes(Scanner scanner) {
        System.out.println("\nЗадача 1.9\nВведите количество элементов массива, затем его элементы");
        int size = scanner.nextInt();
        int[] array = new int[size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            sum += Math.pow(array[i], 3);
        }
        return sum;
    }

    public static boolean abc_Math(Scanner scanner) {
        System.out.println("\nЗадача 1.10\nВведите три числа: a, b, c");
        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();
        return (a + b) % c == 0;
    }
}