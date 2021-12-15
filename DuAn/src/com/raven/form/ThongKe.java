package com.raven.form;

import Controller.AbsController;
import Controller.ChuyenDoi;
import Controller.HoaDonController;
import Controller.ThongKeController;
import MODEL.HoaDon;
import MODEL.SanPham;
import VIEW.ViewImp;

import VIEW.ViewInterface;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import net.sf.oval.ConstraintViolation;

public final class ThongKe extends javax.swing.JPanel implements ViewInterface {

    ThongKeController thongKeController = new ThongKeController(this);
    List<Object[]> dataThang = thongKeController.loadMonth();
    List<Object[]> dataNgay = thongKeController.loadNgay();
    List<Object[]> dataKhachHang = thongKeController.loadKhachHang();

    public ThongKe() {
        initComponents();
        setOpaque(false);
        init();
        showSanPham();
    }

    private void init() {

        for (Object[] obj : dataNgay) {
            String ngay = String.valueOf(obj[0]);
            double tongTien = Double.parseDouble(obj[1].toString());
            chart.addData(new ModelChart(ngay, new double[]{tongTien, 500000, 700000, 1000000}));
        }
        chart.start();
        chart.addLegend("Tổng Doanh Thu", new Color(245, 189, 135));
        chart.addLegend("Expense", new Color(135, 189, 245));
        chart.addLegend("Profit", new Color(189, 135, 245));
        chart.addLegend("Cost", new Color(139, 229, 222));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new com.raven.swing.PanelRound();
        chart = new com.raven.chart.Chart();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new com.raven.swing.TableColumn();
        jLabel2 = new javax.swing.JLabel();
        scrollBar1 = new com.raven.swing.ScrollBar();
        cbbThongKe = new javax.swing.JComboBox<>();
        cbbThongKe1 = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 79, 79));
        jLabel1.setText("Dashboard");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 1, 1));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableData);
        if (tableData.getColumnModel().getColumnCount() > 0) {
            tableData.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(79, 79, 79));
        jLabel2.setText("Table Data");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 1, 1));

        scrollBar1.setBackground(new java.awt.Color(245, 245, 245));

        cbbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống Tháng Hiện tại", "Thống Kê Năm", "Khách Hàng Tiêu Biểu" }));
        cbbThongKe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThongKeItemStateChanged(evt);
            }
        });

        cbbThongKe1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống Tháng Hiện tại", "Thống Kê Năm" }));
        cbbThongKe1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThongKe1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbbThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(scrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
  public void showSanPham() {
        DefaultTableModel tableModel = (DefaultTableModel) tableData.getModel();
        for (int rowIndex = tableModel.getRowCount() - 1; rowIndex >= 0; rowIndex--) {
            tableModel.removeRow(rowIndex);
        }
        ArrayList<SanPham> list = thongKeController.DSSanPham();
        System.out.println(list);
        DefaultTableModel model = (DefaultTableModel) tableData.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getIdLoaiSanPham();
            row[2] = list.get(i).getTenSanPham();
            row[3] = list.get(i).getGiaNhap();
            row[4] = list.get(i).getGiaBan();
            row[5] = list.get(i).getSoLuong();
            row[6] = list.get(i).getDVT();

            model.addRow(row);

        }
    }

    public void showHoaDon() {
        DefaultTableModel tableModel = (DefaultTableModel) tableData.getModel();
        for (int rowIndex = tableModel.getRowCount() - 1; rowIndex >= 0; rowIndex--) {
            tableModel.removeRow(rowIndex);
        }
        ArrayList<HoaDon> list = thongKeController.DSHoaDOn();
        System.out.println(list);
        DefaultTableModel model = (DefaultTableModel) tableData.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getIdKhachHang();
            row[2] = list.get(i).getIdKhuyenMai();
            row[3] = list.get(i).getIdNhanVien();
            row[4] = list.get(i).getNgayLap();
            row[5] = list.get(i).getSoLuong();
            row[6] = list.get(i).getTongTien();

            model.addRow(row);

        }
    }
    private void cbbThongKeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThongKeItemStateChanged
        if (cbbThongKe.getSelectedIndex() == 0) {
            chart.clear();
            for (Object[] obj : dataNgay) {
                String ngay = String.valueOf(obj[0]);
                double tongTien = Double.parseDouble(obj[1].toString());
                chart.addData(new ModelChart(ngay, new double[]{0, tongTien, 0, 0}));
            }
            chart.start();

        } else if ((cbbThongKe.getSelectedIndex() == 1)) {
            chart.clear();
            for (Object[] obj : dataThang) {
                String thang = String.valueOf(obj[0]);
                double tongTien = Double.parseDouble(obj[1].toString());
                chart.addData(new ModelChart(thang, new double[]{0, tongTien, 0, 0}));
            }
            chart.start();
        } else if ((cbbThongKe.getSelectedIndex() == 2)) {
            chart.clear();
            for (Object[] obj : dataKhachHang) {
                String KH = String.valueOf(obj[0]);
                double tongTien = Double.parseDouble(obj[1].toString());
                chart.addData(new ModelChart(KH, new double[]{0, tongTien, 0, 0}));
            }
            chart.start();
        }
    }//GEN-LAST:event_cbbThongKeItemStateChanged

    private void cbbThongKe1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThongKe1ItemStateChanged
        // TODO add your handling code here:
        if (cbbThongKe.getSelectedIndex() == 0) {
            showSanPham();
        }
        if (cbbThongKe.getSelectedIndex() == 1) {
            showHoaDon();
        }
    }//GEN-LAST:event_cbbThongKe1ItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbThongKe;
    private javax.swing.JComboBox<String> cbbThongKe1;
    private com.raven.chart.Chart chart;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelRound panelRound1;
    private com.raven.swing.ScrollBar scrollBar1;
    public static com.raven.swing.TableColumn tableData;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
//        ViewImp.viewList(rows, tableData);

    }

    @Override
    public void setColumnNames(String[] columnNames) {
//        ViewImp.setColumnNames(columnNames, tableData);
    }
    private ThongKeController thongKeController1;

    @Override
    public void setController(AbsController controller) {
        thongKeController1 = (ThongKeController) thongKeController1;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
