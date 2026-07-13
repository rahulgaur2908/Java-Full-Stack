// 1. Creating the Custom Checked Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptions {

    // 2. Using 'throws' to announce this method can fail if rules are broken
    public static void checkEligibility(int age) throws InvalidAgeException {
        System.out.println("Checking eligibility for age: " + age);
        
        if (age < 18 || age > 120) {
            // Using 'throw' to explicitly fire our custom error
            throw new InvalidAgeException("Access Denied: Age must be between 18 and 120.");
        }
        
        System.out.println("Verification successful. Welcome aboard!");
    }

    public static void main(String[] args) {
        System.out.println("--- Day 19: Executing Custom Exceptions ---");

        // 3. Testing our business logic inside a try-catch block
        try {
            checkEligibility(23);  // This will succeed
            checkEligibility(15);  // This will trigger our custom exception!
            
        } catch (InvalidAgeException e) {
            // Catching our specific custom error cleanly
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
        
        System.out.println("\n System Status: Stable and listening for new inputs.");
    }
}