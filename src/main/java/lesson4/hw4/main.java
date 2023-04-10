package lesson4.hw4;

//1. Реализовать консольное приложение, которое:
//Принимает от пользователя и “запоминает” строки.
//Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//Если введено revert, удаляет предыдущую введенную строку из памяти.
//2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.


import java.util.*;

public class main {
    public static void main(String[] args) {

//        exec01();
        exec02();
    }

    private static void exec01() {
        Scanner scan = new Scanner(System.in);
        Deque<String> dequeList = new ArrayDeque<>();
        while (true) {
            System.out.print("Введите строку: ");
            String name = scan.nextLine();
            if (name.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (name.equals("print")) {
                try {
                    Deque<String> dequeNewList = new ArrayDeque<>(dequeList);
                    String firstVol = dequeNewList.pollFirst();
                    String lastVol = dequeNewList.pollLast();
                    dequeNewList.push(lastVol);
                    dequeNewList.add(firstVol);
                    System.out.println(dequeNewList);
                } catch (NullPointerException e) {
                    System.out.println("Не введены строки");
                }
            } else if (name.equals("revert")) {
                try {
                    dequeList.removeLast();
                    System.out.println(dequeList);
                } catch (NoSuchElementException e) {
                    System.out.println("Не введены строки");
                }
            } else {
                dequeList.add(name.trim());
            }
        }
    }

    private static void exec02() {
        int SIZE = 10;
        Random random = new Random();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(random.nextInt(0,100));
        }
        System.out.println(linkedList);
        List<Integer> newList = new LinkedList<>();
        for (int i = linkedList.size()-1 ; i >= 0 ; i--) {
            newList.add(linkedList.get(i));
        }
        System.out.println(newList);
    }

}
