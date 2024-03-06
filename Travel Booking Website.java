import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Trip {
    private String destination;
    private String startDate;
    private String endDate;

    public Trip(String destination, String startDate, String endDate) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDestination() {
        return destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}

class Booking {
    private String customerName;
    private Trip trip;

    public Booking(String customerName, Trip trip) {
        this.customerName = customerName;
        this.trip = trip;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Trip getTrip() {
        return trip;
    }
}

public class TravelBookingSystem {
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Travel Booking System!");

        while (true) {
            System.out.println("\n1. Book a Trip");
            System.out.println("2. View Bookings");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookTrip(scanner);
                    break;
                case 2:
                    viewBookings();
                    break;
                case 3:
                    System.out.println("Thank you for using the Travel Booking System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void bookTrip(Scanner scanner) {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter trip destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter trip start date: ");
        String startDate = scanner.nextLine();
        System.out.print("Enter trip end date: ");
        String endDate = scanner.nextLine();

        Trip trip = new Trip(destination, startDate, endDate);
        Booking booking = new Booking(customerName, trip);
        bookings.add(booking);
        System.out.println("Trip booked successfully!");
    }

    private static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        System.out.println("\nBookings:");
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            System.out.println("Booking " + (i + 1) + ":");
            System.out.println("Customer Name: " + booking.getCustomerName());
            System.out.println("Destination: " + booking.getTrip().getDestination());
            System.out.println("Start Date: " + booking.getTrip().getStartDate());
            System.out.println("End Date: " + booking.getTrip().getEndDate());
            System.out.println();
        }
    }
}
