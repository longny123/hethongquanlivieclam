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
public class Nhatuyendung {
    private int idnhatuyendung;
    private String tennhatuyendung;
    private int sdt;
    private String tendangnhap;
    
    public Nhatuyendung(int id, String ten, int sdt){
        this.idnhatuyendung = id;
        this.tennhatuyendung = ten;
        this.sdt = sdt;
    }
    
     public Nhatuyendung(int id, String ten, int sdt,String tendangnhap){
        this(id,ten,sdt);
        this.tendangnhap = tendangnhap;
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
     * @return the tennhatuyendung
     */
    public String getTennhatuyendung() {
        return tennhatuyendung;
    }

    /**
     * @param tennhatuyendung the tennhatuyendung to set
     */
    public void setTennhatuyendung(String tennhatuyendung) {
        this.tennhatuyendung = tennhatuyendung;
    }

    /**
     * @return the sdt
     */
    public int getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(int sdt) {
        this.sdt = sdt;
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
}
