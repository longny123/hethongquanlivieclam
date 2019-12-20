/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import htgtvieclam.models.Vieclam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author longn
 */
public class Utils {
    public static List<Vieclam> getViecLam() throws SQLException{
        List<Vieclam> cats = new ArrayList<>();
        
        Connection conn = HibernateUtils.getConn();
        Statement stm = conn.createStatement();
        
        ResultSet rs = stm.executeQuery("SELECT * FROM Vieclam");
        while (rs.next()) {
            int idvieclam = rs.getInt("idvieclam");
            String tenvieclam = rs.getString("tenvieclam");
            String vitri = rs.getString("vitri");
            int luong = rs.getInt("luong");
            String diachi = rs.getString("diachi");
            
            
            Vieclam cat = new Vieclam(idvieclam, tenvieclam,vitri,luong,diachi);
            cats.add(cat);
        }
        
        return cats;
    }
}
