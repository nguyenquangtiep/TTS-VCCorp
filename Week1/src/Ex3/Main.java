package Ex3;

public class Main {

    public static void main(String[] args) {

        int arr[] = {5, 6, 7, 8, 8, 15};

        int key = 8;

        int[] result = indexSearch(arr, key, 0, arr.length - 1);

        for (Integer e : result) {
            System.out.println(e);
        }
    }

    static int firstIndex(int arr[], int key, int begin, int end) {
        int mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (arr[mid] == key) {
                if (mid == begin) return mid;
                if (arr[mid - 1] == key) end = mid - 1;
                else return mid;
            } else if (key > arr[mid]) begin = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    static int lastIndex(int arr[], int key, int begin, int end) {
        int mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (arr[mid] == key) {
                if (mid == end) return mid;
                if (arr[mid + 1] == key) begin = mid + 1;
                else return mid;
            } else if (key > arr[mid]) begin = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    static int[] indexSearch(int arr[], int key, int begin, int end) {
        int firstIndex = firstIndex(arr, key, begin, end);
        int lastIndex = lastIndex(arr, key, begin, end);
        return new int[] {firstIndex, lastIndex};
    }
}
