package org.yammy.cs;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class binarySearch {
    public static int solution(int[] arr, int target) {
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            }
        }
        throw new NoSuchElementException("타켓이 존재하지 않습니다!");
    }
}
