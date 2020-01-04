/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author BTS4LIFE
 */
public class FXMLDangNhapController implements Initializable {
    
    @FXML
    private Button btnQtv;
    @FXML
    private Button btnNtv;
    @FXML
    private Button btnNtd;
    @FXML
    private Text txtQtv;
    @FXML
    private Text txtNtv;
    @FXML
    private Text txtNtd;
    
    @FXML
    private void btnqtvOnMouseEnteredHandler(MouseEvent e) {
        txtQtv.setFill(Color.RED);
        txtQtv.setStrokeWidth(0);
    }
    
    @FXML
    private void btnqtvOnMouseExiteddHandler(MouseEvent e) {
        txtQtv.setFill(Color.BLUE);
        txtQtv.setStroke(Color.BLACK);
        txtQtv.setStrokeWidth(0.8);
    }
    
    @FXML
    private void btnntvMouseEnteredHandler(MouseEvent e) {
        txtNtv.setFill(Color.RED);
        txtNtv.setStrokeWidth(0);
    }
    
    @FXML
    private void btnntvOnMouseExiteddHandler(MouseEvent e) {
        txtNtv.setFill(Color.BLUE);
        txtNtv.setStroke(Color.BLACK);
        txtNtv.setStrokeWidth(0.8);
    }
    
    @FXML
    private void btnntdOnMouseEnteredHandler(MouseEvent e) {
        txtNtd.setFill(Color.RED);
        txtNtd.setStrokeWidth(0);
    }
    
    @FXML
    private void btnntdvOnMouseExiteddHandler(MouseEvent e) {
        txtNtd.setFill(Color.BLUE);
        txtNtd.setStroke(Color.BLACK);
        txtNtd.setStrokeWidth(0.8);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    public void hienThiTrangChuNTV(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLTrangChuNTV.fxml"));
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
    
    public void hienThiTrangChuNTD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLTrangChuNTD.fxml"));
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
    
    public void hienThiDangNhapAdmin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDangNhapAdmin.fxml"));
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
    
    public void hienThiDangNhapNTV(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDangNhapNTV.fxml"));
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
    
    public void hienThiDangNhapNTD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDangNhapNTD.fxml"));
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
