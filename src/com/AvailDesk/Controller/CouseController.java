/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AvailDesk.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author ROG STRIX
 */
public class CouseController {
     PreparedStatement pst = null;
    Connection con;
    ResultSet re = null;
    String URL = "jdbc:mysql://localhost:3306/availdesk?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String Uname = "root";
    String Password = "";
    
    public boolean addCourse(String coursename) {
         try
        {
             con = DriverManager.getConnection(URL,Uname,Password);
             String query = "INSERT INTO course(id,name) VALUES (?,?)";
         
             pst = con.prepareStatement(query);
             String id = String.valueOf(System.currentTimeMillis());
      
             pst.setString(1, id);
              pst.setString(2, coursename);
       
              
              
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
        public boolean updateCourse(String id, String name) {
         try
        {
             con = DriverManager.getConnection(URL,Uname,Password);
             String query = "UPDATE `course` SET `name`=? WHERE `id`=?";
         
             pst = con.prepareStatement(query);
             
      
             pst.setString(1, name);
              pst.setString(2, id);
       
              
              
              pst.executeUpdate();
               
               
                   return true;
               
         
               
      
               
             
        }
        catch (Exception ex)
        {
             return true;
        }
}
         public boolean deleteCourse(String id) {
         try
        {
             con = DriverManager.getConnection(URL,Uname,Password);
             String query = "DELETE FROM `course` WHERE `id`=?";
         
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
}
