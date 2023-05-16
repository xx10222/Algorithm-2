package org.yammy.cs;

import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {34, 6, 16, 38, 28, 38, 41, 49, 25, 43};
        System.out.println("before : " + Arrays.toString(arr));
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {
        int indexMin, temp;
        for (int i = 0; i < arr.length - 1; i++) {
            indexMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            temp = arr[indexMin];
            arr[indexMin] = arr[i];
            arr[i] = temp;
        }
        System.out.println("after : " + Arrays.toString(arr));
    }
}
