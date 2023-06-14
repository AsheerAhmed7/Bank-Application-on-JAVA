import java.util.*;
//Banking Application
class Bank{
    private String bankname;
    private Customer[] list = new Customer[10];
    public Bank(String name){
        this.bankname=name;
    }
    int n=0;
    Scanner input = new Scanner(System.in);
    public void create(){
        if(n>9){
        System.out.println("You can not make more accounts in this bank");
        }
        else {
     System.out.println("Enter the name of the new customer");
   String name = input.nextLine();
   System.out.println("Create the password for the new customer");
   String pass = input.nextLine();
    System.out.println("Enter the starting balance of the new customer");
 Double balance = input.nextDouble();
     list[n] = new Customer(name,balance,pass);
       n++;
      }
   }
    public int call(){
        int flag=0;
       if(n==0) {
    System.out.println("No account in this bank yet");
    return 0;
       }
     System.out.println("Enter the name of the account");
  String name=input.next();
  input.nextLine();
  System.out.println("Enter the password of the account");
  String pass=input.next();
  String pass1,name1;
  for(int i=0;i<n;i++){
      name1=list[i].getName();
      pass1=list[i].getPass();
      if(name.equals(name1) && pass.equals(pass1)){
          int choice=1;
          flag=1;
    while(choice>=1 && 3>=choice){
     System.out.println("Enter 1 to deposit. 2 to withdraw. 3 to display balance or press any key to exit");
     choice=input.nextInt();
     input.nextLine();
     if(choice==1){
         list[i].deposit();
     }
     else if(choice==2){
         list[i].withdraw();
     }
     else if(choice==3){
         list[i].display();
     }
     
      }
  }
  }
  if(flag==0){
      System.out.println("Invalid Input");
  }
  return 0;
    }
}
class Customer {
    private String name,password;
    private double balance;
    Scanner in = new Scanner(System.in);
    public Customer(String name,double balance,String password){
        this.name=name;
        this.balance=balance;
        this.password=password;
    }
    public void deposit(){
 System.out.println("Enter the amount you want to withdraw");
        int amount = in.nextInt();
        if(amount>=0){
            System.out.println("Successfully deposited");
            balance+=amount;
        }
        else {
            System.out.println("Invalid Input");
            deposit();
        }
    }
    public void withdraw(){
        System.out.println("Enter the amount you want to withdraw");
        int amount = in.nextInt();
        if(balance==0){
            System.out.println("You balance is 0.Deposit some amount");
        }
       else if(amount<=balance && 
        amount>0){
            System.out.println("Successful Transaction");
            balance=balance-amount;
        }
        else {
            System.out.println("Invalid Input");
            withdraw();
        }
    }
    public void display(){
        System.out.println("Current balance is "+balance);
    }
    public String getName(){
        return name;
    }
    public String getPass(){
        return password;
    }
}
class Main {
    public static void main(String[] args) {
    Scanner in1 = new Scanner(System.in);
    Bank[] bank = new Bank[4];
 bank[0] = new Bank("Habib Bank");
 bank[1] = new Bank("UBL Bank");
 bank[2] = new Bank("Meezan Bank");
 bank[3] = new Bank("MCB Bank");
    String[] banklist={"Habib Bank","UBL Bank","Meezan Bank","MCB Bank"};
   System.out.println("List of Banks are ");
    for(int i=0;i<4;i++){
  System.out.println(banklist[i]) ;
    }
    int choice=1;
    while(choice==1 || choice==2){
  int flag=0,j;
  for(int i=0;flag!=1;i++){
      j=0;
 System.out.println("Enter thr name of bank account");
  String name = in1.nextLine();
  for(String n : banklist){
      if(n.equals(name)){
          flag=1;
          if(choice==1){
    System.out.println("WELCOME TO THE "+banklist[j]);
          bank[j].create();
          }
          else if(choice==2){
 System.out.println("WELCOME TO THE "+banklist[j]);
    bank[j].call();
          }
       }
       j++;
    }
    if (flag==0){
        System.out.println("Invalid Input");
    }
  }
  System.out.println("Enter 1 to create bank account and 2 to access an account");
  choice = in1.nextInt();
  in1.nextLine();
    
}
System.out.println("Exit");
    }
}