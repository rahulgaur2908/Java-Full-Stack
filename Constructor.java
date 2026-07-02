class SmartBike{
    String model;
    String color;
    int topSpeed;

    // 1. Parameterized Constructor using 'this' keyword.
    public SmartBike(String model, String color, int topSpeed) {
        this.model = model;    // 'this.model' refers to the instance variable above,  'model' refers to the parameter inside the parantheses.
        this.color = color;    
        this.topSpeed = topSpeed;
    }

    // 2. Constructor Overloading (A secondary opitonwith a default speed)
    public SmartBike(String model, String color){
        this.model = model;
        this.color = color;
        this.topSpeed = 150; // Default fallback speed.

    }
    public void displayDetails(){
        System.out.println("Bike: " +  color + "" + model + "Top Speed: " + topSpeed + "Km/h");

    }
}   

    public class Constructor{
        public static void main(String[] args){
            System.out.println("Day 9: Learning Constructor");

            // Instantiating objects elegantly using constructors in a single line.

            SmartBike premiumBike = new SmartBike("GT 650 Chrome", "Silver", 200);
            SmartBike standardBike = new SmartBike("Classic 350",  "Black", 120);

            premiumBike.displayDetails();
            standardBike.displayDetails();
        }
    }
