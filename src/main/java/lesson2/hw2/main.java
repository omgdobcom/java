package lesson2.hw2;

import java.io.*;

public class main {
    //    Задача 1. 1. Напишите метод, который принимает на вход строку (String)
//    и определяет, является ли строка палиндромом (возвращает boolean значение).
//
//    Задача 2. Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
//    который запишет эту строку в простой текстовый файл, обработайте исключения.
    public static void main(String[] args) {
//        Задача 1.
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите слово: ");
//        String input = scanner.nextLine();
//        System.out.println(palindrome(input));

//        Задача 2.
        stringCreator(100, "TEST ");
        saveFile("text.txt", stringCreator(100, "TEST"));
    }

    private static boolean palindrome(String a) {
        boolean res = true;
        int j = a.length() - 1;
        for (int i = 0; i < (a.length() / 2); i++) {
            if (a.charAt(i) == a.charAt(j)) {
                res = true;
                j--;
            } else {
                res = false;
            }
        }
        return res;
    }

    public static String stringCreator(Integer a, String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            sb.append(word).append(System.lineSeparator());
        }
        String text = sb.toString();
        System.out.println(text);
        return text;
    }

    public static void saveFile(String fileName, String text) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

