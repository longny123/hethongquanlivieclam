/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;


import htgtvieclam.pojo.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author longn
 */
public class HibernateUtils {
    
    private static SessionFactory factory;
    
    static {
        Configuration configure = new Configuration();
        configure.configure("hibernate.cfg.xml");
        configure.addAnnotatedClass(Taikhoan.class);
        configure.addAnnotatedClass(Vieclam.class);
        configure.addAnnotatedClass(Danhmucnganhnghe.class);
        configure.addAnnotatedClass(Nguoitimviec.class);
        configure.addAnnotatedClass(Nhatuyendung.class);
        configure.addAnnotatedClass(QLthongtindk.class);
        configure.addAnnotatedClass(QLthongtintd.class);
        StandardServiceRegistryBuilder builder
            = new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
        factory = configure.buildSessionFactory(builder.build());
} 
    
    public static SessionFactory getSessionFactory(){
        return factory;
    }
}
