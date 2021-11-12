/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import Interface.TableInterface;


/**
 *
 * @author gnaht
 */
public class NhaCungCap extends TableInterface{
    Integer idNhaCungCap;
    String tenNhaCungCap;
    String soDienThoai;
    String email;
    float tongMua;
    String diaChi;
    String ghiChu;

    public NhaCungCap() {
    }

    public Integer getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public NhaCungCap(Integer idNhaCungCap, String tenNhaCungCap, String soDienThoai, String email, float tongMua, String diaChi, String ghiChu) {
        this.idNhaCungCap = idNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.tongMua = tongMua;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
    }

    public void setIdNhaCungCap(Integer idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getTongMua() {
        return tongMua;
    }

    public void setTongMua(float tongMua) {
        this.tongMua = tongMua;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public int getId() {
        return idNhaCungCap;
    }
    
}
