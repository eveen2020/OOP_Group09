/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AvailDesk.Controller;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author ROG STRIX
 */
public class IssueController {
    PreparedStatement pst = null;
    Connection con;
    ResultSet re = null;
    String URL = "jdbc:mysql://localhost:3306/availdesk?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String Uname = "root";
    String Password = "";
    
    public boolean addIssue(String firstname,String lastname, String email, String admission, String issue_type, String issue, String course) {
         try
        {
             con = DriverManager.getConnection(URL,Uname,Password);
             String query = "INSERT INTO issues(id,first_name,last_name,email,admission,course,issue_type,issue,assigned_employee,status,issue_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
         
             pst = con.prepareStatement(query);
             String id = String.valueOf(System.currentTimeMillis());
             String assigned_employee = "";
             String status = "PENDING";
            
           Date date= new Date();
         
	 long time = date.getTime();
        
	 Timestamp ts = new Timestamp(time);
             pst.setString(1, id);
              pst.setString(2, firstname);
                 pst.setString(3, lastname);
              pst.setString(4, email);
              pst.setString(5, admission);
               pst.setString(6, course);
              pst.setString(7, issue_type);
              pst.setString(8, issue);
              pst.setString(9, assigned_employee);
              pst.setString(10, status);
               pst.setString(11, ts.toString());
           
              
              
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
             return false;
        }
       
       
    }
     public boolean updateIssue(String id, String firstname,String lastname, String email, String admission, String issue, String course) {
        try
        {
              con = DriverManager.getConnection(URL,Uname,Password);
              String query = "UPDATE `issues` SET `first_name`=?,`last_name`=?,`email`=?,`admission`=?,`course`=?,`issue`=? WHERE `id`=?";
         
              pst = con.prepareStatement(query);
              
              pst.setString(1, firstname);
              pst.setString(2, lastname);
              pst.setString(3, email);    
              pst.setString(4, admission);  
                pst.setString(5, course);  
                  pst.setString(6, issue);  
              pst.setString(7, id);  
              
                 pst.executeUpdate();
               
                   return true;
               
             
        }
        catch (Exception ex)
        {
             return true;
        }
       
       
    }
     
             public boolean deleteIssue(String id) {
         try
        {
             con = DriverManager.getConnection(URL,Uname,Password);
             String query = "DELETE FROM `issues` WHERE `id`=?";
         
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
        public boolean assignEmployee(String eid, String iid) {
        try
        {
              con = DriverManager.getConnection(URL,Uname,Password);
              String query = "UPDATE `issues` SET `assigned_employee`=? WHERE `id`=?";
         
              pst = con.prepareStatement(query);
              
              pst.setString(1, eid);
              pst.setString(2, iid);
             
              
                 pst.executeUpdate();
               
                   return true;
               
             
        }
        catch (Exception ex)
        {
             return true;
        }
        
       
       
    }
         public boolean updateStatus(String id, String status) {
        try
        {
              con = DriverManager.getConnection(URL,Uname,Password);
              String query = "UPDATE `issues` SET `status`=? WHERE `id`=?";
         
              pst = con.prepareStatement(query);
              
              pst.setString(1, status);
              pst.setString(2, id);
             
              
                 pst.executeUpdate();
               
                   return true;
               
             
        }
        catch (Exception ex)
        {
             return true;
        }
         }
     
}
