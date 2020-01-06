/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import htgtvieclam.pojo.Danhmucnganhnghe;
import htgtvieclam.pojo.Vieclam;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * FXML Controller class
 *
 * @author BTS4LIFE
 */
public class FXMLAdmin_NTDController implements Initializable {
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
//    public void XoaHandler(){
//         if (Utils.deleteVieclam(docgia) == true) {
//                loadDocGia(Utils.getDocGia());
//                
//            } else {
//                mess = "Lỗi xóa độc giả";
//            }
//    }
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
