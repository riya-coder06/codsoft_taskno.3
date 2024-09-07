 
 import java.util.Scanner;

 class BankAccount{
     private int balance;
 
     public BankAccount(int initialAmount){
         this.balance = initialAmount;
     }
 
     public int balance(){
         return balance;
     }
 
     public void deposit(int amount){
         if (amount > 0){
             balance += amount;
             System.out.println("Succesfully " + amount +" Rs deposited to your bank" );
         } else {
             System.out.println("Please choose a number above 0 .Invalid entry");
         }
     }
 
     public void withdraw(int amount){
         if (amount > 0 && amount <= balance){
             System.out.println("Succesfully " + amount +" Rs withdraw from your bank");
             balance -= amount;

         } else {
             System.out.println("Insuffucient balance or negative value entered");
         }
     }
 }
 
 class ATM{
 
     private BankAccount account; 
     public ATM(BankAccount account){
         this.account = account;
     }
 
     public void display(){
        System.out.println("Welcome to the ATM Interface ");
         System.out.println("Select Options");
         System.out.println("1. Deposit");
         System.out.println("2. Withdraw");
         System.out.println("3. Check Balance");
         System.out.println("4. Exit");
     }
 
     public void run(){
         Scanner sc = new Scanner(System.in);
         int option;
         do{
             display();
             System.out.println("Choose an option:");
             option = sc.nextInt();
             
             switch (option){
                 case 1:
                     System.out.println("Enter amount to deposit");
                     int depositAmount = sc.nextInt();
                     account.deposit(depositAmount);
                     break;
                 case 2:
                     System.out.println("Enter amount to withdraw");
                     int withdrawAmount = sc.nextInt();
                     account.withdraw(withdrawAmount);
                     break;
                 case 3:
                     System.out.println("Total balance = " + account.balance());
                     break;
                 case 4:
                     System.out.println("Thanks for using Pathak Bank");
                     break;
                 default:
                     System.out.println("Invalid entry!!. Enter only the given options");   
             }
         }while (option != 4);
         sc.close();

     }
 }
 
 public class AtmInterface {
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         BankAccount userAccount = new BankAccount(50000);
         ATM atm = new ATM(userAccount);
         System.out.println("Enter Your PIN");
         String pin = sc.nextLine();
         if (pin.equals("2589")) {

             atm.run();
         } else {
             System.out.println("Wrong pin");
         }
 
        
     }
 }