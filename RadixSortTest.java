import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class RadixSortTest {
    private RadixSort<Integer> radixSortInteger;

    @Before
    public void setUp() {
        radixSortInteger = new RadixSort<>();
    }

    @Test
    public void testSortIntegers() {
        Integer[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
        Integer[] expected = { 2, 24, 45, 66, 75, 90, 170, 802 };
        assertArrayEquals(expected, radixSortInteger.sort(arr));
    }

    @Test
    public void testSortEmptyArray() {
        Integer[] arr = {};
        Integer[] expected = {};
        assertArrayEquals(expected, radixSortInteger.sort(arr));
    }

    @Test
    public void testSortSingleElementArray() {
        Integer[] arr = { 5 };
        Integer[] expected = { 5 };
        assertArrayEquals(expected, radixSortInteger.sort(arr));
    }

    @Test
    public void testSortAlreadySortedArray() {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        Integer[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, radixSortInteger.sort(arr));
    }

    @Test
    public void testSortReverseSortedArray() {
        Integer[] arr = { 5, 4, 3, 2, 1 };
        Integer[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, radixSortInteger.sort(arr));
    }
}