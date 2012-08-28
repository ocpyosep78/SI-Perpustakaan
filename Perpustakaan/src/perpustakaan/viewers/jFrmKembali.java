/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.viewers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import perpustakaan.controllers.database.cDatabaseConnection;
import perpustakaan.controllers.utils.cUtils;
import perpustakaan.main;
import perpustakaan.models.mBuku;
import perpustakaan.models.mTransaksi;
import perpustakaan.models.mTransaksiDetil;
import perpustakaan.viewers.pop.jFrmPopBuku;

/**
 *
 * @author ophicxs
 */
public class jFrmKembali extends javax.swing.JInternalFrame {
    private java.util.Date today = new java.util.Date();
    private Date skg = new Date(today.getTime());
    
    public jFrmKembali() {
        initComponents();
        String[] column = new String[]{"Kode Buku", "Judul Buku", "Harga Sewa", "Status"};
        cUtils.TabCreateColumn(jTabDetil, column);
        txtTglKembali.setText(skg.toString());
        //<editor-fold defaultstate="collapsed" desc="Create Listener Kode Buku">
        txtKodeBuku.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (txtKodeBuku.getText().length()>0){
                    fillCurrentPeminjamanDetil(txtKodeBuku.getText());
                }
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtKodeBuku.getText().length()>0){
                    fillCurrentPeminjamanDetil(txtKodeBuku.getText());
                }
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                if (txtKodeBuku.getText().length()>0){
                    fillCurrentPeminjamanDetil(txtKodeBuku.getText());
                }
            }
        });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Create Listener JTabDetil">
        jTabDetil.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jTabDetil.getSelectedRow()>-1){
                    btnKembali.setEnabled(true);
                } else  {
                    btnKembali.setEnabled(false);
                }
            }
        });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Create Listener NoPeminjaman">
        txtNoPinjam.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (txtNoPinjam.getText().length()>0){ btnProses.setEnabled(true); lblDenda.setText("Denda : 0"); } else { btnProses.setEnabled(false); }
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtNoPinjam.getText().length()>0){ btnProses.setEnabled(true); lblDenda.setText("Denda : 0"); } else { btnProses.setEnabled(false); }
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                if (txtNoPinjam.getText().length()>0){ btnProses.setEnabled(true); lblDenda.setText("Denda : 0"); } else { btnProses.setEnabled(false); }
            }
        });
        //</editor-fold>
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtKodeBuku = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNoPinjam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTglPinjam = new javax.swing.JTextField();
        txtTglBatas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTglKembali = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabDetil = new javax.swing.JTable();
        lblDenda = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtJudulBuku = new javax.swing.JTextField();
        btnProses = new javax.swing.JButton();

        setClosable(true);
        setTitle("Transaksi Pengembalian");

        jLabel1.setText("Kode Buku");

        txtKodeBuku.setEditable(false);

        btnBrowse.setText("...");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Peminjaman"));

        jLabel2.setText("No. Peminjaman");

        txtNoPinjam.setEditable(false);
        txtNoPinjam.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("Tgl. Pinjam");

        txtTglPinjam.setEditable(false);

        txtTglBatas.setEditable(false);

        jLabel4.setText("Tgl. batas");

        jLabel5.setText("Tgl. Kembali");

        txtTglKembali.setEditable(false);

        jTabDetil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTabDetil);

        lblDenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDenda.setText("Denda : 0");

        btnKembali.setText("Kembali");
        btnKembali.setEnabled(false);
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTglBatas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNoPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDenda))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNoPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtTglBatas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtTglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKembali)))
                    .addComponent(lblDenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jLabel7.setText("Judul Buku");

        txtJudulBuku.setEditable(false);

        btnProses.setText("Proses");
        btnProses.setEnabled(false);
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJudulBuku)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnProses)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProses)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillCurrentPeminjamanDetil(String idBuku){
        try {
            String sql = "SELECT "
                       + "    transaksi.no_peminjaman "
                       + "    , transaksi.tgl_pinjam "
                       + "    , transaksi.tgl_batas "
                       + "    , detil_transaksi.id_buku "
                       + "    , buku.judul "
                       + "    , detil_transaksi.nilai_sewa "
                       + "FROM "
                       + "    buku "
                       + "    INNER JOIN detil_transaksi  "
                       + "        ON (buku.id = detil_transaksi.id_buku) "
                       + "    INNER JOIN transaksi  "
                       + "        ON (transaksi.no_peminjaman = detil_transaksi.no_peminjaman) "
                       + "WHERE (ISNULL(transaksi.tgl_kembali) "
                       + "    AND detil_transaksi.id_buku = ?);";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(sql);
            command.setString(1, idBuku);
            ResultSet rs  = command.executeQuery();
            DefaultTableModel tblModel = (DefaultTableModel) jTabDetil.getModel();
            cUtils.ResetTableContent(tblModel);
            while (rs.next()){
                txtNoPinjam.setText(rs.getString("no_peminjaman"));
                txtTglPinjam.setText(rs.getString("tgl_pinjam"));
                txtTglBatas.setText(rs.getString("tgl_batas"));
                tblModel.addRow(new Object[]{rs.getString("id_buku"), 
                                             rs.getString("judul"),
                                             rs.getInt("nilai_sewa"), 
                                             " - "});
            }
        } catch (SQLException ex) {
            Logger.getLogger(jFrmKembali.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        jFrmPopBuku fBuku = new jFrmPopBuku(txtKodeBuku, txtJudulBuku, new JTextField(), mBuku.EnumBukuStatus.keluar);
        fBuku.setVisible(true);
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel) jTabDetil.getModel();
        tblModel.setValueAt("kembali", jTabDetil.getSelectedRow(), 3);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        mTransaksiDetil trxDetil = new mTransaksiDetil(Integer.parseInt(txtNoPinjam.getText()));
        mTransaksi trx = new mTransaksi();
        trx.setNoPeminjaman(Integer.parseInt(txtNoPinjam.getText()));
        
        DefaultTableModel tblModel = (DefaultTableModel) jTabDetil.getModel();
        for (int i = 0; i < jTabDetil.getRowCount(); i++){
            if (tblModel.getValueAt(i, 3) == "kembali") {
                trxDetil.setIdBuku(tblModel.getValueAt(i, 0).toString());
                trxDetil.UpdateBukuStatus(0);
            }
        }
        
        trx.updateTglKembali(skg);
        this.CalculateDenda(Integer.parseInt(txtNoPinjam.getText()));
    }//GEN-LAST:event_btnProsesActionPerformed

    private void CalculateDenda(int noPeminjaman){
        try {
            int denda = 0;
            mTransaksi trx = new mTransaksi();
            trx.setNoPeminjaman(noPeminjaman);
            
            String sql = "SELECT DATEDIFF(tgl_kembali, tgl_batas) * (SELECT COUNT(det.no_peminjaman) FROM detil_transaksi det WHERE det.no_peminjaman = ?) * ? AS denda "
                       + "FROM transaksi "
                       + "WHERE transaksi.no_peminjaman = ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(sql);
            command.setInt(1, noPeminjaman);
            command.setInt(2, main.DefaultDenda);
            command.setInt(3, noPeminjaman);
            
            ResultSet rs = command.executeQuery();
            while (rs.next()){
                denda = rs.getInt("denda");
                lblDenda.setText("Denda : "+String.valueOf(denda));
                trx.updateDenda(denda);
                break;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(jFrmKembali.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnProses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabDetil;
    private javax.swing.JLabel lblDenda;
    private javax.swing.JTextField txtJudulBuku;
    private javax.swing.JTextField txtKodeBuku;
    private javax.swing.JTextField txtNoPinjam;
    private javax.swing.JTextField txtTglBatas;
    private javax.swing.JTextField txtTglKembali;
    private javax.swing.JTextField txtTglPinjam;
    // End of variables declaration//GEN-END:variables
}
