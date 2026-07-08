import java.util.ArrayList;

public class ArrayListDemo{
    public static void main(String args[]){
        System.out.println("Day 15: Array List");

        // Declaring a type-safe dynamic ArrayList of full-stack skill.
        ArrayList<String> learningPath = new ArrayList();

        // 1. Dynamically adding elements (No pre-defined size needed).
        learningPath.add("Java Syntax");
        learningPath.add("OOPs Pillars");
        learningPath.add("Design Patterns");

        System.out.println("Current Path Size: " + learningPath.size());
        System.out.println("Initial List: " + learningPath);

        // 2. Modifying an elemnt using its index.
        learningPath.set(2, "Collections Framework");  // Replaced index 2.
        System.out.println("\n Updated List: " + learningPath);

        // 3. Checking for specific data inside the collection.
        if(learningPath.contains("OOPs Pillars")){
            System.out.println(" OOPs Pillars milestone verified.");
        }

        // 4. Removing Data Cleanly.
        learningPath.remove("Java Syntax");
        System.out.println("Final list after changes: " + learningPath);
    }
}