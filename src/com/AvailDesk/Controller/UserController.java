package com.AvailDesk.Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public class UserController {
    
    PreparedStatement pst = null;
    Connection con;
    String URL = "jdbc:mysql://localhost:3306/availdesk?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String Uname = "root";
    String Password = "";

    public boolean checkUserLogin(String name, String password) {
         try
        {
            
             String query = "SELECT * FROM users WHERE username=? AND password=?";
             con = DriverManager.getConnection(URL,Uname,Password);
             pst = con.prepareStatement(query);
             
             pst.setString(1, name);
              pst.setString(2, password);
              
              ResultSet dd = pst.executeQuery();
               if(dd.next())
               {
                   
                return true;
                   
                   
               }
               else
               {
                   return false;
               }
             
        }
        catch (Exception ex)
        {
             return true;
        }
       
       
    }
     public boolean checkUserAdmin(String name, String password) {
         try
        {
            String type = "admin";
             String query = "SELECT * FROM users WHERE username=? AND password=? AND type=?";
             con = DriverManager.getConnection(URL,Uname,Password);
             pst = con.prepareStatement(query);
             pst.setString(1, name);
              pst.setString(2, password);
              pst.setString(3, type);
              ResultSet dd = pst.executeQuery();
               if(dd.next())
               {
                   return true;
               }
               else
               {
                   return false;
               }
             
        }
        catch (Exception ex)
        {
             return true;
        }
       
       
    }
      public boolean addEmployee(String username, String email, String password) {
         try
        {
             con = DriverManager.getConnection(URL,Uname,Password);
             String query = "INSERT INTO users(`id`, `username`, `password`, `email`, `type`, `date`) VALUES (?,?,?,?,?,?)";
         
             pst = con.prepareStatement(query);
             String id = String.valueOf(System.currentTimeMillis());
             String type = "employee";
             
             
           Date date= new Date();
         
	 long time = date.getTime();
        
	 Timestamp ts = new Timestamp(time);
         
             pst.setString(1, id);
              pst.setString(2, username);
                 pst.setString(3, password);
              pst.setString(4, email);
              pst.setString(5, type);
               pst.setString(6, ts.toString());
           
              
              
              int a = pst.executeUpdate();
               if(a>0)
               {
                   return true;
               }
               else
               {
                   return false;
               }
             
        }
        catch (Exception ex)
        {
             return true;
        }
       
       
    }
      public boolean updateEmployee(String id, String username, String email, String password) {
        try
        {
              con = DriverManager.getConnection(URL,Uname,Password);
              String query = "UPDATE `users` SET `username`=?,`password`=?,`email`=? WHERE `id`=?";
         
              pst = con.prepareStatement(query);
              
              pst.setString(1, username);
              pst.setString(2, password);
              pst.setString(3, email);    
              pst.setString(4, id);  
              
              
                 pst.executeUpdate();
               
                   return true;
               
             
        }
        catch (Exception ex)
        {
             return true;
        }
       
       
    }
      
      
       public boolean deleteEmployee(String id) {
         try
        {
             con = DriverManager.getConnection(URL,Uname,Password);
             String query = "DELETE FROM `users` WHERE `id`=?";
         
             pst = con.prepareStatement(query);
             
      
    
              pst.setString(1, id);
       
              
              
              pst.executeUpdate();
               
               
                   return true;
               
         
               
      
               
             
        }
        catch (Exception ex)
        {
             return true;
        }
         }
        public String getId(String username, String password)
       {
       
         
          String id = null;
         try
        {
             con = DriverManager.getConnection(URL,Uname,Password);
             String type = "employee";
             String query = "SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"' AND type='"+type+"'";
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(query);
         
              
            
             while(rs.next())
             {
                 id = rs.getString("id");
                 if(!id.equals("1")){
                     
                 
                
                 
                
                 }
                 else
                 {
               
                 }
             }
             return id;
             
        }
        catch (Exception ex)
        {
            return id;
        }
     }

}
