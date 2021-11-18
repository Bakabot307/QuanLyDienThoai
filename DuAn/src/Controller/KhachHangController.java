/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.KhachHangDAO;
import MODEL.KhachHang;
import VIEW.ViewInterface;
import java.util.Dictionary;

/**
 *
 * @author Admin
 */
public class KhachHangController extends AbsController<KhachHang>{

    public KhachHangController(ViewInterface view) {
        super(view);
    }

    @Override
    public AbsDAO<KhachHang> getDao() {
        return new KhachHangDAO();
    }

    @Override
    public String[] getTableColumnNames() {
         return new String[]{"ID Khách Hàng", "Tên Khách Hàng", "Số điện thoại", "Địa Chỉ","Số CMND" ,"Ghi chú","GiớiTính","Email"};
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
