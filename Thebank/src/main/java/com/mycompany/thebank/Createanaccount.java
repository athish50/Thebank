
package com.mycompany.thebank ;
import java.sql.*;
import java.util.Scanner;

public class Createanaccount {
   
    
    public void createaccount( ){

       
       
    System.out.println("Alright you chose to create an account in our bank great choice");
    System.out.println("So know just type in your details");
   
     DBConnector connector = new DBConnector();
     
     Connection connection =  connector.getConnection();
                 
               Scanner input = new Scanner(System.in);
                 
                  // acc num
               System.out.println("Enter your account number (not more than 20 characters) ");
               String accountNum = input.nextLine();
               //name
               System.out.println("Enter your name");
               String name = input.nextLine();
               //username
               System.out.println("Enter your Username");
               String userName = input.nextLine();
               
                //passkey
               System.out.println("Enter your password");
               String passKey =input.nextLine();
               
               System.out.println("Enter your balance");
               int balance = input.nextInt();
               if(0 > balance){
                   System.out.println("Please enter 0 or your official balance no negative values ");
                     balance = input.nextInt();
               }
               input.nextLine();
               
                //acc type -> we should later on change this to "switch case" cleaner(after testing)
               System.out.println("Enter your account type options -> |savings|current|fixed|");
               String accType = input.nextLine();
               accType = accType.toUpperCase();
               Accountype accounType ;
               accounType = null;
               
               
               if(accType.equals("SAVINGS")){
                   
                   accounType = Accountype.SAVINGS;
               
               }else if(accType.equals("CHECKING")){
                   
                   accounType =Accountype.CHECKING;
               
               }else if(accType.equals("FIXED")){
                  
                   accounType = Accountype.FIXED;
               
               }else if(!accType.equals("SAVINGS")&&!accType.equals("CHECKING")&& accType.equals("FIXED")){
                   System.out.println("Your status didnt match our given input options");
               }
               
               //account status -> we should later on change this to "switch case" cleaner(after testing)
               System.out.println("tell us what your account status should be -> |active|frozen|closed|");
               String account_status = input.nextLine();
               account_status = account_status.toUpperCase();
               Status status;
               status = null;
               if(account_status.equals("ACTIVE")){
                   
                    status = Status.ACTIVE;
                   
               }else if(account_status.equals("CLOSED")){
                   
                   status = Status.CLOSED;
                   
               }else if(account_status.equals("FROZEN")){
                   
                   status = Status.FROZEN;
                   
               }else if(!status.equals("FROZEN")&&!status.equals("ACTIVE")&&!status.equals("CLOSED")){
                   System.out.println("your input didnt match our given option");
               }
               //currency code
               System.out.println("Type of currency in 3 charcters (currency code Example : INR)");
               String currencyCode = input.nextLine();
               currencyCode = currencyCode.toUpperCase();
     
     String query ="INSERT INTO ACCOUNTS (ACCOUNT_NUMBER,CUSTOMER_NAME,ACCOUNT_TYPE,BALANCE,CURRENCY_CODE,STATUS,USERNAME,PASSKEY)"+
                   "VALUES(?,?,?,?,?,?,?,?)";
     
    try{
     PreparedStatement prepdstatmt = connection.prepareStatement(query);
    
    
       prepdstatmt.setString(1,accountNum);
       prepdstatmt.setString(2,name);
       prepdstatmt.setString(3,accounType.name());
       prepdstatmt.setInt(4,balance);
       prepdstatmt.setString(5,currencyCode);
       prepdstatmt.setString(6,status.name());
       prepdstatmt.setString(7,userName);
       prepdstatmt.setString(8,passKey);
    
       prepdstatmt.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
        System.out.println("your data might have been wrong or an internal error might have occurred from our side");
        
    }   
    }
}
