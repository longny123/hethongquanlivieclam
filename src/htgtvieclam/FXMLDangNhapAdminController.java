/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import htgtvieclam.pojo.Taikhoan;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author BTS4LIFE
 */
public class FXMLDangNhapAdminController implements Initializable {
    private static SessionFactory factory;
    @FXML
    private TextField txttendangnhap;
    @FXML
    private TextField txtmatkhau;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void DangNhapHandler(ActionEvent event) throws SQLException, IOException{
        Session session = factory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            Query q = session.createQuery("from taikhoan");
            List taikhoan = q.list();
            Iterator iterator = taikhoan.iterator();
            while (iterator.hasNext()){
                    Taikhoan tk = (Taikhoan)iterator.next();
                    if (this.txttendangnhap.toString() == tk.getTendangnhap() && this.txtmatkhau.toString() == tk.getMatkhau() && tk.getLoainguoidung() == "admin"){
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLTrangchuNTV.fxml"));
                    Scene scene = new Scene(root);

                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }
            }
       }
        catch (HibernateException ex){
                if (trans != null)
                    trans.rollback();;
                System.err.println(ex.getMessage());
            }
            finally{session.close();}
        
//        ResultSet rs = stm.executeQuery("select * from taikhoan");
//        while (rs.next()){
//            String tendangnhap = rs.getString("tedangnhap");
//            String matkhau = rs.getString("matkhau");
//            String loainguoidung = rs.getString("loainguoidung");
//            
//            if (this.txttendangnhap.toString() == tendangnhap && this.txtmatkhau.toString() == matkhau && loainguoidung == "admin"){
//                Parent root = FXMLLoader.load(getClass().getResource("FXMLQuestionManagement.fxml"));
//                Scene scene = new Scene(root);
//
//                Stage stage = new Stage();
//                stage.setScene(scene);
//                stage.show();
//            }
//        }
        
    }
}
