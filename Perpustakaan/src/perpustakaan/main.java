package perpustakaan;

import perpustakaan.controllers.database.cDatabaseConnection;
import perpustakaan.viewers.jFrmLogin;
import perpustakaan.viewers.jFrmMain;

/**
 *
 * @author ophicxs 
 * Sebelumnya saya sampaikan mohon maaf mengenai coding di aplikasi yang kurang rapi, 
 * karena keterbatasan atas pengetahuan dari konseptual MVC (Model-View-Class). 
 * mohon masukannya untuk dapat memberikan masukan mengenai konsep MVC yg diterapkan dalam aplikasi desktop
 */
public class main {
    public static String username = null;
    public static int DefaultDenda = 500;
    
    private static void setGui(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        setGui();
        cDatabaseConnection db = new cDatabaseConnection();
        db.setDbHost("127.0.0.1");
        db.setDbName("perpus");
        db.setDbUsername("Adm");
        db.setDbPassword("96099e22672004ef611250d9892c6047");
        db.Open();
        
        jFrmMain fMain = new jFrmMain();
        fMain.setVisible(true);
    }
}
