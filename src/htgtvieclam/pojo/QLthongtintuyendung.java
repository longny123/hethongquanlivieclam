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
@Table(name = "qlthongtintuyendung")
public class QLthongtintuyendung implements Serializable{
    @Id
    @Column(name = "idvieclam")
    private String idvieclam;
    @Id
    @Column(name = "idnhatuyendung")
    private int idnhatuyendung;
    @Column(name = "ngaydangki")
    private Date ngaydangki;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idnhatuyendung")
    private Nhatuyendung nhatuyendung;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idvieclam")
    private Vieclam vieclam;
    
    public QLthongtintuyendung(){}
    
    public QLthongtintuyendung(String idvl, int idntd, Date ngaydk){
        this.idvieclam = idvl;
        this.idnhatuyendung = idntd;
        this.ngaydangki = ngaydk;
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
     * @return the ngaydangki
     */
    public Date getNgaydangki() {
        return ngaydangki;
    }

    /**
     * @param ngaydangki the ngaydangki to set
     */
    public void setNgaydangki(Date ngaydangki) {
        this.ngaydangki = ngaydangki;
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

    /**
     * @return the vieclam
     */
    public Vieclam getVieclam() {
        return vieclam;
    }

    /**
     * @param vieclam the vieclam to set
     */
    public void setVieclam(Vieclam vieclam) {
        this.vieclam = vieclam;
    }
}
