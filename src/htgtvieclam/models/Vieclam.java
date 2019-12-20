/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam.models;

/**
 *
 * @author longn
 */
public class Vieclam {
    private int idvieclam;
    private String tenvieclam;
    private String vitri;
    private int luong;
    private String diachi;
    private int idnhatuyendung;
    private int iddangmuc;
    
    public Vieclam (int idvieclam, String ten, String vitri,int luong,String diachi){
        this.idvieclam = idvieclam;
        this.tenvieclam = ten;
        this.vitri = vitri;
        this.luong = luong;
        this.diachi = diachi;
    }
    
    public Vieclam (int idvieclam, String ten, String vitri,int luong,String diachi,int idnhatuyendung, int iddangmuc){
        this(idvieclam,ten,vitri,luong,diachi);
        this.idnhatuyendung = idnhatuyendung;
        this.iddangmuc;
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
     * @return the iddangmuc
     */
    public int getIddangmuc() {
        return iddangmuc;
    }

    /**
     * @param iddangmuc the iddangmuc to set
     */
    public void setIddangmuc(int iddangmuc) {
        this.iddangmuc = iddangmuc;
    }
}
