/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import htgtvieclam.pojo.Taikhoan;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLDangKyNTDController implements Initializable {
    private static SessionFactory factory;
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txttendangnhap;
    @FXML
    private TextField txtmatkhau;
    @FXML
    private TextField txtnhaplai;
    @FXML
    private TextField txttencongty;
    @FXML
    private TextField txtthanhpho;
    @FXML
    private TextField txttenlienhe;
    @FXML
    private TextField txtsdt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void DangKyHanler (ActionEvent event){

        Session session = factory.openSession();
        Transaction trans = null;
        
        Taikhoan tk;
        Alert alert = null;
        if (this.txtmatkhau.getText() == null ? this.txtnhaplai.getText() == null : this.txtmatkhau.getText().equals(this.txtnhaplai.getText()))
        {
            try{
                trans = session.beginTransaction();
                tk = new Taikhoan(this.txttendangnhap.getText(),this.txtmatkhau.getText(),"Nhà tuyển dụng");
                session.save(tk);
                trans.commit();
            }
            catch (HibernateException ex){
                if (trans != null)
                    trans.rollback();;
                System.err.println(ex.getMessage());
            }
            finally{session.close();}
        }
        else if (txttendangnhap.getText() == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Thiếu tên đăng nhập");
        }
        else if (txtmatkhau.getText() == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Thiếu mật khẩu");
        }
        else if (txtnhaplai.getText() == null && txtnhaplai != txtmatkhau){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("phải nhập đúng mật khảu giống ô trên");
        }
        else if (txttencongty.getText() == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Thiếu tên công ty");
        }
        else if (txttenlienhe.getText() == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Thiếu tên liên hệ");
        }
        else if (txtthanhpho.getText() == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Thiếu thành phố");
        }
        else if (txtsdt.getText() == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Thiếu số điện thoại");
        }
    }

}      

            

