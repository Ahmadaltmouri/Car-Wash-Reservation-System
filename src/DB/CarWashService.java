package DB;



public class CarWashService {

    public static void showServices() {
        System.out.println("\nAvailable Services:");
        System.out.println("1. External Wash");
        System.out.println("2. Internal Wash");
        System.out.println("3. Full Wash");
        System.out.println("4. VIP Wash\n");
    }

    public static String getServiceByNumber(int choice) {
        switch (choice) {
            case 1: return "External Wash";
            case 2: return "Internal Wash";
            case 3: return "Full Wash";
            case 4: return "VIP Wash";
            default: return "Unknown";
        }
    }
}
