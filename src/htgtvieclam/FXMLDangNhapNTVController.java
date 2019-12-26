/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BTS4LIFE
 */
public class FXMLDangNhapNTVController implements Initializable {
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
        Connection conn = HibernateUtils.getConn();
        Statement stm = conn.createStatement();
        
        ResultSet rs = stm.executeQuery("select * from taikhoan");
        while (rs.next()){
            String tendangnhap = rs.getString("tedangnhap");
            String matkhau = rs.getString("matkhau");
            String loainguoidung = rs.getString("loainguoidung");
            
            if (this.txttendangnhap.toString() == tendangnhap && this.txtmatkhau.toString() == matkhau && loainguoidung == "Người tìm việc"){
                Parent root = FXMLLoader.load(getClass().getResource("FXMLQuestionManagement.fxml"));
                Scene scene = new Scene(root);

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }
        }
        
    }
}
