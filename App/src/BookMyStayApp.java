import java.util.HashMap;
import java.util.Map;

/**
 * BookMyStayApp
 * Use Case 4: Room Search & Availability Check
 */
public class BookMyStayApp {

    /**
     * Room Class (Domain Model)
     */
    static class Room {
        private String type;
        private int beds;
        private int size;
        private double price;

        public Room(String type, int beds, int size, double price) {
            this.type = type;
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        public void displayDetails(int available) {
            System.out.println(type + " Room:");
            System.out.println("Beds: " + beds);
            System.out.println("Size: " + size + " sqft");
            System.out.println("Price per night: " + price);
            System.out.println("Available: " + available);
            System.out.println();
        }
    }

    /**
     * RoomInventory (Read-only access here)
     */
    static class RoomInventory {
        private Map<String, Integer> roomAvailability;

        public RoomInventory() {
            roomAvailability = new HashMap<>();
            initializeInventory();
        }

        private void initializeInventory() {
            roomAvailability.put("Single", 5);
            roomAvailability.put("Double", 3);
            roomAvailability.put("Suite", 2);
        }

        public Map<String, Integer> getRoomAvailability() {
            return roomAvailability;
        }
    }

    /**
     * RoomSearchService (Read-only logic)
     */
    static class RoomSearchService {

        public void searchAvailableRooms(
                RoomInventory inventory,
                Room singleRoom,
                Room doubleRoom,
                Room suiteRoom) {

            Map<String, Integer> availability = inventory.getRoomAvailability();

            System.out.println("Room Search\n");

            // Single Room
            if (availability.get("Single") > 0) {
                singleRoom.displayDetails(availability.get("Single"));
            }

            // Double Room
            if (availability.get("Double") > 0) {
                doubleRoom.displayDetails(availability.get("Double"));
            }

            // Suite Room
            if (availability.get("Suite") > 0) {
                suiteRoom.displayDetails(availability.get("Suite"));
            }
        }
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {

        // Create Inventory
        RoomInventory inventory = new RoomInventory();

        // Create Room Objects
        Room singleRoom = new Room("Single", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double", 2, 400, 2500.0);
        Room suiteRoom = new Room("Suite", 3, 750, 5000.0);

        // Search Service
        RoomSearchService searchService = new RoomSearchService();

        // Perform Search (Read-only)
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}