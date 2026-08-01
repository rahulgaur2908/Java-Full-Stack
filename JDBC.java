import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {
        System.out.println("--- Day 25: Executing Raw JDBC Queries ---");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/fullstack_db";
        String user = "root";
        String password = "password123";

        // Try-with-Resources automatically closes Connection, Statement, and ResultSet
        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, username, current_day FROM users")
        ) {
            System.out.println(" Connected to Database successfully!\n");
            System.out.println("--- Fetching User Records ---");

            // Iterating through the returning SQL rows
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                int day = rs.getInt("current_day");

                System.out.println(" User ID: " + id + " | Name: " + name + " | Progress: Day " + day);
            }

        } catch (Exception e) {
            System.out.println(" Database Connection Error: " + e.getMessage());
        }
    }
}