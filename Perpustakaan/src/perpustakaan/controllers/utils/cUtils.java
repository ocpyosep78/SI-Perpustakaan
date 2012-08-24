package perpustakaan.controllers.utils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ophicxs
 */
public class cUtils {
    public static void TabCreateColumn(JTable objTable, String[] Column){
        objTable.setModel(new DefaultTableModel(Column, 0));
    } 
}

