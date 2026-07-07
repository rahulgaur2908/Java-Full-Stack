// The Pure Contract Interface.
interface EngineController{
    
    // All methods in a interface are implicitly public and abstract.
    
    void ignitionON();
    void ignitionOFF();
}

// A class implementing the strict contract.
class car implements EngineController{
    private String model;

    public car(String model){
        this.model = model;
    }

    // Must explicitly provide concrete implementations for the interfaces methods.

    @Override
    public void ignitionON(){
        System.out.println("Ignition is ON for " + model);
    }

    @Override
    public void ignitionOFF(){
        System.out.println("Ignition is OFF for " + model);
    }
}

public class Interface{
    public static void main(String args[]){
        System.out.println("Day 14: Interface");

        // Instantiating the class using the Interface type (Polymorphic Assignment).
        EngineController myCar = new car("Skoda Slavia");

        myCar.ignitionON();
        myCar.ignitionOFF();

    }
}
