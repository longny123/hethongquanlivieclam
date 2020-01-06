/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam.pojo;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author longn
 */
@Entity
@Table(name = "qlthongtindk")
public class QLthongtindk {
    @Id
    @Column (name = "idqlthongtin")
    private int idqlthongtindk;
    @OneToMany(mappedBy = "qlthongtindk")
    private List<Nguoitimviec> idnguoitimviec;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "iddanhmuc")
    private int iddanhmuc;
    @ManyToOne(fetch = FetchType.EAGER)
    private List<Vieclam> idvieclam;
    @Column(name = "ngaydk")
    private Date ngaydk;
    
    public QLthongtindk(){}
    public QLthongtindk(int id, int iddm, Date ngay){
        this.idqlthongtindk = id;
        this.iddanhmuc = iddm;
        this.ngaydk = ngay;
    }

    /**
     * @return the idqlthongtindk
     */
    public int getIdqlthongtindk() {
        return idqlthongtindk;
    }

    /**
     * @param idqlthongtindk the idqlthongtindk to set
     */
    public void setIdqlthongtindk(int idqlthongtindk) {
        this.idqlthongtindk = idqlthongtindk;
    }

    /**
     * @return the idnguoitimviec
     */
    public List<Nguoitimviec> getIdnguoitimviec() {
        return idnguoitimviec;
    }

    /**
     * @param idnguoitimviec the idnguoitimviec to set
     */
    public void setIdnguoitimviec(List<Nguoitimviec> idnguoitimviec) {
        this.idnguoitimviec = idnguoitimviec;
    }

    /**
     * @return the iddanhmuc
     */
    public int getIddanhmuc() {
        return iddanhmuc;
    }

    /**
     * @param iddanhmuc the iddanhmuc to set
     */
    public void setIddanhmuc(int iddanhmuc) {
        this.iddanhmuc = iddanhmuc;
    }

    /**
     * @return the idvieclam
     */
    public List<Vieclam> getIdvieclam() {
        return idvieclam;
    }

    /**
     * @param idvieclam the idvieclam to set
     */
    public void setIdvieclam(List<Vieclam> idvieclam) {
        this.idvieclam = idvieclam;
    }

    /**
     * @return the ngaydk
     */
    public Date getNgaydk() {
        return ngaydk;
    }

    /**
     * @param ngaydk the ngaydk to set
     */
    public void setNgaydk(Date ngaydk) {
        this.ngaydk = ngaydk;
    }
    
}
