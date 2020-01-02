// *
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package htgtvieclam.pojo;

/**
 *
 * @author longn
 */
public class Nguoitimviec {

    
    private int idnguoitimviec;
    private String ho;
    private String ten;
    private int sdt;
    private String diachi;
    private String hocvan;
    private String kinhnghiem;
    private int tienganh;
    private int tinhoc;
    private String tendangnhap;
    
    public Nguoitimviec(int idnguoitimviec, String ho, 
            String ten, int sdt,String diachi, String hocvan, String kinhnghiem,int tienganh, int tinhoc){
        this.idnguoitimviec = idnguoitimviec;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.hocvan = hocvan;
        this.kinhnghiem = kinhnghiem;
        this.tienganh = tienganh;
        this.tinhoc = tinhoc;
    }
    
     public Nguoitimviec(int idnguoitimviec, String ho, 
            String ten, int sdt,String diachi, String hocvan, String kinhnghiem,int tienganh, int tinhoc,String tendangnhap){
        this(idnguoitimviec,ho,ten,sdt,diachi,hocvan,kinhnghiem,tienganh,tinhoc);
        this.tendangnhap = tendangnhap;
    }
    /**
     * @return the idnguoitimviec
     */
    public int getIdnguoitimviec() {
        return idnguoitimviec;
    }

    /**
     * @param idnguoitimviec the idnguoitimviec to set
     */
    public void setIdnguoitimviec(int idnguoitimviec) {
        this.idnguoitimviec = idnguoitimviec;
    }

    /**
     * @return the ho
     */
    public String getHo() {
        return ho;
    }

    /**
     * @param ho the ho to set
     */
    public void setHo(String ho) {
        this.ho = ho;
    }

    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
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
     * @return the hocvan
     */
    public String getHocvan() {
        return hocvan;
    }

    /**
     * @param hocvan the hocvan to set
     */
    public void setHocvan(String hocvan) {
        this.hocvan = hocvan;
    }

    /**
     * @return the kinhnghiem
     */
    public String getKinhnghiem() {
        return kinhnghiem;
    }

    /**
     * @param kinhnghiem the kinhnghiem to set
     */
    public void setKinhnghiem(String kinhnghiem) {
        this.kinhnghiem = kinhnghiem;
    }

    /**
     * @return the tienganh
     */
    public int getTienganh() {
        return tienganh;
    }

    /**
     * @param tienganh the tienganh to set
     */
    public void setTienganh(int tienganh) {
        this.tienganh = tienganh;
    }

    /**
     * @return the tinhoc
     */
    public int getTinhoc() {
        return tinhoc;
    }

    /**
     * @param tinhoc the tinhoc to set
     */
    public void setTinhoc(int tinhoc) {
        this.tinhoc = tinhoc;
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
