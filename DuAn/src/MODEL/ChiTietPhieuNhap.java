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
public class ChiTietPhieuNhap extends TableInterface{
    private Integer idChiTietPhieuNhap;
    private Integer idPhieuNhap;
    private Integer idSanPham;
    private Integer soLuong;
    private float giaTien;
    private float tongTien;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(Integer idChiTietPhieuNhap, Integer idPhieuNhap, Integer idSanPham, Integer soLuong, float giaTien, float tongTien) {
        this.idChiTietPhieuNhap = idChiTietPhieuNhap;
        this.idPhieuNhap = idPhieuNhap;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.tongTien = tongTien;
    }

    public Integer getIdChiTietPhieuNhap() {
        return idChiTietPhieuNhap;
    }

    public void setIdChiTietPhieuNhap(Integer idChiTietPhieuNhap) {
        this.idChiTietPhieuNhap = idChiTietPhieuNhap;
    }

    public Integer getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(Integer idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public int getId() {
        return  idChiTietPhieuNhap;
    }
    
}
