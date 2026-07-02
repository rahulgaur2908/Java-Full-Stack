class UserAcc{
    // Private variales = hidden data (data hiding)

    private String username;
    private int accountBalance;

    public UserAcc(String username, int initialBalance){
        this.username = username;
        this.accountBalance = initialBalance;
    }

    // Gettre method to safely read the private balance.
    public int getaccountBalance(){
        return this.accountBalance;
    }

    // Setter method actiing as a security gaurd with validation logic.

    public void depositMoney(int amount){
        if(amount > 0){
            this.accountBalance += amount;
            System.out.println("Sucess: Deposited " + amount);
        } else{
            System.out.println("Error: Invalid Deposit Amount(" + amount + ").Operation Blocked");
        }
    }
}       

public class Encapsulation{
    public static void main(String args[]){
        System.out.println("Day 10: Encapsulation");

        UserAcc myAcc = new UserAcc("Rahul", 10000);

        // 1. Attempting direct access would cause a compile error.
        // myAcc.accountBalance = -2000; // Prevents direct tampering!

        // 2. Accessing data safely through encapsulated methods.
        myAcc.depositMoney(10000); // Valid Input.
        myAcc.depositMoney(-1200); // Invalid Input.

        System.out.println("Final safe balance: " + myAcc.getaccountBalance());
   
    }
}
        

 
