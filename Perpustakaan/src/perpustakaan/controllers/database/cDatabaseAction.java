package perpustakaan.controllers.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ophicxs
 */

abstract public class cDatabaseAction {
    public static enum DbOperations{ Merge, Erase }
    public static enum DbTables{ buku, pegawai, member, transaksi, transaksi_detil }

    abstract protected List<Object> FillFromDatabase(ResultSet rows);
    abstract protected PreparedStatement DbCommandFetch();
    abstract protected PreparedStatement DbCommandMerge();
    abstract protected PreparedStatement DbCommandErase();
    abstract protected PreparedStatement DBCommandFetchSelected(Object criteria);
    
    public List<Object> FetchRowSelected(Object criteria){
        List result = null;
        try {
            PreparedStatement command = this.DBCommandFetchSelected(criteria);
            result = FillFromDatabase(command.executeQuery());
        } catch (SQLException ex) {
            Logger.getLogger(cDatabaseAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public List<Object> FetchRows(){
        List result = null;
        try {
            PreparedStatement command = this.DbCommandFetch();
            result = FillFromDatabase(command.executeQuery());
        } catch (SQLException ex) {
            Logger.getLogger(cDatabaseAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean MergeRow(){
        boolean result = false;
        try {
            PreparedStatement command = this.DbCommandMerge();
            Object retVal = command.executeUpdate();
            result = (retVal != 0);
        } catch (SQLException ex) {
            Logger.getLogger(cDatabaseAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean EraseRow(){
        boolean result = false;
        try {
            PreparedStatement command = this.DbCommandErase();
            int retVal = command.executeUpdate();
            result = (retVal != 0);
        } catch (SQLException ex) {
            Logger.getLogger(cDatabaseAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
