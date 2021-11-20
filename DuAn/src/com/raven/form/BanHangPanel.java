package com.raven.form;

import Controller.AbsController;
import Controller.SanPhamController;
import MODEL.KhuyenMai;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.oval.ConstraintViolation;

public class BanHangPanel extends javax.swing.JPanel implements ViewInterface {

    public BanHangPanel() {
        initComponents();
        setOpaque(false);
        SanPhamController sanPhamController = new SanPhamController(this);
        init();

        DefaultComboBoxModel<KhuyenMai> modle = (DefaultComboBoxModel<KhuyenMai>) cbbKhuyenMai.getModel();
        modle.removeAllElements();
        List<KhuyenMai> khuyenMais = sanPhamController.layCbbKhuyenMai();
        modle.addAll(khuyenMais);
        modle.setSelectedItem(khuyenMais.get(0));
    }

    private void init() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchText1 = new com.raven.swing.SearchText();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataTable1 = new com.raven.swing.TableColumn();
        jScrollPane3 = new javax.swing.JScrollPane();
        dataTable2 = new com.raven.swing.TableColumn();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCanTra = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnThem = new javax.swing.JButton();
        txtThanhToan = new com.raven.swing.KButton();
        txtKhachDua = new javax.swing.JTextField();
        cbbKhuyenMai = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1043, 680));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(null);

        dataTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Gender", "Age", "Email", "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable1.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 200));
        jScrollPane2.setViewportView(dataTable1);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jScrollPane3.setBorder(null);

        dataTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Gender", "Age", "Email", "Phone Number", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable2.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 250));
        jScrollPane3.setViewportView(dataTable2);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.PAGE_START);

        jLabel5.setText("Tổng tiền hàng");

        txtTongTien.setText("  ");
        txtTongTien.setEnabled(false);

        jLabel4.setText("Giảm giá");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Khách cần trả");

        txtCanTra.setText("  ");
        txtCanTra.setEnabled(false);

        jLabel3.setText("Khách thanh toán");

        jLabel1.setText("Tiền thừa trả khách");

        txtTienThua.setText("  ");
        txtTienThua.setEnabled(false);

        btnThem.setText("them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtThanhToan.setText("Thanh toán");
        txtThanhToan.setFont(new java.awt.Font("UTM Avo", 0, 18)); // NOI18N
        txtThanhToan.setkEndColor(new java.awt.Color(0, 153, 153));
        txtThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhToanActionPerformed(evt);
            }
        });

        txtKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachDuaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThem))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCanTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(txtTienThua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(txtKhachDua, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator1))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btnThem)
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        TableModel model1 = dataTable1.getModel();

        int[] indexs = dataTable1.getSelectedRows();

        Object[] row = new Object[7];

        DefaultTableModel model2 = (DefaultTableModel) dataTable2.getModel();
        for (int i = 0; i < indexs.length; i++) {
            row[0] = model1.getValueAt(indexs[i], 0);

            row[1] = model1.getValueAt(indexs[i], 1);

            row[2] = model1.getValueAt(indexs[i], 2);

            row[3] = model1.getValueAt(indexs[i], 3);
            row[4] = model1.getValueAt(indexs[i], 4);
            row[5] = model1.getValueAt(indexs[i], 5);
            row[6] = model1.getValueAt(indexs[i], 6);

            model2.addRow(row);
            hoaDonTable();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhToanActionPerformed
        // TODO add your handling code here:
        KhuyenMai khuyenMai = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
        Integer phanTramKM = khuyenMai.getPhanTramKhuyenMai();

        System.out.println(phanTramKM);


    }//GEN-LAST:event_txtThanhToanActionPerformed

    private void txtKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachDuaKeyReleased
        double tienKhachDua, tienThoi, tienKhachCanTra;
        tienKhachCanTra = Double.parseDouble(txtCanTra.getText());
        tienKhachDua = Double.parseDouble(txtKhachDua.getText());
        tienThoi = tienKhachDua - tienKhachCanTra;
        txtTienThua.setText(Double.toString(tienThoi));
    }//GEN-LAST:event_txtKhachDuaKeyReleased
// public boolean isExist(String code) {
//        boolean result;
//            try {
//            Cursor cursor = db.rawQuery("SELECT QTY FROM users_data WHERE CODE " + code + "'", null);
//            if (cursor.getCount() > 0 ){
//                while (cursor.moveToFirst()){
//                    rQty = cursor.getInt(cursor.getColumnIndex("QTY"));
//                }
//                result = true;
//            }else {
//                result = false;
//            }
//        }
//        catch (Exception ex){
//            result = false;
//        }
//        return result;
//    }

    public void hoaDonTable() {
        double giamGia, khachCanTra, tienKhachDua, tienThua;
        DefaultTableModel t = (DefaultTableModel) dataTable2.getModel();
        double total = 0;
        for (int i = 0; i < t.getRowCount(); i++) {
            total = total + Double.parseDouble(t.getValueAt(i, 4).toString());
            txtTongTien.setText(Double.toString(total));

        }
        // lấy phần trăm khuyến mãi theo đúng tên khuyến mãi
        KhuyenMai khuyenMai = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
        Integer phanTramKM = khuyenMai.getPhanTramKhuyenMai();

        giamGia = Double.parseDouble(phanTramKM.toString());
        khachCanTra = total - giamGia;

        txtCanTra.setText(Double.toString(khachCanTra));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<KhuyenMai> cbbKhuyenMai;
    private com.raven.swing.TableColumn dataTable1;
    private com.raven.swing.TableColumn dataTable2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private com.raven.swing.SearchText searchText1;
    private javax.swing.JButton txtCanTra;
    private javax.swing.JTextField txtKhachDua;
    private com.raven.swing.KButton txtThanhToan;
    private javax.swing.JButton txtTienThua;
    private javax.swing.JButton txtTongTien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, dataTable1);
    }

    @Override
    public void setColumnNames(String[] columnNames) {
        ViewImp.setColumnNames(columnNames, dataTable1);
    }

    private SanPhamController sanPhamController;

    @Override
    public void setController(AbsController controller) {
        sanPhamController = (SanPhamController) sanPhamController;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
