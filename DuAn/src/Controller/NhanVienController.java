/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.NhanVienDAO;
import MODEL.NhanVien;
import VIEW.ViewInterface;
import java.util.Dictionary;

/**
 *
 * @author Admin
 */
public class NhanVienController extends AbsController<NhanVien>{

    public NhanVienController(ViewInterface view) {
        super(view);
    }

    @Override
    public AbsDAO<NhanVien> getDao() {
        return new NhanVienDAO();
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
