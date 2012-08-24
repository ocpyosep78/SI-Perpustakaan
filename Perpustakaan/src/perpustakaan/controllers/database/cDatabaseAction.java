
package perpustakaan.controllers.database;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
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
    public static enum DbCriteria{
        like,               // LIKE
        notLike,            // NOT LIKE
        equals,             // =
        notEquals,          // <>
        greaterThan,        // >
        greaterThanOrEquals,// >=
        lessThan,           // <
        lessThanOrEquals,   // <=
    } 
    abstract protected List FillFromDatabase(ResultSet rows);
    abstract protected PreparedStatement DbCommandFetch();
    abstract protected PreparedStatement DbCommandMerge();
    abstract protected PreparedStatement DbCommandErase();
    abstract protected Object CurrentClass();
    
//    protected void SetDefaultRowCriteria(Object modelObject){
//        try {
//            BeanInfo info = Introspector.getBeanInfo(modelObject.getClass(), Object.class);  
//            PropertyDescriptor[] props = info.getPropertyDescriptors();  
//            
//            for (PropertyDescriptor pd : props) {  
//                String name = pd.getName();  
//                Method setter = pd.getWriteMethod();  
//                Method getter = pd.getReadMethod();
//                Class<?> type = pd.getPropertyType();  
//
//                setter.invoke(modelObject, "%");
//                Object value = getter.invoke(modelObject);  
//
//                System.out.println(name + " = " + value + "; type = " + type);  
//            }
//        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException ex) {
//            Logger.getLogger(cDatabaseAction.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    private void fillPropertyChild(String dbColumName, Object dbValue){
//       Method[] method = this.CurrentClass().getClass().getDeclaredMethods();
//    }
    
//    private mSimpleObject[] ConvertRsToObjArray(ResultSet queryResult){
//        mSimpleObject[] obj = null;
//        String[] stringType = new String[]{"varchar", "char"};
//        String[] intType = new String[]{"int", "year", "double", "tinyint"};
//        
//        try {
//            ResultSetMetaData rsMeta = queryResult.getMetaData();
//            int columnCount = rsMeta.getColumnCount();
//            mSimpleObject modelObject;
//            
//            while (queryResult.next()){
//                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
//                    if (Arrays.asList(stringType).contains(rsMeta.getColumnTypeName(columnIndex).toLowerCase())) {
//                        modelObject = new mSimpleObject();
//                        modelObject.setName(rsMeta.getColumnName(columnIndex));
//                        modelObject.setValue(queryResult.getString(columnIndex));
//                        Arrays.fill(obj, modelObject);
//                    } else if (Arrays.asList(intType).contains(rsMeta.getColumnTypeName(columnIndex).toLowerCase())) {
//                        modelObject = new mSimpleObject();
//                        modelObject.setName(rsMeta.getColumnName(columnIndex));
//                        modelObject.setValue(queryResult.getInt(columnIndex));
//                        Arrays.fill(obj, modelObject);
//                    } else if (rsMeta.getColumnTypeName(columnIndex).toLowerCase().equals("date")) {
//                        modelObject = new mSimpleObject();
//                        modelObject.setName(rsMeta.getColumnName(columnIndex));
//                        modelObject.setValue(queryResult.getDate(columnIndex));
//                        Arrays.fill(obj, modelObject);
//                    }
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(cDatabaseAction.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return obj;
//    }
    
//    public Object[] FetchObjects(){
//        Object obj = CurrentClass();
//        c clsName CurrentClass().getClass().getName() 
//    }
    
    public List FetchRows(){
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
