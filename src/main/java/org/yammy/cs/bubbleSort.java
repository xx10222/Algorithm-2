package org.yammy.cs;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {34, 6, 16, 38, 28, 38, 41, 49, 25, 43};
        System.out.println("before : " + Arrays.toString(arr));
        bubbleSort(arr);
    }

    static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("after : " + Arrays.toString(arr));
    }
}
