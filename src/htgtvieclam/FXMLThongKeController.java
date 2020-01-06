/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 *
 * @author longn
 */
public class FXMLThongKeController implements Initializable{
    @FXML
    private Label lblNumOfQuestion;
    @FXML
    private StackPane pane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int num = Utils.countSoLuongDK();
        this.lblNumOfQuestion.setText(String.format("Số lượng câu hỏi: %d", num));
        
        // Ve barchart
        List cates = Utils.countSoLuongByCate();
        String[] cateName = new String[cates.size()];
        int[] numSoLg = new int[cates.size()];
        
        for (int i = 0; i < cates.size(); i++) {
            Object[] row = (Object[]) cates.get(i);
            cateName[i] = row[0].toString();
            numSoLg[i] = Integer.parseInt(row[1].toString());
        }
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Category");
        xAxis.setCategories(FXCollections.observableArrayList(cateName));
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Số lượng người đã dăng kí");
        
        BarChart bar = new BarChart(xAxis, yAxis);
        
        for (int i = 0; i < cates.size(); i++) {
            XYChart.Series series = new XYChart.Series();
            series.setName(cateName[i]);
            series.getData().add(new XYChart.Data(cateName[i], numSoLg[i]));
            bar.getData().add(series);
        }
        
        this.pane.getChildren().add(bar);
    }
}
