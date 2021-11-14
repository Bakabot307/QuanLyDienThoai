/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.PhieuBaoHanhDAO;
import MODEL.PhieuBaoHanh;
import VIEW.ViewInterface;
import java.util.Dictionary;

/**
 *
 * @author Admin
 */
public class PhieuBaoHanhController extends AbsController<PhieuBaoHanh>{

    public PhieuBaoHanhController(ViewInterface view) {
        super(view);
    }

    @Override
    public AbsDAO<PhieuBaoHanh> getDao() {
        return new PhieuBaoHanhDAO();
    }

    @Override
    public String[] getTableColumnNames() {
         return new String[]{"ID Sản Phẩm", "ID Loại Sản Phẩm", "Tên Sản Phẩm", "Giá Nhập","Giá Bán" ,"Số Lượng","Đơn Vị Tính"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {
       
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
