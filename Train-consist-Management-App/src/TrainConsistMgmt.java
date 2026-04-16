import java.util.Arrays;

public class TrainConsistMgmt {

    // UC20: Binary Search with Exception Handling
    public static boolean searchBogie(String[] bogieIds, String searchKey) {

        // 🔴 UC20 CHANGE: Fail-fast validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        // Sort (from UC19)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int cmp = bogieIds[mid].compareTo(searchKey);

            if (cmp == 0) {
                return true; // found
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("UC20 - Exception Handling During Search\n");

        String[] bogieIds = {"BG309","BG101","BG550","BG205","BG412"};
        String searchKey = "BG205";

        try {
            boolean result = searchBogie(bogieIds, searchKey);

            if (result) {
                System.out.println("Bogie ID " + searchKey + " FOUND");
            } else {
                System.out.println("Bogie ID " + searchKey + " NOT FOUND");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 completed...");
    }
}