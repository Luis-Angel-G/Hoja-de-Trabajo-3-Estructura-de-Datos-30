import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class InsertionSortTest {
    private InsertionSort<Integer> insertionSortInteger;
    private InsertionSort<Double> insertionSortDouble;
    private InsertionSort<String> insertionSortString;

    @Before
    public void setUp() {
        insertionSortInteger = new InsertionSort<>();
        insertionSortDouble = new InsertionSort<>();
        insertionSortString = new InsertionSort<>();
    }

    @Test
    public void testSortIntegers() {
        Integer[] arr = { 9, 8, 6, 4, 5, 3, 1 };
        Integer[] expected = { 1, 3, 4, 5, 6, 8, 9 };
        assertArrayEquals(expected, insertionSortInteger.sort(arr));
    }

    @Test
    public void testSortDoubles() {
        Double[] arr = { 0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434 };
        Double[] expected = { 0.1234, 0.3434, 0.565, 0.656, 0.665, 0.897 };
        assertArrayEquals(expected, insertionSortDouble.sort(arr));
    }

    @Test
    public void testSortStrings() {
        String[] arr = { "o", "b", "a", "z", "u" };
        String[] expected = { "a", "b", "o", "u", "z" };
        assertArrayEquals(expected, insertionSortString.sort(arr));
    }
}