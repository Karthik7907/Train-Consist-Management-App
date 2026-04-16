public class TrainConsistMgmt {

    // Linear Search Method
    public static boolean searchBogie(String[] bogieIds, String searchKey) {

        for (int i = 0; i < bogieIds.length; i++) {

            if (bogieIds[i].equals(searchKey)) { // correct comparison
                return true; // stop when found
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("UC18 - Linear Search for Bogie ID\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        String searchKey = "BG309"; // change for testing

        boolean result = searchBogie(bogieIds, searchKey);

        if (result) {
            System.out.println("\n\nBogie ID " + searchKey + " FOUND");
        } else {
            System.out.println("\n\nBogie ID " + searchKey + " NOT FOUND");
        }

        System.out.println("\nUC18 search completed ...");
    }
}