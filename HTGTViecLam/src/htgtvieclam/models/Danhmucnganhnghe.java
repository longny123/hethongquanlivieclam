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
public class Danhmucnganhnghe {
    private int iddanhmucnganhnghe;
    private String tendanhmuc;
    
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
