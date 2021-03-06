package perpustakaan.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import perpustakaan.controllers.database.cDatabaseAction;
import perpustakaan.controllers.database.cDatabaseConnection;

/**
 *
 * @author ophicxs
 */
public class mTransaksiDetil extends cDatabaseAction {
    private int _noPeminjaman = 0;
    private String _idBuku = null;
    private String _judulBuku = null;
    private int _nilaiSewa = 0;

    public String getJudulBuku() {
        return _judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this._judulBuku = judulBuku;
    }
    
    public mTransaksiDetil (int no_peminjaman){
        this._noPeminjaman = no_peminjaman;
    }

    public int getNoPeminjaman() {
        return _noPeminjaman;
    }
    
    public String getIdBuku() {
        return _idBuku;
    }

    public void setIdBuku(String idBuku) {
        this._idBuku = idBuku;
    }

    public int getNilaiSewa() {
        return _nilaiSewa;
    }

    public void setNilaiSewa(int nilaiSewa) {
        this._nilaiSewa = nilaiSewa;
    }
    
    public void UpdateBukuStatus(int Status){
        try {
            String query = "UPDATE buku SET `status` = ? WHERE id = ?;";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setInt(1, Status);
            command.setString(2, this._idBuku);
            command.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksiDetil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected List FillFromDatabase(ResultSet rows) {
        List<mTransaksiDetil> CollectionOfTrxDetil = new ArrayList<mTransaksiDetil>();
        mTransaksiDetil trxDetil;
        
        try {
            while (rows.next()){
                trxDetil = new mTransaksiDetil(getNoPeminjaman());
                
                trxDetil.setIdBuku(rows.getString("id_buku"));
                trxDetil.setJudulBuku(rows.getString("judul"));
                trxDetil.setNilaiSewa(rows.getInt("nilai_sewa"));
                
                CollectionOfTrxDetil.add(trxDetil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksiDetil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CollectionOfTrxDetil;
    }

    @Override
    protected PreparedStatement DbCommandFetch() {
        PreparedStatement result = null;
        try {
            String query = "SELECT detil_transaksi.*, buku.judul "
                         + "  FROM detil_transaksi "
                         + "INNER JOIN buku ON detil_transaksi.id_buku = buku.id "
                         + "WHERE detil_transaksi.no_peminjaman = ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setInt(1, this._noPeminjaman);
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksiDetil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    protected PreparedStatement DbCommandMerge() {
        PreparedStatement result = null;
        try {
            String query = "INSERT INTO detil_transaksi (no_peminjaman, id_buku, nilai_sewa) "
                         + "     VALUES (?, ?, ?) "
                         + "ON DUPLICATE KEY UPDATE "
                         + "    id_buku = ?,"
                         + "    nilai_sewa = ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setInt(1, this.getNoPeminjaman());
            command.setString(2, this.getIdBuku());
            command.setInt(3, this.getNilaiSewa());

            command.setString(4, this.getIdBuku());
            command.setInt(5, this.getNilaiSewa());
            
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksiDetil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    protected PreparedStatement DbCommandErase() {
        PreparedStatement result = null;
        try {
            String query = "DELETE FROM detil_transaksi "
                         + "WHERE detil_transaksi.no_peminjaman = ? AND detil_transaksi.id_buku = ?; ";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setInt(1, this._noPeminjaman);
            command.setString(2, this._idBuku);
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksiDetil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
//    @Override
//    protected PreparedStatement DBCommandFetchSelected(Object criteria) {
//        PreparedStatement result = null;
//        try {
//            String query = "SELECT detil_transaksi.*, buku.judul "
//                         + "  FROM detil_transaksi INNER JOIN buku ON detil_transaksi.id_buku = buku.id "
//                         + "WHERE detil_transaksi.no_peminjaman = ?";
//            
//            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
//            command.setInt(1, Integer.parseInt(criteria.toString()));
//            
//            result = command;
//        } catch (SQLException ex) {
//            Logger.getLogger(mTransaksiDetil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
}
