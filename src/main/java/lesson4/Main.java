package lesson4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static void ex0() {
        final int SIZE = 10_000_000;
        Random random = new Random();
        List<Integer> linkedList = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(random.nextInt());
        }
        System.out.println("LinkedList: " + (System.currentTimeMillis() - start));

        List<Integer> arrayList = new ArrayList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(random.nextInt());
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        LinkedList<String> ln = new LinkedList<String>();
        System.out.printf("Введите текст в формате - текст~номер");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String name = scanner.nextLine();
            System.out.println(name);
            String[] result = name.split("\\~");
            System.out.println(Arrays.toString(result));

            int a = Integer.parseInt(result[1]);
            if (result[0].equals("print")){
                System.out.println (ln.get(a-1));
                ln.remove(a-1);
                System.out.println(ln);
            } else if (a < ln.size()) {
                ln.set(a-1,result[0]);

            } else {
                ln.add(result[0]);

            }
            //System.out.println(ln);
        }


    }
}
