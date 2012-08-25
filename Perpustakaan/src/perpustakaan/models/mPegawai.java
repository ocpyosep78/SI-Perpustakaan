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
public class mPegawai extends cDatabaseAction {
    private String _username = null;
    private String _password = null;
    private String _nama = null;
    private String _alamat = null;
    private String _kontak = null;

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        this._password = password;
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

    public String getKontak() {
        return _kontak;
    }

    public void setKontak(String kontak) {
        this._kontak = kontak;
    }
    
    @Override
    protected PreparedStatement DbCommandFetch(){
        PreparedStatement result = null;
        try {
            String query = "SELECT * "
                         + "  FROM pegawai ";
            
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected PreparedStatement DbCommandMerge(){
        PreparedStatement result = null;
        try {
            String query = "INSERT INTO pegawai (username, password, nama, alamat, kontak) "
                         + "     VALUES (?, MD5(?), ?, ?, ?) "
                         + "ON DUPLICATE KEY UPDATE "
                         + "    password = MD5(?),"
                         + "    nama = ?," 
                         + "    alamat = ?," 
                         + "    kontak = ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setString(1, this.getUsername());
            command.setString(2, this.getPassword());
            command.setString(3, this.getNama());
            command.setString(4, this.getAlamat());
            command.setString(5, this.getKontak());
            
            command.setString(6, this.getPassword());
            command.setString(7, this.getNama());
            command.setString(8, this.getAlamat());
            command.setString(9, this.getKontak());
            
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected PreparedStatement DbCommandErase(){
        PreparedStatement result = null;
        try {
            String query = "DELETE FROM pegawai "
                         + "WHERE pegawai.username = ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setString(1, this.getUsername());
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected List FillFromDatabase(ResultSet rows){
        List<mPegawai> CollectionOfPegawai = new ArrayList<mPegawai>();
        mPegawai pegawai;
        
        try {
            while (rows.next()){
                pegawai = new mPegawai();
                pegawai.setUsername(rows.getString("username"));
                pegawai.setPassword(rows.getString("password"));
                pegawai.setNama(rows.getString("nama"));
                pegawai.setAlamat(rows.getString("alamat"));
                pegawai.setKontak(rows.getString("kontak"));
                CollectionOfPegawai.add(pegawai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CollectionOfPegawai;
    }
    
    @Override
    protected PreparedStatement DBCommandFetchSelected(Object criteria) {
        PreparedStatement result = null;
        try {
            String query = "SELECT * "
                         + "  FROM pegawai "
                         + "WHERE nama LIKE ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setString(1, "%"+((String) criteria)+"%");
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
