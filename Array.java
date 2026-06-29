public class Array{
    public static void main(String args[]){
        System.out.println("Initializing and looping through arrays");

        // Declaring and initiallizing a string array of skills.
        String[] fullStackSkills = {"Java Basics", "Variables", "Loops", "Control Flow", "Arrays"};

        System.out.println("Total topics coverd so far: " + fullStackSkills.length + "\n");

        // Using a loop to iterate through array elements using zero-based indexing.
        for (int i = 0; i < fullStackSkills.length; i++){
        System.out.println("Skill Index [" + i + "]: " + fullStackSkills[i]);

    }

    // Simulating the classic rookie mistake.
    //System.out.println(fullStackSkills[6]); //Un-Commenting this will trigger an OutofBoundsException.
}
}

        