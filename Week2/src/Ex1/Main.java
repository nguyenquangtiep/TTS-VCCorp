package Ex1;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 5, 3, 0, 2, 3, 0, 3};
        int[] countSortArr = countingSort(arr);
        for (Integer element: countSortArr) {
            System.out.println(element);
        }
    }

    static int[] countingSort(int arr[]) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i]] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }
        int[] result = new int[n];
        for (int i = n-1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];
        }
        return result;
    }

}
