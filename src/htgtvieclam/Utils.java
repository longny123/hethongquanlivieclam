/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import htgtvieclam.pojo.Danhmucnganhnghe;
import htgtvieclam.pojo.Nguoitimviec;
import htgtvieclam.pojo.Taikhoan;
import htgtvieclam.pojo.Vieclam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale.Category;
import java.util.UUID;
import javafx.scene.control.Alert;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author longn
 */
public class Utils {
    
    private static SessionFactory factory = HibernateUtils.getSessionFactory();
    
    public static List<Vieclam> getVieclam() {
        return getVieclam("");
    }
    
    public static List<Vieclam> getVieclam(String kw) {
        Session session = factory.openSession();
                
        Criteria cr = session.createCriteria(Vieclam.class);
        
        if (!kw.isEmpty()) {
            Criterion c1= Restrictions.ilike("tenvieclam", String.format("%%%s%%", kw));
            Criterion c2 = Restrictions.ilike("vitri", String.format("%%%s%%", kw));
            Criterion c3 = Restrictions.gt("luong","10000");
            Criterion c4 = Restrictions.ilike("diachi", String.format("%%%s%%", kw));
            cr.add(Restrictions.or(c1, c2, c3, c4));
            //cr.add(Restrictions.ilike("content", String.format("%%%s%%", kw)));
            
//            Criteria cr2 = cr.createCriteria("category");
//            cr2.add(Restrictions.ilike("name", String.format("%%%s%%", kw)));
        }
        
        List<Vieclam> vieclam = cr.list();
        
        session.close();
        
        return vieclam;
    }
//    public static List<Vieclam> getViecLam() throws ClassNotFoundException,SQLException{
//        List<Vieclam> cats = new ArrayList<>();
//        
//        Connection conn = HibernateUtils.getConn();
//        Statement stm = conn.createStatement();
//        
//        ResultSet rs = stm.executeQuery("SELECT * FROM Vieclam");
//        while (rs.next()) {
//            int idvieclam = rs.getInt("idvieclam");
//            String tenvieclam = rs.getString("tenvieclam");
//            String vitri = rs.getString("vitri");
//            int luong = rs.getInt("luong");
//            String diachi = rs.getString("diachi");
//            
//            
//            Vieclam cat = new Vieclam(idvieclam, tenvieclam,vitri,luong,diachi);
//            cats.add(cat);
//        }
//        
//        return cats;
//    }
//    
//      public static void addViecLam(Vieclam vl) throws ClassNotFoundException, SQLException {
//        Connection conn = HibernateUtils.getConn();
//        conn.setAutoCommit(false);
//        
//        // Thêm việc làm
//        String question_id = UUID.randomUUID().toString();
//        String sql = "INSERT INTO vieclam(idvieclam, tenvieclam, vitri, luong, diachi,id_danhmuc) VALUES(?, ?, ?, ?, ?, ?)";
//        
//        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setString(1, question_id);
//        stm.setString(2, vl.getTenvieclam());
//        stm.setString(3, vl.getVitri());
//        stm.setInt(4, vl.getLuong());
//        stm.setString(5,vl.getDiachi());
//        stm.setInt(6, vl.getIddanhmuc());
//        
//        stm.executeUpdate();
//        
//        conn.commit();
//      }
//      
//      public static void addTaiKhoan(Taikhoan tk) throws ClassNotFoundException, SQLException {
//        Connection conn = HibernateUtils.getConn();
//        conn.setAutoCommit(false);
//        
//        // Thêm tài khoản mới
//        String sql = "INSERT INTO vieclam(tendangnhap, matkhau, loainguoidung) VALUES(?, ?, ?)";
//        
//        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setString(1, tk.getTendangnhap());
//        stm.setString(2, tk.getMatkhau());
//        stm.setString(3, tk.getLoainguoidung());
//
//        
//        stm.executeUpdate();
//        
//        conn.commit();
//      }
//      
//      public static void addNguoiTimViec(Nguoitimviec ntv) throws ClassNotFoundException, SQLException {
//        Connection conn = HibernateUtils.getConn();
//        conn.setAutoCommit(false);
//        
//        // Thêm thông tin người tìm việc
//        String idnguoitimviec = UUID.randomUUID().toString();
//        String sql = "INSERT INTO nguoitimviec(idnguoitimviec, ho, ten, sdt, diachi, hocvan, kinhnghiem, tienganh, tinhoc) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        
//        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setString(1, idnguoitimviec);
//        stm.setString(2, ntv.getHo());
//        stm.setString(3, ntv.getTen());
//        stm.setInt(4, ntv.getSdt());
//        stm.setString(5, ntv.getDiachi());
//        stm.setString(6, ntv.getHocvan());
//        stm.setString(7, ntv.getKinhnghiem());
//        stm.setInt(8, ntv.getTienganh());
//        stm.setInt(8, ntv.getTinhoc());
//        
//        stm.executeUpdate();
//        
//        conn.commit();
//      }
//      
//       public static void addDanhMuc(Danhmucnganhnghe dm) throws ClassNotFoundException, SQLException {
//        Connection conn = HibernateUtils.getConn();
//        conn.setAutoCommit(false);
//        
//        // Thêm danh mục mới
//        String iddanhmucnganhnghe = UUID.randomUUID().toString();
//        String sql = "INSERT INTO vieclam(tendangnhap, matkhau, loainguoidung) VALUES(?, ?, ?)";
//        
//        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setString(1, iddanhmucnganhnghe);
//        stm.setString(2, dm.getTendanhmuc());
//       
//        stm.executeUpdate();
//        
//        conn.commit();
//       }
//        public static List<Vieclam> getViecLam(String kw) throws SQLException {
//        Connection conn = HibernateUtils.getConn();
//        String sql = "SELECT * FROM vieclam";
//        
//        if (kw.equals("") == false) {
//            sql += " WHERE content like ?";
//        }
//          
//        PreparedStatement stm = conn.prepareStatement(sql);
//        if (kw.equals("") == false)
//            stm.setString(1, "%%"+kw+"%%");
//        
//        ResultSet rs = stm.executeQuery();
//        
//        List<Vieclam> r = new ArrayList<>();
//        while (rs.next()) {
//            Vieclam q = new Vieclam(rs.getInt("idvieclam"), 
//                    rs.getString("ten"), rs.getString("vitri"),rs.getInt("luong"),rs.getString("Diachi"));
//            r.add(q);
//        }
//        
//        return r;
//    }
      
        public static List<Danhmucnganhnghe> getCategories() {
        Session session = factory.openSession();
                
        Criteria cr = session.createCriteria(Category.class);
        List<Danhmucnganhnghe> categories = cr.list();
        
        session.close();
        
        return categories;
    }
     
        public static boolean addorUpdateVieclam(Vieclam vieclam) {
        Session session = factory.openSession();
        
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
        
            session.saveOrUpdate(vieclam);
            
            trans.commit();
        } catch (Exception ex) {
            if (trans != null)
                trans.rollback();
            
            return false;
        } finally {
            session.close();
        }
        
        return true;
    }
        
       public static boolean deleteQuestion(Vieclam vl) {
       Session session = factory.openSession();
       try {
           session.beginTransaction();
            session.delete(vl);
            session.getTransaction().commit();
            
            return true;
       } catch (Exception ex) {
           session.getTransaction().rollback();
           return false;
       }
   }
       
       public static Alert getAlert(String content, Alert.AlertType type) {
        Alert a = new Alert(type);
        a.setContentText(content);
        
        return a;
    }
}
