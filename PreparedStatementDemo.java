import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        System.out.println("--- Day 26: Secure Query Execution with PreparedStatement ---");

        String url = "jdbc:mysql://localhost:3306/fullstack_db";
        String user = "root";
        String password = "password123";

        // Simulated user inputs (e.g., from an API or web form)
        String userInputEmail = "rahul@example.com";
        String userInputPassword = "' OR '1'='1"; // Classic SQL Injection payload!

        // Parameterized SQL query using '?' placeholders
        String sql = "SELECT id, username FROM users WHERE email = ? AND password = ?";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // Safely binding parameters (prevents SQL Injection completely)
            pstmt.setString(1, userInputEmail);
            pstmt.setString(2, userInputPassword);

            System.out.println(" Executing pre-compiled query safely...");

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Login Successful! Welcome " + rs.getString("username"));
                } else {
                    System.out.println("Login Failed! Security check successfully blocked malicious payload.");
                }
            }

        } catch (Exception e) {
            System.out.println(" Database Error: " + e.getMessage());
        }
    }
}