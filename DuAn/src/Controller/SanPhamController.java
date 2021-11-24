/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.KhuyenMaiDAO;
import DAO.LoaiSanPhamDAO;
import DAO.SanPhamDAO;
import MODEL.KhuyenMai;
import MODEL.LoaiSanPham;
import MODEL.SanPham;
import VIEW.ViewInterface;
import com.raven.component.Menu;
import com.raven.form.BanHangPanel;
import com.raven.form.SanPhamPanel;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamController extends AbsController<SanPham> {

    private Menu menu;

    public SanPhamController(ViewInterface view) {
        super(view);
        khuyenMaiDAO = new KhuyenMaiDAO();
        loaiSanPhamDAO =  new LoaiSanPhamDAO();
    }

    private KhuyenMaiDAO khuyenMaiDAO;
    private SanPhamPanel sanPhamPanel;
    private SanPhamDAO sanPhamDAO;
    private LoaiSanPhamDAO loaiSanPhamDAO;

    public List<KhuyenMai> layCbbKhuyenMai() {
        return khuyenMaiDAO.getAll();
    }
    
     public List<LoaiSanPham> layCbbLoaiSP() {
        return loaiSanPhamDAO.getAll();
    }

    @Override
    public void loadList() {
        sanPhamPanel = (SanPhamPanel) view;
        sanPhamDAO = (SanPhamDAO) dao;
        List<Object[]> data = sanPhamDAO.layListSanPham();
        sanPhamPanel.setColumnNames(this.getTableColumnNames());
        sanPhamPanel.viewList(data);
    }

    @Override
    public AbsDAO<SanPham> getDao() {
        return new SanPhamDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Sản Phẩm", "Tên Loại Sản Phẩm", "Tên Sản Phẩm", "Accept/Reject", "Giá Bán", ""};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {
        viewBag.put("tieu_de", "");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
