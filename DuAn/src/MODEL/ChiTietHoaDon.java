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
public class ChiTietHoaDon extends TableInterface {
    private Integer idChiTietHoaDon;
    private Integer idSanPham;
    private Integer idHoaDon;
    private String tenSanPham;
    private Integer soLuong;
    private float gia;
    private float tongTien;
 

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(Integer idChiTietHoaDon, Integer idSanPham, Integer idHoaDon, String tenSanPham, Integer soLuong, float gia, float tongTien, String ghiChu) {
        this.idChiTietHoaDon = idChiTietHoaDon;
        this.idSanPham = idSanPham;
        this.idHoaDon = idHoaDon;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tongTien = tongTien;
    }

    public Integer getIdChiTietHoaDon() {
        return idChiTietHoaDon;
    }

    public void setIdChiTietHoaDon(Integer idChiTietHoaDon) {
        this.idChiTietHoaDon = idChiTietHoaDon;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

  

    @Override
    public int getId() {
        return idChiTietHoaDon;
    }
    
}
