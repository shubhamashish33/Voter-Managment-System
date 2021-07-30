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
