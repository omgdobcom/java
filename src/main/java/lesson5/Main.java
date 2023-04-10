package lesson5;


/*        System.out.println(passportsToSernameMap);

        for (Map.Entry<String, String> entry : passportsToSernameMap.entrySet()) {
            System.out.printf("%s\t%s%n", entry.getKey(), entry.getValue());
        }*/

/*        for (String key : passportsToSernameMap.keySet()) {
            System.out.printf("%s\t%s%n", key, passportsToSernameMap.get(key));
        }*/

/*        passportsToSernameMap.forEach((key, value) -> System.out.printf(
                "%s\t%s%n",
                key, value)
        );*/

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("2999 " + ex("MMCMXCIX"));
        System.out.println("30 " + ex("XXX"));
        System.out.println("1666 " + ex("MDCLXVI"));
    }

    private static int ex(String str) {
        Map<String, Integer> converter = new HashMap<>();

        converter.put("M", 1000);
        converter.put("D", 500);
        converter.put("C", 100);
        converter.put("L", 50);
        converter.put("X", 10);
        converter.put("V", 5);
        converter.put("I", 1);
        int sum = 0;
        int current = 0;
        int next = -1;
        for (int i = 0; i < str.length() - 1; i++) {
            current = converter.get(str.charAt(i) + "");
            next = converter.get(String.valueOf(str.charAt(i + 1)));
            if (current < next) {
                sum -= current;
            } else {
                sum += current;
            }
        }
        sum += next;
        return sum;
    }
}

