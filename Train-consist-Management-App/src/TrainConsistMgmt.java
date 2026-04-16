import java.util.Arrays;

public class TrainConsistMgmt {

    // Binary Search Method (UC19)
    public static boolean binarySearchBogie(String[] bogieIds, String searchKey) {

        // Edge case
        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }

        // Step 1: Sort (important for UC19)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        // Step 2: Binary Search
        while (low <= high) {

            int mid = (low + high) / 2;

            int cmp = bogieIds[mid].compareTo(searchKey);

            if (cmp == 0) {
                return true; // found
            }
            else if (cmp < 0) {
                low = mid + 1; // search right
            }
            else {
                high = mid - 1; // search left
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("UC19 - Binary Search for Bogie ID\n");

        String[] bogieIds = {"BG309","BG101","BG550","BG205","BG412"};

        String searchKey = "BG205";

        boolean result = binarySearchBogie(bogieIds, searchKey);

        if (result) {
            System.out.println("Bogie ID " + searchKey + " FOUND");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT FOUND");
        }

        System.out.println("\nUC19 completed...");
    }
}