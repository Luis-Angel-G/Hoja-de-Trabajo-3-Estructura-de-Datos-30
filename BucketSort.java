import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementación del algoritmo de ordenamiento Bucket Sort.
 * 
 * @param <T> Tipo de dato genérico que debe ser comparable.
 */
public class BucketSort<T extends Comparable<T>> implements IGenericSort<T> {

    @Override
    public T[] sort(T[] arr) {
        int n = arr.length;
        if (n <= 0)
            return arr;

        @SuppressWarnings("unchecked")
        List<T>[] buckets = new List[n];

        // Inicialización de buckets
        for (int i = 0; i < n; i++) {
            buckets[i] = new LinkedList<>();
        }

        // Encontrar el mínimo y máximo valor en el array
        T min = arr[0], max = arr[0];
        for (T num : arr) {
            if (num.compareTo(min) < 0)
                min = num;
            if (num.compareTo(max) > 0)
                max = num;
        }

        // Convertir valores a double para normalización
        double minValue = Double.parseDouble(min.toString());
        double maxValue = Double.parseDouble(max.toString());
        double range = maxValue - minValue;

        // Distribuir elementos en los buckets
        for (T num : arr) {
            double value = Double.parseDouble(num.toString());
            int bucketIndex = (int) ((value - minValue) / range * (n - 1));
            buckets[bucketIndex].add(num);
        }

        // Ordenar los elementos dentro de cada bucket e insertarlos en el array final
        int index = 0;
        for (List<T> bucket : buckets) {
            insertionSort(bucket);
            for (T num : bucket) {
                arr[index++] = num;
            }
        }
        return arr;
    }

    /**
     * Ordena una lista utilizando el algoritmo de Insertion Sort.
     * 
     * @param bucket Lista de elementos a ordenar.
     */
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
}
