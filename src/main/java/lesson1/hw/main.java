package lesson1.hw;

import java.util.Arrays;

//Задача 1. Задать одномерный массив и найти в нем минимальный и максимальный элементы. - minMax()
// Задача 2. Дан массив nums = [3,2,2,3] и число val = 3. - arrangeArr()
//Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
//Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

public class main {
    public static void main(String[] args) {
//        minMax();
        arrangeArr();
    }
    public static void minMax() {

        int[] arr = {6, 8, 3, 5, 1, 9};

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        System.out.println("Минимальный элемент " + min);
        System.out.println("Максимальный элемент " + max);
    }
    private static void arrangeArr() {
        int[] arr = {3,2,2,3};
        int val = 3;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                if (i != j) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}





