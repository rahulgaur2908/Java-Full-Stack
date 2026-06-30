public class Strings{
    public static void main(String args[]){

        System.out.println("Mastering String Manipulation");

        String baseText = "Java Full Stack Devloper";
        // 1. Cleaning and modifying text.

        String cleanedText = baseText.trim();
        System.out.println("Cleaned: '" + cleanedText + "'");
        System.out.println("Length: " + cleanedText.length());
        System.out.println("Uppercase: " + cleanedText.toUpperCase());

        // 2. Extracting a specific word.

        String coreLanguage = cleanedText.substring(0,4);
        System.out.println("Core Language: " + coreLanguage);

        // 3. The Java String Comparison Trap.

        String str1 = new String("Java");
        String str2 = new String("Java");

        System.out.println("\n Memory Comparison vs Value Comparison");
        System.out.println("Using '==': " + (str1 == str2)); // False (Compares memory locations)
        System.out.println("Using '.equals()' : " + str1.equals(str2)); // True (Compares Actual content)

    }
}