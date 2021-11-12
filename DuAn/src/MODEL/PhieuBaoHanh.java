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
public class PhieuBaoHanh extends TableInterface{
    private Integer idPhieuBaoHanh;
    private Integer idKhachHang;
    private Integer idNhanVien;
    private Integer idHoaDon;
    private Date ngayLap;
    private String lyDo;
    private Date thoiGianBaoTri;
    private float chiPhiBaoHanh;
    private String trangThai;
    private String ghiChu;

    public PhieuBaoHanh() {
    }

    public PhieuBaoHanh(Integer idPhieuBaoHanh, Integer idKhachHang, Integer idNhanVien, Integer idHoaDon, Date ngayLap, String lyDo, Date thoiGianBaoTri, float chiPhiBaoHanh, String trangThai, String ghiChu) {
        this.idPhieuBaoHanh = idPhieuBaoHanh;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idHoaDon = idHoaDon;
        this.ngayLap = ngayLap;
        this.lyDo = lyDo;
        this.thoiGianBaoTri = thoiGianBaoTri;
        this.chiPhiBaoHanh = chiPhiBaoHanh;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public Integer getIdPhieuBaoHanh() {
        return idPhieuBaoHanh;
    }

    public void setIdPhieuBaoHanh(Integer idPhieuBaoHanh) {
        this.idPhieuBaoHanh = idPhieuBaoHanh;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public Date getThoiGianBaoTri() {
        return thoiGianBaoTri;
    }

    public void setThoiGianBaoTri(Date thoiGianBaoTri) {
        this.thoiGianBaoTri = thoiGianBaoTri;
    }

    public float getChiPhiBaoHanh() {
        return chiPhiBaoHanh;
    }

    public void setChiPhiBaoHanh(float chiPhiBaoHanh) {
        this.chiPhiBaoHanh = chiPhiBaoHanh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public int getId() {
       return idPhieuBaoHanh;
    }
    
}
