// 1. The Blueprint (The class)
class Devloper{
    // Attribute (What the object knows)

    String name;
    String primaryLanguage;
    int daysCoding;

    // Behavior (What the object does)

    void printProfile(){
        System.out.println("Devloper profile created!");
        System.out.println("Name: " + name);
        System.out.println("Language: " + primaryLanguage);
        System.out.println("Streak: " + daysCoding);
    }
}

// 2. The Execution (The object Instance)

public class OOPs{
    public static void main(String args[]){
        System.out.println("Day 8: Learning OOPs");

        // Creating an instance of the Developer class.
        Devloper dev1 = new Devloper();

        // Assigning values to fields.
        dev1.name = "Rahul";
        dev1.primaryLanguage = "JAVA";
        dev1.daysCoding = 8;

        // Invoking the object's behavior.
        dev1.printProfile();
    }
}