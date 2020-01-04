/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam.pojo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author longn
 */
@Entity
@Table(name = "taikhoan")
public class Taikhoan implements Serializable {
    @Id
    @Column(name = "tendangnhap")
    private String tendangnhap;
    @Column(name = "matkhau")
    private String matkhau;
    @Column(name = "loainguoidung")
    private String loainguoidung;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tendangnhap")
    private Nguoitimviec nguoitimviec;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tendangnhap")
    private Nhatuyendung nhatuyendung;
    
    public Taikhoan(String tendangnhap, String matkhau, String loainguuoidung){
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.loainguoidung = loainguoidung;
    }

    /**
     * @return the tendangnhap
     */
    public String getTendangnhap() {
        return tendangnhap;
    }

    /**
     * @param tendangnhap the tendangnhap to set
     */
    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    /**
     * @return the matkhau
     */
    public String getMatkhau() {
        return matkhau;
    }

    /**
     * @param matkhau the matkhau to set
     */
    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    /**
     * @return the loainguoidung
     */
    public String getLoainguoidung() {
        return loainguoidung;
    }

    /**
     * @param loainguoidung the loainguoidung to set
     */
    public void setLoainguoidung(String loainguoidung) {
        this.loainguoidung = loainguoidung;
    }

    /**
     * @return the nguoitimviec
     */
    public Nguoitimviec getNguoitimviec() {
        return nguoitimviec;
    }

    /**
     * @param nguoitimviec the nguoitimviec to set
     */
    public void setNguoitimviec(Nguoitimviec nguoitimviec) {
        this.nguoitimviec = nguoitimviec;
    }

    /**
     * @return the nhatuyendung
     */
    public Nhatuyendung getNhatuyendung() {
        return nhatuyendung;
    }

    /**
     * @param nhatuyendung the nhatuyendung to set
     */
    public void setNhatuyendung(Nhatuyendung nhatuyendung) {
        this.nhatuyendung = nhatuyendung;
    }
}
