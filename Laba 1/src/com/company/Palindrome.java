package com.company;

import java.util.Scanner;

public class Palindrome {
    // Класс для реверсирования строк и определения палиндромов
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку для ее инвертирования и проверки на палиндромность");
        String input_string = scan.nextLine();
        System.out.println(Reverse_String(input_string));
        System.out.println(Is_Palindrome(input_string));
        scan.close();
    }

    public static String Reverse_String(String s) {
        // Инвертирование строки
        StringBuilder finalString = new StringBuilder();
        for (int pos = s.length() - 1; pos > -1; pos--) {
            finalString.append(s.charAt(pos));
        }
        return "Инвертированная строка:\n" + finalString.toString();
    }

    public static String Is_Palindrome(String s) {
        // Проверка на палиндромность
        String reverse = Reverse_String(s);
        return (reverse.equals(s)? "Палиндром":"Не палиндром");
    }
}
