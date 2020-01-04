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
@Table(name = "qlthongtindk")
public class QLthongtindk implements Serializable{
    @Id
    @Column(name = "id_vieclam")
    private String id_vieclam;
    @Id
    @Column(name = "id_danhmuc")
    private int id_danhmuc;
    @Id
    @Column(name = "id_nguoitimvec")
    private int id_nguoitimviec;
    @Column(name = "ngaydangki")
    private Date ngaydangki;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idvieclam")
    private Vieclam vieclam;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iddanhmucnganhnghe")
    private Danhmucnganhnghe danhmucnganhnghe;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idnguoitimviec")
    private Nguoitimviec nguoitimviec;
    
    public QLthongtindk(){}
    
    public QLthongtindk(String idvl, int iddm, int idntv, Date ngaydk){
        this.id_vieclam = idvl;
        this.id_danhmuc = iddm;
        this.id_nguoitimviec = idntv;
        this.ngaydangki = ngaydk;
    }

    /**
     * @return the id_vieclam
     */
    public String getId_vieclam() {
        return id_vieclam;
    }

    /**
     * @param id_vieclam the id_vieclam to set
     */
    public void setId_vieclam(String id_vieclam) {
        this.id_vieclam = id_vieclam;
    }

    /**
     * @return the id_danhmuc
     */
    public int getId_danhmuc() {
        return id_danhmuc;
    }

    /**
     * @param id_danhmuc the id_danhmuc to set
     */
    public void setId_danhmuc(int id_danhmuc) {
        this.id_danhmuc = id_danhmuc;
    }

    /**
     * @return the id_nguoitimviec
     */
    public int getId_nguoitimviec() {
        return id_nguoitimviec;
    }

    /**
     * @param id_nguoitimviec the id_nguoitimviec to set
     */
    public void setId_nguoitimviec(int id_nguoitimviec) {
        this.id_nguoitimviec = id_nguoitimviec;
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

    /**
     * @return the danhmuc
     */
    public Danhmucnganhnghe getDanhmuc() {
        return danhmucnganhnghe;
    }

    /**
     * @param danhmuc the danhmuc to set
     */
    public void setDanhmuc(Danhmucnganhnghe danhmuc) {
        this.danhmucnganhnghe = danhmuc;
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
}
