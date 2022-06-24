import java.util.Scanner;

public class Account {

    //Class variables

    int balance;
    int previousTransaction;
    String customerName;
    String customerID;
    double interestRate = -0.0185;

    //Class constructor
    Account(String customerName, String customerID){
        this.customerName = customerName;
        this.customerID = customerID;
    }

    //Methods

    //Method for Depositing money
    public void deposit(int amount){
        if(amount != 0){
            this.balance = this.balance + amount;
            this.previousTransaction = amount;
        }

    }

    //Method for withdrawing money
    public void withdraw(int amount){
        if(amount != 0 ){
            this.balance = this.balance - amount;
            this.previousTransaction = -amount; // negative sign because we are taking money out of the account
        }
    }

    // Method showing the previous transaction in the bank account
    public void getPreviousTransaction(){
        if(this.previousTransaction > 0){
            System.out.println("DEPOSITED: " + this.previousTransaction);
        } else if(this.previousTransaction < 0) {
            System.out.println("WITHDRAWN: " + Math.abs(this.previousTransaction));
        } else {
            System.out.println("NO TRANSACTION OCCURRED");
        }
    }

    //Method for calculating interest of current funds after a number of years
    public void calculateInterest(int years){
        double newBalance = (this.balance * this.interestRate * years) + this.balance;
        System.out.println("The current interest rate is " + (100* this.interestRate));
        System.out.println("After " + years + "years, you balance will be: " + newBalance);
    }

    // Method showing the main menu
    public void showMenu(){
        char option = '\0'; //placeholder variable
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME, "+ this.customerName + "!");
        System.out.println("YOUR ID IS: " + this.customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A: check your balance");
        System.out.println("B: Make a deposit");
        System.out.println("C: Make a withdrawal");
        System.out.println("D: View  previous transaction");
        System.out.println("F: Calculate interest");
        System.out.println("F: Exit");

        do {
            System.out.println();
            System.out.println("ENTER AN OPTION: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                //Case 'A' allows the user to check their account balance
                case 'A':
                    System.out.println("===============================================");
                    System.out.println("Balance = £" + this.balance);
                    System.out.println("===============================================");
                    System.out.println();
                    break;
                // Case 'B' allows the user to deposit money into their account using the deposit method
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                //Case 'C' allows the user to withdraw money from their account using withdraw method
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                // Case 'D' allows the user to view their most recent transaction using the previousTransaction method
                case 'D':
                    System.out.println("===============================================");
                    getPreviousTransaction();
                    System.out.println("===============================================");
                    System.out.println();
                    break;
                //Case 'E' calculates the accured interest on the account after a number of years
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                // Case 'F' exits the user from their account
                case 'F':
                    System.out.println("EXITING ACCOUNT....");
                    System.out.println("===============================================");
                    break;
                // The default case lets the user know that they entered an invalid character
                default:
                    System.out.println("ERROR: INVALID OPTION");
                    System.out.println("please enter A, B, C, D, E, F");
                    break;
            }
        }while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }


}
