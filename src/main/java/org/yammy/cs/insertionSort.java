package org.yammy.cs;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr = {34, 6, 16, 38, 28, 38, 41, 49, 25, 43};
        System.out.println("before : " + Arrays.toString(arr));
        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int temp = arr[index];
            int prev = index - 1;

            while ((prev >= 0) && (arr[prev] > temp)) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = temp;
        }
        System.out.println("after : " + Arrays.toString(arr));
    }
}
