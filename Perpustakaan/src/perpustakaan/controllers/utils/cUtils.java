package perpustakaan.controllers.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ophicxs
 */
public class cUtils {
    public static void TabCreateColumn(JTable objTable, String[] column){
        objTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        objTable.setModel(new DefaultTableModel(column, 0){
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        });
    }
    
    public static void StateObjInput(boolean state, Object[] objInput){
        for (int i = 0; i < objInput.length; i++){
            String objClass = objInput[i].getClass().getName();
            
            if (objClass.equals(JTextField.class.getName())){
                ((JTextField) objInput[i]).setEnabled(state);
            } else if (objClass.equals(JPasswordField.class.getName())) {
                ((JPasswordField) objInput[i]).setEnabled(state);
            } else if (objClass.equals(JFormattedTextField.class.getName())){
                ((JFormattedTextField) objInput[i]).setEnabled(state);
            } else if (objClass.equals(JTextArea.class.getName())){
                ((JTextArea) objInput[i]).setEnabled(state);
            }
        }
    }
    
    public static void ClearObjInput(Object[] objInput){
        for (int i = 0; i < objInput.length; i++){
            String objClass = objInput[i].getClass().getName();
            
            if (objClass.equals(JTextField.class.getName())){
                ((JTextField) objInput[i]).setText(null);
            } else if (objClass.equals(JPasswordField.class.getName())) {
                ((JPasswordField) objInput[i]).setText(null);
            } else if (objClass.equals(JFormattedTextField.class.getName())){
                ((JFormattedTextField) objInput[i]).setText(null);
            } else if (objClass.equals(JTextArea.class.getName())){
                ((JTextArea) objInput[i]).setText(null);
            }
        }
    }
    
    public static void FlipButtonName(JButton btnAdd, JButton btnEdit, JButton btnDelete, boolean isManipulation){
        if (isManipulation){
            btnAdd.setText("Save");
            btnEdit.setText("Cancel");
        } else {
            btnAdd.setText("Add");
            btnEdit.setText("Edit");
        }
    }
}

