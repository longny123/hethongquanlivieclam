/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class HTGTViecLam extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        Image image = new Image("htgtvieclam/icon/app_icon.png");
        
        stage.getIcons().add(image);        
        stage.setTitle("Hệ thống giới thiệu việc làm");        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest((WindowEvent we) -> {
            we.consume();
            Alert alert = new Alert(AlertType.CONFIRMATION);
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
