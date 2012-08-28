package perpustakaan.viewers;

import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import perpustakaan.controllers.utils.cUtils;
import perpustakaan.models.mPegawai;

/**
 *
 * @author ophicxs
 */
public class jFrmPegawai extends javax.swing.JInternalFrame {
    private boolean _isNew = false;
    private mPegawai _pegawai = new mPegawai();

    public jFrmPegawai() {
        initComponents();
        String[] column = new String[]{"Username", 
                                       "Password", 
                                       "Nama", 
                                       "Alamat", 
                                       "No. Kontak"};
        cUtils.TabCreateColumn(jTabPegawai, column);
        this.LoadRows();
        jTabPegawai.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow =  jTabPegawai.convertRowIndexToModel(jTabPegawai.getSelectedRow());
                
                if (selectedRow >= 0){
                    txtUsername.setText((String) jTabPegawai.getValueAt(selectedRow, 0));
                    txtPassword.setText((String) jTabPegawai.getValueAt(selectedRow, 1));
                    txtNama.setText((String) jTabPegawai.getValueAt(selectedRow, 2));
                    txtAlamat.setText((String) jTabPegawai.getValueAt(selectedRow, 3));
                    txtKontak.setText((String) jTabPegawai.getValueAt(selectedRow, 4));
                } else {
                    cUtils.ClearObjInput(new Object[]{txtUsername, txtPassword, txtNama, txtAlamat, txtKontak});
                }        
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtKontak = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabPegawai = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txtAlamat = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setTitle("Data Pegawai");

        jLabel1.setText("Username");

        txtUsername.setEnabled(false);

        txtNama.setEnabled(false);

        jLabel2.setText("Nama");

        jLabel3.setText("Password");

        txtPassword.setEnabled(false);

        jLabel4.setText("Alamat");

        txtKontak.setEnabled(false);

        jLabel5.setText("No. Kontak");

        jTabPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTabPegawai);

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

        txtAlamat.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPassword))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtKontak, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtAlamat, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNama, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            this.CopyObjectToModel();
            _pegawai.EraseRow();
            DefaultTableModel tblModel = (DefaultTableModel) jTabPegawai.getModel();
            tblModel.removeRow(jTabPegawai.convertColumnIndexToModel(jTabPegawai.getSelectedRow()));
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        switch (btnAdd.getText()) {
            case "Add":
                _isNew = true;
                cUtils.StateObjInput(true, new Object[]{txtUsername, txtPassword, txtNama, txtAlamat, txtKontak});
                cUtils.ClearObjInput(new Object[]{txtUsername, txtPassword, txtNama, txtAlamat, txtKontak});
                cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, true);
                break;
            case "Save":
                if (this.SaveRow()) {
                    cUtils.StateObjInput(false, new Object[]{txtUsername, txtPassword, txtNama, txtAlamat, txtKontak});
                    cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, false);
                }
                break;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        switch (btnEdit.getText()) {
            case "Edit":
                _isNew = false;
                cUtils.StateObjInput(true, new Object[]{txtUsername, txtPassword, txtNama, txtAlamat, txtKontak});
                cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, true);
                break;
            case "Cancel":
                if (_isNew) {
                    cUtils.ClearObjInput(new Object[]{txtUsername, txtPassword, txtNama, txtAlamat, txtKontak});
                }
                cUtils.StateObjInput(false, new Object[]{txtUsername, txtPassword, txtNama, txtAlamat, txtKontak});
                cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, false);
                break;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private boolean SaveRow(){
        boolean result = false;
        
        this.CopyObjectToModel();
        if (_pegawai.MergeRow()){
            DefaultTableModel tblModel = (DefaultTableModel) jTabPegawai.getModel();
            if (_isNew){
                tblModel.addRow(new Object[]{_pegawai.getUsername(),
                                             _pegawai.getPassword(),
                                             _pegawai.getNama(),
                                             _pegawai.getAlamat(), 
                                             _pegawai.getKontak()});
                cUtils.ClearObjInput(new Object[]{txtUsername, txtPassword, txtNama, txtAlamat, txtKontak});
            } else {
                int rowPosition = jTabPegawai.convertRowIndexToModel(jTabPegawai.getSelectedRow());
                tblModel.setValueAt(_pegawai.getUsername(), rowPosition, 0);
                tblModel.setValueAt(_pegawai.getPassword(), rowPosition, 1);
                tblModel.setValueAt(_pegawai.getNama(), rowPosition, 2);
                tblModel.setValueAt(_pegawai.getAlamat(), rowPosition, 3);
                tblModel.setValueAt(_pegawai.getKontak(), rowPosition, 4);
            }
            result = true;
        }
        return result;
    }
    
    private void LoadRows(){
        mPegawai pegawai = new mPegawai();
        List CollectionOfBuku = pegawai.FetchRows();
        ListIterator lst = CollectionOfBuku.listIterator();
        DefaultTableModel tblModel = (DefaultTableModel) jTabPegawai.getModel();
        while (lst.hasNext()){
            mPegawai item = (mPegawai) lst.next();
            tblModel.addRow(new Object[]{item.getUsername(),
                                         item.getPassword(),
                                         item.getNama(),
                                         item.getAlamat(), 
                                         item.getKontak()});
        }
    }
    
    private void CopyObjectToModel(){
        _pegawai.setUsername(txtUsername.getText());
        _pegawai.setPassword(txtPassword.getText());
        _pegawai.setNama(txtNama.getText());
        _pegawai.setAlamat(txtAlamat.getText());
        _pegawai.setKontak(txtKontak.getText());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabPegawai;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtKontak;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
