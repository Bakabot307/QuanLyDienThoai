/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import Controller.AbsController;
import Controller.HoaDonController;
import MODEL.ChiTietSanPham;
import MODEL.SanPham;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import com.raven.chart.ModelChart;
import java.awt.Frame;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.oval.ConstraintViolation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Admin
 */
public class HoaDonPnl extends javax.swing.JPanel implements ViewInterface {

    /**
     * Creates new form HoaDonPnl
     */
    static int idSanPham = 0;
    public static List<Integer> listID = new ArrayList<Integer>();

    ;
    public HoaDonPnl() {
        initComponents();
        HoaDonController hoaDonController = new HoaDonController(this);

        System.out.println("lay dc roi " + hoaDonController.showName(DangNhapPnl.ID));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new com.raven.swing.TableColumn();
        scrollBar1 = new com.raven.swing.ScrollBar();
        jPanel2 = new javax.swing.JPanel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel1 = new javax.swing.JLabel();
        btnChiTiet1 = new javax.swing.JLabel();

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new java.awt.BorderLayout());

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane1.setViewportView(tblHoaDon);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jPanel1.add(scrollBar1, java.awt.BorderLayout.LINE_END);

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        searchText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchText1KeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/arrow-55-16.png"))); // NOI18N
        jLabel1.setText("     Xuất file");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        btnChiTiet1.setBackground(new java.awt.Color(0, 153, 153));
        btnChiTiet1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnChiTiet1.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTiet1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChiTiet1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/key.png"))); // NOI18N
        btnChiTiet1.setText("   Chi Tiết");
        btnChiTiet1.setOpaque(true);
        btnChiTiet1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChiTiet1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChiTiet1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnChiTiet1, jLabel1});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChiTiet1))
                .addGap(10, 10, 10))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnChiTiet1, jLabel1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        exportExcel(tblHoaDon);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased
        // TODO add your handling code here:
        String id = searchText1.getText();

        if (!id.matches(".*\\d.*")) {
            hoaDonController.loadList();
            System.out.println("Lỗi nhập string");
            return;
        } else if (id.equals("")) {
            hoaDonController.loadList();
            return;
        }

        System.out.println(id);
        hoaDonController.search(id);
    }//GEN-LAST:event_searchText1KeyReleased

    private void btnChiTiet1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChiTiet1MouseClicked
        // TODO add your handling code here:
        for (int i = 0; i < HoaDonPnl.listID.size(); i++) {
            idSanPham = HoaDonPnl.listID.get(0);

        }
        if (tblHoaDon.getSelectedRow() == -1) {
            System.out.println("Lỗi chưa chọn dòng");
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn phiếu cần xem ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("click");

        ChiTietHoaDonDialog chiTietHoaDonDialog = new ChiTietHoaDonDialog(null, true);

        chiTietHoaDonDialog.errorLB.setText("");
        chiTietHoaDonDialog.lbStatus.setText("");
        id = tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString();
        System.out.println(id);
        chiTietHoaDonDialog.setIdHoaDon(Integer.parseInt(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString()));

        DefaultComboBoxModel<SanPham> modle2 = (DefaultComboBoxModel<SanPham>) chiTietHoaDonDialog.cbbSanPham.getModel();
        modle2.removeAllElements();
        List<SanPham> sanpham = hoaDonController.layCbbSanPham();
        modle2.addAll(sanpham);
        modle2.setSelectedItem(sanpham.get(0));
        SanPham sp = (SanPham) chiTietHoaDonDialog.cbbSanPham.getSelectedItem();
        Integer idSP = sp.getId();

        DefaultComboBoxModel<ChiTietSanPham> modle1 = (DefaultComboBoxModel<ChiTietSanPham>) chiTietHoaDonDialog.cbbCTSP.getModel();
        modle1.removeAllElements();
        List<Object[]> CTSP = hoaDonController.layIdCTSP(idSP);
        for (Object[] obj : CTSP) {
            chiTietHoaDonDialog.cbbCTSP.addItem(Integer.parseInt(obj[0].toString()));
        }
        chiTietHoaDonDialog.setVisible(true);

//        ArrayList<SanPham> list = hoaDonController.DSSanPham();
//        DefaultComboBoxModel<SanPham> modle = (DefaultComboBoxModel<SanPham>) chiTietHoaDonDialog.cbbSanPham.getModel();
//        modle.removeAllElements();
//        DefaultComboBoxModel dml = new DefaultComboBoxModel();
//        for (int i = 0; i < list.size(); i++) {
//            dml.addElement(list.get(i).getTenSanPham());
//            listID.add(list.get(i).getIdSanPham());
//            System.out.println(listID);
//
//        }

    }//GEN-LAST:event_btnChiTiet1MouseClicked
    public void exportExcel(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        String Link = "";
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            Link = String.valueOf(file);
        } else {

            return;
        }
        try {
            //khai báo tên file muốn tạo
            String filename = Link + ".xls";
            //tạo một đối tượng của lớp HSSFWorkbook
            HSSFWorkbook workbook = new HSSFWorkbook();
            //gọi phương thức creatSheet() và truyền tên file muốn tạo
            HSSFSheet sheet = workbook.createSheet("January");
            //tạo hàng thứ 0 sử dụng phương thức createRow()
            HSSFRow rowhead = sheet.createRow((short) 0);

            // ten Cot
            for (int j = 0; j < table.getColumnCount(); j++) {
                rowhead.createCell(j).setCellValue(model.getColumnName(j));
            }

            for (int j = 1; j < table.getRowCount(); j++) {
                String a = String.valueOf(j);
                HSSFRow row = sheet.createRow((short) j);
                for (int k = 0; k < table.getColumnCount(); k++) {
                    row.createCell(k).setCellValue(model.getValueAt(j, k).toString());
                }
            }

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            //đóng stream
            fileOut.close();
            //đóng workbook
            workbook.close();
            //in thông báo tạo thành công
            JOptionPane.showMessageDialog(null, "Lưu file thành công !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lưu file thất bại !");

        }
    }
    public static String id;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChiTiet1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.SearchText searchText1;
    private com.raven.swing.TableColumn tblHoaDon;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, tblHoaDon);
    }

    @Override
    public void setColumnNames(String[] columnNames) {
        ViewImp.setColumnNames(columnNames, tblHoaDon);
    }
    private HoaDonController hoaDonController;

    @Override
    public void setController(AbsController controller) {
        hoaDonController = (HoaDonController) controller;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
