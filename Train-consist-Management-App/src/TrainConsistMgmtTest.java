import static org.junit.Assert.*;
import org.junit.Test;

public class TrainConsistMgmtTest {

    @Test
    public void testSearch_BogieFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistMgmt.searchBogie(input, "BG309"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(TrainConsistMgmt.searchBogie(input, "BG999"));
    }

    @Test
    public void testSearch_FirstElementMatch() {
        String[] input = {"BG101","BG205","BG309"};
        assertTrue(TrainConsistMgmt.searchBogie(input, "BG101"));
    }

    @Test
    public void testSearch_LastElementMatch() {
        String[] input = {"BG101","BG205","BG309"};
        assertTrue(TrainConsistMgmt.searchBogie(input, "BG309"));
    }

    @Test
    public void testSearch_SingleElementArray() {
        String[] input = {"BG101"};
        assertTrue(TrainConsistMgmt.searchBogie(input, "BG101"));
    }
}