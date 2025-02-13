import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class BucketSortTest {
    private BucketSort<Integer> bucketSortInteger;
    private BucketSort<Double> bucketSortDouble;
    private BucketSort<String> bucketSortString;

    @Before
    public void setUp() {
        bucketSortInteger = new BucketSort<>();
        bucketSortDouble = new BucketSort<>();
        bucketSortString = new BucketSort<>();
    }

    @Test
    public void testSortIntegers() {
        Integer[] arr = { 9, 8, 6, 4, 5, 3, 1 };
        Integer[] expected = { 1, 3, 4, 5, 6, 8, 9 };
        assertArrayEquals(expected, bucketSortInteger.sort(arr));
    }

    @Test
    public void testSortDoubles() {
        Double[] arr = { 0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434 };
        Double[] expected = { 0.1234, 0.3434, 0.565, 0.656, 0.665, 0.897 };
        assertArrayEquals(expected, bucketSortDouble.sort(arr));
    }

    @Test
    public void testSortStrings() {
        String[] arr = { "o", "b", "a", "z", "u" };
        String[] expected = { "a", "b", "o", "u", "z" };
        assertArrayEquals(expected, bucketSortString.sort(arr));
    }
}