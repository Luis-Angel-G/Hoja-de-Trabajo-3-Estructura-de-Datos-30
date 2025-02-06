/* Clase que lleva el merge sort
 * Link información sobre como funciona el merge sort: https://www.geeksforgeeks.org/merge-sort/
 */

import java.util.*;

public class MergeSort<T extends Comparable<T>> implements IGenericSort<T> {

    @Override
    public T[] sort(T[] arr) {
        if (arr.length <= 1)
            return arr;

        int middle = arr.length / 2;
        T[] left = Arrays.copyOfRange(arr, 0, middle);
        T[] right = Arrays.copyOfRange(arr, middle, arr.length);

        sort(left);
        sort(right);

        return merge(left, right);
    }

    private T[] merge(T[] left, T[] right) {
        List<T> tempList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0) {
                tempList.add(left[i++]);
            } else {
                tempList.add(right[j++]);
            }
        }

        while (i < left.length)
            tempList.add(left[i++]);
        while (j < right.length)
            tempList.add(right[j++]);

        return tempList.toArray(Arrays.copyOf(left, tempList.size()));
    }

    public static void main(String[] args) {
        Integer[] arr = { 3, 1, 4, 1, 5, 9 };
        MergeSort<Integer> sorter = new MergeSort<>();
        Integer[] sortedArr = sorter.sort(arr);

        System.out.println(Arrays.toString(sortedArr));
    }
}
