/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gnaht
 */
public class NhanVienDAO extends AbsDAO<NhanVien> {

    public boolean kiemTraTaiKhoan(String tenDangNhap, String mk) {
        List<Object[]> data = getRawValues("select count(*)from NhanVien where TenDangNhap = ? and MatKhau = ?", tenDangNhap, mk);
        Integer dem = (Integer) data.get(0)[0];
        return dem > 0;
    }

    public String layTenNV(String tenDangNhap, String mk) {

        String cauLenh = "select * from  NhanVien where TenDangNhap = ? and MatKhau = ?";
        ResultSet rs = DBConnection.executeQuery(cauLenh, tenDangNhap, mk);

        try {
            if (rs.next()) {
                if (rs.getString("MatKhau").equals(mk)) {

                    return rs.getString("TenNhanVien");
                } else {

                    return "";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public int layChucVuNV(String tenDangNhap, String mk) {

        String cauLenh = "select * from  NhanVien where TenDangNhap = ? and MatKhau = ?";
        ResultSet rs = DBConnection.executeQuery(cauLenh, tenDangNhap, mk);

        try {
            if (rs.next()) {
                if (rs.getString("MatKhau").equals(mk)) {

                    return rs.getInt("Lv");
                } else {

                    return 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
