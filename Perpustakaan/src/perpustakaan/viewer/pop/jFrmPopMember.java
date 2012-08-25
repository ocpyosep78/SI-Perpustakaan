package perpustakaan.viewer.pop;

import java.util.List;
import java.util.ListIterator;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import perpustakaan.controllers.utils.cUtils;
import perpustakaan.models.mMember;

/**
 *
 * @author ophicxs
 */
public class jFrmPopMember extends javax.swing.JFrame {
    private JTextField _idMember = null;
    private JTextField _namaMember = null;
    
    public jFrmPopMember(JTextField idMember, JTextField namaMember) {
        this._idMember = idMember;
        this._namaMember = namaMember;
        initComponents();
        String[] column = new String[]{"ID", 
                                       "Nama", 
                                       "Alamat", 
                                       "Pengenal", 
                                       "No. Pengenal", 
                                       "No. Kontak", 
                                       "Tgl. Daftar"};
        cUtils.TabCreateColumn(jTabResult, column);
        this.LoadRows("");
    }
    
    private void LoadRows(String criteria){
        mMember member = new mMember();
        List CollectionOfMember = member.FetchRowSelected(criteria);
        ListIterator lst = CollectionOfMember.listIterator();
        DefaultTableModel tblModel = (DefaultTableModel) jTabResult.getModel();
        cUtils.ResetTableContent((DefaultTableModel) jTabResult.getModel());
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
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabResult = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cari Member");
        setAlwaysOnTop(true);

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

        jLabel1.setText("Nama Member");

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        this.LoadRows(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void jTabResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabResultMouseClicked
        if (evt.getClickCount() == 2){
            int selected = jTabResult.convertRowIndexToModel(jTabResult.getSelectedRow());
            this._idMember.setText((String) jTabResult.getModel().getValueAt(selected, 0));
            this._namaMember.setText((String) jTabResult.getModel().getValueAt(selected, 1));
            this.dispose();
        }
    }//GEN-LAST:event_jTabResultMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabResult;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
