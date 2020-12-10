package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //System.out.println("Результат 4.1: " + Bessie41(scan));
        //System.out.println("Результат 4.2: " + split42(scan));
        //System.out.println("Результат 4.3:\n " + toCamelOrSnakeCase43(scan));
        //System.out.println("Результат 4.4: " + overtime44(scan));
        //System.out.println("Результат 4.5: " + BMI45(scan));
        //System.out.println("Результат 4.6: " + bugger46(scan));
        //System.out.println("Результат 4.7: " + toStarShortHand47(scan));
        //System.out.println("Результат 4.8: " + doesRhyme48(scan));
        //System.out.println("Результат 4.9: " + trouble49(scan));
        System.out.println("Результат 4.10: " + countUniqueBooks410(scan));
        scan.close();
    }

    public static String Bessie41(Scanner scanner) {
        System.out.println("Задача 4.1\n Введите строку, разделяя слова пробелами");
        int max_char = 10; // Максимальное количество символов в строке
        int count = 0;
        String stroka = scanner.nextLine();
        String[] words_array = stroka.split(" ");
        StringBuilder result = new StringBuilder();
        for (String element:words_array){
            if (element.length() + count <= max_char && count != 0){ // Слова в первой строке, кроме первого слова
                result.append(" ").append(element);
                count += element.length();
            } else if (element.length() + count <= max_char && count == 0){ // Первое слово
                result.append(element);
                count += element.length();
            } else if (element.length() + count > max_char && count != 0){ // Перенос на следующую строку
                result.append("\n").append(element);
                count = element.length();
            } else if (element.length() + count > max_char && count == 0){ // Слово занимает всю строку
                result.append(element).append("\n");
            }
        }
        return result.toString();
    }

    public static ArrayList<String> split42(Scanner scanner) {
        System.out.println("\nЗадача 4.2\nВведите строку из скобок");
        String stroka = scanner.nextLine();
        char[] char_array = stroka.toCharArray();
        int open_counter = 0;
        int close_counter = 0;
        int last_index = 0;
        ArrayList<String> bracket_array = new ArrayList<>();
        for (int i = 0; i < stroka.length(); i++) {
            if (char_array[i] == '(') { // Считаем кол-во открывающихся скобок
                open_counter++;
            }
            if (char_array[i] == ')') { // Считаем кол-во закрывающихся скобок
                close_counter++;
            }
            if (open_counter == close_counter) {
                bracket_array.add(stroka.substring(last_index, i + 1)); // Запись одного кластера в массив строк
                last_index = i + 1;
                close_counter = 0;
                open_counter = 0;
            }
        }
        return bracket_array;
    }

    public static String toCamelOrSnakeCase43(Scanner scanner) {
        System.out.println("\nЗадача 4.3\nВведите строку со словами для преобразования");
        String stroka = scanner.nextLine();
        StringBuilder camel_case_result = new StringBuilder();
        StringBuilder snake_case_result = new StringBuilder();
        String[] words_array = stroka.split(" "); // Создаем массив слов на основе полученной строки
        int k = 1;
        for (String s : words_array) {
            if (k == 1) { // Обработка первого слова в camel case
                camel_case_result.append(s.toLowerCase());
                k = 0;
            }
            else { // Обработка остальных слов в camel case
                camel_case_result.append(s.substring(0, 1).toUpperCase()).
                        append(s.substring(1).toLowerCase());
            }
            snake_case_result.append(s.toLowerCase()).append("_"); // Обработка для snake case
        }
        String[] camel_snake_array = new String[]{camel_case_result.toString(),
                snake_case_result.substring(0, snake_case_result.length() - 1)};
        // Создание массива строк для удобного возвращения
        return String.join("\n", camel_snake_array);
    }

    public static String overtime44(Scanner scanner) {
        System.out.println("\nЗадача 4.4\nВведите начало рабочего дня, конец рабочего дня, почасовую ставку и коэффициент сверхурочной работы");
        float[] data_array = new float[4];
        String result;
        for (int i = 0; i < 4; i++) {
            data_array[i] = scanner.nextFloat();
        }
        if (data_array[1] <= 17) {
            result = "$" + ((data_array[1] - data_array[0]) * data_array[2]); // Обычные часы работы до 17
        }
        else if (data_array[0] < 17) {
            result = "$" + ((17 - data_array[0]) * data_array[2] + (data_array[1] - 17) * data_array[3] * data_array[2]); // Обычные часы работы и сверхурочные
            }
        else {
            result = "$" + ((data_array[1] - data_array[0]) * data_array[3] * data_array[2]); // Только сверхурочные
            }
        return result;
    }

    public static String BMI45(Scanner scanner) {
        System.out.println("\nЗадача 4.5\nВведите вес в pounds или kg, и рост в inches или meters");
        String result;
        String stroka_weight = scanner.nextLine();
        String stroka_height = scanner.nextLine();
        String[] weight_array = stroka_weight.split(" "); // Разделение строки на строку с числом и строку с текстом
        String[] height_array = stroka_height.split(" ");
        float weight_number;
        float height_number;

        if (Objects.equals(weight_array[1], "pounds")) {
            weight_number = new Float(weight_array[0]); // Преобразование строки в float
            weight_number = (float) (weight_number / 2.2); // Перевод в килограммы
        }
        else {
            weight_number = new Float(weight_array[0]);
        }
        if (Objects.equals(height_array[1], "inches")) {
            height_number = new Float(height_array[0]);
            height_number = (float) (height_number / 39.4); // Перевод в метры
        } else {
            height_number = new Float(height_array[0]);
        }

        float B_M_I = (float) (weight_number / Math.pow(height_number, 2)); // Вычисление ИМТ по формуле
        if (B_M_I < 18.5) {
            result = new DecimalFormat("#0.0").format(B_M_I) + " - Недостаточный вес";
        }
        else if (B_M_I > 25) {
            result = new DecimalFormat("#0.0").format(B_M_I) + " - Избыточный вес";
        }
        else {
            result = new DecimalFormat("#0.0").format(B_M_I) + " - Вес в пределах нормы";
        }
        return result;
    }

    public static int bugger46(Scanner scanner){
        System.out.println("Задача 4.6\nвведите число");
        int number = scanner.nextInt();
        int count = 0;
        while (number > 9){
            count++;
            String stroka_number = String.valueOf(number); // Преобразование числа в строку
            number = 1;
            for (int i = 0; i < stroka_number.length(); i++){ // Перемножение разрядов числа
                number *= Character.getNumericValue(stroka_number.charAt(i));
            }
        }
        return count;
    }

    public static String toStarShortHand47(Scanner scanner) {
        System.out.println("Задача 4.7\nВведите строку состоящую только из букв");
        String stroka = scanner.nextLine();
        char[] char_array = stroka.toCharArray();
        StringBuilder result = new StringBuilder();
        int char_count = 1;
        for (int i = 1; i < stroka.length(); i++) {
            if (char_array[i - 1] == char_array[i]) {
                char_count += 1;
            }
            else if (char_count > 1) {
                result.append(char_array[i - 1]).append("*").append(char_count);
                char_count = 1;
            }
            else {
                result.append(char_array[i - 1]);
                char_count = 1;
            }
            if (i == stroka.length() - 1 & char_count > 1) { // Специальные случаи для последней итерации
                result.append(char_array[i - 1]).append("*").append(char_count);
            }
            else if (i == stroka.length() - 1 & char_count == 1) {
                result.append(char_array[i]);
            }
        }
        return result.toString();
    }

    public static boolean doesRhyme48(Scanner scanner){
        System.out.println("Задача 4.8\nВведите две строки");
        String stroka_1 = scanner.nextLine();
        String stroka_2 = scanner.nextLine();
        // Берем последнюю последовательность символов после пробела, убирараем все согласные и знаки препинания, понижаем регистр и сравниваем
        return stroka_1.split(" ")[stroka_1.split(" ").length - 1].replaceAll("[BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxZz!?.,]", "").toLowerCase().
                equals(stroka_2.split(" ")[stroka_2.split(" ").length - 1].replaceAll("[BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxZz!?.,]", "").toLowerCase());
    }

    public static boolean trouble49(Scanner scanner) {
        System.out.println("Задача 4.9\nВведите два числа");
        String stroka_num_1 = scanner.nextLine();
        String stroka_num_2 = scanner.nextLine();
        boolean result = false;
        if ((stroka_num_1.matches("[0-9&&[^0]]*0{3}[0-9&&[^0]]*") &&
                stroka_num_2.matches("[0-9&&[^0]]*0{2}[0-9&&[^0]]*")) ||
                (stroka_num_1.matches("[0-9&&[^1]]*1{3}[0-9&&[^1]]*") &&
                        stroka_num_2.matches("[0-9&&[^1]]*1{2}[0-9&&[^1]]*")) ||
                (stroka_num_1.matches("[0-9&&[^2]]*2{3}[0-9&&[^2]]*") &&
                        stroka_num_2.matches("[0-9&&[^2]]*2{2}[0-9&&[^2]]*")) ||
                (stroka_num_1.matches("[0-9&&[^3]]*3{3}[0-9&&[^3]]*") &&
                        stroka_num_2.matches("[0-9&&[^3]]*3{2}[0-9&&[^3]]*")) ||
                (stroka_num_1.matches("[0-9&&[^4]]*4{3}[0-9&&[^4]]*") &&
                        stroka_num_2.matches("[0-9&&[^4]]*4{2}[0-9&&[^4]]*")) ||
                (stroka_num_1.matches("[0-9&&[^5]]*5{3}[0-9&&[^5]]*") &&
                        stroka_num_2.matches("[0-9&&[^5]]*5{2}[0-9&&[^5]]*")) ||
                (stroka_num_1.matches("[0-9&&[^6]]*6{3}[0-9&&[^6]]*") &&
                        stroka_num_2.matches("[0-9&&[^6]]*6{2}[0-9&&[^6]]*")) ||
                (stroka_num_1.matches("[0-9&&[^7]]*7{3}[0-9&&[^7]]*") &&
                        stroka_num_2.matches("[0-9&&[^7]]*7{2}[0-9&&[^7]]*")) ||
                (stroka_num_1.matches("[0-9&&[^8]]*8{3}[0-9&&[^8]]*") &&
                        stroka_num_2.matches("[0-9&&[^8]]*8{2}[0-9&&[^8]]*")) ||
                (stroka_num_1.matches("[0-9&&[^9]]*9{3}[0-9&&[^9]]*") &&
                        stroka_num_2.matches("[0-9&&[^9]]*9{2}[0-9&&[^9]]*"))) {
            result = true;
        }
        return result;
    }

    public static int countUniqueBooks410(Scanner scanner) {
        System.out.println("Задача 4.10\nВведите строку и символ начала и конца книг");
        String stroka = scanner.nextLine();
        String end_mark = scanner.nextLine();
        String[] books_array = stroka.split(end_mark); // Разбиение строки по символу разделителю в массив строк
        HashSet<Character> unique_books = new HashSet<>(); // Создаем хэш для подсчета уникальных книг
        for (int i = 1; i < books_array.length; i++) {
            if (i % 2 != 0) {
                if (!books_array[i].isBlank()) {
                    char[] char_array = books_array[i].toCharArray(); // Преобразуем слово между символами разделителями в массив char
                    for (char letter : char_array) {
                        unique_books.add(letter);
                    }
                }
            }
        }
        return unique_books.size();
    }
}
