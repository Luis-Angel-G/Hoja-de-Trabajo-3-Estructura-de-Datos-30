import java.util.Arrays;
import java.util.LinkedList;

public class BucketSort<T extends Comparable<T>> implements IGenericSort<T> {
    @Override
    public T[] sort(T[] arr) {
        int n = arr.length;
        if (n <= 0) {
            return arr;
        }

        @SuppressWarnings("unchecked")
        T[] output = (T[]) new Comparable[n];

        @SuppressWarnings("unchecked")
        LinkedList<T>[] buckets = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) ((n - 1) * ((Number) arr[i]).doubleValue());
            buckets[bucketIndex].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            LinkedList<T> bucket = buckets[i];
            insertionSort(bucket);
            for (int j = 0; j < bucket.size(); j++) {
                output[i++] = bucket.get(j);
            }
        }

        return output;
    }

    private void insertionSort(LinkedList<T> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            T key = bucket.get(i);
            int j = i - 1;

            while (j >= 0 && bucket.get(j).compareTo(key) > 0) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        Double[] arr = { 0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434 };
        BucketSort<Double> sorter = new BucketSort<>();
        Double[] sortedArr = sorter.sort(arr);

        System.out.println(Arrays.toString(sortedArr));
    }
}
