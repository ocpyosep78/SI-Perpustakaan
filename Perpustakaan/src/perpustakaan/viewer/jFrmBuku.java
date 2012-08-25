package perpustakaan.viewer;

import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import perpustakaan.controllers.utils.cUtils;
import perpustakaan.models.mBuku;

/**
 *
 * @author ophicxs
 */
public class jFrmBuku extends javax.swing.JInternalFrame {
    private mBuku _buku = new mBuku();
    private boolean _isNew = false;
    
    public jFrmBuku() {
        this.initComponents();
        String[] column = new String[]{"Kode Buku", 
                                       "Judul Buku", 
                                       "Penerbit", 
                                       "Pengarang", 
                                       "Tahun Terbit", 
                                       "Tebal", 
                                       "ISBN", 
                                       "Harga Sewa",
                                       "Status"};
        cUtils.TabCreateColumn(jTabBuku, column);
        this.LoadRows();
        jTabBuku.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow =  jTabBuku.convertRowIndexToModel(jTabBuku.getSelectedRow());
                
                if (selectedRow >= 0){
                    txtId.setText((String) jTabBuku.getValueAt(selectedRow, 0));
                    txtJudul.setText((String) jTabBuku.getValueAt(selectedRow, 1));
                    txtPenerbit.setText((String) jTabBuku.getValueAt(selectedRow, 2));
                    txtPengarang.setText((String) jTabBuku.getValueAt(selectedRow, 3));
                    txtTahunTerbit.setText(jTabBuku.getValueAt(selectedRow, 4).toString());
                    txtTebal.setText((String) jTabBuku.getValueAt(selectedRow, 5));
                    txtIsbn.setText((String) jTabBuku.getValueAt(selectedRow, 6));
                    txtHrgSewa.setText((String) jTabBuku.getValueAt(selectedRow, 7));
                    lblStatus.setText("Status: "+ jTabBuku.getValueAt(selectedRow, 8).toString());
                } else {
                    cUtils.ClearObjInput(new Object[]{txtId, txtJudul, txtIsbn, txtPenerbit, txtPengarang, txtTahunTerbit, txtTebal, txtHrgSewa});
                }        
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtJudul = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPengarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPenerbit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        txtTahunTerbit = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabBuku = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTebal = new javax.swing.JTextField();
        txtHrgSewa = new javax.swing.JTextField();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Data Buku");

        jLabel1.setText("Kode Buku");

        txtId.setEnabled(false);

        txtJudul.setEnabled(false);

        jLabel2.setText("Judul Buku");

        txtPengarang.setEnabled(false);

        jLabel3.setText("Pengarang");

        txtPenerbit.setEnabled(false);

        jLabel4.setText("Penerbit");

        jLabel5.setText("Tahun Terbit");

        jLabel6.setText("ISBN");

        txtIsbn.setEnabled(false);

        txtTahunTerbit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy"))));
        txtTahunTerbit.setEnabled(false);

        jTabBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTabBuku);
        jTabBuku.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStatus.setText("Status : Ada");

        jLabel7.setText("Tebal");

        jLabel8.setText("Harga Sewa");

        txtTebal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTebal.setEnabled(false);

