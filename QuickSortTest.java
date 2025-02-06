
/*JUnit test para QuickSort */
import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
    private QuickSort<Integer> quicksortInteger;
    private QuickSort<String> quicksortString;

    @Before
    public void SetUp() {
        quicksortInteger = new QuickSort<>();
        quicksortString = new QuickSort<>();
    }

    @Test
    public void ItShouldOrderTheValuesFromLowestToHighestInt() {
        Integer[] arr = { 9, 8, 6, 4, 5, 3, 1 };
        Integer[] result = { 1, 3, 4, 5, 6, 8, 9 };

        assertArrayEquals(result, quicksortInteger.sort(arr));
    }

    @Test
    public void ItShouldOrderTheStringsInAlphabeticOrder() {
        String[] arr = { "o", "b", "a", "z", "u" };
        String[] result = { "a", "b", "o", "u", "z" };

        assertArrayEquals(result, quicksortString.sort(arr));
    }
}
