/*Test para el mergesort para Strings e Integer */

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    private MergeSort<Integer> mergesort;
    private MergeSort<String> mergesortstring;

    @Before
    public void setUp() {
        mergesort = new MergeSort<>();
        mergesortstring = new MergeSort<>();
    }

    @Test
    public void ItShouldOrderTheValuesFromLowestToHighestInt() {
        Integer[] arr = { 0, 2, 7, 4, 8, 1, 3 };
        Integer[] result = { 0, 1, 2, 3, 4, 7, 8 };

        assertArrayEquals(result, mergesort.sort(arr));
    }

    @Test
    public void ItShouldOrderTheStringsInAlphabeticOrder() {
        String[] arr = { "a", "t", "q", "s", "b" };
        String[] result = { "a", "b", "q", "s", "t" };

        assertArrayEquals(result, mergesortstring.sort(arr));
    }

}
