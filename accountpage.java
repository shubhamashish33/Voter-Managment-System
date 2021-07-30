
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
