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
import java.util.Dictionary;

/**
 *
 * @author Admin
 */
public class HoaDonController extends AbsController<HoaDon>{

    public HoaDonController(ViewInterface view) {
        super(view);
    }

    @Override
    public AbsDAO<HoaDon> getDao() {
       return new HoaDonDAO();
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
