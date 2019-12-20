/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author longn
 */
public class HibernateUtils {
    public static Connection CONN;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            CONN = DriverManager.getConnection("jdbc:mysql://localhost/hethonggtvl",
                    "root", "123456");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HibernateUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(HibernateUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
     public static Connection getConn() {
        return CONN;
    }
}
