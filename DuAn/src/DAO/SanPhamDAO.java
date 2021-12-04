/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Admin
 */
public class SanPhamDAO extends AbsDAO<SanPham> {

    public List<Object[]> layTenLoaiSanPham() {
        String selectSql = "select SanPham.idSanPham, CONCAT(TenSanPham,' Màu ',MauSac,' ',DungLuong)as TenSanPham,GiaBan,SoLuong,DVT from SanPham\n"
                + "inner join ChiTietSanPham on SanPham.idSanPham = ChiTietSanPham.idSanPham ";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public List<Object[]> DanhSachSanPham() {
        String selectSql = "select * from SanPham";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public ArrayList<SanPham> layListSanPham() {
        ArrayList<SanPham> SanPham = new ArrayList<>();
        try {
            String selectSql = "select * from SanPham";

            ResultSet rs = DBConnection.executeQuery(selectSql);
            SanPham sp;
            while (rs.next()) {
                sp = new SanPham(rs.getInt("idSanPham"),
                        rs.getInt("idLoaiSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getDouble("GiaNhap"),
                        rs.getDouble("GiaBan"),
                        rs.getInt("SoLuong"),
                        rs.getString("DVT"),
                        rs.getBytes("hinhAnh"));

                SanPham.add(sp);
                System.out.println(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return SanPham;

    }

    public void them(int idloaisanpham, String tensanpham, double gianhap, double giaban, int soluong, String dvt, byte[] hinhanh) {
        String cauLenhThemNguoiDung = "insert into SanPham  values ( ?, ?, ?, ?,?,?,?)";
        DBConnection.executeUpdate(cauLenhThemNguoiDung, idloaisanpham, tensanpham, gianhap, giaban, soluong, dvt, hinhanh);

    }
}
