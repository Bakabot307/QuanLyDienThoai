/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.PhieuNhapDAO;
import MODEL.PhieuNhap;
import VIEW.ViewInterface;
import java.util.Dictionary;

/**
 *
 * @author Admin
 */
public class PhieuNhapController extends AbsController<PhieuNhap>{

    public PhieuNhapController(ViewInterface view) {
        super(view);
    }

    @Override
    public AbsDAO<PhieuNhap> getDao() {
       return new PhieuNhapDAO();
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
