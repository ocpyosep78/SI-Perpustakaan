package perpustakaan.viewer;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import perpustakaan.controllers.utils.cUtils;
import perpustakaan.main;
import perpustakaan.models.mTransaksi;
import perpustakaan.models.mTransaksiDetil;
import perpustakaan.viewer.pop.jFrmPopBuku;
import perpustakaan.viewer.pop.jFrmPopMember;
import perpustakaan.viewer.pop.jFrmPopPeminjaman;

/**
 *
 * @author ophicxs
 */
public class jFrmPinjam extends javax.swing.JInternalFrame {
    private mTransaksi _trx = new mTransaksi();
    private boolean _isNew = false;
    
    public jFrmPinjam() {
        initComponents();
        lblPegawai.setText("Operator : "+ main.username);
        cUtils.TabCreateColumn(jTabDetil, new String[]{"Kode Buku", "Judul Buku", "Harga Sewa"});
        txtNoPinjam.getDocument().addDocumentListener(new DocumentListener() {            
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (txtNoPinjam.getText().length() > 0) {
                    getDetilTrx(Integer.parseInt(txtNoPinjam.getText()));
                }
                System.out.println(txtNoPinjam.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtNoPinjam.getText().length() > 0) {
                    getDetilTrx(Integer.parseInt(txtNoPinjam.getText()));
                }
                System.out.println(txtNoPinjam.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (txtNoPinjam.getText().length() > 0) {
                    getDetilTrx(Integer.parseInt(txtNoPinjam.getText()));
                }
                System.out.println(txtNoPinjam.getText());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTglPinjam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTglBatas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdMember = new javax.swing.JTextField();
        btnBrowseMember = new javax.swing.JButton();
        lblPegawai = new javax.swing.JLabel();
        btnBrowseNoPinjam = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtKodeBuku = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBrowseBuku = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtJudulBuku = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHargaSewa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabDetil = new javax.swing.JTable();
        btnRemoveList = new javax.swing.JButton();
        btnAddList = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txtNamaMember = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNoPinjam = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setTitle("Transaksi Peminjaman");

        jLabel1.setText("No. Peminjaman");

        txtTglPinjam.setEditable(false);

        jLabel2.setText("Tgl. Pinjam");

        txtTglBatas.setEditable(false);

        jLabel3.setText("Tgl. Batas");

        jLabel4.setText("Member");

        txtIdMember.setEditable(false);

        btnBrowseMember.setText("...");
        btnBrowseMember.setEnabled(false);
        btnBrowseMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseMemberActionPerformed(evt);
            }
        });

        lblPegawai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPegawai.setText("operator : -");

        btnBrowseNoPinjam.setText("...");
        btnBrowseNoPinjam.setEnabled(false);
        btnBrowseNoPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseNoPinjamActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detil Peminjaman"));

        txtKodeBuku.setEditable(false);

        jLabel6.setText("Kode Buku");

        btnBrowseBuku.setText("...");
        btnBrowseBuku.setEnabled(false);
        btnBrowseBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseBukuActionPerformed(evt);
            }
        });

        jLabel7.setText("Judul Buku");

        txtJudulBuku.setEditable(false);

        jLabel8.setText("Harga Sewa");

        txtHargaSewa.setEditable(false);

        jTabDetil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTabDetil);

        btnRemoveList.setText("Hapus item");
        btnRemoveList.setEnabled(false);
        btnRemoveList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveListActionPerformed(evt);
            }
        });

        btnAddList.setText("Tambah item");
        btnAddList.setEnabled(false);
        btnAddList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddListActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJudulBuku)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBrowseBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtHargaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveList)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseBuku))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHargaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveList)
                    .addComponent(btnAddList))
                .addContainerGap())
        );

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txtNamaMember.setEditable(false);

        jLabel9.setText("Nama");

        txtNoPinjam.setEditable(false);
        txtNoPinjam.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtNoPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBrowseNoPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTglBatas)
                                    .addComponent(txtTglPinjam))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(lblPegawai))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtIdMember, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBrowseMember, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 188, Short.MAX_VALUE))
                                    .addComponent(txtNamaMember))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtIdMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseMember)
                    .addComponent(btnBrowseNoPinjam)
                    .addComponent(txtNoPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(txtNamaMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPegawai)
                        .addComponent(jLabel3))
                    .addComponent(txtTglBatas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            this.CopyObjectToModel();
            _trx.EraseRow();
            DefaultTableModel tblModel = (DefaultTableModel) jTabDetil.getModel();
            tblModel.removeRow(jTabDetil.convertColumnIndexToModel(jTabDetil.getSelectedRow()));
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        switch (btnAdd.getText()) {
            case "Add":
                java.util.Date today = new java.util.Date();
                Date skg = new Date(today.getTime());
                
                _isNew = true;
                cUtils.StateObjInput(true, new Object[]{btnBrowseBuku, btnBrowseMember, btnBrowseNoPinjam, btnAddList, btnRemoveList});
                cUtils.ClearObjInput(new Object[]{txtNoPinjam, txtIdMember, txtNamaMember, txtTglBatas, txtTglPinjam, txtKodeBuku, txtJudulBuku, txtHargaSewa});
                cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, true);
                
                txtNoPinjam.setText(String.valueOf(_trx.GetNewTrxId()));
                txtTglPinjam.setText(skg.toString());
                break;
            case "Save":
                if (this.SaveRow()) {
                    cUtils.StateObjInput(false, new Object[]{btnBrowseBuku, btnBrowseMember, btnBrowseNoPinjam, btnAddList, btnRemoveList});
                    cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, false);
                }
                break;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        switch (btnEdit.getText()) {
            case "Edit":
                _isNew = false;
                cUtils.StateObjInput(true, new Object[]{btnBrowseBuku, btnBrowseMember, btnBrowseNoPinjam, btnAddList, btnRemoveList});
                cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, true);
                break;
            case "Cancel":
                if (_isNew) {
                    cUtils.ClearObjInput(new Object[]{txtNoPinjam, txtIdMember, txtNamaMember, txtTglBatas, txtTglPinjam, txtKodeBuku, txtJudulBuku, txtHargaSewa});
                }
                cUtils.StateObjInput(false, new Object[]{btnBrowseBuku, btnBrowseMember, btnBrowseNoPinjam, btnAddList, btnRemoveList});
                cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, false);
                break;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBrowseNoPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseNoPinjamActionPerformed
        jFrmPopPeminjaman fPop = new jFrmPopPeminjaman(txtNoPinjam, txtTglPinjam, txtTglBatas);
        fPop.setVisible(true);
    }//GEN-LAST:event_btnBrowseNoPinjamActionPerformed

    private void btnBrowseMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseMemberActionPerformed
        jFrmPopMember fPop = new jFrmPopMember(txtIdMember, txtNamaMember);
        fPop.setVisible(true);
    }//GEN-LAST:event_btnBrowseMemberActionPerformed

    private void btnBrowseBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseBukuActionPerformed
        jFrmPopBuku fPop = new jFrmPopBuku(txtKodeBuku, txtJudulBuku, txtHargaSewa);
        fPop.setVisible(true);
    }//GEN-LAST:event_btnBrowseBukuActionPerformed

    private void btnAddListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddListActionPerformed
        if (txtKodeBuku.getText().length() > 0){
            DefaultTableModel tblModel = (DefaultTableModel) jTabDetil.getModel();
            tblModel.addRow(new Object[]{txtKodeBuku.getText(),
                                         txtJudulBuku.getText(),
                                         txtHargaSewa.getText()});
            cUtils.ClearObjInput(new Object[]{txtKodeBuku, txtJudulBuku, txtHargaSewa});
            IncreaseDate(jTabDetil.getRowCount());
        }
    }//GEN-LAST:event_btnAddListActionPerformed

    private void btnRemoveListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveListActionPerformed
        if (jTabDetil.getSelectedRow() > -1){
            DefaultTableModel tblModel = (DefaultTableModel) jTabDetil.getModel();
            tblModel.removeRow(jTabDetil.getSelectedRow());
            IncreaseDate(jTabDetil.getRowCount());
        }
    }//GEN-LAST:event_btnRemoveListActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddList;
    private javax.swing.JButton btnBrowseBuku;
    private javax.swing.JButton btnBrowseMember;
    private javax.swing.JButton btnBrowseNoPinjam;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemoveList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabDetil;
    private javax.swing.JLabel lblPegawai;
    private javax.swing.JTextField txtHargaSewa;
    private javax.swing.JTextField txtIdMember;
    private javax.swing.JTextField txtJudulBuku;
    private javax.swing.JTextField txtKodeBuku;
    private javax.swing.JTextField txtNamaMember;
    private javax.swing.JTextField txtNoPinjam;
    private javax.swing.JTextField txtTglBatas;
    private javax.swing.JTextField txtTglPinjam;
    // End of variables declaration//GEN-END:variables

    private void CopyObjectToModel() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtPinjam = sdf.parse(txtTglPinjam.getText());
            java.util.Date dtBatas = sdf.parse(txtTglBatas.getText());
            
           _trx.setNoPeminjaman(Integer.parseInt(txtNoPinjam.getText()));
           _trx.setTglPinjam(java.sql.Date.valueOf(sdf.format(dtPinjam)));
           _trx.setTglBatas(java.sql.Date.valueOf(txtTglBatas.getText()));
           _trx.setIdPegawai(main.username);
           _trx.setIdMember(txtIdMember.getText());
        } catch (ParseException ex) {
            Logger.getLogger(jFrmPinjam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean SaveRow() {
        boolean result = false;
        
        this.CopyObjectToModel();
        if (_trx.MergeRow()){
            mTransaksiDetil trxDet;
            for (int i = 0; i < jTabDetil.getRowCount(); i++){
                trxDet = new mTransaksiDetil(Integer.parseInt(txtNoPinjam.getText()));
                
                TableModel tblModel = jTabDetil.getModel();
                trxDet.setIdBuku((String) tblModel.getValueAt(i, 0));
                trxDet.setJudulBuku((String) tblModel.getValueAt(i, 1));
                trxDet.setNilaiSewa((int) tblModel.getValueAt(i, 2));
                trxDet.MergeRow();
            }
        }
        return result;
    }
    
    private void getDetilTrx(int noPinjam) {
        mTransaksiDetil trxDet = new mTransaksiDetil(noPinjam);
        List CollectionOfTrxDet = trxDet.FetchRows();
        ListIterator lst = CollectionOfTrxDet.listIterator();
        DefaultTableModel tblModel = (DefaultTableModel) jTabDetil.getModel();
        cUtils.ResetTableContent(tblModel);
        while (lst.hasNext()){
            mTransaksiDetil item = (mTransaksiDetil) lst.next();
            tblModel.addRow(new Object[]{item.getIdBuku(),
                                         item.getJudulBuku(),
                                         item.getNilaiSewa()});
        }
        if (jTabDetil.getRowCount() > 0 && _isNew){
            IncreaseDate(jTabDetil.getRowCount());
        }
    }
    
    private void IncreaseDate(int number){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(txtTglPinjam.getText()));
            c.add(Calendar.DATE, number);  
            txtTglBatas.setText(sdf.format(c.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(jFrmPinjam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
