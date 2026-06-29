import java.util.Scanner;

public class SwitchCase{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an Alphabet: ");
        char value = sc.next().charAt(0);
        switch(value){

            case 'a' : 
                System.out.println("You entered a Vowel");
                break;

            case 'e' :
                System.out.println("You enterd a Vowel");
                break;

            case 'i' :
                System.out.println("You entered a Vowel");
                break;

            case 'o' :
                System.out.println("You entered a Vowel");
                break;

            case 'u' :
                System.out.println("You entered a Vowel");
                break;

            default :
                System.out.println("This is not a Vowel");
                break;
        }
    }
}