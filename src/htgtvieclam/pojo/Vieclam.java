/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam.pojo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import static org.hibernate.FetchMode.LAZY;
/**
 *
 * @author longn
 */
@Entity
@Table(name = "vieclam")
public class Vieclam implements Serializable{
    @Id
    private String idvieclam;
    @Column(name = "tenvieclam")
    private String tenvieclam;
    @Column(name = "vitri")
    private String vitri;
    @Column(name = "luong")
    private String luong;
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "ngaydang")
    private Date ngaydang;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idnhatuyendung")
    private Nhatuyendung nhatuyendung;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iddanhmuc")
    private Danhmucnganhnghe danhmucnganhnghe;
    
    public Vieclam(){}
  
    public Vieclam (String idvieclam, String ten,String luong,String diachi){
        this.idvieclam = idvieclam;
        this.tenvieclam = ten;
        this.luong = luong;
        this.diachi = diachi;
    }
    
    public Vieclam (String idvieclam, String ten, String vitri,String luong,String diachi){
        this.idvieclam = idvieclam;
        this.tenvieclam = ten;
        this.vitri = vitri;
        this.luong = luong;
        this.diachi = diachi;
    }
    
    public String getCateNameView() {
        return this.getDanhmucnganhnghe().getTendanhmuc();
    }
    /**
     * @return the idvieclam
     */
    public String getIdvieclam() {
        return idvieclam;
    }

    /**
     * @param idvieclam the idvieclam to set
     */
    public void setIdvieclam(String idvieclam) {
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
    public String getLuong() {
        return luong;
    }

    /**
     * @param luong the luong to set
     */
    public void setLuong(String luong) {
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

    /**
     * @return the qlthongtintuyendung
     */

    /**
     * @return the danhmucnganhnghe
     */
    public Danhmucnganhnghe getDanhmucnganhnghe() {
        return danhmucnganhnghe;
    }

    /**
     * @param danhmucnganhnghe the danhmucnganhnghe to set
     */
    public void setDanhmucnganhnghe(Danhmucnganhnghe danhmucnganhnghe) {
        this.danhmucnganhnghe = danhmucnganhnghe;
    }

}
