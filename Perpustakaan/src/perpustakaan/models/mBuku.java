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
public class mBuku extends cDatabaseAction{
    public enum EnumBukuStatus { ada, keluar }
    
    private String _id = null;
    private String _judul = null;
    private String _pengarang = null;
    private String _penerbit = null;
    private int _tahunTerbit = 0;
    private String _isbn = null;
    private int _jmlHalaman = 0;
    private EnumBukuStatus _status = null;
    
    public EnumBukuStatus getStatus() {
        return _status;
    }
    
    public int getTahunTerbit() {
        return _tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this._tahunTerbit = tahunTerbit;
    }

    public int getJmlHalaman() {
        return _jmlHalaman;
    }

    public void setJmlHalaman(int jml_Halaman) {
        this._jmlHalaman = jml_Halaman;
    }

    public void setStatus(EnumBukuStatus status) {
        this._status = status;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getJudul() {
        return _judul;
    }

    public void setJudul(String judul) {
        this._judul = judul;
    }

    public String getPengarang() {
        return _pengarang;
    }

    public void setPengarang(String pengarang) {
        this._pengarang = pengarang;
    }

    public String getPenerbit() {
        return _penerbit;
    }

    public void setPenerbit(String penerbit) {
        this._penerbit = penerbit;
    }

    public String getIsbn() {
        return _isbn;
    }

    public void setIsbn(String isbn) {
        this._isbn = isbn;
    }
    
    @Override
    protected PreparedStatement DbCommandFetch(){
        PreparedStatement result = null;
        try {
            String query = "SELECT * "
                         + "  FROM buku ";
            
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected PreparedStatement DbCommandMerge(){
        PreparedStatement result = null;
        try {
            String query = "INSERT INTO buku (id, judul, pengarang, penerbit, tahun_terbit, isbn, jml_halaman) "
                         + "     VALUES (?, ?, ?, ?, ?, ?, ?) "
                         + "ON DUPLICATE KEY UPDATE "
                         + "    judul = ?,"
                         + "    pengarang = ?,"
                         + "    penerbit = ?," 
                         + "    tahun_terbit = ?," 
                         + "    isbn = ?,"
                         + "    jml_halaman = ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setString(1, this.getId());
            System.out.println(this.getId());
            command.setString(2, this.getJudul());
            System.out.println(this.getJudul());
            command.setString(3, this.getPengarang());
            command.setString(4, this.getPenerbit());
            command.setInt(5, this.getTahunTerbit());
            command.setString(6, this.getIsbn());
            command.setInt(7, this.getJmlHalaman());
            
            command.setString(8, this.getJudul());
            command.setString(9, this.getPengarang());
            command.setString(10, this.getPenerbit());
            command.setInt(11, this.getTahunTerbit());
            command.setString(12, this.getIsbn());
            command.setInt(13, this.getJmlHalaman());
            
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected PreparedStatement DbCommandErase(){
        PreparedStatement result = null;
        try {
            String query = "DELETE FROM buku "
                         + "WHERE buku.id = ?";
            PreparedStatement command = cDatabaseConnection.dbConn.prepareStatement(query);
            command.setString(1, this.getId());
            result = command;
        } catch (SQLException ex) {
            Logger.getLogger(mBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    protected List FillFromDatabase(ResultSet rows){
        List<mBuku> CollectionOfBuku = new ArrayList<mBuku>();
        mBuku buku;
        
        try {
            while (rows.next()){
                buku = new mBuku();
                
                buku.setId(rows.getString("id"));
                buku.setJudul(rows.getString("judul"));
                buku.setPenerbit(rows.getString("penerbit"));
                buku.setPengarang(rows.getString("pengarang"));
                buku.setTahunTerbit(rows.getInt("tahun_terbit"));
                buku.setIsbn(rows.getString("isbn"));
                buku.setJmlHalaman(rows.getInt("jml_halaman"));
                buku.setStatus(EnumBukuStatus.values()[rows.getInt("status")]);
                CollectionOfBuku.add(buku);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CollectionOfBuku;
    }
}
