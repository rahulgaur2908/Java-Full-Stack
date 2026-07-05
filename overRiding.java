// Parent Class.
class vechile{
    String brand;

    public vechile(String brand){
        this.brand = brand;
    }

    public void startEngine(){
        System.out.println("Vechile Engine Started");
    }
}

// Child Class implementing Polymorphism.
class car extends vechile{
    String carModel;

    public car(String brand, String carModel){
        super(brand);
        this.carModel = carModel;
    }

    // OverRiding the parent method to give it a specific form.

    @Override
    public void startEngine(){
        System.out.println("Push-button Start: The " + brand + " " + carModel + " roars to life cleanly!");
    }

    public void displayDetails(){
        System.out.println("Car Model: " + carModel);
    }
}

public class overRiding {
    public static void main(String args[]){
        System.out.println("Day 12: Method OverRiding");

        // Creating a car instance.
        car myCar = new car("Skoda", "Slavia");

        myCar.displayDetails();

        // This executes the CHILD version of the method, not the parent version.
        myCar.startEngine();
    }
}