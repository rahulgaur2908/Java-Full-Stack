import java.util.Scanner;

class ConditionalStatement {

    public static void main(String args[]){
        int orignalpass = 1234;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first Number: ");
        int num1 = sc.nextInt();
         System.out.println("Enter second Number: ");
         int num2 = sc.nextInt();

          System.out.println("Which Mathamatical opreation do you want to perform +, -, /, * = " );

          char op = sc.next().charAt(0);
        if(op == '+'){
            int sum = num1 + num2;
            System.out.println(num1 + "+" + num2 + "=" + sum );

        }else if(op == '-'){
            int subtract = num1 - num2;
            System.out.println(num1 + "-" + num2 + "=" + subtract);

        }else if(op == '*'){
            int multiply = num1 * num2;
            System.out.println(num1 + "*" + num2 + "=" + multiply);
            
        }else if(op == '/'){
            int divide = num1 / num2;
            System.out.println(num1 + "/" + num2 + "=" + divide);
        }
    }

}