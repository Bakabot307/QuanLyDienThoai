/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
