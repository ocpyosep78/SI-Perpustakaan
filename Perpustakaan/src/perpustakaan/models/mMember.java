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
public class mMember extends cDatabaseAction {
    public enum EnumJenisPengenal { ktp, sim, kartu_pelajar }
    
    private String _id = null;
    private String _nama = null;
    private String _alamat = null;
    private EnumJenisPengenal _jenisPengenal = null;
    private String _noPengenal = null;
    private String _kontak = null;
    private Date _tglDaftar = null;
    
    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getNama() {
        return _nama;
    }

    public void setNama(String nama) {
        this._nama = nama;
    }

    public String getAlamat() {
        return _alamat;
    }

    public void setAlamat(String alamat) {
        this._alamat = alamat;
    }

    public EnumJenisPengenal getJenisPengenal() {
        return _jenisPengenal;
    }

    public void setJenisPengenal(EnumJenisPengenal jenisPengenal) {
        this._jenisPengenal = jenisPengenal;
    }

    public String getNoPengenal() {
        return _noPengenal;
    }

    public void setNoPengenal(String noPengenal) {
        this._noPengenal = noPengenal;
    }

    public String getKontak() {
        return _kontak;
    }

    public void setKontak(String kontak) {
        this._kontak = kontak;
    }

    public Date getTglDaftar() {
        return _tglDaftar;
    }

    public void setTglDaftar(Date tglDaftar) {
        this._tglDaftar = tglDaftar;
    }
    
        @Override
    protected PreparedStatement DbCommandFetch(){
        PreparedStatement result = null;
        try {
            String query = "SELECT * "
                         + "  FROM member ";
            
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected PreparedStatement DbCommandMerge(){
        PreparedStatement result = null;
        try {
            String query = "INSERT INTO member (id, nama, alamat, jenis_pengenal, no_pengenal, kontak, tgl_daftar) "
                         + "     VALUES (?, ?, ?, ?, ?, ?, ?) "
                         + "ON DUPLICATE KEY UPDATE "
                         + "    nama = ?,"
                         + "    alamat = ?," 
                         + "    jenis_pengenal = ?," 
                         + "    no_pengenal = ?,"
                         + "    kontak = ?, "
                         + "    tgl_daftar = ?";
            
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setString(1, this.getId());
            command.setString(2, this.getNama());
            command.setString(3, this.getAlamat());
            command.setInt(4, this.getJenisPengenal().ordinal());
            command.setString(5, this.getNoPengenal());
            command.setString(6, this.getKontak());
            command.setDate(7, this.getTglDaftar());
            
            command.setString(8, this.getNama());
            command.setString(9, this.getAlamat());
            command.setInt(10, this.getJenisPengenal().ordinal());
            command.setString(11, this.getNoPengenal());
            command.setString(12, this.getKontak());
            command.setDate(13, this.getTglDaftar());
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected PreparedStatement DbCommandErase(){
        PreparedStatement result = null;
        try {
            String query = "DELETE FROM member "
                         + "WHERE member.id = ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setString(1, this.getId());
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected List FillFromDatabase(ResultSet rows){
        List<mMember> CollectionOfMember = new ArrayList<mMember>();
        mMember member;
        
        try {
            while (rows.next()){
                member = new mMember();
                
                member.setId(rows.getString("id"));
                member.setNama(rows.getString("nama"));
                member.setAlamat(rows.getString("alamat"));
                member.setJenisPengenal(EnumJenisPengenal.values()[rows.getInt("jenis_pengenal")]);
                member.setNoPengenal(rows.getString("no_pengenal"));
                member.setKontak(rows.getString("kontak"));
                member.setTglDaftar(rows.getDate("tgl_daftar"));
                CollectionOfMember.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CollectionOfMember;
    }
    
    @Override
    protected PreparedStatement DBCommandFetchSelected(Object criteria) {
        PreparedStatement result = null;
        try {
            String query = "SELECT * "
                         + "  FROM member "
                         + "WHERE nama LIKE ?";
            
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setString(1, "%"+((String) criteria)+"%");
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
