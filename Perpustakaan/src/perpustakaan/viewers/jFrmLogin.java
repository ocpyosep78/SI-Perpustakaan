package perpustakaan.viewers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import perpustakaan.controllers.database.cDatabaseConnection;
import perpustakaan.main;
import perpustakaan.models.mBuku;

/**
 *
 * @author ophicxs
 */
public class jFrmLogin extends javax.swing.JInternalFrame {
    private JMenu[] jmenu;
    private JMenuItem selectedmenu;
    
    public jFrmLogin(JMenu[] activatedMenu, JMenuItem selectedMenu) {
        jmenu = activatedMenu;
        selectedmenu = selectedMenu;
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Login Pegawai");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogin)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (!isLoginCorrect(txtUsername.getText(), txtPassword.getText())) {
            JOptionPane.showMessageDialog(null, "Login ada salah", "Informasi", JOptionPane.OK_OPTION);
        } else {
            selectedmenu.setText("Logout");
            for (int i = 0; i < jmenu.length; i++){
                jmenu[i].setEnabled(true);
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private boolean isLoginCorrect(String username, String password){
        boolean isCorrect = false;
        try {
            String query = "SELECT (COUNT(*) > 0) AS result "
                         + "  FROM pegawai "
                         + " WHERE username = ? AND "
                         + "       password = MD5(?)";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setString(1, username);
            command.setString(2, password);
            ResultSet result = command.executeQuery();
            
            while(result.next()){
                System.out.println(result.getString("result"));
                isCorrect = (result.getInt("result") != 0);
                main.username = username;
            }
        } catch (SQLException ex) {
            Logger.getLogger(mBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCorrect;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
