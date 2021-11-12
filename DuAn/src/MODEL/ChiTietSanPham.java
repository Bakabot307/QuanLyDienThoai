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
public class ChiTietSanPham extends TableInterface {
    Integer idChiTietSanPham;
    Integer idSanPham;
    String MauSac;
    String HangSanXuat;
    Integer DungLuong;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(Integer idChiTietSanPham, Integer idSanPham, String MauSac, String HangSanXuat, Integer DungLuong) {
        this.idChiTietSanPham = idChiTietSanPham;
        this.idSanPham = idSanPham;
        this.MauSac = MauSac;
        this.HangSanXuat = HangSanXuat;
        this.DungLuong = DungLuong;
    }

    public Integer getIdChiTietSanPham() {
        return idChiTietSanPham;
    }

    public void setIdChiTietSanPham(Integer idChiTietSanPham) {
        this.idChiTietSanPham = idChiTietSanPham;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getHangSanXuat() {
        return HangSanXuat;
    }

    public void setHangSanXuat(String HangSanXuat) {
        this.HangSanXuat = HangSanXuat;
    }

    public Integer getDungLuong() {
        return DungLuong;
    }

    public void setDungLuong(Integer DungLuong) {
        this.DungLuong = DungLuong;
    }

    @Override
    public int getId() {
        return idChiTietSanPham;
    }
    
}
