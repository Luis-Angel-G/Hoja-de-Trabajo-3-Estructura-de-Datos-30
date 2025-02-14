/* Clase que lleva el merge sort
 * Link información sobre como funciona el merge sort: https://www.geeksforgeeks.org/merge-sort/
 * Complejidad del mergesort:
 *      Best Case: O(nlog(n))
 *      Average Case: O(nlog(n))
 *      Worst Case: O(nlog(n))
 */

import java.util.Arrays;

/**
 * Implementación del algoritmo de ordenamiento Merge Sort para una lista de
 * elementos genéricos.
 * Este algoritmo divide recursivamente el arreglo en dos mitades, ordena ambas
 * mitades y luego las fusiona.
 *
 * @param <T> El tipo de los elementos del arreglo, debe ser Comparable.
 */
public class MergeSort<T extends Comparable<T>> implements IGenericSort<T> {

    /**
     * Ordena un arreglo usando el algoritmo Merge Sort.
     * 
     * @param arr El arreglo de elementos a ordenar.
     * @return Un nuevo arreglo con los elementos ordenados.
     */
    @Override
    public T[] sort(T[] arr) {
        // Si el arreglo tiene un solo elemento o está vacío, ya está ordenado.
        if (arr.length <= 1)
            return arr.clone();

        // Encontramos el punto medio del arreglo.
        int middle = arr.length / 2;

        // Creamos dos subarreglos, uno para la izquierda y otro para la derecha.
        T[] left = Arrays.copyOfRange(arr, 0, middle);
        T[] right = Arrays.copyOfRange(arr, middle, arr.length);

        // Ordenamos recursivamente las dos mitades.
        left = sort(left);
        right = sort(right);

        // Fusionamos las dos mitades ordenadas.
        return merge(left, right, arr.clone());
    }

    /**
     * Fusiona dos subarreglos ordenados en un solo arreglo ordenado.
     * 
     * @param left   El subarreglo izquierdo ordenado.
     * @param right  El subarreglo derecho ordenado.
     * @param result El arreglo de resultado donde se almacenará la fusión.
     * @return El arreglo fusionado y ordenado.
     */
    private T[] merge(T[] left, T[] right, T[] result) {
        int i = 0, j = 0, k = 0;

        // Fusionamos los dos subarreglos mientras ambos tengan elementos.
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Si quedan elementos en el subarreglo izquierdo, los copiamos al resultado.
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Si quedan elementos en el subarreglo derecho, los copiamos al resultado.
        while (j < right.length) {
            result[k++] = right[j++];
        }

        // Devolvemos el arreglo fusionado y ordenado.
        return result;
    }
}
