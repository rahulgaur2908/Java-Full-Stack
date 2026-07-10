import java.util.HashMap;

public class HashDemo{
    public static void main(String[] args) {
        System.out.println("--- Day 17: Mastering Key-Value HashMaps ---");

        // Initializing a HashMap: Key = Integer (ID), Value = String (Current Topic)
        HashMap<Integer, String> developerRegistry = new HashMap<>();

        // 1. Storing data pairs using .put()
        developerRegistry.put(101, "Java Basics");
        developerRegistry.put(102, "OOPs Architecture");
        developerRegistry.put(103, "Collections Framework");

        System.out.println("Initial Registry Map: " + developerRegistry);

        // 2. Demonstrating that Keys must be unique (Overwriting data)
        System.out.println("\n--- Updating Employee ID 101 ---");
        developerRegistry.put(101, "Full Stack Masterclass"); // Key 101 gets updated!
        
        // 3. Instant data retrieval using a key
        int searchId = 101;
        if (developerRegistry.containsKey(searchId)) {
            System.out.println("ID " + searchId + " is currently tracking: " + developerRegistry.get(searchId));
        }

        // 4. Looping through the map keys cleanly
        System.out.println("\n--- Final Active Registry Status ---");
        for (int id : developerRegistry.keySet()) {
            System.out.println("🎯 Developer ID: " + id + " | Milestone: " + developerRegistry.get(id));
        }
    }
}