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



public class manageBooks extends javax.swing.JFrame {

   String bookName, author;
    int bookId, quantity;
    
    DefaultTableModel model;
    
    public manageBooks() {
        initComponents();
        setBookDetails();
    }
    
    // to set the book details into table
    public void setBookDetails()
    {
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");
            // Statement pst = con.createStatement();
            PreparedStatement pst = con.prepareStatement("select * from book_details");
             ResultSet rs = pst.executeQuery();
             
             while (rs.next())
             {
                 String book_id = rs.getString("book_id");
                 String bookname = rs.getString("bookname");
                 String author = rs.getString("author");
                 int quantity = rs.getInt("quantity");
                 
                 Object[] obj = {book_id, bookname, author, quantity};
                 model = (DefaultTableModel) bookdeetstable.getModel();
                 model.addRow(obj);
             }
            
        }catch (Exception e){
          e.printStackTrace();
            
        }
         
        
    }
    
        public boolean addBook()
        {
            boolean isAdded = false;
            bookId = Integer.parseInt(txtbookid.getText());
            bookName = txtbookname.getText();
            author = txtauthorname.getText();
            quantity = Integer.parseInt(txtquantity.getText());
            
            try{
                Connection con = DBConnection.getConnection();
                String sql = "insert into book_details values(?,?,?,?)";
                
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1,bookId);
                pst.setString(2,bookName);
                pst.setString(3, author);
                pst.setInt(4, quantity);
                
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
        public boolean updateBook()
        {
             boolean isUpdated = false;
            bookId = Integer.parseInt(txtbookid.getText());
            bookName = txtbookname.getText();
            author = txtauthorname.getText();
            quantity = Integer.parseInt(txtquantity.getText());
            
            try
            {
                
                Connection con = DBConnection.getConnection();
                String sql = "update book_details set bookname = ?, author = ?, quantity = ? where book_id = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,bookName);
                pst.setString(2,author);
                pst.setInt(3,quantity);
                pst.setInt(4, bookId);
                
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
        public boolean deleteBook()
        {
            boolean isDeleted = false;
            bookId = Integer.parseInt(txtbookid.getText());
            
            try
            {
                Connection con = DBConnection.getConnection();
                String sql = "delete from book_details where book_id=?";
                PreparedStatement  pst = con.prepareStatement(sql);
                pst.setInt(1, bookId);
                
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
            DefaultTableModel model = (DefaultTableModel) bookdeetstable.getModel();
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
        txtauthorname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtbookid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        logemail2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        logemail3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtquantity = new javax.swing.JTextField();
        button2 = new java.awt.Button();
        button4 = new java.awt.Button();
        button3 = new java.awt.Button();
        txtbookid1 = new javax.swing.JTextField();
        txtbookname = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookdeetstable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();

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
        setPreferredSize(new java.awt.Dimension(1410, 810));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jLabel5.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter Book ID:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, -1));

        jLabel6.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter Book Name:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtauthorname.setBackground(new java.awt.Color(102, 102, 102));
        txtauthorname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtauthornameFocusLost(evt);
            }
        });
        jPanel1.add(txtauthorname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 300, 30));

        jLabel7.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Book ID:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, -1));

        jLabel8.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter Book Name:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtbookid.setBackground(new java.awt.Color(102, 102, 102));
        txtbookid.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtbookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbookidFocusLost(evt);
            }
        });
        jPanel1.add(txtbookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, -1));

        jLabel9.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Book ID:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, -1));

        jLabel10.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Book Name:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        logemail2.setBackground(new java.awt.Color(102, 102, 102));
        logemail2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                logemail2FocusLost(evt);
            }
        });
        jPanel1.add(logemail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, -1));

        jLabel11.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enter Book ID:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, -1));

        jLabel12.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enter Book Name:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        logemail3.setBackground(new java.awt.Color(102, 102, 102));
        logemail3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                logemail3FocusLost(evt);
            }
        });
        jPanel1.add(logemail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, -1));

        jLabel13.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Author Name:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 130, -1));

        jLabel19.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Quantity:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 130, -1));

        txtquantity.setBackground(new java.awt.Color(102, 102, 102));
        txtquantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtquantityFocusLost(evt);
            }
        });
        jPanel1.add(txtquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 300, -1));

        button2.setBackground(new java.awt.Color(255, 51, 0));
        button2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("Delete");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 90, 30));

        button4.setBackground(new java.awt.Color(255, 51, 0));
        button4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setLabel("Add");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        jPanel1.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 90, 30));

        button3.setBackground(new java.awt.Color(255, 51, 0));
        button3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("Update");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 90, 30));

        txtbookid1.setBackground(new java.awt.Color(102, 102, 102));
        txtbookid1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbookid1FocusLost(evt);
            }
        });
        jPanel1.add(txtbookid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, -1));

        txtbookname.setBackground(new java.awt.Color(102, 102, 102));
        txtbookname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbooknameFocusLost(evt);
            }
        });
        jPanel1.add(txtbookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 300, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, -1, -1));

        jPanel7.setBackground(new java.awt.Color(204, 102, 0));
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

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 0, 60, 40));

        bookdeetstable.setBorder(new javax.swing.border.MatteBorder(null));
        bookdeetstable.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        bookdeetstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ));
        bookdeetstable.setGridColor(new java.awt.Color(0, 102, 102));
        bookdeetstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookdeetstableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bookdeetstable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 590, 230));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, -1));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setText("Manage Books");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, 210, 40));

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

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, 300, 10));

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));

        jTextField1.setBackground(new java.awt.Color(102, 102, 102));
        jTextField1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("X");
        jTextField1.setBorder(null);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 70, 30));

        setSize(new java.awt.Dimension(1410, 810));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        Homepage home = new Homepage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void txtauthornameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtauthornameFocusLost

    }//GEN-LAST:event_txtauthornameFocusLost

    private void txtbookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbookidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookidFocusLost

    private void logemail2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_logemail2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_logemail2FocusLost

    private void logemail3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_logemail3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_logemail3FocusLost

    private void txtquantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtquantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantityFocusLost

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
         if (deleteBook() == true)
        {
            JOptionPane.showMessageDialog(this, "Book Deleted :) ");
            clearTable();
            setBookDetails();
        }else{
            JOptionPane.showMessageDialog(this, "Deletion failed. Please try Again");
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        if (addBook() == true)
        {
            JOptionPane.showMessageDialog(this, "Book Added :) ");
            clearTable();
            setBookDetails();
        }else{
            JOptionPane.showMessageDialog(this, "Book Addition failed. Please try Again");
        }
    }//GEN-LAST:event_button4ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
         if (updateBook() == true)
        {
            JOptionPane.showMessageDialog(this, "Book Updated :) ");
            clearTable();
            setBookDetails();
        }else{
            JOptionPane.showMessageDialog(this, "Book Updation failed. Please try Again");
        }
    }//GEN-LAST:event_button3ActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        
    }//GEN-LAST:event_jPanel7MouseClicked

    private void bookdeetstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookdeetstableMouseClicked
        int rowNo = bookdeetstable.getSelectedRow();
        TableModel model = bookdeetstable.getModel();
        
        txtbookid.setText(model.getValueAt(rowNo, 0).toString());
        txtbookname.setText(model.getValueAt(rowNo,1).toString());
         txtauthorname.setText(model.getValueAt(rowNo,2).toString());
          txtquantity.setText(model.getValueAt(rowNo,3).toString());
        
    }//GEN-LAST:event_bookdeetstableMouseClicked

    private void txtbookid1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbookid1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookid1FocusLost

    private void txtbooknameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbooknameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbooknameFocusLost

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jTextField1MouseClicked

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
            java.util.logging.Logger.getLogger(manageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookdeetstable;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField logemail2;
    private javax.swing.JTextField logemail3;
    private javax.swing.JTextField txtauthorname;
    private javax.swing.JTextField txtbookid;
    private javax.swing.JTextField txtbookid1;
    private javax.swing.JTextField txtbookname;
    private javax.swing.JTextField txtquantity;
    // End of variables declaration//GEN-END:variables
}
