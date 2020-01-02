/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam.pojo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author longn
 */
@Entity
@Table(name = "vieclam")
public class Vieclam implements Serializable{
    @Id
    private int idvieclam;
    @Column(name = "tenvieclam", length = 45, nullable = false)
    private String tenvieclam;
    @Column(name = "vitri", length = 45, nullable = false)
    private String vitri;
    @Column(name = "luong", nullable = false)
    private int luong;
    @Column(name = "diachi", length = 100, nullable = false)
    private String diachi;
    @Column(name = "ngaydang")
    private Date ngaydang;
    @Id
    private int idnhatuyendung;
    @Id
    private Danhmucnganhnghe danhmucnganhnghe;
    
    public Vieclam(){}
  
    
    public Vieclam (int idvieclam, String ten, String vitri,int luong,String diachi){
        this.idvieclam = idvieclam;
        this.tenvieclam = ten;
        this.vitri = vitri;
        this.luong = luong;
        this.diachi = diachi;
    }
    
    public Vieclam (int idvieclam, String ten, String vitri,int luong,String diachi,int idnhatuyendung){
        this(idvieclam,ten,vitri,luong,diachi);
        this.idnhatuyendung = idnhatuyendung;
    }
    
    public String getCateNameView() {
        return this.danhmucnganhnghe.getTendanhmuc();
    }
    /**
     * @return the idvieclam
     */
    public int getIdvieclam() {
        return idvieclam;
    }

    /**
     * @param idvieclam the idvieclam to set
     */
    public void setIdvieclam(int idvieclam) {
        this.idvieclam = idvieclam;
    }

    /**
     * @return the tenvieclam
     */
    public String getTenvieclam() {
        return tenvieclam;
    }

    /**
     * @param tenvieclam the tenvieclam to set
     */
    public void setTenvieclam(String tenvieclam) {
        this.tenvieclam = tenvieclam;
    }

    /**
     * @return the vitri
     */
    public String getVitri() {
        return vitri;
    }

    /**
     * @param vitri the vitri to set
     */
    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    /**
     * @return the luong
     */
    public int getLuong() {
        return luong;
    }

    /**
     * @param luong the luong to set
     */
    public void setLuong(int luong) {
        this.luong = luong;
    }

    /**
     * @return the diachi
     */
    public String getDiachi() {
        return diachi;
    }

    /**
     * @param diachi the diachi to set
     */
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    /**
     * @return the idnhatuyendung
     */
    public int getIdnhatuyendung() {
        return idnhatuyendung;
    }

    /**
     * @param idnhatuyendung the idnhatuyendung to set
     */
    public void setIdnhatuyendung(int idnhatuyendung) {
        this.idnhatuyendung = idnhatuyendung;
    }

    /**
     * @return the ngaydang
     */
    public Date getNgaydang() {
        return ngaydang;
    }

    /**
     * @param ngaydang the ngaydang to set
     */
    public void setNgaydang(Date ngaydang) {
        this.ngaydang = ngaydang;
    }
}
