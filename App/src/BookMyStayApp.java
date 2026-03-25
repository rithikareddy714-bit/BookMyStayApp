import java.util.HashMap;
import java.util.Map;

/**
 * BookMyStayApp
 * Centralized Room Inventory Management System
 */
public class BookMyStayApp {

    /**
     * Inner Class - RoomInventory
     * Handles all room availability logic
     */
    static class RoomInventory {

        // Stores room availability
        private Map<String, Integer> roomAvailability;

        // Constructor
        public RoomInventory() {
            roomAvailability = new HashMap<>();
            initializeInventory();
        }

        // Initialize default values
        private void initializeInventory() {
            roomAvailability.put("Single", 5);
            roomAvailability.put("Double", 3);
            roomAvailability.put("Suite", 2);
        }

        // Get current availability
        public Map<String, Integer> getRoomAvailability() {
            return roomAvailability;
        }

        // Update availability safely
        public void updateAvailability(String roomType, int count) {
            if (roomAvailability.containsKey(roomType)) {
                roomAvailability.put(roomType, count);
            } else {
                System.out.println("Invalid room type!");
            }
        }
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Hotel Room Inventory Status\n");

        // Single Room
        System.out.println("Single Room:");
        System.out.println("Beds: 1");
        System.out.println("Size: 250 sqft");
        System.out.println("Price per night: 1500.0");
        System.out.println("Available Rooms: " + availability.get("Single"));
        System.out.println();

        // Double Room
        System.out.println("Double Room:");
        System.out.println("Beds: 2");
        System.out.println("Size: 400 sqft");
        System.out.println("Price per night: 2500.0");
        System.out.println("Available Rooms: " + availability.get("Double"));
        System.out.println();

        // Suite Room
        System.out.println("Suite Room:");
        System.out.println("Beds: 3");
        System.out.println("Size: 750 sqft");
        System.out.println("Price per night: 5000.0");
        System.out.println("Available Rooms: " + availability.get("Suite"));
    }
}