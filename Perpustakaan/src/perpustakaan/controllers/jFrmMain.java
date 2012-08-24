package perpustakaan.controllers;

import javax.swing.JFrame;
import perpustakaan.controllers.database.cDatabaseConnection;
import perpustakaan.models.mBuku;

/**
 *
 * @author ophicxs
 */
public class jFrmMain extends JFrame {
    public jFrmMain() {
        initComponents();
        cDatabaseConnection db = new cDatabaseConnection();
        db.setDbHost("127.0.0.1");
        db.setDbName("perpus");
        db.setDbUsername("hiruka");
        db.setDbPassword("1234");
        System.out.println(db.Open());
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
        jMenu2 = new javax.swing.JMenu();
        jMnBuku = new javax.swing.JMenuItem();
        jMnPegawai = new javax.swing.JMenuItem();
        jMnMember = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
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
        jMenu1.add(jMnLogin);
        jMenu1.add(jSep1);

        jMnKeluar.setText("Keluar");
        jMenu1.add(jMnKeluar);

        jMnBar.add(jMenu1);

        jMenu2.setText("Data");

        jMnBuku.setText("Buku");
        jMnBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnBukuActionPerformed(evt);
            }
        });
        jMenu2.add(jMnBuku);

        jMnPegawai.setText("Pegawai");
        jMenu2.add(jMnPegawai);

        jMnMember.setText("Member");
        jMenu2.add(jMnMember);

        jMnBar.add(jMenu2);

        jMenu3.setText("Transaksi");

        jMnDaftarMember.setText("Pendaftaran Member");
        jMenu3.add(jMnDaftarMember);

        jMnuPeminjamanBuku.setText("Peminjaman Buku");
        jMenu3.add(jMnuPeminjamanBuku);

        jMnPengembalianBuku.setText("Pengembalian Buku");
        jMenu3.add(jMnPengembalianBuku);
        jMenu3.add(jSep2);

        jMnPembayaranDenda.setText("Pembayaran Denda");
        jMenu3.add(jMnPembayaranDenda);

        jMnBar.add(jMenu3);

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
        jFrmBuku fBuku = new jFrmBuku();
        jDeskPane.add(fBuku);
        fBuku.setVisible(true);
    }//GEN-LAST:event_jMnBukuActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>    
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new jFrmMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDeskPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
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
    // End of variables declaration//GEN-END:variables
}
