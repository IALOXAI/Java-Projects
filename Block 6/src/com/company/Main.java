package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Задача 6.1: " + Bell_Number(scan));
        System.out.println("Задача 6.2: " + Translate_Sentence(scan));
        System.out.println("Задача 6.3: " + Valid_Color(scan));
        System.out.println("Задача 6.5: " + Get_HashTags(scan));
        System.out.println("Задача 6.7: " + Longest_Non_Repeating_Substring(scan));
        System.out.println("Задача 6.8: " + Convert_To_Roman(scan));
        System.out.println("Задача 6.9: " + Formula(scan));
        System.out.println("Задача 6.10: " + Palindrome_Descendant(scan));
        scan.close();
    }

    public static int Bell_Number(Scanner scanner){
        System.out.println("Задача 6.1\nВведите положительное число");
        int number = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i <= number; i++){
            sum += Stirling(number, i);  // Вычисления по формуле
        }
        return sum;
    }
    // Отдельный рекурсивный метод для вычисления числа Белла
    static int Stirling(int input_num, int i_num){
        if (input_num == i_num) return 1;
        else if (i_num == 0) return 0;
        else return Stirling(input_num-1, i_num-1) + i_num * Stirling(input_num-1, i_num);
    }

    static String Translate_Sentence(Scanner scanner){
        System.out.println("Задача 6.2\nВведите предложение на английском");
        String[] words = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++){
            String word = words[i].trim();
            // Обработка пунктуации
            if (word.endsWith(",") || word.endsWith(".") ||
                    word.endsWith(";") || word.endsWith("-") ||
                    word.endsWith("!") || word.endsWith("?")){
                word = word.substring(0, word.length()-1);
            }
            word = Translate_Word(word);
            // Обработка регистра
            if (Character.isUpperCase(words[i].toCharArray()[0])){
                word = Character.toUpperCase(word.toCharArray()[0]) + word.substring(1);
            }
            // Добавление знаков пунктуации после слов
            if (words[i].endsWith(",")){
                result.append(word).append(",\s");
                continue;
            }
            if (words[i].endsWith(".")){
                result.append(word).append(".");
                continue;
            }
            if (words[i].endsWith(";")){
                result.append(word).append(";\s");
                continue;
            }
            if (words[i].endsWith("!")){
                result.append(word).append("!\s");
                continue;
            }
            if (words[i].endsWith("?")){
                result.append(word).append("?\s");
                continue;
            }
            if (words[i].endsWith("-")){
                result.append(word).append("\s-\s");
                continue;
            }
            result.append(word).append("\s");
        }
        return result.toString();
    }
    // Метод для изменения слов
    public static  String Translate_Word(String word){
        word = word.toLowerCase();
        if (String.valueOf(word.charAt(0)).matches("[aeiou]")){
            word += "yay";
        }
        else {
            String buffer = "";
            for(int i = 0; i < word.length(); i++) {
                if(!String.valueOf(word.charAt(i)).matches("[aeiou]")) {
                    buffer += word.charAt(i);
                }
                else {
                    word = word.substring(i) + buffer + "ay";
                    break;
                }
            }
        }
        return word;
    }

    public static boolean Valid_Color(Scanner scanner){
        System.out.println("Задача 6.3\nВведите RGB формат цвета");
        String stroka = scanner.nextLine().replaceAll(" ", "").trim();
        if (stroka.startsWith("rgba")){
            stroka = stroka.substring(5, stroka.length() - 1); // Убираем все символы кроме чисел и запятых
            String[] values = stroka.split(",");
            // Проверка на количество введенных данных
            if (values.length != 4){
                return false;
            }
            // Оставшаяся проверка данных
            for (int i = 0; i < values.length - 1; i++){
                if (values[i].length() > 0){
                    int value;
                    try {
                        value = Integer.parseInt(values[i]);
                        if (value < 0 || value > 255){
                            return false;
                        }
                    }
                    catch (Exception e){  // Если значение не является числом
                        return false;
                    }
                }
            }
            // Проверка значения прозрачности цвета
            if (values[3].length() > 0){
                float value;
                try {
                    value = Float.parseFloat(values[3]);
                    if (value < 0 || value > 1){
                        return false;
                    }
                }
                catch (Exception e){
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else if (stroka.startsWith("rgb")){
            stroka = stroka.substring(4, stroka.length() - 1);
            String[] values = stroka.split(",");
            System.out.println("\tvalues: " + Arrays.toString(values));
            if (values.length < 3){
                return false;
            }
            for (String colorValue : values) {
                if (colorValue.length() > 0) {
                    int value;
                    try {
                        value = Integer.parseInt(colorValue);
                        if (value < 0 || value > 255) {
                            return false;
                        }
                    }
                    catch (Exception e) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    public static String Get_HashTags(Scanner scanner){
        System.out.println("Задача 6.5\nВведите строку");
        String stroka = scanner.nextLine();
        String[] words = stroka.split(" ");
        for (int i = 0; i < words.length; i++) {  // Удаление знаков препинания
            if (words[i].endsWith(",") || words[i].endsWith(".") ||
                    words[i].endsWith(";") || words[i].endsWith("-") ||
                    words[i].endsWith("!") || words[i].endsWith("?")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
        }
        // Сортировка массива по длине слов
        Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));
        int length;
        length = Math.min(words.length, 3);
        String[] result = new String[length];
        for (int i = 0; i < length; i++){
            result[i] = '#' + words[i].toLowerCase();
        }
        return Arrays.toString(result);
    }

    public static String Longest_Non_Repeating_Substring(Scanner scanner){
        System.out.println("Задача 6.7\nВведите строку для нахождения длиннейшей неповторяющейся подстроки");
        String stroka = scanner.nextLine();
        char[] chars = stroka.toCharArray();
        int first_index = 0;
        int final_index = 0;
        int counter;
        for (int i = 0; i < chars.length; i++){
            char char_copy = chars[i];
            if (i != chars.length - 1){
                counter = i + 1;
                while (chars[counter] != char_copy && counter < chars.length - 1) {
                    counter++;  // Подсчет самой длинной подстроки
                }
            }
            else {
                counter = i;
            }
            // Запись индексов у самой длинной подстроки
            if (counter - i > final_index - first_index){
                final_index = counter;
                first_index = i;
            }
        }
        return stroka.substring(first_index, final_index);
    }

    public static String Convert_To_Roman(Scanner scanner){
        System.out.println("Задача6.8\nВведите арабское число от 0 до 3999");
        int number = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        String[] roman_numbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int count = 0;
        while (number > 0 && count < roman_numbers.length){
            if (values[count] <= number){  // Перебор элементов в массиве чисел
                result.append(roman_numbers[count]);
                number -= values[count];
            }
            else {
                count++;
            }
        }
        return result.toString();
    }

    public static boolean Formula(Scanner scanner){
        System.out.println("Задача 6.9\nВведите формулу");
        String stroka = scanner.nextLine().replaceAll(" ", "").strip();
        String[] parts = stroka.split("=");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++){
            // Проверка на наличие арифметических знаков в части неравенства
            if (parts[i].contains("-")){
                if (parts[i].indexOf("-") > 0 &&
                        parts[i].lastIndexOf("-") < parts[i].length() - 1) {
                    String[] numbers = parts[i].split("-");
                    // Вычитание чисел
                    int buffer = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
                    if (numbers.length > 2){
                        for (int count = 1; count < numbers.length; count++){
                            buffer -= Integer.parseInt(numbers[count]);
                        }
                    }
                    result[i] = buffer;
                } 
                else {
                    return false;
                }
            }
            if (parts[i].contains("+")){
                if (parts[i].indexOf("+") > 0 &&
                        parts[i].lastIndexOf("+") < parts[i].length() - 1) {
                    String[] numbers = parts[i].split("\\+");
                    int buffer = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
                    if (numbers.length > 2){
                        for (int count = 1; count < numbers.length; count++){
                            buffer += Integer.parseInt(numbers[count]);
                        }
                    }
                    result[i] = buffer;
                }
                else {
                    return false;
                }
            }
            if (parts[i].contains("/")){
                if (parts[i].indexOf("/") > 0 && parts[i].lastIndexOf("/") < parts[i].length() - 1){
                    String[] numbers = parts[i].split("\\/");
                    try {
                        int buffer = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]);
                        if (numbers.length > 2){
                            for (int count = 1; count < numbers.length; count++){
                                buffer /= Integer.parseInt(numbers[i]);
                            }
                        }
                        result[i] = buffer;
                    } 
                    catch (Exception e){
                        return false;
                    }
                }
            }
            if (parts[i].contains("*")){
                if (parts[i].indexOf("*") > 0 && parts[i].lastIndexOf("*") < parts[i].length() - 1){
                    String[] numbers = parts[i].split("\\*");
                    try {
                        int buffer = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
                        if (numbers.length > 2){
                            for (int count = 1; count < numbers.length; count++){
                                buffer += Integer.parseInt(numbers[i]);
                            }
                        }
                        result[i] = buffer;
                    }
                    catch (Exception e){
                        return false;
                    }
                }
            }
            if (!(parts[i].contains("-") || parts[i].contains("+") ||
                    parts[i].contains("/") || parts[i].contains("*"))){
                result[i] = Integer.parseInt(parts[i]);
            }
        }
        for (int count = 1; count <= result.length - 1; count++){ // Проверка на равенство частей выражения
            if (result[count] != result[count - 1]){
                return false;
            }
        }
        return true;
    }

    public static boolean Palindrome_Descendant(Scanner scanner){
        System.out.println("Задача 6.10\nВведите число для проверки его на палиндромность");
        int number = scanner.nextInt();
        String value = String.valueOf(number);
        // Проверка на принадлежность допустимому диапазону значений и четное количество знаков
        if (number < 10 || String.valueOf(number).length() % 2 != 0) return false;
        while (value.length() >= 2 ){
            StringBuilder part2 = new StringBuilder(value.substring(value.length() / 2));
            if (value.substring(0, (value.length()) / 2).equals(part2.reverse().toString())) { // Проверка на палиндромность
                return true;
            }
            StringBuilder buffer = new StringBuilder();
            for (int i = 0; i <= value.length() - 2; i+=2){ // Создание прямого потомка числа
                buffer.append(Character.getNumericValue(value.charAt(i)) + Character.getNumericValue(value.charAt(i + 1)));
            }
            value = buffer.toString();
            System.out.println(value);
        }
        return false;
    }
}
