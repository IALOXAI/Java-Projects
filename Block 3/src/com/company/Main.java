package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Результат 3.1: " + Solutions(scan));
        System.out.println("Результат 3.2: " + Find_Zip(scan));
        System.out.println("Результат 3.3: " + Check_Perfect(scan));
        System.out.println("Результат 3.4: " + FlipEndChars(scan));
        System.out.println("Результат 3.5: " + Is_Valid_Hex_Code(scan));
        System.out.println("Результат 3.6: " + Same(scan));
        System.out.println("Результат 3.7: " + Is_Kaprekar(scan));
        System.out.println("Результат 3.8: " + Longest_Zero(scan));
        System.out.println("Результат 3.9: " + Next_Prime(scan));
        System.out.println("Результат 3.10: " + Right_Triangle(scan));
        scan.close();
    }

    public static int Solutions(Scanner scanner) {
        System.out.println("\nЗадача 3.1\nВведите коэффициенты a, b, c для уравнения a*(x^2) + b*x + c = 0");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int result;
        double discriminant = Math.pow(b, 2) - 4 * a * c; // Нахождение дискриминанта уравнения
        System.out.println(discriminant);
        if (discriminant > 0) { // Сравнение дискриминанта с нулем для выявления кол-ва корней
            result = 2;
        }
        else if (discriminant == 0) {
            result = 1;
            }
        else {
            result = 0;
        }
        return result;
    }

    public static int Find_Zip(Scanner scanner) {
        System.out.println("\nЗадача 3.2\nВведите строку для поиска повторяющегося \"zip\" в ней");
        String stroka = scanner.nextLine();
        int result = -1;
        int first_position = stroka.indexOf("zip"); // Нахождение первого zip
        int second_position = stroka.indexOf("zip", first_position + 1); // Нахождение второго zip
        if (second_position > first_position) { // Проверка на два вхождения
            result = second_position;
        }
        return result;
    }

    public static boolean Check_Perfect(Scanner scanner) {
        System.out.println("\nЗадача 3.3\nВведите число");
        int number = scanner.nextInt();
        int sum = 0;
        boolean result = false;
        for (int i = 1; i <= number - 1; i++) { // Рассчет суммы делителей числа
            if (number % i == 0) {
                sum += i;
            }
            if (sum == number)
                result = true;
        }
        return result;
    }

    public static String FlipEndChars(Scanner scanner) {
        System.out.println("\nЗадача 3.4\nВведите строку");
        String stroka = scanner.nextLine();
        String result = null;
        char[] stroka_array = stroka.toCharArray(); // Создание массива char на основе строки
        if (stroka.length() >= 2 && stroka_array[0] != stroka_array[stroka.length() - 1]) { // Проверка условий задачи
            result = stroka_array[stroka.length() - 1] + stroka.substring(1, stroka.length() - 1)  + stroka_array[0];
            // Преобразование строки
        }
        else if (stroka.length() < 2) {
            result = "Слишком мало символов";
        }
        else if (stroka_array[0] == stroka_array[stroka.length() - 1]) {
            result = "Символы в начале и в конце строки одинаковые";
        }
        return result;
    }

    public static boolean Is_Valid_Hex_Code(Scanner scanner) {
        System.out.println("\nЗадача 3.5\nВведите строку");
        String stroka = scanner.nextLine();
        return stroka.matches("^#[a-zA-Z0-9]{6}$"); // Проверка условий задачи
    }

    public static boolean Same(Scanner scanner) {
        System.out.println("\nЗадача 3.6");

        System.out.println("Введите количество элементов первого массива и сами элементы");
        int size_1 = scanner.nextInt();
        int[] array_1 = new int[size_1];
        for (int pos = 0; pos < size_1; pos++) { // Заполнение массива пользовательского размера
            array_1[pos] = scanner.nextInt();
        }
        int count1 = size_1;
        for (int pos_1 = 0; pos_1 < size_1; pos_1++) {
            for (int pos_2 = 0; pos_2 < pos_1; pos_2++) { // Проверка на уникальность элемента
                if (array_1[pos_1] == array_1[pos_2]) {
                    count1--; // Уменьшение счетчика если элемент не уникален
                    break;
                }
            }
        }

        System.out.println("Введите количество элементов второго массива и сами элементы");
        int size_2 = scanner.nextInt();
        int[] array_2 = new int[size_2];
        for (int pos = 0; pos < size_2; pos++) {
            array_2[pos] = scanner.nextInt();
        }
        int count2 = size_2;
        for (int pos_1 = 0; pos_1 < size_2; pos_1++) {
            for (int pos_2 = 0; pos_2 < pos_1; pos_2++) {
                if (array_2[pos_1] == array_2[pos_2]) {
                    count2--;
                    break;
                }
            }
        }

        return count1 == count2;
    }

    public static boolean Is_Kaprekar(Scanner scanner) {
        System.out.println("\nЗадача 3.7\nВведите число");
        int number = scanner.nextInt();
        boolean result;
        int count_digits = 1;
        double square_number = Math.pow(number, 2);
        int left_part;
        int right_part;
        if (Math.log10(square_number) < 1) {
            result = square_number == number;
        }
        else {
            double temp = square_number;
            while (temp > 10) { // Считаем разряды
                temp /= 10;
                count_digits++;
            }
            if (count_digits % 2 == 0) {
                left_part = (int) (square_number / Math.pow(10, count_digits / 2)); // левая часть числа
                right_part = (int) (square_number % Math.pow(10, count_digits / 2)); // правая часть числа
            }
            else {
                left_part = (int) (square_number / Math.pow(10, (count_digits + 1) / 2));
                right_part = (int) (square_number % Math.pow(10, (count_digits + 1) / 2));
            }
            result = left_part + right_part == number;
        }
        return result;
    }

    public static String Longest_Zero(Scanner scanner) {
        System.out.println("\nЗадача 3.8\nВведите строку");
        String stroka = scanner.nextLine();
        int count = 0;
        int max_count = 0;
        StringBuilder result = new StringBuilder(); // Создание изменяемой строки
        char[] stroka_array = stroka.toCharArray(); // Создание массива char на основе строки
        for (int i = 0; i < stroka_array.length; i++){
            if (stroka_array[i] == '0'){
                count++; // рассчет нулей
            }
            if (i + 1 == stroka_array.length || stroka_array[i] != '0'){ // Условия прекращения счета нулей
                if (count > max_count){
                    max_count = count;
                }
                count = 0;
            }
        }
        if (max_count > 0){
            result.append("0".repeat(max_count));
        } else {
            result.append("В строке нет нулей");
        }
        return result.toString();
    }

    public static int Next_Prime(Scanner scanner) {
        System.out.println("\nЗадача 3.9\nВведите число");
        int result = 0;
        int number = scanner.nextInt();
        boolean check_prime = false;
        if (number <= 2) { // Если введенное число меньше 3, то оно простое
            result = number;
        }
        else {
            while (!check_prime) {
                for (int i = 2; i < Math.sqrt(number) + 1; i++) {
                    // Проверка числа до его корня+1
                    if (number % i == 0) { // В случае наличия делителя, увеличиваем число
                        number++;
                        break;
                    }
                    else if (i > Math.sqrt(number)) { // Число простое
                        check_prime = true; // Выход из цикла с условием
                        result = number; // Присвоение оканчательного значения
                    }
                }
            }
        }
        return result;
    }

    public static boolean Right_Triangle(Scanner scanner) {
        System.out.println("\nЗадача 3.10\nВведите длины сторон треугольника");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) ||
                Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2) ||
                Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2);
    }
}
