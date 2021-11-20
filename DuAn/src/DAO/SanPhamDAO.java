/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.SanPham;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamDAO extends AbsDAO<SanPham>{
    public List<Object[]> layTenLoaiSanPham() {
        String selectSql = "select idSanPham, TenLoaiSanPham,TenSanPham,GiaNhap, GiaBan ,SoLuong,DVT from SanPham join LoaiSanPham on SanPham.idLoaiSanPham = LoaiSanPham.idLoaiSanPham";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }
}
