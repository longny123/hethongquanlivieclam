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
public class QLthongtintd implements Serializable{
    @Id
    @Column(name = "idqlthongtintd")
    private String idqlthongtintd; 
    @Column(name = "idnhatuyendung")
    private int idnhatuyendung;
    @Column(name = "idvieclam")
    private String idvieclam;
    @Column(name = "ngaydangki")
    private Date ngaydangki;

    public QLthongtintd(){}
    
    public QLthongtintd(String idtd, int idntd, String idvl ,Date ngaydk){
        this.idqlthongtintd = idtd;
        this.idnhatuyendung = idntd;
        this.idvieclam = idvl;
        this.ngaydangki = ngaydk;
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
     * @return the idqlthongtintd
     */
    public String getIdqlthongtintd() {
        return idqlthongtintd;
    }

    /**
     * @param idqlthongtintd the idqlthongtintd to set
     */
    public void setIdqlthongtintd(String idqlthongtintd) {
        this.idqlthongtintd = idqlthongtintd;
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

}
