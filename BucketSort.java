import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BucketSort<T extends Comparable<T>> implements IGenericSort<T> {
    @Override
    public T[] sort(T[] arr) {
        int n = arr.length;
        if (n <= 0) return arr;

        @SuppressWarnings("unchecked")
        List<T>[] buckets = new List[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new LinkedList<>();
        }

        // Encontrar el mínimo y máximo
        T min = arr[0], max = arr[0];
        for (T num : arr) {
            if (num.compareTo(min) < 0) min = num;
            if (num.compareTo(max) > 0) max = num;
        }

        // Normalización con conversión explícita (asumiendo Double.parseDouble())
        double minValue = Double.parseDouble(min.toString());
        double maxValue = Double.parseDouble(max.toString());
        double range = maxValue - minValue;

        // Distribuir en buckets
        for (T num : arr) {
            double value = Double.parseDouble(num.toString());
            int bucketIndex = (int) ((value - minValue) / range * (n - 1));
            buckets[bucketIndex].add(num);
        }

        // Ordenar cada bucket e insertarlos en el array final
        int index = 0;
        for (List<T> bucket : buckets) {
            insertionSort(bucket);
            for (T num : bucket) {
                arr[index++] = num;
            }
        }

        return arr;
    }

    private void insertionSort(List<T> bucket) {
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