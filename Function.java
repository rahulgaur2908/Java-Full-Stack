public class Function{

    public static void main(String args[]){
        System.out.println("");


        greetDevloper("Rahul", 100);
        greetDevloper("Karan", 90);
        greetDevloper("Neeraj", 115);
    }

    public static void greetDevloper(String name, int currentDay){
        System.out.println("Hello: " + name + "Progress: Day" + currentDay + "/100");

        if(currentDay >= 100){
            System.out.println("Journey completed.\n");
            
        }else{
            System.out.println("Journey is not completed.\n");
        }
    }

}