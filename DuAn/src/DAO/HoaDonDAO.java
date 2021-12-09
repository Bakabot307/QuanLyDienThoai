/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.DBConnection;

/**
 *
 * @author gnaht
 */
public class HoaDonDAO extends AbsDAO<HoaDon> {

    public int layId(int ten) {

        String cauLenh = "select * from  NhanVien where idNhanVien = ?";
        ResultSet rs = DBConnection.executeQuery(cauLenh, ten);

        try {
            if (rs.next()) {
                return rs.getInt("idNhanVien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
public List<Object[]> LoadDSSanPham() {
        String selectSql = "select SanPham.idsanPham, ChiTietSanPham.idChiTietSanPham, TenSanPham, DungLuong, Mausac,GiaBan,SoLuong,DVT from SanPham\n"
                + "inner join ChiTietSanPham on SanPham.idSanPham = ChiTietSanPham.idSanPham ";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }
//    public List<Object[]> layDataSearch(Object[] values) { // cho nay em dung cach nao cung duoc nhung co the dung cach nhuw thay cho tuong minh
//        String selectSql = "SELECT SUM(TongTien) AS totalIncome FROM HoaDon WHERE NgayLap >=dateadd(month,datediff(month,0,getdate())-12,0) group by Month(NgayLap)";
//        List<Object[]> data = getRawValues(selectSql);
//        return data;
//    }
    public List<Object[]> loadThang() {
        String selectSql = "SELECT SUM(TongTien) AS totalIncome FROM HoaDon WHERE NgayLap >=dateadd(month,datediff(month,0,getdate())-12,0) group by Month(NgayLap)";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

//    public List<Integer> layT() throws SQLException {
//
//        String cauLenh = "SELECT SUM(TongTien) AS totalIncome FROM HoaDon WHERE NgayLap >=dateadd(month,datediff(month,0,getdate())-12,0) group by Month(NgayLap)";
//        ResultSet rs = DBConnection.executeQuery(cauLenh);
//
//        while(rs.next()){
//               
//                    
//
//
//        }
//                 }
    public void themHD(int idSanPham, int idNhanVien, int idKhuyenMai, double tongTien, Date ngayLap, String hinhThucThanhToan, String TrangThai, String ghiChu) {
        String cauLenhThem = "insert into HoaDon values (?,?,?,?,?,?,?,?)";
        DBConnection.executeUpdate(cauLenhThem, idSanPham, idNhanVien, idKhuyenMai, tongTien, ngayLap, hinhThucThanhToan, TrangThai, ghiChu);
    }
    

    public Integer idHoaDOn() {
        String selectSql = "SELECT TOP 1 * FROM [HoaDon] ORDER BY idHoaDon DESC";
        ResultSet rs = DBConnection.executeQuery(selectSql);

        try {
            if (rs.next()) {
                return rs.getInt("idHoaDon");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<Object[]> search(String id) {
        String selectSql = "select idHoaDon,TenNhanVien,TenNhanVien,TenKhuyenMai,TongTien,NgayLap,HinhThucThanhToan,HoaDon.TrangThai,HoaDon.GhiChu\n"
                + "from HoaDon join KhachHang on HoaDon.idKhachHang = KhachHang.idKhachHang join \n"
                + "NhanVien on HoaDon.idNhanVien = NhanVien.idNhanVien join KhuyenMai on HoaDon.idKhuyenMai = KhuyenMai.idKhuyenMai where idHoaDon = ? ";
        List<Object[]> data = getRawValues(selectSql, id);
        return data;
    }

    public List<Object[]> layDS() {
        String selectSql = "select idHoaDon,TenNhanVien,TenNhanVien,TenKhuyenMai,TongTien,NgayLap,HinhThucThanhToan,HoaDon.TrangThai,HoaDon.GhiChu\n"
                + "from HoaDon join KhachHang on HoaDon.idKhachHang = KhachHang.idKhachHang join \n"
                + "NhanVien on HoaDon.idNhanVien = NhanVien.idNhanVien join KhuyenMai on HoaDon.idKhuyenMai = KhuyenMai.idKhuyenMai";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }
    
}
