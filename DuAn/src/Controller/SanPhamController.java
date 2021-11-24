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
import com.raven.component.Menu;
import com.raven.event.EventMenuSelected;
import com.raven.form.BanHangPanel;
import com.raven.form.KhachHangPanel;
import com.raven.form.KhuyenMaiPnl;
import com.raven.form.SanPhamPanel;
import com.raven.form.ThongKe;
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

    }

    private KhuyenMaiDAO khuyenMaiDAO;
    private SanPhamPanel sanPhamPanel;
    private BanHangPanel banHangPanel;
    private SanPhamDAO sanPhamDAO;

    public List<KhuyenMai> layCbbKhuyenMai() {
        return khuyenMaiDAO.getAll();
    }

    @Override
    public void loadList() {
        banHangPanel = (BanHangPanel) view;
        sanPhamDAO = (SanPhamDAO) dao;
        menu = new Menu();
        menu.setEvent(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    banHangPanel = (BanHangPanel) view;
                    List<Object[]> data2 = sanPhamDAO.layTenLoaiSanPham();
//                     banHangPanel.setColumnNames(this.getTableColumnNames());
                    banHangPanel.viewList(data2);
                } else if (index == 4) {
                    sanPhamPanel = (SanPhamPanel) view;
                    List<Object[]> data = sanPhamDAO.layListSanPham();
                    sanPhamPanel.viewList(data);

                }
            }
        });
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

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
