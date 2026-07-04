// Parent Class (Super Class).

class vehicle{
    String brand;
    int year;
     public vehicle(String brand, int year){
        this.brand = brand;
        this.year = year;

     }

     public void startEngine(){
        System.out.println("Engine Started" + brand);

     }
}

// Child Class (Sub class).

class car extends vehicle{
    String modelType;  // Specific to Cars.

    public car(String brand, int year, String modelType){

        // 'super' invokes the parent constructor to set brand and year.
        super(brand, year);
        this.modelType = modelType;
    }

    public void displayDetails(){
        System.out.println("Car Brand: " + brand);
        System.out.println("Car Year: " + year);
        System.out.println("Car Model: " + modelType);
    }
}

public class Inheritance{
    public static void main(String args[]){
        System.out.println("Day 11: Inheritance");

        // Creating an object of the child class.

        car myCar = new car("Skoda", 2026, "Slavia");

        // Calling its own unique method.
        myCar.displayDetails();

        // Calling the inheritated method from the parent class.
        myCar.startEngine();

    }
}