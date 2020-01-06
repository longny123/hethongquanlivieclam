/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author longn
 */
@Entity
@Table(name = "nhatuyendung")
public class Nhatuyendung implements Serializable {
    @Id
    @Column(name = "idnhatuyendung")
    private int idnhatuyendung;
    @Column(name = "tennhatuyendung")
    private String tennhatuyendung;
    @Column(name = "sdt")
    private int sdt;
    @OneToMany(mappedBy = "nhatuyendung")
    private List<Vieclam> vieclam;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tendangnhap")
    private Taikhoan taikhoan;
    
    public Nhatuyendung(int id, String ten, int sdt){
        this.idnhatuyendung = id;
        this.tennhatuyendung = ten;
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return this.tennhatuyendung; //To change body of generated methods, choose Tools | Templates.
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
     * @return the vieclam
     */
    public List<Vieclam> getVieclam() {
        return vieclam;
    }

    /**
     * @param vieclam the vieclam to set
     */
    public void setVieclam(List<Vieclam> vieclam) {
        this.vieclam = vieclam;
    }

    /**
     * @return the taikhoan
     */
    public Taikhoan getTaikhoan() {
        return taikhoan;
    }

    /**
     * @param taikhoan the taikhoan to set
     */
    public void setTaikhoan(Taikhoan taikhoan) {
        this.taikhoan = taikhoan;
    }
}
