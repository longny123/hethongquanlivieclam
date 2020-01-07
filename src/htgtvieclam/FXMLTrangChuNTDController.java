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
import org.hibernate.Session;
import htgtvieclam.HibernateUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
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
public class FXMLTrangChuNTDController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Vieclam> tvVieclam;
    @FXML
    private TextField txtTenvieclam;
    @FXML
    private TextField txtThanhpho;
    @FXML
    private TextField txtLuong;
    @FXML
    private TableColumn colTenVL;
    @FXML
    private TableColumn colLuong;
    @FXML
    private TableColumn colTinhThanh;
    @FXML
    private TableColumn colNgayDang;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//          this.txtTimviec.textProperty().addListener(et -> {
//            this.tvVieclam.getItems().clear();
//            try {
//                this.tvVieclam.setItems(FXCollections.observableArrayList(
//                        Utils.getViecLam(this.txtTimviec.getText()))
//                );
//            } catch (SQLException ex) {
//                Logger.getLogger(FXMLTrangChuNTVController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//        try {
//            getDanhMuc();
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLTrangChuNTVController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        this.colTenVL.setCellValueFactory(new PropertyValueFactory("tenvieclam"));
        this.colLuong.setCellValueFactory(new PropertyValueFactory("luong"));
        this.colTinhThanh.setCellValueFactory(new PropertyValueFactory("diachi"));
        this.colNgayDang.setCellValueFactory(new PropertyValueFactory("ngaydang"));
        this.tvVieclam.setItems(this.getVieclam(""));
//         this.txtTimviec.textProperty().addListener(p -> {
//            this.reloadTable(this.txtTimviec.getText());
//        });
    }    
    
//      private void getDanhMuc() throws SQLException{
//            List<Danhmucnganhnghe> cats = new ArrayList<>();
//
//            Connection conn = HibernateUtils.getConn();
//            Statement stm = conn.createStatement();
//
//            ResultSet rs = stm.executeQuery("SELECT * FROM danhmucnganhnghe");
//            while (rs.next()) {
//               Danhmucnganhnghe dm = new Danhmucnganhnghe(rs.getInt("iddanhmuc"),rs.getString("tendanhmuc"));
//               
//                cbDanhmuc.getItems().add(dm);
//            }
//
//    }
     
      
    public void hienThiTrangChuNTV(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLTrangChuNTV.fxml"));
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
    public void themVieclamHandler() throws ParseException
    {
        String idn  = UUID.randomUUID().toString();
        Vieclam vieclam = new Vieclam(idn, this.txtTenvieclam.getText(), this.txtLuong.getText(), this.txtThanhpho.getText());
        
        if (Utils.addorUpdateVieclam(vieclam) == true)
        {
            reloadTable("");
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Thêm độc giả thành công");
            a.show();
        }
        else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Thêm độc giả thất bại");
            a.show();
        }      
    }
}
