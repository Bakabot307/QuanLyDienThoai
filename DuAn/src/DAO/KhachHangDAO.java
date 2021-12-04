/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.KhachHang;
import java.util.List;

/**
 *
 * @author gnaht
 */
public class KhachHangDAO extends AbsDAO<KhachHang>{
     public List<Object[]> search(String ten) {
        String selectSql = "select * from KhachHang where TenKhachHang like ? ";
        List<Object[]> data = getRawValues(selectSql, ten);
        return data;
    }
     
      public List<Object[]> layDS() {
        String selectSql = "select * from KhachHang";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }
}
