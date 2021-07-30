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
