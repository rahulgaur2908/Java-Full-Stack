import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transactions {
    public static void main(String[] args) {
        System.out.println("--- Day 27: Database Transactions & Rollback ---");

        String url = "jdbc:mysql://localhost:3306/bank_db";
        String user = "root";
        String password = "password123";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            // 1. Disable Auto-Commit to start a manual transaction
            conn.setAutoCommit(false);

            // Step A: Deduct $100 from Account 1
            PreparedStatement deductStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - 100 WHERE account_id = ?"
            );
            deductStmt.setInt(1, 101);
            deductStmt.executeUpdate();

            // Simulating an unexpected error mid-transaction (e.g., system crash/network issue)
            boolean unexpectedErrorOccurred = true; 
            if (unexpectedErrorOccurred) {
                throw new SQLException("Simulated network failure during transfer!");
            }

            // Step B: Deposit $100 into Account 2
            PreparedStatement depositStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + 100 WHERE account_id = ?"
            );
            depositStmt.setInt(1, 102);
            depositStmt.executeUpdate();

            // 2. Commit transaction ONLY if all steps succeeded!
            conn.commit();
            System.out.println(" Transaction Successful! Funds transferred.");

        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
            if (conn != null) {
                try {
                    // 3. Rollback ALL changes if any step failed!
                    conn.rollback();
                    System.out.println(" Rollback executed! Database restored to previous clean state.");
                } catch (SQLException rollbackEx) {
                    System.out.println("Rollback failed: " + rollbackEx.getMessage());
                }
            }
        }
    }
}