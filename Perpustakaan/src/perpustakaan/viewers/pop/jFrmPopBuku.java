package perpustakaan.viewers.pop;

import java.util.List;
import java.util.ListIterator;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import perpustakaan.controllers.utils.cUtils;
import perpustakaan.models.mBuku;

/**
 *
 * @author ophicxs
 */
public class jFrmPopBuku extends javax.swing.JFrame {
    private JTextField _id = null;
    private JTextField _judul = null;
    private JTextField _hrgSewa = null;
    private mBuku.EnumBukuStatus _state;
    
    public jFrmPopBuku(JTextField idBuku, JTextField judulBuku, JTextField hrgSewa, mBuku.EnumBukuStatus status) {
        this._id = idBuku;
        this._judul = judulBuku;
        this._hrgSewa = hrgSewa;
        this._state = status;
        initComponents();
        String[] column = new String[]{"Kode Buku", 
                                       "Judul Buku", 
                                       "Penerbit", 
                                       "Pengarang", 
                                       "Tahun Terbit", 
                                       "Tebal", 
                                       "ISBN", 
                                       "Harga Sewa",
                                       "Status"};
        cUtils.TabCreateColumn(jTabResult, column);
        this.LoadRows("");
    }

    private void LoadRows(String criteria){
        mBuku buku = new mBuku();
        
        buku.setFilterStatus(this._state);
        buku.setFilterByJudul(criteria);
        List CollectionOfBuku = buku.FetchRows();
        ListIterator lst = CollectionOfBuku.listIterator();
        DefaultTableModel tblModel = (DefaultTableModel) jTabResult.getModel();
        cUtils.ResetTableContent(tblModel);
        while (lst.hasNext()){
            mBuku item = (mBuku) lst.next();
            tblModel.addRow(new Object[]{item.getId(),
                                         item.getJudul(),
                                         item.getPenerbit(),
                                         item.getPengarang(), 
                                         item.getTahunTerbit(), 
                                         item.getJmlHalaman(),
                                         item.getIsbn(), 
                                         item.getNilaiSewa(),
                                         item.getStatus()});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabResult = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cari Buku");

        jTabResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTabResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabResultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabResult);

        jLabel1.setText("Judul");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabResultMouseClicked
        if (evt.getClickCount() == 2){
            int selected = jTabResult.convertRowIndexToModel(jTabResult.getSelectedRow());
            this._id.setText((String) jTabResult.getModel().getValueAt(selected, 0));
            this._judul.setText((String) jTabResult.getModel().getValueAt(selected, 1));
            this._hrgSewa.setText(String.valueOf(jTabResult.getModel().getValueAt(selected, 7)));
            this.dispose();
        }
    }//GEN-LAST:event_jTabResultMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        this.LoadRows(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabResult;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
