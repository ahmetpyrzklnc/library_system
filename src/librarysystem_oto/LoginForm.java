package librarysystem_oto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();
    }

    public void Login() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            connection = helper.getConnection();
            String sql = "SELECT * FROM library_systemdb.users where `UserName` = ? and `UserPassword` = ?;";

            statement = connection.prepareStatement(sql);
            statement.setString(1, user_text_name.getText());
            statement.setString(2, user_text_password.getText());

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                HomePageForm home = new HomePageForm();
                home.setVisible(true); // düzenlenecek
                dispose(); // eski pencereyi kapatır 
            } else {
                JOptionPane.showMessageDialog(null, "Kullanıcı Adınız veya Şifreniz Yanlıştır!");
            }
        } catch (Exception exception) {
            helper.showErrorMessage((SQLException) exception);
        } finally {
            statement.close();
            connection.close();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        giris_button = new javax.swing.JButton();
        kayit_button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        user_text = new javax.swing.JTextField();
        sifre_text = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        user_text_name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_Register = new javax.swing.JButton();
        btn_entry = new javax.swing.JButton();
        user_text_password = new javax.swing.JPasswordField();
        checkbox_password = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        giris_button.setBackground(new java.awt.Color(34, 167, 240));
        giris_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        giris_button.setForeground(new java.awt.Color(255, 255, 255));
        giris_button.setText("Giriş Yap");
        giris_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giris_buttonActionPerformed(evt);
            }
        });

        kayit_button.setBackground(new java.awt.Color(242, 38, 19));
        kayit_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kayit_button.setForeground(new java.awt.Color(255, 255, 255));
        kayit_button.setText("Kayıt Ol");
        kayit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kayit_buttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setText("Kullanıcı Adı:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setText("Şifre:");

        user_text.setBackground(new java.awt.Color(108, 122, 137));
        user_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_text.setForeground(new java.awt.Color(228, 241, 254));

        sifre_text.setBackground(new java.awt.Color(108, 122, 137));
        sifre_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sifre_text.setForeground(new java.awt.Color(228, 241, 254));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("KULLANICI GİRİŞİ");

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setText("Kullanıcı Adı:");

        user_text_name.setBackground(new java.awt.Color(108, 122, 137));
        user_text_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_text_name.setForeground(new java.awt.Color(228, 241, 254));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setText("Şifre:");

        btn_Register.setBackground(new java.awt.Color(242, 38, 19));
        btn_Register.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Register.setForeground(new java.awt.Color(255, 255, 255));
        btn_Register.setText("Kayıt Ol");
        btn_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegisterActionPerformed(evt);
            }
        });

        btn_entry.setBackground(new java.awt.Color(34, 167, 240));
        btn_entry.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_entry.setForeground(new java.awt.Color(255, 255, 255));
        btn_entry.setText("Giriş Yap");
        btn_entry.setName(""); // NOI18N
        btn_entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entryActionPerformed(evt);
            }
        });

        user_text_password.setBackground(new java.awt.Color(108, 122, 137));
        user_text_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_text_password.setForeground(new java.awt.Color(228, 241, 254));
        user_text_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_text_passwordActionPerformed(evt);
            }
        });

        checkbox_password.setBackground(new java.awt.Color(108, 122, 137));
        checkbox_password.setForeground(new java.awt.Color(255, 255, 255));
        checkbox_password.setText("Şifreyi Göster");
        checkbox_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(user_text_name)
                        .addGap(250, 250, 250))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(62, 62, 62))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(429, 429, 429))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(user_text_password)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkbox_password, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(btn_entry, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Register, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_text_name)
                .addGap(45, 45, 45)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(user_text_password)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(checkbox_password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btn_entry, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_Register, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem_oto/images/library_books_.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem_oto/images/group_FILL0_wght400_GRAD0_opsz48.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(149, 149, 149)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void giris_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giris_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_giris_buttonActionPerformed

    private void kayit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kayit_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kayit_buttonActionPerformed

    private void btn_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegisterActionPerformed
        RegisterForm register = new RegisterForm();
        register.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_RegisterActionPerformed

    private void btn_entryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entryActionPerformed
        try {
            Login();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btn_entryActionPerformed

    private void checkbox_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_passwordActionPerformed
        if (checkbox_password.isSelected()) {
            user_text_password.setEchoChar((char) 0);
        } else {
            user_text_password.setEchoChar('*');
        }
    }//GEN-LAST:event_checkbox_passwordActionPerformed

    private void user_text_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_text_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_text_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Register;
    private javax.swing.JButton btn_entry;
    private javax.swing.JCheckBox checkbox_password;
    private javax.swing.JButton giris_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton kayit_button;
    private java.awt.Label label1;
    private javax.swing.JPasswordField sifre_text;
    private javax.swing.JTextField user_text;
    private javax.swing.JTextField user_text_name;
    private javax.swing.JPasswordField user_text_password;
    // End of variables declaration//GEN-END:variables
}
