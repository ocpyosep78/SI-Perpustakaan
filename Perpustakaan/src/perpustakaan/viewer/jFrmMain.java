package perpustakaan.viewer;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;

/**
 *
 * @author ophicxs
 */
public class jFrmMain extends JFrame {
    public jFrmMain() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDeskPane = new javax.swing.JDesktopPane();
        jMnBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMnLogin = new javax.swing.JMenuItem();
        jSep1 = new javax.swing.JPopupMenu.Separator();
        jMnKeluar = new javax.swing.JMenuItem();
        mnData = new javax.swing.JMenu();
        jMnBuku = new javax.swing.JMenuItem();
        jMnPegawai = new javax.swing.JMenuItem();
        jMnMember = new javax.swing.JMenuItem();
        mnTransaksi = new javax.swing.JMenu();
        jMnDaftarMember = new javax.swing.JMenuItem();
        jMnuPeminjamanBuku = new javax.swing.JMenuItem();
        jMnPengembalianBuku = new javax.swing.JMenuItem();
        jSep2 = new javax.swing.JPopupMenu.Separator();
        jMnPembayaranDenda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Perpustakaan");

        jDeskPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setText("File");

        jMnLogin.setText("Login");
        jMnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnLoginActionPerformed(evt);
            }
        });
        jMenu1.add(jMnLogin);
        jMenu1.add(jSep1);

        jMnKeluar.setText("Keluar");
        jMnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnKeluarActionPerformed(evt);
            }
        });
        jMenu1.add(jMnKeluar);

        jMnBar.add(jMenu1);

        mnData.setText("Data");
        mnData.setEnabled(false);

        jMnBuku.setText("Buku");
        jMnBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnBukuActionPerformed(evt);
            }
        });
        mnData.add(jMnBuku);

        jMnPegawai.setText("Pegawai");
        jMnPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnPegawaiActionPerformed(evt);
            }
        });
        mnData.add(jMnPegawai);

        jMnMember.setText("Member");
        mnData.add(jMnMember);

        jMnBar.add(mnData);

        mnTransaksi.setText("Transaksi");
        mnTransaksi.setEnabled(false);

        jMnDaftarMember.setText("Pendaftaran Member");
        mnTransaksi.add(jMnDaftarMember);

        jMnuPeminjamanBuku.setText("Peminjaman Buku");
        mnTransaksi.add(jMnuPeminjamanBuku);

        jMnPengembalianBuku.setText("Pengembalian Buku");
        mnTransaksi.add(jMnPengembalianBuku);
        mnTransaksi.add(jSep2);

        jMnPembayaranDenda.setText("Pembayaran Denda");
        mnTransaksi.add(jMnPembayaranDenda);

        jMnBar.add(mnTransaksi);

        setJMenuBar(jMnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDeskPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDeskPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jMnBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnBukuActionPerformed
        if (!this.isChildExist(jFrmBuku.class.getName())){
            jFrmBuku fBuku = new jFrmBuku();
            jDeskPane.add(fBuku);
            fBuku.setVisible(true);
        }
    }//GEN-LAST:event_jMnBukuActionPerformed

    private void jMnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnLoginActionPerformed
        switch (jMnLogin.getText()){
            case "Login":
                if (!this.isChildExist(jFrmLogin.class.getName())){
                    jFrmLogin fLogin = new jFrmLogin(new JMenu[]{mnData, mnTransaksi}, jMnLogin);
                    jDeskPane.add(fLogin);
                    fLogin.setVisible(true);
                }
                break;
            case "Logout":
                this.closeAllChild();
                mnData.setEnabled(false);
                mnTransaksi.setEnabled(false);
                jMnLogin.setText("Login");
                break;
        }
        
    }//GEN-LAST:event_jMnLoginActionPerformed

    private void jMnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnKeluarActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMnKeluarActionPerformed

    private void jMnPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnPegawaiActionPerformed
        if (!this.isChildExist(jFrmPegawai.class.getName())){
            jFrmPegawai fPegawai = new jFrmPegawai();
            jDeskPane.add(fPegawai);
            fPegawai.setVisible(true);
        }
    }//GEN-LAST:event_jMnPegawaiActionPerformed

    private void closeAllChild(){
        for (int i = 0; i < jDeskPane.getAllFrames().length; i++){
            jDeskPane.getAllFrames()[i].dispose();
        }
    }
    
    private boolean isChildExist(String className){
        boolean result = false;
        
        for (int i = 0; i < jDeskPane.getAllFrames().length; i++){
            if (jDeskPane.getAllFrames()[i].getClass().getName().equals(className)){
                try {
                    result = true;
                    jDeskPane.getAllFrames()[i].setSelected(true);
                    break;
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(jFrmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        
        return result;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDeskPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMnBar;
    private javax.swing.JMenuItem jMnBuku;
    private javax.swing.JMenuItem jMnDaftarMember;
    private javax.swing.JMenuItem jMnKeluar;
    private javax.swing.JMenuItem jMnLogin;
    private javax.swing.JMenuItem jMnMember;
    private javax.swing.JMenuItem jMnPegawai;
    private javax.swing.JMenuItem jMnPembayaranDenda;
    private javax.swing.JMenuItem jMnPengembalianBuku;
    private javax.swing.JMenuItem jMnuPeminjamanBuku;
    private javax.swing.JPopupMenu.Separator jSep1;
    private javax.swing.JPopupMenu.Separator jSep2;
    private javax.swing.JMenu mnData;
    private javax.swing.JMenu mnTransaksi;
    // End of variables declaration//GEN-END:variables
}
