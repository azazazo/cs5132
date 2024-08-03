package Lab5.Q1;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        Integer[] numArr = {91, 7, 2, 38, 31, 76, 12, 15, 12, 3};
        System.gc();

        long startTime = System.nanoTime();

        Integer[] resultArr = genericSort(numArr);

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Sorted integer array: " + Arrays.toString(resultArr));
        System.out.println("Time elapsed: " + elapsedTime + " nano seconds\n");
    }

    // State what sorting algorithm the below method implements as a comment
    // DO NOT CHANGE THE FOLLOWING METHOD NAME
    public static <T extends Comparable<? super T>> T[] genericSort(T[] data) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    sorted = false;
                    T temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }
        return data;
    }

}
