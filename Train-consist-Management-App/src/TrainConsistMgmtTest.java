import static org.junit.Assert.*;
import org.junit.Test;

public class TrainConsistMgmtTest {

    @Test(expected = IllegalStateException.class)
    public void testSearch_ThrowsExceptionWhenEmpty() {
        String[] input = {};
        TrainConsistMgmt.searchBogie(input, "BG101");
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists() {
        String[] input = {"BG101","BG205"};
        TrainConsistMgmt.searchBogie(input, "BG101"); // should not throw
    }

    @Test
    public void testSearch_BogieFoundAfterValidation() {
        String[] input = {"BG101","BG205","BG309"};
        assertTrue(TrainConsistMgmt.searchBogie(input, "BG205"));
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation() {
        String[] input = {"BG101","BG205","BG309"};
        assertFalse(TrainConsistMgmt.searchBogie(input, "BG999"));
    }

    @Test
    public void testSearch_SingleElementValidCase() {
        String[] input = {"BG101"};
        assertTrue(TrainConsistMgmt.searchBogie(input, "BG101"));
    }
}