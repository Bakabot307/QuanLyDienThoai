/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.ChiTietHoaDon;
import java.util.Date;

/**
 *
 * @author gnaht
 */
public class ChiTietHoaDonDAO extends AbsDAO<ChiTietHoaDon>{
     public void themHD(int idSanPham, int idHoaDon, String TenSanPham, int SoLuong, Double Gia, Double TongTien) {
        String cauLenhThem = "insert into ChiTietHoaDon values (?,?,?,?,?,?,?,?)";
        DBConnection.executeUpdate(cauLenhThem, idSanPham, idHoaDon, TenSanPham, SoLuong, Gia, TongTien);
    }
}
