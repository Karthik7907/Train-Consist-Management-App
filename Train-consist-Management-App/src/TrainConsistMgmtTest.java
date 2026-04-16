import static org.junit.Assert.*;
import org.junit.Test;

public class TrainConsistMgmtTest {

    @Test
    public void testBinarySearch_BogieFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistMgmt.binarySearchBogie(input, "BG309"));
    }

    @Test
    public void testBinarySearch_BogieNotFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(TrainConsistMgmt.binarySearchBogie(input, "BG999"));
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistMgmt.binarySearchBogie(input, "BG101"));
    }

    @Test
    public void testBinarySearch_LastElementMatch() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistMgmt.binarySearchBogie(input, "BG550"));
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        String[] input = {"BG101"};
        assertTrue(TrainConsistMgmt.binarySearchBogie(input, "BG101"));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        String[] input = {};
        assertFalse(TrainConsistMgmt.binarySearchBogie(input, "BG101"));
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {
        String[] input = {"BG309","BG101","BG550","BG205","BG412"};
        assertTrue(TrainConsistMgmt.binarySearchBogie(input, "BG205"));
    }
}