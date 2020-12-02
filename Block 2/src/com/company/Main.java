package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Результат 2.1: " + Repeat_3_Times(scan));
        System.out.println("Результат 2.2: " + Max_Min_Difference(scan));
        System.out.println("Результат 2.3: " + Is_Avg_Whole(scan));
        System.out.println("Результат 2.4: " + Cumulative_Sum(scan));
        System.out.println("Результат 2.5: " + Decimal_Places(scan));
        System.out.println("Результат 2.6: " + Fibonacci(scan));
        System.out.println("Результат 2.7: " + Is_Valid(scan));
        System.out.println("Результат 2.8: " + Is_Strange_Pair(scan));
        System.out.println("Результат 2.9:\nПрефикс " + Is_Prefix(scan) + "\nСуффикс " + Is_Suffix(scan));
        System.out.println("Результат 2.10: " + Box_Seq(scan));
        scan.close();
    }

    public static StringBuilder Repeat_3_Times(Scanner scanner) {
        System.out.println("\nЗадача 2.1\nВведите строку и количество повторений символов");
        String stroka = scanner.nextLine();
        int multiplier = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        char[] string_array = stroka.toCharArray();
        for (int i = 0; i < stroka.length(); i++)
            result.append(String.valueOf(string_array[i]).repeat(multiplier));
        return result;
    }

    public static float Max_Min_Difference(Scanner scanner) {
        System.out.println("\nЗадача 2.2\nВведите размер массива и значения его элементов");
        int size = scanner.nextInt();
        float[] array = new float[size];
        for (int i = 0; i < size; i++)
            array[i] = scanner.nextFloat();
        Arrays.sort(array);
        return array[array.length - 1] - array[0];
    }

    public static boolean Is_Avg_Whole(Scanner scanner) {
        System.out.println("\nЗадача 2.3\nВведите размер массива и значения его элементов");
        int size = scanner.nextInt();
        float[] array = new float[size];
        for (int i = 0; i < size; i++)
            array[i] = scanner.nextFloat();
        float sum = 0;
        for (float a : array)
            sum += a;
        double avg = sum / array.length;
        return avg % 1 == 0;
    }

    public static String Cumulative_Sum(Scanner scanner) {
        System.out.println("\nЗадача 2.4\nВведите размер массива и значения его элементов");
        int size = scanner.nextInt();
        int[] array = new int[size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
            array[i] = sum;
        }
        return Arrays.toString(array);
    }

    public static int Decimal_Places(Scanner scanner) {
        System.out.println("\nЗадача 2.5\nВведите десятичное число");
        String chislo = scanner.nextLine();
        String[] splitted_string = chislo.split("\\.");
        return splitted_string[1].length();
    }

    public static int Fibonacci(Scanner scanner) {
        System.out.println("\nЗадача 2.6\nВведите порядковый номер числа Фибоначчи");
        int number = scanner.nextInt();
        int num1 = 1;
        int num2 = 2;
        int current_num = 0;
        for (int i = 3; i <= number; i++) {
            current_num = num1 + num2;
            num1 = num2;
            num2 = current_num;
        }
        return current_num;
    }

    public static boolean Is_Valid(Scanner scanner) {
        System.out.println("\nЗадача 2.7\nВведите почтовый индекс");
        String Index = scanner.nextLine();
        return Index.matches("\\d{5}");
    }

    public static boolean Is_Strange_Pair(Scanner scanner) {
        System.out.println("\nЗадача 2.8\nВведите две строки");
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        boolean result;
        if (!(str1.isBlank() && str2.isBlank())) {
            result = (str1.charAt(str1.length() - 1) == str2.charAt(0)) && (str2.charAt(str2.length() - 1) == str1.charAt(0));
        } else {
            result = true;
        }
        return result;
    }

    public static boolean Is_Prefix(Scanner scanner) {
        System.out.println("\nЗадача 2.9\nВведите строку и префикс");
        String stroka = scanner.nextLine();
        String Input_prefix = scanner.nextLine();
        String prefix = Input_prefix.substring(0, Input_prefix.length()-1);
        boolean result = stroka.startsWith(prefix);
        return result;
    }

    public static boolean Is_Suffix(Scanner scanner) {
        System.out.println("\nВведите строку и суффикс");
        String stroka = scanner.nextLine();
        String input_suffix = scanner.nextLine();
        String suffix = input_suffix.substring(1, input_suffix.length());
        boolean result = stroka.endsWith(suffix);
        return result;
    }

    public static int Box_Seq(Scanner scanner) {
        System.out.println("\nЗадача 2.10\nВведите номер шага");
        int number = scanner.nextInt();
        int result;
        if (number % 2 == 0) {
            result = number;
        } else {
            result = number + 2;
        }
        return result;
    }
}
