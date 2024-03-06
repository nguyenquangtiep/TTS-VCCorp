package Ex1;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        int a[] = {1, 2, 3, 4, 5, 6};
        int b[] = {4, 5, 6, 7, 8};

        Object[] arr = intersectArr(a, b);
        for (Object element : arr) {
            System.out.println(element);
        }
    }

    static int binarySearch(int arr[], int key, int begin, int end) {
        int mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (arr[mid] == key) return mid;
            if (key > arr[mid]) begin = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    static Object[] intersectArr(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int found = binarySearch(b, a[i], 0, n-1);
            if (found < 0) continue;
            result.add(a[i]);
        }
        return result.toArray();
    }
}
