/*Clase que lleva el quicksort
 * Link de la información acerca del quicksort: https://www.geeksforgeeks.org/quick-sort-algorithm/
 * Complejidad
 *      Best Case: O(nlog(n))
 *      Average Case: O(nlog(n))
 *      Worst Case: O(n^2)
 */

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> implements IGenericSort<T> {
    @Override
    public T[] sort(T[] arr) {
        T[] copia = arr.clone();
        quickSort(copia, 0, copia.length - 1);
        return copia;
    }

    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
