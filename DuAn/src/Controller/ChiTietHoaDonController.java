/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.DBConnection;
import MODEL.ChiTietHoaDon;
import VIEW.ViewInterface;
import java.util.Date;
import java.util.Dictionary;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDonController extends AbsController<ChiTietHoaDon> {

    public ChiTietHoaDonController(ViewInterface view) {
        super(view);
    }
    private ChiTietHoaDonDAO chiTiethoaDonDAO;
    public void ThemCTHD(int idSanPham, int idHoaDon, String TenSanPham, int SoLuong, Double Gia, Double TongTien) {
        chiTiethoaDonDAO.themHD(idSanPham, idHoaDon, TenSanPham, SoLuong, Gia, TongTien);

        
    }

    @Override
    public AbsDAO<ChiTietHoaDon> getDao() {
        return new ChiTietHoaDonDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Sản Phẩm", "ID Loại Sản Phẩm", "Tên Sản Phẩm", "Giá Nhập", "Giá Bán", "Số Lượng", "Đơn Vị Tính"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
