package DB;



import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {

    static ArrayList<Booking> bookings = new ArrayList<>();
    static String[] availableTimes = {
            "9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM",
            "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM",
            "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM",
            "3:00 PM", "3:30 PM", "4:00 PM"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Car Wash Reservation System ===");
            System.out.println("1. Show Available Times");
            System.out.println("2. Make a Booking");
            System.out.println("3. Show All Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                showAvailableTimes();
            } else if (choice == 2) {
                makeBooking(scanner);
            } else if (choice == 3) {
                showAllBookings();
            } else if (choice == 4) {
                System.out.println("Thank you for using the system!");
                break;
            }
        }

        scanner.close();
    }

    public static void showAvailableTimes() {
        System.out.println("\n--- Available Times ---");
        for (String time : availableTimes) {
            boolean taken = false;
            for (Booking booking : bookings) {
                if (booking.getTime().equals(time)) {
                    taken = true;
                    break;
                }
            }
            if (!taken) System.out.println(time);
        }
        System.out.println("-------------------------");
    }

    public static void makeBooking(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        CarWashService.showServices();
        System.out.print("Choose service (1-4): ");
        int serviceChoice = scanner.nextInt();
        String service = CarWashService.getServiceByNumber(serviceChoice);

        scanner.nextLine();
        System.out.print("Enter car type (Sedan / SUV / Truck): ");
        String carType = scanner.nextLine();

        showAvailableTimes();
        System.out.print("Choose time: ");
        String time = scanner.nextLine();

        if (!isTimeAvailable(time)) {
            System.out.println("❌ This time is already booked. Try another one.");
            return;
        }

        Booking newBooking = new Booking(name, phone, service, carType, time);
        bookings.add(newBooking);

        System.out.println("✔ Booking confirmed!");
        newBooking.printBookingDetails();
    }

    public static boolean isTimeAvailable(String time) {
        for (Booking booking : bookings) {
            if (booking.getTime().equals(time)) {
                return false;
            }
        }
        return true;
    }

    public static void showAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings yet.");
            return;
        }

        System.out.println("\n=== All Bookings ===");
        for (Booking booking : bookings) {
            booking.printBookingDetails();
        }
    }
}