        txtHrgSewa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHrgSewa.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblStatus))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtHrgSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTebal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTebal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtHrgSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        switch (btnAdd.getText()){
                case "Add":
                    _isNew = true;
                    cUtils.StateObjInput(true, new Object[]{txtId, txtJudul, txtIsbn, txtPenerbit, txtPengarang, txtTahunTerbit, txtTebal, txtHrgSewa});
                    lblStatus.setText("Status: Kosong");
                    cUtils.ClearObjInput(new Object[]{txtId, txtJudul, txtIsbn, txtPenerbit, txtPengarang, txtTahunTerbit, txtTebal, txtHrgSewa});
                    cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, true);
                    break;
                case "Save":
                    if (this.SaveRow()){
                        cUtils.StateObjInput(false, new Object[]{txtId, txtJudul, txtIsbn, txtPenerbit, txtPengarang, txtTahunTerbit, txtTebal, txtHrgSewa});
                        cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, false);
                    }
                    break;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        switch (btnEdit.getText()){
                case "Edit":
                    _isNew = false;
                    cUtils.StateObjInput(true, new Object[]{txtId, txtJudul, txtIsbn, txtPenerbit, txtPengarang, txtTahunTerbit, txtTebal, txtHrgSewa});
                    cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, true);
                    break;
                case "Cancel":
                    if (_isNew){ cUtils.ClearObjInput(new Object[]{txtId, txtJudul, txtIsbn, txtPenerbit, txtPengarang, txtTahunTerbit, txtTebal, txtHrgSewa}); }
                    cUtils.StateObjInput(false, new Object[]{txtId, txtJudul, txtIsbn, txtPenerbit, txtPengarang, txtTahunTerbit, txtTebal, txtHrgSewa});
                    cUtils.FlipButtonName(btnAdd, btnEdit, btnDelete, false);
                    break;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            this.CopyObjectToModel();
            _buku.EraseRow();
            DefaultTableModel tblModel = (DefaultTableModel) jTabBuku.getModel();
            tblModel.removeRow(jTabBuku.convertColumnIndexToModel(jTabBuku.getSelectedRow()));
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private boolean SaveRow(){
        boolean result = false;
        
        this.CopyObjectToModel();
        if (_buku.MergeRow()){
            DefaultTableModel tblModel = (DefaultTableModel) jTabBuku.getModel();
            if (_isNew){
                tblModel.addRow(new Object[]{_buku.getId(),
                                             _buku.getJudul(),
                                             _buku.getPenerbit(),
                                             _buku.getPengarang(), 
                                             _buku.getTahunTerbit(), 
                                             _buku.getJmlHalaman(), 
                                             _buku.getIsbn(), 
                                             _buku.getNilaiSewa(), 
                                             _buku.getStatus()});
                cUtils.ClearObjInput(new Object[]{txtId, txtJudul, txtIsbn, txtPenerbit, txtPengarang, txtTahunTerbit, txtTebal, txtHrgSewa});
            } else {
                int rowPosition = jTabBuku.convertRowIndexToModel(jTabBuku.getSelectedRow());
                tblModel.setValueAt(_buku.getId(), rowPosition, 0);
                tblModel.setValueAt(_buku.getJudul(), rowPosition, 1);
                tblModel.setValueAt(_buku.getPenerbit(), rowPosition, 2);
                tblModel.setValueAt(_buku.getPengarang(), rowPosition, 3);
                tblModel.setValueAt(_buku.getTahunTerbit(), rowPosition, 4);
                tblModel.setValueAt(_buku.getJmlHalaman(), rowPosition, 5);
                tblModel.setValueAt(_buku.getIsbn(), rowPosition, 6);
                tblModel.setValueAt(_buku.getNilaiSewa(), rowPosition, 6);
                tblModel.setValueAt(_buku.getStatus(), rowPosition, 8);
            }
            result = true;
        }
        return result;
    }
    
    private void LoadRows(){
        mBuku buku = new mBuku();
        List CollectionOfBuku = buku.FetchRows();
        ListIterator lst = CollectionOfBuku.listIterator();
        DefaultTableModel tblModel = (DefaultTableModel) jTabBuku.getModel();
        while (lst.hasNext()){
            mBuku item = (mBuku) lst.next();
            tblModel.addRow(new Object[]{item.getId(),
                                         item.getJudul(),
                                         item.getPenerbit(),
                                         item.getPengarang(), 
                                         item.getTahunTerbit(), 
                                         item.getJmlHalaman(), 
                                         item.getJmlHalaman(),
                                         item.getIsbn(), 
                                         item.getNilaiSewa(),
                                         item.getStatus()});
        }
    }
    
    private void CopyObjectToModel(){
        _buku.setId(txtId.getText());
        _buku.setJudul(txtJudul.getText());
        _buku.setPenerbit(txtPenerbit.getText());
        _buku.setPengarang(txtPengarang.getText());
        _buku.setTahunTerbit(Integer.parseInt(txtTahunTerbit.getText()));
        _buku.setJmlHalaman(Integer.parseInt(txtTebal.getText()));
        _buku.setNilaiSewa(Integer.parseInt(txtHrgSewa.getText()));
        _buku.setIsbn(txtIsbn.getText());
        _buku.setStatus(mBuku.EnumBukuStatus.ada);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabBuku;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtHrgSewa;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPengarang;
    private javax.swing.JFormattedTextField txtTahunTerbit;
    private javax.swing.JTextField txtTebal;
    // End of variables declaration//GEN-END:variables

}

