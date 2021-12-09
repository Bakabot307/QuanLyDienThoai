/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.HoaDonDAO;
import MODEL.HoaDon;
import VIEW.ViewInterface;
import com.raven.form.HoaDonPnl;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonController extends AbsController<HoaDon> {

    private HoaDonPnl hoaDonPnl;

    public HoaDonController(ViewInterface view) {
        super(view);
        hoaDonDAO = new HoaDonDAO();
    }

    public List<Object[]> loadMonth() {
        return hoaDonDAO.loadThang();

    }

//    public String layT() {
//        return hoaDonDAO.layT();
//
//    }
    private HoaDonDAO hoaDonDAO;

    public int showName(int id) {
        return hoaDonDAO.layId(id);
    }

    public void ThemHD(int idSanPham, int idNhanVien, int idKhuyenMai, double tongTien, Date ngayLap, String hinhThucThanhToan, String TrangThai, String ghiChu) {
        hoaDonDAO.themHD(idSanPham, idNhanVien, idKhuyenMai, tongTien, ngayLap, hinhThucThanhToan, TrangThai, ghiChu);
    }

    public Integer idHoaDon() {
        return hoaDonDAO.idHoaDOn();
    }

    public void search(String id) {
     
        hoaDonPnl.viewList(hoaDonDAO.search(id));
    }

    @Override
    public void loadList() {
        hoaDonPnl = (HoaDonPnl) view;
        hoaDonDAO = (HoaDonDAO) dao;
        List<Object[]> data = hoaDonDAO.LoadDSSanPham();
        hoaDonPnl.setColumnNames(this.getTableColumnNames());
        hoaDonPnl.viewList(data);
        }
    @Override
    public AbsDAO<HoaDon> getDao() {
        return new HoaDonDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Hóa đơn", "Khách hàng", "Nhân viên", "Khuyến mãi", "Tổng tiền", "Ngày lập", "Hình thức thanh toán", "Trạng Thái", "Ghi chú"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
