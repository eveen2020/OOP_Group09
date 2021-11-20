/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AvailDesk.Activity;

import com.AvailDesk.Controller.CouseController;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROG STRIX
 */
public class ManageCourseActivity extends javax.swing.JFrame {

    /**
     * Creates new form ManageCourseActivity
     */
     CouseController CouseController = new CouseController();
    public ManageCourseActivity() {
        initComponents();
         
         setBackground(new Color(0, 0, 0, 0));
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/availdesk/images/mainlogo.png")));
       loadCourses();
    }
public void clearTableData()
     {
         DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
         int rowCount = dm.getRowCount();
 
         for (int i = rowCount - 1; i >= 0; i--) {
           dm.removeRow(i);
         }
     }
     public void loadCourses()
     {
         clearTableData();
         Connection con;
         String URL = "jdbc:mysql://localhost:3306/availdesk?zeroDateTimeBehavior=CONVERT_TO_NULL";
         String Uname = "root";
         String Password = "";
         try
        {
             con = DriverManager.getConnection(URL,Uname,Password);
             String query = "SELECT * FROM `course` ORDER BY id ASC";
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(query);
         
              
      
             while(rs.next())
             {
                 String id = rs.getString("id");
                 if(!id.equals("1")){
                     
                 
                 String CourseName = rs.getString("name");
                 String tbData[] = {id,CourseName}; 
                 DefaultTableModel tblmodel = (DefaultTableModel)jTable1.getModel();
                                
                 tblmodel.addRow(tbData);
                 }
             }
             
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
     }
     
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 33)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Manage Course");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 30, 270, 39);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 80, 110, 17);

        jTextField1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(60, 100, 280, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "CourseName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 150, 690, 230);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DELETE");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 100, 80, 30);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("x");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(750, 10, 19, 43);

        jLabel4.setBackground(new java.awt.Color(226, 239, 248));
        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(221, 237, 242));
        jLabel4.setText("Avail Desk");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(710, 440, 62, 15);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<< GO BACK");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 440, 86, 17);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("UPDATE");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 100, 80, 30);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ADD");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(660, 100, 80, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/AvailDesk/Images/bg.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 800, 480);

        setSize(new java.awt.Dimension(801, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
          if(jTable1.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Select any row to delete!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            
        
         DefaultTableModel tblmodel = (DefaultTableModel)jTable1.getModel();
         String id = tblmodel.getValueAt(jTable1.getSelectedRow(), 0).toString();
     
          jTextField1.setText("");
        if(CouseController.deleteCourse(id))
        {
            loadCourses();
             JOptionPane.showMessageDialog(null, "Successfully Course Deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
             JOptionPane.showMessageDialog(null, "Something went wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new AdminMenuActivity().setVisible(true);
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Select any row to update!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            
        
         DefaultTableModel tblmodel = (DefaultTableModel)jTable1.getModel();
         String id = tblmodel.getValueAt(jTable1.getSelectedRow(), 0).toString();
          String cname = jTextField1.getText();
          jTextField1.setText("");
        if(CouseController.updateCourse(id, cname))
        {
            loadCourses();
             JOptionPane.showMessageDialog(null, "Successfully Course Updated!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
             JOptionPane.showMessageDialog(null, "Something went wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if(jTextField1.getText().equals(""))
       {
          JOptionPane.showMessageDialog(null, "Enter a course name", "Error!", JOptionPane.ERROR_MESSAGE); 
       }
       else
       {
        if(CouseController.addCourse(jTextField1.getText()))
        {
            
        jTextField1.setText("");
        loadCourses();
        JOptionPane.showMessageDialog(null, "Successfully Course Added!", "Success!", JOptionPane.INFORMATION_MESSAGE);

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Something went wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
       }
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         DefaultTableModel tblmodel = (DefaultTableModel)jTable1.getModel();
         
         jTextField1.setText(tblmodel.getValueAt(jTable1.getSelectedRow(), 1).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCourseActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCourseActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCourseActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCourseActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCourseActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
