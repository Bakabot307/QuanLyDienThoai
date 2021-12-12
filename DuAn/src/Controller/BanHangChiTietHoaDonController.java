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
import com.raven.form.ChiTietHoaDonDialog;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanHangChiTietHoaDonController extends AbsController<ChiTietHoaDon> {

    private ChiTietHoaDonDialog chiTietHoaDonDialog;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;

    public BanHangChiTietHoaDonController(ViewInterface view) {
        super(view);
        chiTietHoaDonDAO = new ChiTietHoaDonDAO();
        chiTietHoaDonDialog = new ChiTietHoaDonDialog(null, true);
    }
    private ChiTietHoaDonDAO chiTiethoaDonDAO;

    public void ThemCTHD(int idSanPham, int idHoaDon, int SoLuong, Double Gia, Double TongTien) {
        chiTiethoaDonDAO.themHD(idSanPham, idHoaDon,  SoLuong, Gia, TongTien);

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