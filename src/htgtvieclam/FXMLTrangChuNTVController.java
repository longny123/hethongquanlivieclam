/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import htgtvieclam.models.Danhmucnganhnghe;
import htgtvieclam.models.Vieclam;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author BTS4LIFE
 */
public class FXMLTrangChuNTVController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Vieclam> tvVieclam;
    @FXML
    private TextField txtTimviec;
    @FXML
    private ComboBox <Danhmucnganhnghe> cbDanhmuc;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          this.txtTimviec.textProperty().addListener(et -> {
            this.tvVieclam.getItems().clear();
            try {
                this.tvVieclam.setItems(FXCollections.observableArrayList(
                        Utils.getViecLam(this.txtTimviec.getText()))
                );
            } catch (SQLException ex) {
                Logger.getLogger(FXMLTrangChuNTVController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        try {
            getDanhMuc();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTrangChuNTVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
      private void getDanhMuc() throws SQLException{
            List<Danhmucnganhnghe> cats = new ArrayList<>();

            Connection conn = HibernateUtils.getConn();
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM danhmucnganhnghe");
            while (rs.next()) {
               Danhmucnganhnghe dm = new Danhmucnganhnghe(rs.getInt("iddanhmuc"),rs.getString("tendanhmuc"));
               
                cbDanhmuc.getItems().add(dm);
            }

    }
      
    public void hienThiTrangChuNTD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDangKi.fxml"));
        Stage stage = new Stage();
        
        Scene scene = new Scene(root);
        
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
}
