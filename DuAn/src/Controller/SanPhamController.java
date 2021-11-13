/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.SanPhamDAO;
import MODEL.SanPham;
import VIEW.ViewInterface;
import java.util.Dictionary;

/**
 *
 * @author Admin
 */
public class SanPhamController extends AbsController<SanPham>{

    public SanPhamController(ViewInterface view) {
        super(view);
    }

    @Override
    public AbsDAO<SanPham> getDao() {
        return new SanPhamDAO();
    }

    @Override
    public String[] getTableColumnNames() {
         return new String[]{"ID Tác giả", "Tên tác giả", "Số điện thoại", "Địa chỉ","5" ,"6","7"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {
     
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
