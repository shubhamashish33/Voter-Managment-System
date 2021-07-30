# Voting-Management-System

We have used Java Applet Programming along with Derby Database for the following project

## Installation

You need NetBeans IDE along with some prerequisite knowledge of databases.

Step 1: Install [Netbeans](https://netbeans.apache.org/download/index.html)\
Step 2: You will need JAVA JDK.\
Step 3: You have to connect your database with the Netbeans or use the default DERBY Database.

## Welcome Page Code
This code you have to paste inside button and Don't Forget to change the variable name

```java
private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {                                      
        setVisible(false);
        new Loginform().setVisible(true);
    }                                     

    private void createaccountActionPerformed(java.awt.event.ActionEvent evt) {                                              
        setVisible(false);
        new Login_form().setVisible(true);
    }

```
## Login Page Code

```java
private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                      
        String user = usernametextfield.getText();
        String pass1 = passwordtextfield.getText();
        if(user.trim().equals("admin") && (pass1.trim().equals("12345")))
        {
            JOptionPane.showMessageDialog(null,"Valid User");
            setVisible(false);
            new Menu();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid User");
        }
    }                                     

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        System.exit(0);
    }

```
## Create Account Page Code

```java
Connection con;
    PreparedStatement pst;
    public Login_form() {
        
        try {
            initComponents();
            setVisible(true);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/Project","admins","admins");
            JOptionPane.showMessageDialog(null,"DataBase Connected");
            pst=con.prepareStatement("insert into FIRST_NAME values(?,?,?,?,?)");
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Login_form.class.getName()).log(Level.SEVERE, null, ex);} 
        catch (SQLException ex) {
            Logger.getLogger(Login_form.class.getName()).log(Level.SEVERE, null, ex);}
        
    }
private void signupActionPerformed(java.awt.event.ActionEvent evt) {                                       
        String fname1 = name.getText();
        String lname1 = lname.getText();
        String email1 = email.getText();
        String pass1 = pass.getText();
        String contact1=contact.getText();
        int contact_number=Integer.parseInt(contact1);
        String conpass = confirmpass.getText();
        try{
        if((conpass.trim().equals(pass1)))
        {
            pst.setString(1,fname1);
            pst.setString(2,lname1);
            pst.setString(3,email1);
            pst.setInt(4,contact_number);
            pst.setString(5,pass1);
            int res=pst.executeUpdate();
            if(res>=1)
            {
            JOptionPane.showMessageDialog(null,"Account Created Successfully");
            setVisible(false);
            new Menu().setVisible(true);
             }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid Password");
        }
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

```
## Menu Page Code

```java
private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        System.exit(0);
    }                                    

    private void createaccountActionPerformed(java.awt.event.ActionEvent evt) {                                              
        setVisible(false);
        new Login_form().setVisible(true);
    }                                             

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                      
        setVisible(false);
        new Loginform().setVisible(true);
    }                                     

private void adddetailActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        setVisible(false);
        new insert().setVisible(true);
    }                                         

    private void searchdetailActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        setVisible(false);
        new search().setVisible(true);
    }                                            

    private void editdetailActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        setVisible(false);
        new edit().setVisible(true);
    }


```
## Insert Page Code

```java
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class insert extends javax.swing.JFrame {
Connection con9;
    PreparedStatement pst9;
    public insert() {
        try {
            initComponents();
            setVisible(true);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con9=DriverManager.getConnection("jdbc:derby://localhost:1527/Project","admins","admins");
            JOptionPane.showMessageDialog(null,"DataBase Connected");
            pst9=con9.prepareStatement("insert into voter_list values(?,?,?,?,?)");
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);} 
        catch (SQLException ex) {
            Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);}
    }
private void insertActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        String voterid1 = voteridtext.getText();
        String name1 = nametext.getText();
        String address1 = addresstext.getText();
        String age1 = agetext.getText();
        String pincode1 = pincodetext.getText();
        try{
            pst9.setString(1,voterid1);
            pst9.setString(2,name1);
            pst9.setString(3,address1);
            pst9.setString(4,age1);
            pst9.setString(5,pincode1);
            int res9=pst9.executeUpdate();
            if(res9>=1)
            {
            JOptionPane.showMessageDialog(null,"Data Added Successfully");
            setVisible(false);
            new Menu().setVisible(true);
             }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }


```
## Show, Update, Remove Records

```java
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
public class edit extends javax.swing.JFrame {
Connection con;
    PreparedStatement pst1,pst2,pst3,pst4;
    DefaultTableModel dtm;
    ResultSet rs;
    public edit() {
        try {
            initComponents();
            setVisible(true);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/Project","admins","admins");
            JOptionPane.showMessageDialog(null,"DataBase Connected");
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Login_form.class.getName()).log(Level.SEVERE, null, ex);} 
        catch (SQLException ex) {
            Logger.getLogger(Login_form.class.getName()).log(Level.SEVERE, null, ex);}
    }
private void searchActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        try{
            pst2=con.prepareStatement("select * from voter_list",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=pst2.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            String colname[]=new String[cols];
            for(int i=1;i<=cols;i++){
            colname[i-1]=rsmd.getColumnName(i);}
            int rows=0;
            while(rs.next()){
                rows++;
            }
            String data[][]=new String[rows][cols];
            rs.beforeFirst();
            rows=0;
            while(rs.next()){
                for(int i=1;i<=cols;i++)
                {
                    data[rows][i-1]=rs.getString(i);
                }
                rows++;
                DefaultTableModel dtm = new DefaultTableModel(data,colname);
                tb1.setModel(dtm);
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());}
    }                                      

    private void editActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        int i=tb1.getSelectedRow();
        try{
            dtm=(DefaultTableModel)tb1.getModel();
            pst1=con.prepareStatement("update voter_list set name=?, address=?, age=?, pincode=? where voterid=?");
            pst1.setString(1,name_text.getText());
            pst1.setString(2,address.getText());
            pst1.setString(3,age.getText());
            pst1.setString(4,pincode.getText());
            pst1.setString(5,voter_id.getText());
            int r1=pst1.executeUpdate();
            if(r1>=1){
              JOptionPane.showMessageDialog(this,"Updated Successfully");}
        }
        catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
                e.printStackTrace();}
    }                                    

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        int i=tb1.getSelectedRow();
        try{
            int r;
            dtm=(DefaultTableModel)tb1.getModel();
            r = Integer.parseInt(dtm.getValueAt(i,0).toString());
            pst3=con.prepareStatement("delete from voter_list where voterid='"+r+"'");
            voter_id.setText(dtm.getValueAt(i,0).toString());
            name_text.setText(dtm.getValueAt(i,1).toString());
            address.setText(dtm.getValueAt(i,2).toString());
            age.setText(dtm.getValueAt(i,3).toString());
            pincode.setText(dtm.getValueAt(i,4).toString());
            int re=pst3.executeUpdate();
            if(re>=1){
            JOptionPane.showConfirmDialog(null,"Do You really want to DELETE?","Confirmation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null,"Item Deleted");
            dtm.removeRow(i);
            voter_id.setText("");
            name_text.setText("");
            address.setText("");
            age.setText("");
            pincode.setText("");
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }                                      

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {                                 
        // TODO add your handling code here:
        int i=tb1.getSelectedRow();
        try{
            dtm=(DefaultTableModel)tb1.getModel();
            pst4=con.prepareStatement("select * from voter_list where voterid=?");
            pst4.setString(1,voter_id.getText());
            voter_id.setText(dtm.getValueAt(i,0).toString());
            name_text.setText(dtm.getValueAt(i,1).toString());
            address.setText(dtm.getValueAt(i,2).toString());
            age.setText(dtm.getValueAt(i,3).toString());
            pincode.setText(dtm.getValueAt(i,4).toString());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());}
    }


```
## Search Records Code

```java
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class search extends javax.swing.JFrame {
Connection con;
    PreparedStatement pst;
    DefaultTableModel dtm;
    ResultSet rs;
    
    public search() {
        initComponents();
        setVisible(true);
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
           con=DriverManager.getConnection("jdbc:derby://localhost:1527/Project","admins","admins");
        JOptionPane.showMessageDialog(null,"DataBase Connected");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Error in Connection");
        }
    }
private void searchActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        try
        {
            if(voterid.isSelected())
            {
                name.setEnabled(false);
                age.setEnabled(false);
                pst=con.prepareStatement("select * from voter where voterid=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                
                pst.setString(1,voter1.getText());
                rs=pst.executeQuery();
               dtm = (DefaultTableModel) table.getModel();  
                dtm.setRowCount(0);
                while(rs.next())
                {
                    Object[] row = {rs.getString("voterid"),rs.getString("name"),rs.getString("address"),rs.getString("age"),rs.getString("pincode")};
                    dtm.addRow(row);
                }
            }
            if(name.isSelected())
            {
                voterid.setEnabled(false);
                age.setEnabled(false);
                pst=con.prepareStatement("select * from voter where name=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                pst.setString(1,name1.getText());
                rs=pst.executeQuery();
                dtm=(DefaultTableModel)table.getModel();
                dtm.setRowCount(0);
                while(rs.next())
                {
                     Object[] row = {rs.getString("voterid"),rs.getString("name"),rs.getString("address"),rs.getString("age"),rs.getString("pincode")};
                    dtm.addRow(row);
                }
            }
            if(age.isSelected())
            {
                voterid.setEnabled(false);
                name.setEnabled(false);
                pst=con.prepareStatement("select * from voter where age=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                pst.setString(1,age1.getText());
                rs=pst.executeQuery();
                dtm=(DefaultTableModel)table.getModel();
                dtm.setRowCount(0);
                while(rs.next())
                {
                    Object[] row = {rs.getString("voterid"),rs.getString("name"),rs.getString("address"),rs.getString("age"),rs.getString("pincode")};
                    dtm.addRow(row);
                }
            }    
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        }
        
    }                                      

    private void backActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        setVisible(false);
        new Menu().setVisible(true);
    }


```


## Other Info
For more information about the snapshot and code. I've also attached a [documentation](https://drive.google.com/file/d/1gsiGV301SFHcj4vvEZdFPit_3XyT1cz0/view?usp=sharing)
