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

/**
 *
 * @author vanbi
 */
public class SanPham extends TableInterface{
    private Integer idSanPham;
    private Integer idLoaiSanPham;
    private String TenSanPham;
    private float GiaNhap;
    private float GiaBan;
    private Integer SoLuong;
    private String DVT;

    public SanPham() {
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

 


    public Integer getIdLoaiSanPham() {
        return idLoaiSanPham;
    }

    public void setIdLoaiSanPham(Integer idLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    @Override
    public int getId() {
        return idSanPham;
    }

    @Override
    public String getIdName() {
        return "TenSanPham"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableName() {
        return "Sản Phẩm"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return TenSanPham; //To change body of generated methods, choose Tools | Templates.
    }
    
}
