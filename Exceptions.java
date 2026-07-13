public class Exceptions {
    public static void main(String[] args) {
        System.out.println("--- Day 18: Testing Exception Handling ---");

        int totalScore = 100;
        int activeUsers = 0; // Simulating a scenario that could trigger a crash

        try {
            System.out.println("Attempting to calculate average score per user...");
            
            // This line will throw an ArithmeticException because division by zero is impossible!
            int averageScore = totalScore / activeUsers; 
            
            System.out.println("Average Score: " + averageScore); // This line will be skipped

        } catch (ArithmeticException e) {
            // Intercepting the crash cleanly
            System.out.println("Safe Catch: Cannot divide by zero! activeUsers must be greater than 0.");
            System.out.println("Error details logged: " + e.getMessage());

        } finally {
            // This block executes regardless of success or failure
            System.out.println(" Finally Block executed: Performing application cleanup duties.");
        }

        System.out.println("\nSuccess: The program survived the error and is still running smoothly!");
    }
}