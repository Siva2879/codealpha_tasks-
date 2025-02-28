import java.util.*;

class Room {
    int roomNumber;
    String category;
    double price;
    boolean isAvailable;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }
}

public class HotelReservationSystem {
    static Map<Integer, Room> rooms = new HashMap<>();
    static Map<Integer, String> bookings = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        
        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> bookRoom();
                case 3 -> viewBookings();
                case 4 -> {
                    System.out.println("Thank you for using the system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void initializeRooms() {
        rooms.put(101, new Room(101, "Standard", 1000));
        rooms.put(102, new Room(102, "Standard", 1000));
        rooms.put(201, new Room(201, "Deluxe", 2000));
        rooms.put(202, new Room(202, "Deluxe", 2000));
        rooms.put(301, new Room(301, "Suite", 5000));
        rooms.put(302, new Room(302, "Suite", 5000));
    }

    static void viewRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms.values()) {
            if (room.isAvailable) {
                System.out.println("Room " + room.roomNumber + " - " + room.category + " - ₹" + room.price);
            }
        }
    }

    static void bookRoom() {
        System.out.print("\nEnter room number to book: ");
        int roomNumber = scanner.nextInt();

        if (!rooms.containsKey(roomNumber)) {
            System.out.println("Invalid room number.");
            return;
        }

        Room room = rooms.get(roomNumber);
        if (!room.isAvailable) {
            System.out.println("Room is already booked.");
            return;
        }

        System.out.print("Enter your name: ");
        scanner.nextLine(); // Consume newline
        String customerName = scanner.nextLine();

        System.out.print("Enter payment amount (₹" + room.price + " required): ");
        double payment = scanner.nextDouble();

        if (payment < room.price) {
            System.out.println("Insufficient payment. Booking failed.");
            return;
        }

        room.isAvailable = false;
        bookings.put(roomNumber, customerName);
        System.out.println("Booking successful for " + customerName + " in Room " + roomNumber + " (" + room.category + ").");
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings yet.");
            return;
        }
        System.out.println("\nBooked Rooms:");
        for (Map.Entry<Integer, String> entry : bookings.entrySet()) {
            System.out.println("Room " + entry.getKey() + " booked by " + entry.getValue());
        }
    }
}
