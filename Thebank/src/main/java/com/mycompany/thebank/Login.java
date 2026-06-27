
package com.mycompany.thebank;
import java.sql.*;
import java.util.Scanner;

public class Login {
    public ResultSet Authenticate(String user, String passkey){
              
          ResultSet result =null;
         boolean statusofaction = false;
             

               
              

        
        DBConnector connector = new DBConnector();
      Connection conn = connector.getConnection();
    
      String query ="SELECT * FROM ACCOUNTS " +
                    "WHERE USERNAME = ? " +
                    "AND PASSKEY = ? ";
      
      
    try{  
     PreparedStatement ps = conn.prepareStatement(query);
      
     ps.setString(1, user);
     ps.setString(2, passkey);
    
     result = ps.executeQuery();
    
     
     // for debugging purposes
      if(result.next()){
         statusofaction = true;
      }
     
       System.out.println("|your name :           " + result.getString("CUSTOMER_NAME"));
       System.out.println("|your account type :   " + result.getString("ACCOUNT_TYPE"));
       System.out.println("|Balance :             " + result.getInt("BALANCE"));
       System.out.println("|Type of currency :    " + result.getString("CURRENCY_CODE"));
       System.out.println("|Status :              " + result.getString("STATUS"));
       System.out.println("|your UserID :         " + result.getString("USERNAME"));
       
    }catch(Exception e){ 
        e.printStackTrace();
  

      System.out.println("An internal error might have occurred");
    }
      

      return result;
    }
}


