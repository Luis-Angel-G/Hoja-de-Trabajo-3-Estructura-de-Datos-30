import java.util.Arrays;

public class RadixSort<T extends Comparable<T>> implements IGenericSort<T> {
    @Override
    public T[] sort(T[] arr) {
        radixSort(arr, arr.length);
        return arr;
    }

    private void radixSort(T[] arr, int n) {
        if (arr.length == 0) {
            return;
        }

        T max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }

        for (int exp = 1; (int) max / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    private void countSort(T[] arr, int n, int exp) {
        T[] output = Arrays.copyOf(arr, n);
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[((int) arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[((int) arr[i] / exp) % 10] - 1] = arr[i];
            count[((int) arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
        RadixSort<Integer> sorter = new RadixSort<>();
        Integer[] sortedArr = sorter.sort(arr);

        System.out.println(Arrays.toString(sortedArr));
    }
}
