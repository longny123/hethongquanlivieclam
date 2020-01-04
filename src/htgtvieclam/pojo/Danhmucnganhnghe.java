/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htgtvieclam.pojo;

import javax.persistence.*;

/**
 *
 * @author longn
 */
@Entity
@Table(name = "danhmucnganhnghe")
public class Danhmucnganhnghe {
    @Id
    @Column(name = "iddanhmucnganhnghe")
    private int iddanhmucnganhnghe;
    @Column(name = "tendanhmuc")
    private String tendanhmuc;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_danhmuc")
    private QLthongtindk qlthongtindk;
    
    public Danhmucnganhnghe(int id, String ten){
        this.iddanhmucnganhnghe = id;
        this.tendanhmuc = ten;
    }

    /**
     * @return the iddanhmucnganhnghe
     */
    public int getIddanhmucnganhnghe() {
        return iddanhmucnganhnghe;
    }

    /**
     * @param iddanhmucnganhnghe the iddanhmucnganhnghe to set
     */
    public void setIddanhmucnganhnghe(int iddanhmucnganhnghe) {
        this.iddanhmucnganhnghe = iddanhmucnganhnghe;
    }

    /**
     * @return the tendanhmuc
     */
    public String getTendanhmuc() {
        return tendanhmuc;
    }

    /**
     * @param tendanhmuc the tendanhmuc to set
     */
    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    @Override
    public String toString() {
        return this.tendanhmuc; //To change body of generated methods, choose Tools | Templates.
    }
    
}
