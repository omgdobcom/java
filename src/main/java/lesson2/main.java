package lesson2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
//        createString();
//        palindrom();
        countChar();


    }

//    Напишите метод, который сжимает строку.
//    Пример: вход aaaabbbcdd.
    private static void countChar() {
        String str = "aaaabbbcdd";
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                if (count == 1) {
                    result.append(str.charAt(i));
                } else {
                    result.append(str.charAt(i)).append(count);
                    count = 1;
                }
            }
        }
        System.out.println(result.append(str.charAt(str.length() - 1)).append(count > 1 ? count : " ").toString());
    }

    public static void createString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = scanner.nextInt();
//        int n = 7;
        String a = "c1";
        String b = "c2";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                sb.append(a);
            } else {
                sb.append(b);
            }

        }
        System.out.println(sb.toString());
    }
}
