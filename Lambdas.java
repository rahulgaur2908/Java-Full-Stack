import java.util.ArrayList;

// A Functional Interface (Only ONE abstract method)
interface PerformanceBooster {
    void boost(String skill);
}

public class Lambdas {
    public static void main(String[] args) {
        System.out.println("--- Day 21: Evolution to Lambda Expressions ---");

        // 1. The Old Way: Anonymous Inner Class (Verbose and clunky)
        PerformanceBooster oldWay = new PerformanceBooster() {
            @Override
            public void boost(String skill) {
                System.out.println("Old Way: Upgrading " + skill + " with lots of boilerplate code.");
            }
        };
        oldWay.boost("Java Basics");

        System.out.println();

        // 2. The Modern Way: Lambda Expression (Clean, elegant, single-line!)
        PerformanceBooster lambdaWay = (skill) -> System.out.println("Lambda Way: Upgrading " + skill + " instantly!");
        lambdaWay.boost("Functional Programming");

        System.out.println("\n--- Bonus: Using Lambdas to loop through a Collection ---");
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Spring Boot");
        skills.add("React");
        skills.add("SQL");

        // Utilizing modern .forEach with a lambda expression
        skills.forEach(skill -> System.out.println(" Ready to learn: " + skill));
    }
}