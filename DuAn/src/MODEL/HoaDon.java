/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

;

import java.sql.Timestamp;
import Interface.TableInterface;

/**
 *
 * @author gnaht
 */


public class HoaDon extends TableInterface {
    
    private Integer idHoaDon;
    private Integer idKhachHang;
    private Integer idNhanVien;
    private Integer idKhuyenMai;
    private double tongTien;
    private java.sql.Timestamp ngayLap;
    private String hinhThucThanhToan;
    private String trangThai;
    private String ghiChu;
    
    public Timestamp getNgayLap() {
        return ngayLap;
    }
    
    public void setNgayLap(Timestamp ngayLap) {
        this.ngayLap = ngayLap;
    }
    
    public Integer getIdHoaDon() {
        return idHoaDon;
    }
    
    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
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
    
    public Integer getIdKhuyenMai() {
        return idKhuyenMai;
    }
    
    public void setIdKhuyenMai(Integer idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }
    
    public double getTongTien() {
        return tongTien;
    }
    
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }
    
    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
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
        return idHoaDon;
    }
    
    @Override
    public String toString() {
        return String.valueOf(idHoaDon);
    }
    
}
