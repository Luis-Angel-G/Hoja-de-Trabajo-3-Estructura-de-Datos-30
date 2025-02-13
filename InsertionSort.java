import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> implements IGenericSort<T> {
    @Override
    public T[] sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr = { 3, 1, 4, 1, 5, 9 };
        InsertionSort<Integer> sorter = new InsertionSort<>();
        Integer[] sortedArr = sorter.sort(arr);

        System.out.println(Arrays.toString(sortedArr));
    }
}
