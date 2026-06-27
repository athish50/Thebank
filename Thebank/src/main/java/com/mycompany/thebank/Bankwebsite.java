package com.mycompany.thebank;
import java.sql.*;
import static spark.Spark.*;
import  spark.Route;
import  spark.Request;
import  spark.Response;        

public class Bankwebsite {

     public void launch(){    
        
         
         
         
         staticFiles.location("/public");
        
        post("/login", new Route() {
      
    @Override
    public Object handle(
        Request req,
        Response res
       
    ) {

        String username  = req.queryParams("uname");
        String password = req.queryParams("password");
         
        Login banklogin = new Login();
         ResultSet result = banklogin.Authenticate(username,password);
        System.out.println(result);
        return  banklogin.Authenticate(username, password);
    }
    });
      
    }   
   
}
