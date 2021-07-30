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
