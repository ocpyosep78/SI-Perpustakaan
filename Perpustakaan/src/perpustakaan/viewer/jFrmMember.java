package perpustakaan.viewer;

import java.sql.Date;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import perpustakaan.controllers.utils.cUtils;
import perpustakaan.models.mMember;

/**
 *
 * @author ophicxs
 */
public class jFrmMember extends javax.swing.JInternalFrame {
   private boolean _isNew = false;
   private mMember _member = new mMember();
   private java.util.Date today = new java.util.Date();
   private Date skg = new Date(today.getTime());
   
   public jFrmMember() {
        initComponents();
        String[] column = new String[]{"ID", 
                                       "Nama", 
                                       "Alamat", 
                                       "Pengenal", 
                                       "No. Pengenal", 
                                       "No. Kontak", 
                                       "Tgl. Daftar"};
        cUtils.TabCreateColumn(jTabMember, column);
        this.LoadRows();
        jTabMember.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow =  jTabMember.convertRowIndexToModel(jTabMember.getSelectedRow());
                
                if (selectedRow >= 0){
                    txtId.setText((String) jTabMember.getValueAt(selectedRow, 0));
                    txtNama.setText((String) jTabMember.getValueAt(selectedRow, 1));
                    txtAlamat.setText((String) jTabMember.getValueAt(selectedRow, 2));
                    cmbJenis.setSelectedIndex(mMember.EnumJenisPengenal.valueOf(jTabMember.getValueAt(selectedRow, 3).toString()).ordinal());
                    txtPengenal.setText((String) jTabMember.getValueAt(selectedRow, 4));
                    txtKontak.setText((String) jTabMember.getValueAt(selectedRow, 5));
                } else {
                    cUtils.ClearObjInput(new Object[]{txtId, txtNama, txtAlamat, cmbJenis, txtPengenal, txtKontak});
                }        
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbJenis = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtPengenal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtKontak = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabMember = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setTitle("Data Member");

        jLabel1.setText("ID");

        txtId.setEnabled(false);

        jLabel2.setText("Nama");

        txtNama.setEnabled(false);

        jLabel3.setText("Alamat");

        txtAlamat.setEnabled(false);

        jLabel4.setText("Jenis Pengenal");

        cmbJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KTP", "SIM", "Kartu Pelajar" }));
        cmbJenis.setSelectedIndex(-1);
        cmbJenis.setEnabled(false);

        jLabel5.setText("No. Pengenal");

        txtPengenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPengenal.setEnabled(false);

        jLabel6.setText("No. Kontak");

        txtKontak.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtKontak.setEnabled(false);

        jTabMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTabMember);

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

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPengenal, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKontak, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPengenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        switch (btnAdd.getText()) {
            case "Add":
                _isNew = true;
                cUtils.StateObjInput(true, new Object[]{txtId, txtNama, txtAlamat, cmbJenis, txtPengenal, txtKontak});
                cUtils.ClearObjInput(new Object[]{txtId, txtNama, txtAlamat, cmbJenis, txtPengenal, txtKontak, });
                cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, true);
                break;
            case "Save":
                if (this.SaveRow()) {
                    cUtils.StateObjInput(false, new Object[]{txtId, txtNama, txtAlamat, cmbJenis, txtPengenal, txtKontak});
                    cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, false);
                }
                break;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        switch (btnEdit.getText()) {
            case "Edit":
                _isNew = false;
                cUtils.StateObjInput(true, new Object[]{txtId, txtNama, txtAlamat, cmbJenis, txtPengenal, txtKontak});
                cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, true);
                break;
            case "Cancel":
                if (_isNew) {
                    cUtils.ClearObjInput(new Object[]{txtId, txtNama, txtAlamat, cmbJenis, txtPengenal, txtKontak});
                }
                cUtils.StateObjInput(false, new Object[]{txtId, txtNama, txtAlamat, cmbJenis, txtPengenal, txtKontak});
                cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, false);
                break;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            this.CopyObjectToModel();
            _member.EraseRow();
            DefaultTableModel tblModel = (DefaultTableModel) jTabMember.getModel();
            tblModel.removeRow(jTabMember.convertColumnIndexToModel(jTabMember.getSelectedRow()));
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private boolean SaveRow(){
        boolean result = false;
        
        this.CopyObjectToModel();
        if (_member.MergeRow()){
            DefaultTableModel tblModel = (DefaultTableModel) jTabMember.getModel();
            if (_isNew){
                tblModel.addRow(new Object[]{_member.getId(),
                                             _member.getNama(),
                                             _member.getAlamat(),
                                             _member.getJenisPengenal(), 
                                             _member.getNoPengenal(), 
                                             _member.getKontak(), 
                                             skg.toString()});
                cUtils.ClearObjInput(new Object[]{txtId, txtNama, txtAlamat, cmbJenis, txtPengenal, txtKontak});
            } else {
                int rowPosition = jTabMember.convertRowIndexToModel(jTabMember.getSelectedRow());
                tblModel.setValueAt(_member.getId(), rowPosition, 0);
                tblModel.setValueAt(_member.getNama(), rowPosition, 1);
                tblModel.setValueAt(_member.getAlamat(), rowPosition, 2);
                tblModel.setValueAt(_member.getJenisPengenal(), rowPosition, 3);
                tblModel.setValueAt(_member.getNoPengenal(), rowPosition, 4);
                tblModel.setValueAt(_member.getKontak(), rowPosition, 5);
                tblModel.setValueAt(skg, rowPosition, 6);
            }
            result = true;
        }
        return result;
    }
    
    
    private void LoadRows(){
        mMember member = new mMember();
        List CollectionOfMember = member.FetchRows();
        ListIterator lst = CollectionOfMember.listIterator();
        DefaultTableModel tblModel = (DefaultTableModel) jTabMember.getModel();
        while (lst.hasNext()){
            mMember item = (mMember) lst.next();
            tblModel.addRow(new Object[]{item.getId(),
                                         item.getNama(),
                                         item.getAlamat(),
                                         item.getJenisPengenal(), 
                                         item.getNoPengenal(),
                                         item.getKontak(), 
                                         item.getTglDaftar()});
        }
    }
    
    private void CopyObjectToModel(){
        _member.setId(txtId.getText());
        _member.setNama(txtNama.getText());
        _member.setAlamat(txtAlamat.getText());
        _member.setJenisPengenal(mMember.EnumJenisPengenal.values()[cmbJenis.getSelectedIndex()]);
        _member.setNoPengenal(txtPengenal.getText());
        _member.setKontak(txtKontak.getText());
        _member.setTglDaftar(skg);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox cmbJenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabMember;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKontak;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPengenal;
    // End of variables declaration//GEN-END:variables
}
