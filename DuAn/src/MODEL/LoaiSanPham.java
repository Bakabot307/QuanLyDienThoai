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
public class LoaiSanPham extends TableInterface{
    Integer idLoaiSanPham;
    String tenLoaiSanPham;

    public LoaiSanPham() {
    }

    public LoaiSanPham(Integer idLoaiSanPham, String tenLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public Integer getIdLoaiSanPham() {
        return idLoaiSanPham;
    }

    public void setIdLoaiSanPham(Integer idLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    @Override
    public int getId() {
        return idLoaiSanPham;
    }
    
}
