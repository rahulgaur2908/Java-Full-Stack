import java.util.Scanner;
public class WhileLoop {

    public static void main(String args[]){
        System.out.println("Enter a Number: ");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int i = 1;
        
        while(i <= 10){
            System.out.println(value + "x" + i + "=" + value*i);
            i++;
        }


    }
    
}
