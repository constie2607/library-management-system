/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import static jframe.DBConnection.con;

/**
 *
 * @author izeko
 */



public class manageStudents extends javax.swing.JFrame {

   String studentName, course, branch;
    int studentId;
    
    DefaultTableModel model;
    
    public manageStudents() {
        initComponents();
        setStudentDetails();
    }
    
    // to set the book details into table
    public void setStudentDetails()
    {
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");
            // Statement pst = con.createStatement();
            PreparedStatement pst = con.prepareStatement("select * from student_details");
             ResultSet rs = pst.executeQuery();
             
             while (rs.next())
             {
                 String studentId = rs.getString("student_id");
                 String studentName = rs.getString("name");
                 String course = rs.getString("course");
                 String branch = rs.getString("branch");
                 
                 Object[] obj = {studentId, studentName, course, branch};
                 model = (DefaultTableModel) studenttbl.getModel();
                 model.addRow(obj);
             }
            
        }catch (Exception e){
          e.printStackTrace();
            
        }
         
        
    }
    
        public boolean addStudent()
        {
            boolean isAdded = false;
            studentId = Integer.parseInt(txtstudentid.getText());
            studentName = txtstudentname.getText();
            course = txtcourse.getText();
            branch = (txtbranch.getText());
            
            try{
                Connection con = DBConnection.getConnection();
                String sql = "insert into student_details values(?,?,?,?)";
                
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1,studentId);
                pst.setString(2,studentName);
                pst.setString(3, course);
                pst.setString(4, branch);
                
                int rowCount = pst.executeUpdate();
                if (rowCount > 0)
                {
                 isAdded = true;   
                }else                    
                {
                    isAdded = false;
                }
                    
                
            }catch (Exception e){
                e.printStackTrace();
            }
            return isAdded ;
            
        }
        
        //update book details
        public boolean updateStudent()
        {
             boolean isUpdated = false;
            studentId = Integer.parseInt(txtstudentid.getText());
            studentName = txtstudentname.getText();
            course = txtcourse.getText();
            branch = (txtbranch.getText());
            
            try
            {
                
                Connection con = DBConnection.getConnection();
                String sql = "update student_details set name = ?, course = ?, branch = ? where student_id = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,studentName);
                pst.setString(2,course);
                pst.setString(3, branch);
                pst.setInt(4, studentId);
                
                int rowCount = pst.executeUpdate();
                if (rowCount >0)
                {
                    isUpdated = true;
                }else
                {
                    isUpdated = false;
                }
                
                
                
            }catch(Exception e)
            {
                 e.printStackTrace(); 
            }
               return isUpdated;
           
        }
        
        //delete book detail
        public boolean deleteStudent()
        {
            boolean isDeleted = false;
            studentId = Integer.parseInt(txtstudentid.getText());
            
            try
            {
                Connection con = DBConnection.getConnection();
                String sql = "delete from student_details where student_id=?";
                PreparedStatement  pst = con.prepareStatement(sql);
                pst.setInt(1, studentId);
                
                int rowCount = pst.executeUpdate();
                if(rowCount > 0)
                {
                    isDeleted = true;
                }else
                {
                    isDeleted=false;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return isDeleted;
        }
        
        //clear table
        public void clearTable()
        {
            DefaultTableModel model = (DefaultTableModel) studenttbl.getModel();
            model.setRowCount(0);
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcourse = new javax.swing.JTextField();
        txtstudentid = new javax.swing.JTextField();
        logemail2 = new javax.swing.JTextField();
        logemail3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtbranch = new javax.swing.JTextField();
        deleteButton = new java.awt.Button();
        addButton = new java.awt.Button();
        updateButton = new java.awt.Button();
        txtbookid1 = new javax.swing.JTextField();
        txtstudentname = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studenttbl = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 102, 0));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 51, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<< Back");
        jLabel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel1ComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jLabel5.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter Student ID:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, -1));

        jLabel6.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter Student Name:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtcourse.setBackground(new java.awt.Color(102, 102, 102));
        txtcourse.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcourseFocusLost(evt);
            }
        });
        jPanel1.add(txtcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 300, 30));

        txtstudentid.setBackground(new java.awt.Color(102, 102, 102));
        txtstudentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtstudentidFocusLost(evt);
            }
        });
        jPanel1.add(txtstudentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, -1));

        logemail2.setBackground(new java.awt.Color(102, 102, 102));
        logemail2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                logemail2FocusLost(evt);
            }
        });
        jPanel1.add(logemail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, -1));

        logemail3.setBackground(new java.awt.Color(102, 102, 102));
        logemail3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                logemail3FocusLost(evt);
            }
        });
        jPanel1.add(logemail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, -1));

        jLabel13.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Course: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 130, -1));

        jLabel19.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Branch: ");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 130, -1));

        txtbranch.setBackground(new java.awt.Color(102, 102, 102));
        txtbranch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbranchFocusLost(evt);
            }
        });
        jPanel1.add(txtbranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 300, 30));

        deleteButton.setBackground(new java.awt.Color(255, 51, 0));
        deleteButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setLabel("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 90, 30));

        addButton.setBackground(new java.awt.Color(255, 51, 0));
        addButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setLabel("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 90, 30));

        updateButton.setBackground(new java.awt.Color(255, 51, 0));
        updateButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setLabel("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 90, 30));

        txtbookid1.setBackground(new java.awt.Color(102, 102, 102));
        txtbookid1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbookid1FocusLost(evt);
            }
        });
        jPanel1.add(txtbookid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, -1));

        txtstudentname.setBackground(new java.awt.Color(102, 102, 102));
        txtstudentname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtstudentnameFocusLost(evt);
            }
        });
        jPanel1.add(txtstudentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 300, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, -1, -1));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 51, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 60, 40));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, -1));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setText("Manage Students");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 240, 40));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 300, 10));

        studenttbl.setBorder(new javax.swing.border.MatteBorder(null));
        studenttbl.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        studenttbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Course", "Branch"
            }
        ));
        studenttbl.setGridColor(new java.awt.Color(0, 102, 102));
        jScrollPane1.setViewportView(studenttbl);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 680, 280));

        setSize(new java.awt.Dimension(1410, 810));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcourseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcourseFocusLost

    }//GEN-LAST:event_txtcourseFocusLost

    private void txtstudentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtstudentidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstudentidFocusLost

    private void logemail2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_logemail2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_logemail2FocusLost

    private void logemail3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_logemail3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_logemail3FocusLost

    private void txtbranchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbranchFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbranchFocusLost

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
         if (deleteStudent() == true)
        {
            JOptionPane.showMessageDialog(this, "Student Deleted :) ");
            clearTable();
            setStudentDetails();
        }else{
            JOptionPane.showMessageDialog(this, "Deletion failed. Please try Again");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (addStudent() == true)
        {
            JOptionPane.showMessageDialog(this, "Student Added :) ");
            clearTable();
            setStudentDetails();
        }else{
            JOptionPane.showMessageDialog(this, "Student Addition failed. Please try Again");
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
         if (updateStudent() == true)
        {
            JOptionPane.showMessageDialog(this, "Student Details Updated :) ");
            clearTable();
            setStudentDetails();
        }else{
            JOptionPane.showMessageDialog(this, "Student update failed. Please try Again");
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void txtbookid1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbookid1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookid1FocusLost

    private void txtstudentnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtstudentnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstudentnameFocusLost

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        Homepage home = new Homepage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jLabel1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel1ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1ComponentHidden

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
            java.util.logging.Logger.getLogger(manageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button addButton;
    private java.awt.Button deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField logemail2;
    private javax.swing.JTextField logemail3;
    private javax.swing.JTable studenttbl;
    private javax.swing.JTextField txtbookid1;
    private javax.swing.JTextField txtbranch;
    private javax.swing.JTextField txtcourse;
    private javax.swing.JTextField txtstudentid;
    private javax.swing.JTextField txtstudentname;
    private java.awt.Button updateButton;
    // End of variables declaration//GEN-END:variables
}
