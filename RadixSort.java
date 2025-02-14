import java.util.Arrays;

public class RadixSort<T extends Comparable<T>> implements IGenericSort<T> {
    @Override
    public T[] sort(T[] arr) {
        if (arr.length == 0)
            return arr;

        int n = arr.length;
        T max = findMax(arr);

        for (int exp = 1; Integer.parseInt(max.toString()) / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }

        return arr;
    }

    private T findMax(T[] arr) {
        T max = arr[0];
        for (T num : arr) {
            if (num.compareTo(max) > 0) {
                max = num;
            }
        }
        return max;
    }

    private void countSort(T[] arr, int n, int exp) {
        T[] output = Arrays.copyOf(arr, n);
        int[] count = new int[10];

        for (T num : arr) {
            int index = (Integer.parseInt(num.toString()) / exp) % 10;
            count[index]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = (Integer.parseInt(arr[i].toString()) / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

}