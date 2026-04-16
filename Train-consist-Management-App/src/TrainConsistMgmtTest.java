import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class TrainConsistMgmtTest {

    @Test
    public void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort_SingleElementArray() {
        int[] input = {50};
        int[] expected = {50};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};
        bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    // Helper method for sorting
    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}