/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import htgtvieclam.pojo.Taikhoan;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXMLDangKyNTVController implements Initializable {
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
    private TextField txthoten;
    @FXML
    private TextField txtsdt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void quayLaiDangKy(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDangKy.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        
        Image image = new Image("htgtvieclam/icon/app_icon.png");
        
        stage.getIcons().add(image);        
        stage.setTitle("Hệ thống giới thiệu việc làm");        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest((WindowEvent we) -> {
            we.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Thông báo!");
            
            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Bạn có muốn thoát không ?");
            
            ButtonType btnDongY = new ButtonType("Đồng ý");
            ButtonType btnHuy = new ButtonType("Hủy");
            
            alert.getButtonTypes().setAll(btnDongY, btnHuy);
            
            Optional<ButtonType> rs = alert.showAndWait();
            
            if (rs.get() == btnDongY) {
                stage.close();
            }
        }); 
    }
    
    public void DangKyHanler (ActionEvent event){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Taikhoan tk =  null;
        if (this.txttendangnhap.getText() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Thiếu tên đăng nhập");
            ButtonType btnDongY = new ButtonType("Đồng ý");
            alert.getButtonTypes().setAll(btnDongY);
            Optional<ButtonType> rs = alert.showAndWait();
        }
        else if (this.txtmatkhau.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Thiếu mật khẩu");
            ButtonType btnDongY = new ButtonType("Đồng ý");
            alert.getButtonTypes().setAll(btnDongY);
            Optional<ButtonType> rs = alert.showAndWait();
        }
        else if (this.txtnhaplai.getText().equals("") && txtnhaplai != txtmatkhau){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Phải nhập đúng mật khảu giống ô trên");
            ButtonType btnDongY = new ButtonType("Đồng ý");
            alert.getButtonTypes().setAll(btnDongY);
            Optional<ButtonType> rs = alert.showAndWait();
        }
        else if (this.txthoten.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Thiếu họ và tên");
            ButtonType btnDongY = new ButtonType("Đồng ý");
            alert.getButtonTypes().setAll(btnDongY);
            Optional<ButtonType> rs = alert.showAndWait();
        }
        else if (this.txtsdt.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Thiếu số điện thoại");
            ButtonType btnDongY = new ButtonType("Đồng ý");
            alert.getButtonTypes().setAll(btnDongY);
            Optional<ButtonType> rs = alert.showAndWait();
        }
        else if (this.txtmatkhau.getText() == null ? this.txtnhaplai.getText() == null : this.txtmatkhau.getText().equals(this.txtnhaplai.getText()))
        {
            try{
                tk = new Taikhoan(this.txttendangnhap.getText(),this.txtmatkhau.getText(),"Người tìm việc");
                session.save(tk);
                trans.commit();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Tạo thành công");
                alert.show();
            }
            catch (HibernateException ex){
                if (trans != null)
                    trans.rollback();;
                System.err.println(ex.getMessage());
            }
            finally{session.close();}
        }

       
    }    
    
}
