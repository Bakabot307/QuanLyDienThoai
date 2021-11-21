/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.KhuyenMaiDAO;
import DAO.SanPhamDAO;
import MODEL.KhuyenMai;
import MODEL.SanPham;
import VIEW.ViewInterface;
import com.raven.form.BanHangPanel;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamController extends AbsController<SanPham> {

    public SanPhamController(ViewInterface view) {
        super(view);
        khuyenMaiDAO = new KhuyenMaiDAO();
    }

    private KhuyenMaiDAO khuyenMaiDAO;
    private BanHangPanel banHangPanel;
    private SanPhamDAO sanPhamDAO;

    public List<KhuyenMai> layCbbKhuyenMai() {
        return khuyenMaiDAO.getAll();
    }

    @Override
    public void loadList() {
        banHangPanel = (BanHangPanel) view;
        sanPhamDAO = (SanPhamDAO) dao;
        List<Object[]> data = sanPhamDAO.layTenLoaiSanPham();
        banHangPanel.setColumnNames(this.getTableColumnNames());
        banHangPanel.viewList(data);
    }

    @Override
    public AbsDAO<SanPham> getDao() {
        return new SanPhamDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Sản Phẩm", "Tên Loại Sản Phẩm", "Tên Sản Phẩm", "Giá Nhập", "Giá Bán", "Số Lượng", "Đơn Vị Tính", "button"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
