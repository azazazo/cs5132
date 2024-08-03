package Lab5.Q3;

import java.util.Arrays;

public class QuickSortMedian {
    public static void main(String[] args) {
        int[] intArray = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(quickSortMedian(intArray)));
    }

    public static int[] quickSortMedian(int[] intArray) {
        int[] result = intArray;
        quickSortMedian(result, 0, intArray.length - 1);
        return result;
    }

    // Do NOT modify the method name and parameter signature.
    public static void quickSortMedian(int[] intArray, int left, int right) {
        // Complete your code beleft the comment
        // You are free to add any number of auxiliary methods to aid you in the implementation
        if (left < right) {
            int pivotIndex = partition(intArray, left, right);
            quickSortMedian(intArray, left, pivotIndex - 1);
            quickSortMedian(intArray, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = medianOfThree(arr, left, mid, right);
        swap(arr, pivot, right);

        int pivotValue = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    public static int medianOfThree(int[] arr, int a, int b, int c) {
        if (arr[a] > arr[b]) {
            if (arr[a] < arr[c]) {
                return a;
            } else if (arr[b] > arr[c]) {
                return b;
            } else {
                return c;
            }
        } else {
            if (arr[a] > arr[c]) {
                return a;
            } else if (arr[b] < arr[c]) {
                return b;
            } else {
                return c;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
