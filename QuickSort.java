/*Clase que lleva el quicksort
 * Link de la información acerca del quicksort: https://www.geeksforgeeks.org/quick-sort-algorithm/
 * Complejidad
 *      Best Case: O(nlog(n))
 *      Average Case: O(nlog(n))
 *      Worst Case: O(n^2)
 */

import java.util.Arrays;

/**
 * Implementación del algoritmo de ordenamiento Quick Sort para una lista de
 * elementos genéricos.
 * Este algoritmo utiliza la técnica de divide y vencerás seleccionando un
 * "pivote" para dividir el arreglo
 * en dos subarreglos y luego ordenarlos recursivamente.
 *
 * @param <T> El tipo de los elementos del arreglo, debe ser Comparable.
 */
public class QuickSort<T extends Comparable<T>> implements IGenericSort<T> {

    /**
     * Ordena un arreglo usando el algoritmo Quick Sort.
     * 
     * @param arr El arreglo de elementos a ordenar.
     * @return Un nuevo arreglo con los elementos ordenados.
     */
    @Override
    public T[] sort(T[] arr) {
        // Creamos una copia del arreglo original para no modificarlo.
        T[] copia = arr.clone();
        // Llamamos a quickSort para ordenar el arreglo.
        quickSort(copia, 0, copia.length - 1);
        return copia;
    }

    /**
     * Implementación recursiva del algoritmo Quick Sort.
     * Divide el arreglo en dos subarreglos usando un pivote, y ordena cada
     * subarreglo recursivamente.
     * 
     * @param arr  El arreglo de elementos a ordenar.
     * @param low  El índice más bajo del subarreglo actual.
     * @param high El índice más alto del subarreglo actual.
     */
    private void quickSort(T[] arr, int low, int high) {
        // Si hay más de un elemento, realizamos la partición y ordenamos ambos
        // subarreglos.
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1); // Ordenamos la parte izquierda del pivote.
            quickSort(arr, pivotIndex + 1, high); // Ordenamos la parte derecha del pivote.
        }
    }

    /**
     * Particiona el arreglo en dos subarreglos, colocando los elementos menores que
     * el pivote a la izquierda
     * y los mayores a la derecha. Luego, devuelve el índice final del pivote.
     * 
     * @param arr  El arreglo de elementos a particionar.
     * @param low  El índice más bajo del subarreglo a particionar.
     * @param high El índice más alto del subarreglo a particionar.
     * @return El índice del pivote después de la partición.
     */
    private int partition(T[] arr, int low, int high) {
        // Seleccionamos el último elemento como pivote.
        T pivot = arr[high];
        int i = low - 1;

        // Recorremos el arreglo para ordenar los elementos en relación al pivote.
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j); // Intercambiamos el elemento menor con el de mayor índice.
            }
        }

        // Colocamos el pivote en su posición final.
        swap(arr, i + 1, high);
        return i + 1; // Retornamos el índice final del pivote.
    }

    /**
     * Intercambia dos elementos en el arreglo.
     * 
     * @param arr El arreglo en el que se realizarán los intercambios.
     * @param i   El índice del primer elemento.
     * @param j   El índice del segundo elemento.
     */
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
