package org.yammy.cs;

import java.util.Arrays;

public class quickSort {
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[] {34, 6, 16, 38, 28, 38, 41, 49, 25, 43};
        System.out.println("before : " + Arrays.toString(arr));
        quickSort(0, arr.length - 1);
        System.out.println("after : " + Arrays.toString(arr));
    }

    public static void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(left, right);

        quickSort(left, pivot - 1);
        quickSort(pivot + 1, right);
    }

    public static int partition(int left, int right) {
        int pivot = arr[left]; //pivot을 가장 왼쪽의 원소로 정한다
        int i = left;
        int j = right;

        while (i < j) {
            while (pivot < arr[j]) {
                j--;
            }
            while(i<j && pivot >= arr[i]) {
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }
}
