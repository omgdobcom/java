package lesson5.hw5;
//1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
//2. Пусть дан список сотрудников: Иван Иванов Светлана Петрова Кристина Белова Анна Мусина Анна Крутова Иван Юрин
// Петр Лыков Павел Чернов Петр Чернышов Мария Федорова Марина Светлова Мария Савина Мария Рыкова Марина Лугова
// Анна Владимирова Иван Мечников Петр Петин Иван Ежов
//Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

import java.util.*;

public class main {
    public static void main(String[] args) {
//        exer01();
        exer02();
    }

    private static void exer01() {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.putIfAbsent("1234", "PetrovAA");
        phoneBook.putIfAbsent("1235", "SidorovPP");
        phoneBook.putIfAbsent("1236", "IvanovSE");
        while (true) {
            Scanner scan = new Scanner(System.in);
            menu();
            System.out.print("Выберите опцию: ");
            int num = scan.nextInt();
            switch (num) {
                case 1 -> showAll(phoneBook);
                case 2 -> newRecord(phoneBook);
                case 3 -> searchRecord(phoneBook);
                case 4 -> deleteRecord(phoneBook);
                case 0 -> exit();
                default -> System.out.println("Введен неверный номер");
            }
        }
    }

    private static void deleteRecord(Map<String, String> deletemap) {
        List<String> numbers = searchNumber(deletemap);
        if (numbers != null) {
            System.out.print("Результат поиска:\n");
            for (var item : numbers) {
                for (var key : deletemap.keySet()) {
                    if (item.equals(key)) {
                        System.out.printf("%s был удален\n", item);
                        deletemap.remove(key);
                        break;
                    }
                }
            }
        } else {
            System.out.print("Результат поиска: Контакт не найден\n");
        }
    }

    private static void searchRecord(Map<String, String> hm) {
        List<String> numbers = searchNumber(hm);
        if (numbers != null) {
            System.out.print("Результат поиска:\n");
            for (var item : numbers) {
                for (var key : hm.keySet()) {
                    if (item.equals(key)) {
                        System.out.printf("%s %s\n", hm.get(item), item);
                    }
                }
            }
        } else {
            System.out.print("Результат поиска: Контакт не найден\n");
        }
    }

    private static List<String> searchNumber(Map<String, String> searchNumber) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Выберите имя контакта: ");
        String searchValue = scan.nextLine();
        List<String> contactNumber = new ArrayList<>();
        if (searchNumber.containsValue(searchValue)) {
            for (var key : searchNumber.keySet()) {
                if (searchValue.equals(searchNumber.get(key))) {
                    contactNumber.add(key);
                }
            }
            return contactNumber;
        } else {
            return null;
        }
    }

    private static void showAll(Map<String, String> showMap) {
        if (!showMap.isEmpty()) {
            for (var item : showMap.entrySet()) {
                System.out.printf("%s : %s\n", item.getValue(), item.getKey());
            }
        } else System.out.println("Список пуст\n ============");
    }

    private static Map<String, String> newRecord(Map<String, String> recordMap) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя контакта: ");
        String value = scan.nextLine();
        System.out.print("Введите номер контакта: ");
        String key = scan.nextLine();
        recordMap.putIfAbsent(key, value);
        System.out.printf("Контакт добавлен: %s %s\n", recordMap.get(key), key);
        return recordMap;
    }

    private static void exit() {
        System.out.println("Good bye!");
        System.exit(0);
    }

    private static void menu() {
        System.out.println(
                """
                        Режимы работы:\s
                        1. Вывести телефонный справочник на экран\s
                        2. Добавить запись\s
                        3. Поиск контакта\s
                        4. Удалить запись\s
                        0. Закрыть программу"""
        );
    }

    private static void exer02() {
        String[] fullNames = new String[]{
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"
        };
        List<String> listNames = getName(fullNames);
        Map<String, Integer> mapNames = getMap(listNames);
        System.out.println("Повторяющиеся имена: ");
        duplicateNames(mapNames);
        System.out.println("Отсортированный по популярности список имен: ");
        sortNames(mapNames);
    }

    private static void sortNames(Map<String, Integer> map) {
        Map<String, Integer> sortMap = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> item : list) {
            sortMap.put(item.getKey(), item.getValue());
        }
        for (var item : sortMap.entrySet()) {
            System.out.printf("%s\n", item.getKey());
        }
    }

    private static void duplicateNames(Map<String, Integer> map) {
        for (var item : map.entrySet()) {
            if (item.getValue() > 1) {
                System.out.printf("%s: %d \n", item.getKey(), item.getValue());
            }
        }
    }

    private static Map<String, Integer> getMap(List<String> list) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            String element = list.get(i);
            for (String item : list) {
                if (element.equals(item)) {
                    count++;
                }
            }
            if (!stringIntegerMap.containsKey(element)) {
                stringIntegerMap.put(element, count);
            }
        }
        return stringIntegerMap;
    }

    private static List<String> getName(String[] list) {
        List<String> listNames = new ArrayList<>();
        for (String item : list) {
            String[] listItems = item.split(" ");
            listNames.add(listItems[0]);
        }
        return listNames;
    }
}
