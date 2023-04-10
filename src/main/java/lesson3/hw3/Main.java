package lesson3.hw3;

import java.util.*;

//1. Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то готовое для этого)
//2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
//3. Доделать начатое на семинаре. Пройтись по списку из задания 2 и удалить повторяющиеся элементы.
public class Main {
    public static void main(String[] args) {
//        ex01();
//        ex02();
            ex03();

    }

    public static void ex01() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(0, 1000));
        }
        System.out.println(list);
        list.removeIf(value -> value % 2 == 0);
        System.out.println(list);
    }

    private static void ex02() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(0, 1000));
        }
        System.out.println(list);
            double sum = 0;
        for (int i = 0; i <list.size() ; i++) {
            sum+=list.get(i);
        }
        double result = sum/list.size();

        System.out.printf("Минимальное число - " + Collections.min(list) + "\n");
        System.out.printf("Максимальное число - " + Collections.max(list) + "\n");
        System.out.printf("Среднее арифметическое - " + result);

    }
    private static void ex03() {
        String[] arrPlaner = {"Mer", "Ven", "Ear", "Mars", "jup", "Sat", "Yra", "Nep", "Plut"};
        Random random = new Random();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(arrPlaner[random.nextInt(9)]);
        }
        System.out.println(list);

        list.sort(Comparator.naturalOrder());

        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
               list.remove(i+1);
               i--;
            }
        }
        System.out.println(list);
    }
}
