// Abstract Parent Class (Cannot be instantiated directly!).

abstract class vehicle{
    String brand;

    public vehicle(String brand){
        this.brand = brand;
    }

    // 1. Regular method (inherited as-is).

    public void displayBrand(){
        System.out.println("Vehicle Brand: " + brand);
    }

    // 2. Abstract method (No Body! Child Classes MUST implement this)
    public abstract void accelerate();
}

// Child Class fulfilling the abstract contract.
class Car extends vehicle{

    public Car(String brand){
        super(brand);
    }

    // Providing the mandatory implementation for the abstract method.
    @Override
    public void accelerate() {
        System.out.println(" The " + brand + " accelerates smoothly down the highway.");
    }
}

public class Abstraction {
    public static void main(String args[]){
        System.out.println("Day 13: Abstraction ");

        // Trying to instantiate the parent directly will throw an error:
        // vehicle myVechile = new vehicle ("Generic"); (--Compile Error--)

        // Instantiating the child class that fulfills the contract.

        Car myCar = new Car("Skoda");
        myCar.displayBrand();
        myCar.accelerate(); // Executes the mandatory implementation.
    }
}