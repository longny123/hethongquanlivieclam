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
@Table(name ="danhmucnganhnghe")
public class Danhmucnganhnghe implements Serializable {
    @Id
    @Column(name = "iddanhmuc")
    private String iddanhmuc;
    @Column(name = "tendanhmuc")
    private String tendanhmuc;

    public Danhmucnganhnghe() {
    }
    
    public Danhmucnganhnghe(String id, String ten){
        this.iddanhmuc = id;
        this.tendanhmuc = ten;
    }

    /**
     * @return the iddanhmucnganhnghe
     */
    public String getIddanhmucnganhnghe() {
        return iddanhmuc;
    }

    /**
     * @param iddanhmucnganhnghe the iddanhmucnganhnghe to set
     */
    public void setIddanhmucnganhnghe(String iddanhmucnganhnghe) {
        this.iddanhmuc = iddanhmucnganhnghe;
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
