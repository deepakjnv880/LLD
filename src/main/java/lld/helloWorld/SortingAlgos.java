package helloWorld;

import java.util.Arrays;

public final class SortingAlgos {


    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] leftArr = new int[mid - start + 1];
        int[] rightArr = new int[end - mid];
        System.arraycopy(arr, start, leftArr, 0, mid - start + 1);
        System.arraycopy(arr, mid + 1, rightArr, 0, end - mid);

        int i = start, l, r;
        l = r = 0;
        while (l < leftArr.length && r < rightArr.length) {
            arr[i++] = (leftArr[l] <= rightArr[r]) ? leftArr[l++] : rightArr[r++];
        }

        while (l < leftArr.length) {
            arr[i++] = leftArr[l++];
        }

        while (r < rightArr.length) {
            arr[i++] = rightArr[r++];
        }

    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int p = partition(arr, start, end);
        quickSort(arr, start, p - 1);
        quickSort(arr, p + 1, end);
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int good = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, ++good, j);
            }
        }
        swap(arr, ++good, end);
        return good;
    }


    public static void main(String[] args) {
        int[] arr = {90, 192, -98, -1, 0, 23, 12, 2, 12, 100};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{90, 192, -98, -1, 0, 23, 12, 2, 12, 100};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{90, 192, -98, -1, 0, 23, 12, 2, 12, 100};
        System.out.println(Arrays.toString(arr));
    }


}
