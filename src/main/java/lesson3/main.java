package lesson3;

import javax.print.DocFlavor;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        planet();
//        stringComperssion();

    }

    private static void planet() {
        String[] arrPlaner = {"Mer", "Ven", "Ear", "Mars", "jup", "Sat", "Yra", "Nep", "Plut"};
        Random random = new Random();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(arrPlaner[random.nextInt(9)]);
        }
        System.out.println(list);

        list.sort(Comparator.naturalOrder());

                StringBuilder sb = new StringBuilder();
                System.out.println(list);
                int count = 1;
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i).equals(list.get(i + 1))) {
                        count++;
                    } else {
                        sb.append(list.get(i))
                                .append(": ")
                                .append(count)
                                .append("; ");
                        count = 1;
                    }
                }
                sb.append((list.get(list.size() - 1) + ": ")).append(count).append(".");
                System.out.println(sb);
            }

        }

