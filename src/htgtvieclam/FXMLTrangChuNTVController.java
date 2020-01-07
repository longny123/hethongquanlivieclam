/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import htgtvieclam.pojo.Danhmucnganhnghe;
import htgtvieclam.pojo.Vieclam;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
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
import org.hibernate.Session;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
    @FXML
    private TableColumn colTenVL;
    @FXML
    private TableColumn colNhaTuyenDung;
    @FXML
    private TableColumn colLuong;
    @FXML
    private TableColumn colTinhThanh;
    @FXML
    private TableColumn colNgayDang;
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {

        this.colTenVL.setCellValueFactory(new PropertyValueFactory("tenvieclam"));
        this.colNhaTuyenDung.setCellValueFactory(new PropertyValueFactory("id_nhatuyendung"));
        this.colLuong.setCellValueFactory(new PropertyValueFactory("luong"));
        this.colTinhThanh.setCellValueFactory(new PropertyValueFactory("diachi"));
        this.colNgayDang.setCellValueFactory(new PropertyValueFactory("ngaydang"));
        this.tvVieclam.setItems(this.getVieclam(""));
         this.txtTimviec.textProperty().addListener(p -> {
            this.reloadTable(this.txtTimviec.getText());
        });
    }    
     
      
    public void hienThiTrangChuNTD(ActionEvent event) throws IOException {   
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDangNhapNTD.fxml"));
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
    
    public void hienThiDangNhap(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDangNhap.fxml"));
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
    
    public void hienThiDangKi(ActionEvent event) throws IOException {
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

    private ObservableList<Vieclam> getVieclam(String kw){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Vieclam.class);
        cr.addOrder(Order.desc("tenvieclam"));
        if(kw != null && !kw.equals("")){
            kw = String.format("%%%s%%", kw);
         cr.add(Restrictions.ilike("tenvieclam",kw));
    }
        List<Vieclam> vieclam = cr.list();
        session.close();
        
        return FXCollections.observableArrayList(vieclam);
        
    }
    private void reloadTable(String kw){
            this.tvVieclam.getItems().clear();
            this.tvVieclam.setItems(this.getVieclam(kw));
        }
}
