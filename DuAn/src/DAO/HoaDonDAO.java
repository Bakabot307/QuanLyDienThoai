/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

//    public List<Object[]> layDataSearch(Object[] values) { // cho nay em dung cach nao cung duoc nhung co the dung cach nhuw thay cho tuong minh
//        String selectSql = "SELECT SUM(TongTien) AS totalIncome FROM HoaDon WHERE NgayLap >=dateadd(month,datediff(month,0,getdate())-12,0) group by Month(NgayLap)";
//        List<Object[]> data = getRawValues(selectSql);
//        return data;
//    }
    public List<Integer> loadThang() {
        String selectSql = "SELECT SUM(TongTien) AS totalIncome FROM HoaDon WHERE NgayLap >=dateadd(month,datediff(month,0,getdate())-12,0) group by Month(NgayLap)";
        List data = getRawValues(selectSql);
        return data;
    }

    public String layT() {

        String cauLenh = "SELECT SUM(TongTien) AS totalIncome FROM HoaDon WHERE NgayLap >=dateadd(month,datediff(month,0,getdate())-12,0) group by Month(NgayLap)";
        ResultSet rs = DBConnection.executeQuery(cauLenh);

        try {
            if (rs.next()) {
                return rs.toString();
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
