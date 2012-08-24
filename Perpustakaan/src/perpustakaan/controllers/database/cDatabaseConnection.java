package perpustakaan.controllers.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ophicxs
 */
public class cDatabaseConnection {
    public static java.sql.Connection dbConn;
    private String _dbHost = "localhost";
    private String _dbName = "perpus";
    private String _dbUsername = "root";
    private String _dbPassword = "";
   
    public boolean Open(){
        String dbUrl = "jdbc:mysql://"+this.getDbHost()+":3306/"+this.getDbName();
        boolean result = false;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbConn = DriverManager.getConnection (dbUrl, getDbUsername(), getDbPassword());
            result = true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(cDatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean Close(){
        boolean result = false;
        try {
            dbConn.close();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(cDatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String getDbHost() {
        return _dbHost;
    }

    public void setDbHost(String dbHost) {
        this._dbHost = dbHost;
    }

    public String getDbName() {
        return _dbName;
    }

    public void setDbName(String dbName) {
        this._dbName = dbName;
    }

    public String getDbUsername() {
        return _dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this._dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return _dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this._dbPassword = dbPassword;
    }
}
