/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.NhaCungCapDAO;
import MODEL.NhaCungCap;
import VIEW.ViewInterface;
import java.util.Dictionary;

/**
 *
 * @author Admin
 */
public class NhaCungCapController extends AbsController<NhaCungCap> {

    public NhaCungCapController(ViewInterface view) {
        super(view);
    }

    @Override
    public AbsDAO<NhaCungCap> getDao() {
        return new NhaCungCapDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Email", "Tổng mua", "Địa chỉ", "Ghi chú"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
