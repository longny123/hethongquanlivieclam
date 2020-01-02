/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam.pojo;

/**
 *
 * @author longn
 */
public class Taikhoan {
    private String tendangnhap;
    private String matkhau;
    private String loainguoidung;
    
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
}
