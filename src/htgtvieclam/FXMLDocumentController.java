/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author BTS4LIFE
 */
public class FXMLDocumentController implements Initializable {
    
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
}
