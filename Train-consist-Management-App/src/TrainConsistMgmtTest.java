import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TrainConsistMgmtTest {

    // Helper method simulating the reduction logic from UC10
    private int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        int total = calculateTotalCapacity(bogies);

        // The total seating capacity equals the capacity of the single bogie
        assertEquals(72, total);
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = calculateTotalCapacity(bogies);

        // Aggregation on an empty bogie list returns the default identity value (0)
        assertEquals(0, total);
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

        int total = calculateTotalCapacity(bogies);

        // Ensures the capacities are correctly extracted and aggregated
        assertEquals(80, total);
    }

    @Test
    public void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        int total = calculateTotalCapacity(bogies);

        // The resulting total reflects every bogie's capacity
        assertEquals(242, total);
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));

        int total = calculateTotalCapacity(bogies);

        assertEquals(96, total);

        // The original list size and contents remain the same after stream processing
        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals("First Class", bogies.get(1).name);
    }
}