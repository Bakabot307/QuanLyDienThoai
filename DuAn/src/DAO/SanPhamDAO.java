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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SanPhamDAO extends AbsDAO<SanPham> {

    public List<Object[]> layDSSanPham() {
        String selectSql = "select SanPham.idsanPham, ChiTietSanPham.idChiTietSanPham, ConCat(TenSanPham,' ', DungLuong,' ' ,Mausac),GiaBan,ChiTietSanPham.SoLuong,DVT from SanPham\n"
                + "inner join ChiTietSanPham on SanPham.idSanPham = ChiTietSanPham.idSanPham and chitietsanpham.soluong>0 order by chitietsanpham.soluong desc";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public List<Object[]> search(String ten) {
        String selectSql = "select SanPham.idsanPham, ChiTietSanPham.idChiTietSanPham, ConCat(TenSanPham,' ', DungLuong,' ' ,Mausac) ,GiaBan,ChiTietSanPham.SoLuong,DVT from SanPham\n"
                + "                inner join ChiTietSanPham on SanPham.idSanPham = ChiTietSanPham.idSanPham where ConCat(TenSanPham,' ', DungLuong,' ' ,Mausac)  like ? and chitietsanpham.soluong>0 order by chitietsanpham.soluong desc";
        List<Object[]> data = getRawValues(selectSql, ten);
        return data;
    }

    public List<Object[]> searchTenSanPham(String ten) {
        String selectSql = "select idSanPham,TenLoaiSanPham,TenSanPham,GiaNhap,GiaBan,ChiTietSanPham.SoLuong,DVT from SanPham join LoaiSanPham on SanPham.idLoaiSanPham = LoaiSanPham.idLoaiSanPham\n"
                + "	 where TenSanPham like ? where  chitietsanpham.soluong>0 order by chitietsanpham.soluong desc";
        List<Object[]> data = getRawValues(selectSql, ten);
        return data;
    }

    public List<Object[]> searchDungLuong(String dl) {
        String selectSql = "select SanPham.idsanPham, ChiTietSanPham.idChiTietSanPham, ConCat(TenSanPham,' ', DungLuong,' ' ,Mausac) ,GiaBan,ChiTietSanPham.SoLuong,DVT from SanPham\n"
                + "                inner join ChiTietSanPham on SanPham.idSanPham = ChiTietSanPham.idSanPham where "
                + "ConCat(TenSanPham,' ', DungLuong,' ' ,Mausac) like ? and chitietsanpham.soluong>0 order by chitietsanpham.soluong desc";
        List<Object[]> data = getRawValues(selectSql, dl);
        return data;
    }

    public List<Object[]> searchDungLuongTheoTen(String ten, String dungLuong) {
        String selectSql = "select SanPham.idsanPham, ChiTietSanPham.idChiTietSanPham, ConCat(TenSanPham,' ', DungLuong,' ' ,Mausac) ,GiaBan,ChiTietSanPham.SoLuong,DVT from SanPham\n"
                + "                inner join ChiTietSanPham on SanPham.idSanPham = ChiTietSanPham.idSanPham where  "
                + "ConCat(TenSanPham,' ', DungLuong,' ' ,Mausac)  like ? and ConCat(TenSanPham,' ', DungLuong,' ' ,Mausac) like ? and chitietsanpham.soluong>0 order by chitietsanpham.soluong desc";
        List<Object[]> data = getRawValues(selectSql, ten, dungLuong);
        return data;
    }

    public List<Object[]> DanhSachSanPham() {
        String selectSql = "select idSanPham,TenLoaiSanPham,TenSanPham,GiaNhap,GiaBan,SoLuong,DVT from SanPham join LoaiSanPham on SanPham.idLoaiSanPham = LoaiSanPham.idLoaiSanPham\n";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public int soLuongSPTheoId(int Id) {

        String cauLenh = "select * from  SanPham where idSanPham = ?";
        ResultSet rs = DBConnection.executeQuery(cauLenh, Id);

        try {
            if (rs.next()) {
                return rs.getInt("soLuong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int soLuongCTSPTheoId(int Id) {

        String cauLenh = "select * from  ChiTietSanPham where idChiTietSanPham = ?";
        ResultSet rs = DBConnection.executeQuery(cauLenh, Id);

        try {
            if (rs.next()) {
                return rs.getInt("soLuong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
                        rs.getString("DVT")
                );

                SanPham.add(sp);
                System.out.println(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return SanPham;

    }

    public Object layListSanPhamGanHet(JTable tbl) {
        DefaultTableModel tableModel = (DefaultTableModel) tbl.getModel();
        Object values[] = new Object[7];
        tableModel.setRowCount(0);
        try {
            String selectSql = "Select  * from SanPham join LoaiSanPham on SanPham.idLoaiSanPham = LoaiSanPham.idLoaiSanPham where SoLuong <=3 order by SoLuong asc";

            ResultSet rs = DBConnection.executeQuery(selectSql);
            SanPham sp;
            while (rs.next()) {
                values[0] = rs.getInt("idSanPham");
                values[1] = rs.getString("TenLoaiSanPham");
                values[2] = rs.getString("TenSanPham");
                values[3] = rs.getDouble("GiaNhap");
                values[4] = rs.getDouble("GiaBan");
                values[5] = rs.getInt("SoLuong");
                values[6] = rs.getString("DVT");

                tableModel.addRow(values);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return values;
    }

    public void them(int idloaisanpham, String tensanpham, double gianhap, double giaban, int soluong, String dvt) {
        String cauLenhThemNguoiDung = "insert into SanPham  values ( ?, ?, ?, ?,?,?)";
        DBConnection.executeUpdate(cauLenhThemNguoiDung, idloaisanpham, tensanpham, gianhap, giaban, soluong, dvt);

    }

}
