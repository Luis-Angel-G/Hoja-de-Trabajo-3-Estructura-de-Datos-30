/* Clase que lleva el merge sort
 * Link información sobre como funciona el merge sort: https://www.geeksforgeeks.org/merge-sort/
 * Complejidad del mergesort:
 *      Best Case: O(nlog(n))
 *      Average Case: O(nlog(n))
 *      Worst Case: O(nlog(n))
 */

import java.util.*;

public class MergeSort<T extends Comparable<T>> implements IGenericSort<T> {

    @Override
    public T[] sort(T[] arr) {
        if (arr.length <= 1)
            return arr.clone();

        int middle = arr.length / 2;
        T[] left = Arrays.copyOfRange(arr, 0, middle);
        T[] right = Arrays.copyOfRange(arr, middle, arr.length);

        left = sort(left);
        right = sort(right);

        return merge(left, right, arr.clone());
    }

    private T[] merge(T[] left, T[] right, T[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = { 3, 1, 4, 1, 5, 9 };
        MergeSort<Integer> sorter = new MergeSort<>();
        Integer[] sortedArr = sorter.sort(arr);

        System.out.println(Arrays.toString(sortedArr));
    }
}
