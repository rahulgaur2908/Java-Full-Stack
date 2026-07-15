import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        System.out.println("--- Day 22: Processing Data with Java Streams ---");

        ArrayList<String> technologyStack = new ArrayList<>();
        technologyStack.add("Java");
        technologyStack.add("Spring Boot");
        technologyStack.add("SQL");
        technologyStack.add("React");
        technologyStack.add("JavaScript");

        System.out.println("Original Stack: " + technologyStack);

        // A clean Stream pipeline: Filter out long names, transform to uppercase, and collect into a new list
        List<String> shortCoreSkills = technologyStack.stream()
                .filter(tech -> tech.length() <= 5)                // 1. Intermediate operation (Filtering)
                .map(String::toUpperCase)                          // 2. Intermediate operation (Transformation)
                .collect(Collectors.toList());                      // 3. Terminal operation (Gathering results)

        System.out.println("\n--- Processed Stream Output ---");
        System.out.println("Core Skills (<= 5 chars, Uppercase): " + shortCoreSkills);
    }
}