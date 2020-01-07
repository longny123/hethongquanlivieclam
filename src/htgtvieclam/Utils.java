/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import htgtvieclam.pojo.Danhmucnganhnghe;
import htgtvieclam.pojo.QLthongtindk;
import htgtvieclam.pojo.Vieclam;
import java.util.List;
import javafx.scene.control.Alert;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
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

      
        public static List<Danhmucnganhnghe> getCategories() {
        Session session = factory.openSession();
                
        Criteria cr = session.createCriteria(Danhmucnganhnghe.class);
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
        
       public static boolean deleteVieclam(Vieclam vl) {
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
       
       public static int countSoLuongDK() {
        Session session = factory.openSession();
        
        Criteria cr = session.createCriteria(QLthongtindk.class);
        cr.setProjection(Projections.count("id_nguoitimviec"));
        List rs = cr.list();
        
        session.close();
        
        return Integer.parseInt(rs.get(0).toString()) ;
    }
       
        public static List countSoLuongByCate() {
        Session session = factory.openSession();
        
        Criteria cr = session.createCriteria(QLthongtindk.class);
        cr.createAlias("qlthongtindk", "ql");
        
        cr.setProjection(Projections.projectionList()
                                    .add(Projections.groupProperty("idnguoitimviec"))
                                    .add(Projections.count("ql.idnguoitimviec")));
        List kq = cr.list();
        session.close();
        
        return kq;
    }
}
