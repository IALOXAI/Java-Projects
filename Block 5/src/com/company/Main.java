package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Результат 5.1: " + Arrays.toString(Encrypt(scan)));
        System.out.println("Результат 5.3: " + Can_Complete(scan));
        System.out.println("Результат 5.4: " + Sum_Dig_Prod(scan));
        System.out.println("Результат 5.5: " + Same_Vowel_Group(scan));
        System.out.println("Результат 5.6: " + Validate_Card(scan));
        System.out.println("Результат 5.7: " + Num_To_Eng(scan));
        System.out.println("Результат 5.9: " + Correct_Title(scan));
        System.out.println("Результат 5.10: \n" + Hex_Lattice(scan));
        scan.close();
    }


    public static Object[] Encrypt(Scanner scanner) {
        Object[] result = new Object[2];
        System.out.println("Задача 5.1\nВведите строку для кодирования и массив чисел для декодирования через пробел");
        // Алгоритм кодирования
        String stroka = scanner.nextLine();
        char[] char_array = stroka.toCharArray();
        int first = char_array[0];
        int[] encrypt_result = new int[char_array.length];
        encrypt_result[0] = first;
        for (int i = 1; i < char_array.length; i++) {
            encrypt_result[i] = char_array[i] - first;
            first = char_array[i];
        }
        result[0] = Arrays.toString(encrypt_result);
        // Алгоритм декодирования   83 34 -7 5 -11 1 5 -9
        String stroka_2 = scanner.nextLine();
        StringBuilder decrypt_result = new StringBuilder();
        String[] numbers = stroka_2.split(" ");
        int first_2 = Integer.parseInt(numbers[0]);
        decrypt_result.append(String.valueOf(Character.toChars(first_2)));
        for (int i = 1; i < numbers.length; i++) {
            decrypt_result.append(String.valueOf(Character.toChars(Integer.parseInt(numbers[i]) + first_2)));
            first_2 = Integer.parseInt(numbers[i]) + first_2;
        }
        result[1] = decrypt_result.toString();
        return result;
    }

    public static boolean Can_Complete(Scanner scanner) {
        System.out.println("Задача 5.3\nВведите две строки");
        String stroka = scanner.nextLine();
        String stroka_2 = scanner.nextLine();
        StringBuilder matcher = new StringBuilder("[a-zA-Z]*");
        for (char element : stroka.toCharArray()) {
            matcher.append(element).append("[a-zA-Z]*");  // Создание строки для проверки совпадения
        }
        System.out.println(matcher);
        return stroka_2.matches(matcher.toString());
    }

    public static int Sum_Dig_Prod(Scanner scanner){
        System.out.println("Задача 5.4\nВведите числа, разделяя их пробелами");
        String stroka = scanner.nextLine();
        int[] numbers = new int[stroka.split(" ").length];
        for (int i = 0; i < stroka.split(" ").length; i++){
            numbers[i] = Integer.parseInt(stroka.split(" ")[i]);  // Заполняем массив числами
        }
        int sum = 0;
        for (int element : numbers){
            sum += element;  // Подсчет суммы всех чисел
        }
        int num = sum;
        while (num > 9){  // Нахождение произведения цифр пока не останется один разряд
            sum = 1;
            while (num / 10 > 0){
                sum *= num % 10;
                num /= 10;
            }
            sum *= num;
            num = sum;
        }
        return sum;
    }

    public static String Same_Vowel_Group(Scanner scanner){
        System.out.println("Задача 5.5\nВведите слова");
        String stroka = scanner.nextLine();
        String[] words = stroka.split(" ");
        String[] words_vowels = new String[words.length];
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++){
            HashSet<Character> unique_vowels = new HashSet<>();
            words_vowels[i] = words[i].replaceAll("[^aeiouAEIOU]", "").toLowerCase(); // Заносим в массив элемент состоящий только из гласных
            for (char letter : words_vowels[i].toCharArray()){
                unique_vowels.add(letter);
            }
            words_vowels[i] = "";
            ArrayList<Character> sorted_uniq_vowels = new ArrayList<>(unique_vowels);
            Collections.sort(sorted_uniq_vowels); // Сортировка уникальных гласных
            for (Character letter : sorted_uniq_vowels) {
                words_vowels[i] += letter; // Заносим в массив сортированные гласные из слов
            }
        }
        // Проверка на совпадение гласных у слов
        if (words_vowels.length > 1){
            result.add(words[0]);
            for (int i = 1; i < words_vowels.length; i++){
                if (words_vowels[i].equals(words_vowels[0])){
                    result.add(words[i]);
                }
            }
        } else {
            result.add(words[0]);
        }
        return result.toString();
    }

    public static boolean Validate_Card(Scanner scanner) {
        System.out.println("Задача 5.6\nВведите номер карты (14-19 символов)");
        StringBuffer stroka = new StringBuffer(scanner.nextLine());
        if (stroka.toString().matches("\\b\\d{14,19}\\b")) {
            int check_num = Character.getNumericValue(stroka.charAt(stroka.length() - 1)); // Сохранение контрольной цифры
            stroka = new StringBuffer(stroka.substring(0, stroka.length() - 1)).reverse(); // Удаление последней цифры и переворачивание числа
            for (int i = 0; i < stroka.length(); i++) {
                if ((i + 1) % 2 != 0) { // Изменение всех нечетных цифр в числе
                    int num = Character.getNumericValue(stroka.charAt(i));
                    num *= 2;
                    if (num >= 10) {
                        num = num / 10 + num % 10;
                        stroka.deleteCharAt(i).insert(i, num);
                    } else {
                        stroka.deleteCharAt(i).insert(i, num);
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < stroka.length(); i++) { // Суммирование всех чисел
                sum += Character.getNumericValue(stroka.charAt(i));
            }
            return 10 - (sum % 10) == check_num; // Сравнение с контрольной цифрой
        } else {
            return false;
        }
    }

    public static String Num_To_Eng(Scanner scanner) {
        System.out.println("Задача 5.7\nВведите число от 0 до 999");
        int inputNum = scanner.nextInt();
        // Массив для десятков
        String[] decimals = new String[]{"teen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        // Массив для единиц
        String[] numbers = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        // Массив для нестандартных двузначных чисел
        String[] atypical = new String[]{"eleven", "twelve", "thir", "fif", "ten"};
        StringBuilder result = new StringBuilder();
        if (inputNum < 0 || inputNum > 999) { // Проверка на соответствие условию
            return "Неверный ввод";
        }
        else {
            if (inputNum >= 100) {  // если число трехзначное
                result.append(numbers[inputNum / 100]).append(" hundred");
                if (inputNum % 100 > 0) {
                    if (inputNum % 100 >= 10){  // если после деления остаток двузначный
                        switch (inputNum % 100){
                            case 10:
                                result.append(" ").append(atypical[4]);
                                break;
                            case 11:
                                result.append(" ").append(atypical[0]);
                                break;
                            case 12:
                                result.append(" ").append(atypical[1]);
                                break;
                            case 13:
                                result.append(" ").append(atypical[2]).append(decimals[0]);
                                break;
                            case 15:
                                result.append(" ").append(atypical[3]).append(decimals[0]);
                                break;
                            case 18:
                                result.append(" ").append(numbers[8], 0, numbers[8].length() - 1).append(decimals[0]);
                                break;
                            default:  // случаи для стандартных двухзначных чисел
                                if (inputNum % 100 < 20){
                                    result.append(" ").append(numbers[inputNum % 10]).append(decimals[0]);
                                }
                                else if (inputNum % 100 >= 20){
                                    if (inputNum % 10 == 0){
                                        result.append(" ").append(decimals[inputNum % 100 / 10 -1]);
                                    }
                                    else {
                                        result.append(" ").append(decimals[inputNum % 100 / 10 - 1]).append(" ").append(numbers[inputNum % 10]);
                                    }
                                }
                                break;
                        }
                    }
                }
            }
            else if (inputNum >= 10){  // Если введенное число двузначное
                switch (inputNum ){
                    case 10:
                        result.append(atypical[4]);
                        break;
                    case 11:
                        result.append(atypical[0]);
                        break;
                    case 12:
                        result.append(atypical[1]);
                        break;
                    case 13:
                        result.append(atypical[2]).append(decimals[0]);
                        break;
                    case 15:
                        result.append(atypical[3]).append(decimals[0]);
                        break;
                    case 18:
                        result.append(numbers[8], 0, numbers[8].length() - 1).append(decimals[0]);
                        break;
                    default:
                        if (inputNum < 20){
                            result.append(" ").append(numbers[inputNum % 10]).append(decimals[0]);
                        }
                        else {
                            if (inputNum % 10 == 0){
                                result.append(decimals[inputNum / 10 -1]);
                            }
                            else {
                                result.append(decimals[inputNum / 10 - 1]).append(" ").append(numbers[inputNum % 10]);
                            }
                        }
                        break;
                }
            }
            else {  // Если введенна цифра
                result.append(numbers[inputNum]);
            }
            return result.toString();
        }
    }

    public static String Correct_Title(Scanner scanner){
        System.out.println("Задача 5.9\nВведите заголовок серии игры престолов");
        StringBuilder result = new StringBuilder();
        String stroka = scanner.nextLine();
        String[] words = stroka.split(" ");
        for (String word : words) {
            if (word.contains("-")) {  // Если в слове тире, то создаем массив слов из этого слова, разделенных тире
                String[] dash_words = word.split("-");
                for (String dash_word : dash_words) {
                    if (dash_word.toLowerCase().equals("and") || dash_word.toLowerCase().equals("of") ||
                            dash_word.toLowerCase().equals("in") || dash_word.toLowerCase().equals("the")) {
                        if (result.charAt(result.length() - 1) != '-') {
                            result.append(" ").append(dash_word.toLowerCase()).append("-");
                        }
                        else {
                            result.append(dash_word.toLowerCase()).append("-");
                        }
                    }
                    else {
                        if (result.charAt(result.length() - 1) != '-') {
                            result.append(" ").append(dash_word.substring(0, 1).toUpperCase())
                                    .append(dash_word.substring(1).toLowerCase()).append("-");
                        }
                        else {
                            result.append(dash_word.substring(0, 1).toUpperCase())
                                    .append(dash_word.substring(1).toLowerCase()).append("-");
                        }
                    }
                }
                result.deleteCharAt(result.length() - 1);  // Убираем лишнее тире в конце
            }
            else {
                if (word.toLowerCase().equals("and") || word.toLowerCase().equals("of") ||
                        word.toLowerCase().equals("in") || word.toLowerCase().equals("the")) {
                    if (result.length() == 0) {
                        result.append(word.toLowerCase());
                    }
                    else {
                        result.append(" ").append(word.toLowerCase());
                    }
                }
                else {
                    if (result.length() == 0) {
                        result.append(word.substring(0, 1).toUpperCase()).
                                append(word.substring(1).toLowerCase());
                    }
                    else {
                        result.append(" ").append(word.substring(0, 1).toUpperCase())
                                .append(word.substring(1).toLowerCase());
                    }
                }
            }
        }
        return result.toString();
    }

    public static String Hex_Lattice(Scanner scanner){
        System.out.println("Задача 5.10\nВведите положительное число");
        int number = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        if (number > 0){
            int is_correct = number - 1;
            int count = 0;
            while (is_correct > 0){  // Проверка введенного числа на центрированное шестиугольное число
                count += 1;
                is_correct -= 6 * count;
            }
            if (is_correct == 0){
                for (int i = count + 1; i < 2 * count + 1; i++){  // Построение верхних элементов шестиугольника
                    result.append("\t").append("\s".repeat(2 * count + 1 - i)).append("o\s".repeat(i)).append("\n");
                }
                for (int i= 2 * count + 1; i >= count + 1; i--){  // Построение нижних элементов шестиугольника
                    result.append("\t").append("\s".repeat(2 * count + 1 - i)).append("o\s".repeat(i)).append("\n");
                }
            }
            else {
                result.append("Недопустимое число");
            }
        }
        return result.toString();
    }
}