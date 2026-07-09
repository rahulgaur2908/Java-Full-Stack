import java.util.HashSet;

public class HashSetDemo{
    public static void main(String args[]){
        System.out.println("Day 16: HashSet");

        // Initializing a HashSet of project Tags.
        HashSet<String> projectTags = new HashSet<>();

        // 1. Adding unique elements.
        projectTags.add("Java");
        projectTags.add("Backend");
        projectTags.add("SpringBoot");

        System.out.println("Initial Set: " + projectTags);

        // 2. Attempting to add duplicate values.
        System.out.println("\n ---Attempting to add duplicates---");
        boolean isFirstJavaAdded = projectTags.add("Java");      // Already Exists.
        boolean newFrontEndAdded = projectTags.add("Frontend");  // New Elemnt.

        // Printing the boolean returns to see what java did.
        System.out.println("Did Duplicate 'Java' get Added? " + isFirstJavaAdded);
        System.out.println("Did Unique FrontEnd get Added? " + newFrontEndAdded);

        // 4. Printing Finl size and collection contents.
        System.out.println("\n Fial Size: " + projectTags.size());
        System.out.println("Final Size: " + projectTags);

    }
}