/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import Interface.TableInterface;
import java.util.Date;

/**
 *
 * @author gnaht
 */
public class NhanVien extends TableInterface{
    private Integer idNhanVien;
    private String tenNhanVien;
    private String diaChi;
    private String CMND;
    private String soDienThoai;
    private Date ngayVaoLam;
    private Integer lv;
    private String gioiTinh;
    private String trangThai;
    private String email;

    public NhanVien() {
    }

    public NhanVien(Integer idNhanVien, String tenNhanVien, String diaChi, String CMND, String soDienThoai, Date ngayVaoLam, Integer lv, String gioiTinh, String trangThai, String email) {
        this.idNhanVien = idNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.diaChi = diaChi;
        this.CMND = CMND;
        this.soDienThoai = soDienThoai;
        this.ngayVaoLam = ngayVaoLam;
        this.lv = lv;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
        this.email = email;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public Integer getLv() {
        return lv;
    }

    public void setLv(Integer lv) {
        this.lv = lv;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getId() {
       return idNhanVien;
    }
    
}
