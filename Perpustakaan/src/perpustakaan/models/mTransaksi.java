package perpustakaan.models;

import java.sql.Date;
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
public class mTransaksi extends cDatabaseAction {
    private int _noPeminjaman = 0;
    private Date _tglPinjam = null;
    private Date _tglBatas = null;
    private Date _tglKembali = null;
    private int _denda = 0;
    private String _idMember = null;
    private String _idPegawai = null;

    public int getNoPeminjaman() {
        return _noPeminjaman;
    }

    public void setNoPeminjaman(int noPeminjaman) {
        this._noPeminjaman = noPeminjaman;
    }

    public Date getTglPinjam() {
        return _tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this._tglPinjam = tglPinjam;
    }

    public Date getTglBatas() {
        return _tglBatas;
    }

    public void setTglBatas(Date tglBatas) {
        this._tglBatas = tglBatas;
    }

    public Date getTglKembali() {
        return _tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this._tglKembali = tglKembali;
    }

    public int getDenda() {
        return _denda;
    }

    public void setDenda(int denda) {
        this._denda = denda;
    }

    public String getIdMember() {
        return _idMember;
    }

    public void setIdMember(String idMember) {
        this._idMember = idMember;
    }

    public String getIdPegawai() {
        return _idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this._idPegawai = idPegawai;
    }

    public int GetNewTrxId(){
        int result = 0;
                
        try {
            String query = "SELECT IF(ISNULL(MAX(no_peminjaman)+1), 1,MAX(no_peminjaman)+1) AS newtrx "
                         + "  FROM transaksi ";
            
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            ResultSet rs = command.executeQuery();
            while (rs.next()){
                result = rs.getInt("newtrx");
            }
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected List FillFromDatabase(ResultSet rows) {
        List<mTransaksi> CollectionOfTrx = new ArrayList<mTransaksi>();
        mTransaksi trx;
        
        try {
            while (rows.next()){
                trx = new mTransaksi();
                
                trx.setNoPeminjaman(rows.getInt("no_peminjaman"));
                trx.setTglPinjam(rows.getDate("tgl_pinjam"));
                trx.setTglBatas(rows.getDate("tgl_batas"));
                trx.setTglKembali(rows.getDate("tgl_kembali"));
                trx.setIdMember(rows.getString("id_member"));
                trx.setIdPegawai(rows.getString("id_pegawai"));
                trx.setDenda(rows.getInt("denda"));
                CollectionOfTrx.add(trx);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CollectionOfTrx;
    }

    @Override
    protected PreparedStatement DbCommandFetch() {
        PreparedStatement result = null;
        try {
            String query = "SELECT * "
                         + "  FROM transaksi ";
            
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    protected PreparedStatement DbCommandMerge() {
        PreparedStatement result = null;
        try {
            String query = "INSERT INTO transaksi (no_peminjaman, tgl_pinjam, tgl_batas, tgl_kembali, id_member, id_pegawai, denda) "
                         + "     VALUES (?, ?, ?, ?, ?, ?, ?) "
                         + "ON DUPLICATE KEY UPDATE "
                         + "    tgl_pinjam = ?,"
                         + "    tgl_batas = ?,"
                         + "    tgl_kembali = ?," 
                         + "    id_member = ?," 
                         + "    id_pegawai = ?,"
                         + "    denda = ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setInt(1, this.getNoPeminjaman());
            command.setDate(2, this.getTglPinjam());
            command.setDate(3, this.getTglBatas());
            command.setDate(4, this.getTglKembali());
            command.setString(5, this.getIdMember());
            command.setString(6, this.getIdPegawai());
            command.setInt(7, this.getDenda());
            
            command.setDate(8, this.getTglPinjam());
            command.setDate(9, this.getTglBatas());
            command.setDate(10, this.getTglKembali());
            command.setString(11, this.getIdMember());
            command.setString(12, this.getIdPegawai());
            command.setInt(13, this.getDenda());
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    protected PreparedStatement DbCommandErase() {
        PreparedStatement result = null;
        try {
            String query = "DELETE FROM "
                         + "    transaksi, detil_transaksi "
                         + "USING transaksi LEFT JOIN detil_transaksi ON transaksi.no_peminjaman = detil_transaksi.no_peminjaman "
                         + "WHERE transaksi.no_peminjaman = ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setInt(1, this.getNoPeminjaman());
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected PreparedStatement DBCommandFetchSelected(Object criteria) {
        PreparedStatement result = null;
        try {
            String query = "SELECT * "
                         + "  FROM transaksi "
                         + "WHERE no_peminjaman LIKE ?";
            
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setString(1, "%"+((String) criteria)+"%");
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
