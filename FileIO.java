import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) {
        System.out.println("--- Day 20: Testing File Input/Output ---");
        
        String filePath = "journey_log.txt";

        // 1. Writing to a file using Try-with-Resources (Automatically closes the file!)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Milestone Reached: Day 20/100 completed successfully!");
            writer.newLine();
            writer.write("Current Focus: Java Backend & Architecture Foundations.");
            System.out.println("Data successfully written to " + filePath);
            
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }

        // 2. Reading from the exact same file
        System.out.println("\n--- Reading Contents from Disk ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Loop through the file line-by-line until it runs out of text (null)
            while ((line = reader.readLine()) != null) {
                System.out.println(" File Row: " + line);
            }
            
        } catch (IOException e) {
            System.out.println(" Error reading from file: " + e.getMessage());
        }
    }
}