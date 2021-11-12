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
public class PhieuNhap extends TableInterface {

    private Integer idPhieuNhap;
    private Integer idNhaCungCap;
    private java.sql.Timestamp ngayNhap;
    private float tongTien;
    private Integer soLuong;
    private String trangThai;

    public PhieuNhap() {
    }

    public Integer getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(Integer idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public Integer getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(Integer idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int getId() {
        return idPhieuNhap;
    }

}
