/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.ChiTietSanPham;
import java.util.List;

/**
 *
 * @author gnaht
 */
public class ChiTietSanPhamDAO extends AbsDAO<ChiTietSanPham> {

    public List<Object[]> loadLaiDS(int idSanPham) {
        String selectSql = "select idChiTietSanPham,SanPham.idSanPham ,DungLuong,MauSac,HangSanXuat,chitietsanpham.soLuong from ChiTietSanPham join SanPham on ChiTietSanPham.idSanPham = SanPham.idSanPham where SanPham.idSanPham = ? order by chitietSanPham.soLuong DESC ";
        List<Object[]> data = getRawValues(selectSql, idSanPham);
        return data;
    }

    public void them(String dungLuong, int idSanPham, String mauSac, String hangSx, int soLuong) {
        String cauLenhThemNguoiDung = "insert into ChiTietSanPham  values ( ?, ?, ?,?,?)";
        DBConnection.executeUpdate(cauLenhThemNguoiDung, dungLuong, idSanPham, mauSac, hangSx,soLuong);

    }
        public void editSoLuong (int soLuong, int idSanPham){
    String cauLenhEdit = "UPDATE SanPham\n" +
"   SET \n" +
"SoLuong = ?\n" +
"      \n" +
" WHERE idSanPham = ?";
    DBConnection.executeUpdate(cauLenhEdit, soLuong,idSanPham);
    }

    }
