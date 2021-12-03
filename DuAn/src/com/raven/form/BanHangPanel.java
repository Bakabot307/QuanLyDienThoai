package com.raven.form;

import Controller.AbsController;
import Controller.BanHangController;
import Controller.ChiTietHoaDonController;
import Controller.ChuyenDoi;
import Controller.HoaDonController;
import MODEL.KhuyenMai;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import duan.dialog.HandleTangSoLuongDal;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.oval.ConstraintViolation;

public class BanHangPanel extends javax.swing.JPanel implements ViewInterface {

    private HandleTangSoLuongDal tangSoLuongDal = null;

    public BanHangPanel() {
        initComponents();
        setOpaque(false);
        BanHangController banHangController = new BanHangController(this);
        init();

        DefaultComboBoxModel<KhuyenMai> modle = (DefaultComboBoxModel<KhuyenMai>) cbbKhuyenMai.getModel();
        modle.removeAllElements();
        List<KhuyenMai> khuyenMais = banHangController.layCbbKhuyenMai();
        modle.addAll(khuyenMais);
        modle.setSelectedItem(khuyenMais.get(0));
//        dataTable2.getColumn("button").setCellRenderer(new ButtonRenderer());
//        dataTable2.getColumn("button").setCellEditor(
//            new ButtonEditor(new JCheckBox()));
        dataTable2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    tangSoLuongDal = new HandleTangSoLuongDal(null, true);
                    tangSoLuongDal.setVisible(true);
                    if (tangSoLuongDal == null) {
                        tangSoLuongDal = new HandleTangSoLuongDal(null, true);
                    }

                    if (dataTable1.getRowCount() == 0) {

                        TableModel model2 = dataTable2.getModel();

                        int[] indexs = dataTable2.getSelectedRows();

                        Object[] rows = new Object[5];

                        DefaultTableModel model1 = (DefaultTableModel) dataTable1.getModel();
                        for (int i = 0; i < indexs.length; i++) {
                            rows[0] = model2.getValueAt(indexs[i], 0);
                            rows[1] = model2.getValueAt(indexs[i], 1);
                            rows[2] = model2.getValueAt(indexs[i], 2);
                            rows[3] = ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText());
                            rows[4] = model2.getValueAt(indexs[i], 4);
                            model1.addRow(rows);

                        }
                    } else {
                        int t2RowID = Integer.parseInt(dataTable2.getValueAt(dataTable2.getSelectedRow(), 0).toString());
                        Object[] rowData = new Object[dataTable1.getRowCount()];
                        for (int i = 0; i < dataTable1.getRowCount(); i++) {
                            rowData[i] = dataTable1.getValueAt(i, 0);
                            System.out.println(rowData[i]);
                            if (t2RowID == (int) rowData[i]) {
                                double soLuong = Double.parseDouble(dataTable1.getValueAt((int) rowData[i], 3).toString()) + 1;
                                dataTable1.setValueAt(soLuong, (int) rowData[i], 3);
                            } else {
                                TableModel model2 = dataTable2.getModel();

                                int[] indexs = dataTable2.getSelectedRows();

                                Object[] rows = new Object[5];

                                DefaultTableModel model1 = (DefaultTableModel) dataTable1.getModel();
                                for (int j = 0; j < indexs.length; j++) {
                                    rows[0] = model2.getValueAt(indexs[j], 0);
                                    rows[1] = model2.getValueAt(indexs[j], 1);
                                    rows[2] = model2.getValueAt(indexs[j], 2);
                                    rows[3] = model2.getValueAt(indexs[j], 3);
                                    rows[4] = model2.getValueAt(indexs[j], 4);
                                    model1.addRow(rows);
                                }

                            }
                        }
                    }
                }

            }

        });
        dataTable1.getModel().addTableModelListener(
                new TableModelListener() {
            public void tableChanged(TableModelEvent evt) {
//for (int j = 0; j < dataTable2.getRowCount(); j++) {
//                            int id = Integer.parseInt(dataTable1.getValueAt(j, 0).toString());
//                            int t1Row = dataTable2.getSelectedRow();
//                            int t1RowID = Integer.parseInt(dataTable2.getValueAt(t1Row, 0).toString());
//                            if (id == t1RowID) {
//                                double soLuong = Double.parseDouble(dataTable1.getValueAt(t1Row, 3).toString()) + 1;
//                                dataTable1.setValueAt(soLuong, j, 3);
//                            }
//}
                System.out.print("aa");
                hoaDonTable();
            }

        });
    }

    private void init() {

    }
    int idTonTai = 1;

//    public boolean existsInTable(JTable table, Object[] entry) {
//
//        // Get row and column count
//        int rowCount = table.getRowCount();
//        int colCount = table.getColumnCount();
//
//        // Get Current Table Entry
//        String curEntry = "";
//        for (Object o : entry) {
//            String e = o.toString();
//            curEntry = curEntry + " " + e;
//        }
//
//        // Check against all entries
//        for (int i = 0; i < rowCount; i++) {
//            String rowEntry = "";
//            for (int j = 0; j < colCount; j++) {
//                rowEntry = rowEntry + " " + table.getValueAt(i, j).toString();
//            }
//            if (rowEntry.equalsIgnoreCase(curEntry)) {
//                idTonTai = j;
//                System.out.println("id ton tai:" +idTonTai);
//                return true;
//            }
//        }
//        System.out.println("khong ton tai");
//        return false;
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchText1 = new com.raven.swing.SearchText();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataTable2 = new com.raven.swing.TableColumn();
        jScrollPane3 = new javax.swing.JScrollPane();
        dataTable1 = new com.raven.swing.TableColumn();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThem = new javax.swing.JButton();
        txtThanhToan = new com.raven.swing.KButton();
        cbbKhuyenMai = new javax.swing.JComboBox<>();
        txtTienThua1 = new javax.swing.JButton();
        txtCanTra = new javax.swing.JButton();
        txtTongTien = new javax.swing.JButton();
        btnHienThi = new javax.swing.JButton();
        txtKhachDua = new javax.swing.JTextField();
        btnChiTiet = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(null);

        dataTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Gender", "Age", "Email", "Phone Number", "button"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable2.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 200));
        jScrollPane2.setViewportView(dataTable2);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jScrollPane3.setBorder(null);

        dataTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Gender", "Age", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable1.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 250));
        dataTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(dataTable1);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.PAGE_START);

        jLabel5.setText("Tổng tiền hàng");

        jLabel4.setText("Giảm giá");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Khách cần trả");

        jLabel3.setText("Khách thanh toán");

        jLabel1.setText("Tiền thừa trả khách");

        btnThem.setText("them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtThanhToan.setText("Thanh toán");
        txtThanhToan.setFont(new java.awt.Font("UTM Avo", 0, 18)); // NOI18N
        txtThanhToan.setkEndColor(new java.awt.Color(0, 153, 153));
        txtThanhToan.setkHoverEndColor(new java.awt.Color(0, 102, 102));
        txtThanhToan.setkHoverForeGround(new java.awt.Color(153, 153, 153));
        txtThanhToan.setkHoverStartColor(new java.awt.Color(0, 102, 102));
        txtThanhToan.setkSelectedColor(new java.awt.Color(0, 153, 153));
        txtThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhToanActionPerformed(evt);
            }
        });

        cbbKhuyenMai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhuyenMaiItemStateChanged(evt);
            }
        });
        cbbKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKhuyenMaiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbbKhuyenMaiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbKhuyenMaiMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbbKhuyenMaiMouseReleased(evt);
            }
        });

        txtTienThua1.setFont(new java.awt.Font("UTM Avo", 2, 14)); // NOI18N
        txtTienThua1.setForeground(new java.awt.Color(0, 51, 51));
        txtTienThua1.setText("5.000.000");
        txtTienThua1.setEnabled(false);
        txtTienThua1.setRequestFocusEnabled(false);

        txtCanTra.setFont(new java.awt.Font("UTM Avo", 2, 14)); // NOI18N
        txtCanTra.setForeground(new java.awt.Color(0, 51, 51));
        txtCanTra.setText("50.000.000");
        txtCanTra.setEnabled(false);

        txtTongTien.setFont(new java.awt.Font("UTM Avo", 2, 14)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(0, 51, 51));
        txtTongTien.setText("000000");
        txtTongTien.setEnabled(false);
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        btnHienThi.setForeground(new java.awt.Color(0, 51, 51));
        btnHienThi.setText("0%");
        btnHienThi.setEnabled(false);
        btnHienThi.setRequestFocusEnabled(false);

        txtKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachDuaKeyReleased(evt);
            }
        });

        btnChiTiet.setBackground(new java.awt.Color(0, 153, 153));
        btnChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTiet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/key.png"))); // NOI18N
        btnChiTiet.setText("   Chi Tiết");
        btnChiTiet.setOpaque(true);
        btnChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChiTietMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 47, Short.MAX_VALUE)
                        .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienThua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtKhachDua)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(30, 30, 30)))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHienThi))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTienThua1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed


    }//GEN-LAST:event_btnThemActionPerformed

    private void txtThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhToanActionPerformed

        HoaDonController hoaDonController = new HoaDonController(this);
        ChiTietHoaDonController chiTietHoaDonController = new ChiTietHoaDonController(this);
        KhuyenMai khuyenMai = (KhuyenMai) cbbKhuyenMai.getSelectedItem();

        Integer idKM = khuyenMai.getId();
        System.out.println(idKM);
        Integer idNV = DangNhapPnl.ID;
        java.sql.Timestamp now = new Timestamp((new java.util.Date()).getTime());
        double tongTien = Double.parseDouble(txtTongTien.getText());

        hoaDonController.ThemHD(1, idNV, idKM, tongTien, now, "hinh thuc thanh toan", "trang thai", "ghichu");

        System.out.println(hoaDonController.idHoaDon());
        System.out.println(dataTable1.getRowCount());
        System.out.println(dataTable1.getColumnCount());
        for (int i = 0; i < dataTable1.getRowCount(); i++) {
            Object[] values = new Object[8];
            for (int j = 1; j < dataTable1.getColumnCount(); j++) {
                values[0] = 0;
                if (j == 0) {
                    values[1] = dataTable1.getValueAt(i, j);
                }
                values[2] = hoaDonController.idHoaDon();
                if (j == 1) {
                    values[3] = dataTable1.getValueAt(i, j); //Tên               
                }
                if (j == 2) { //gia
                    values[4] = dataTable1.getValueAt(i, j); //              
                }
                if (j == 3) {
                    values[5] = dataTable1.getValueAt(i, j);
                }
                if (j == 4) {
                    values[6] = dataTable1.getValueAt(i, j);
                }
                values[7] = Double.parseDouble(dataTable1.getValueAt(i, 2).toString()) * Double.parseDouble(dataTable1.getValueAt(i, 3).toString());

                chiTietHoaDonController.insert(values);

            }
        }


    }//GEN-LAST:event_txtThanhToanActionPerformed

    private void dataTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTable1MouseClicked


    }//GEN-LAST:event_dataTable1MouseClicked

    private void cbbKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_cbbKhuyenMaiMouseClicked

    private void cbbKhuyenMaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbKhuyenMaiMousePressed

    private void cbbKhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhuyenMaiMouseExited

    private void cbbKhuyenMaiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiMouseReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_cbbKhuyenMaiMouseReleased

    private void cbbKhuyenMaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiItemStateChanged
        // TODO add your handling code here:

        KhuyenMai khuyenMai = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
        Integer phanTramKM = khuyenMai.getPhanTramKhuyenMai();

        btnHienThi.setText(String.valueOf(khuyenMai.getPhanTramKhuyenMai() + " %"));

    }//GEN-LAST:event_cbbKhuyenMaiItemStateChanged

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void txtKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachDuaKeyReleased
        double tienKhachDua, tienCanTra, tienThua;
        tienCanTra = Double.parseDouble(txtCanTra.getText());
        tienKhachDua = Double.parseDouble(txtKhachDua.getText());
        tienThua = tienKhachDua - tienCanTra;
        txtTienThua1.setText(String.valueOf(tienThua));
    }//GEN-LAST:event_txtKhachDuaKeyReleased

    private void btnChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChiTietMouseClicked
        // TODO add your handling code here:
        if (dataTable2.getSelectedRow() == -1) {
            System.out.println("Lỗi chưa chọn dòng");
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn phiếu cần xem ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ChiTietSanPhamDialogForBanHang chiTietSanPhamDialogForBanHang = new ChiTietSanPhamDialogForBanHang(null, true);
        //        chiTietSanPhamDialog.errorLB.setText("");
        chiTietSanPhamDialogForBanHang.errorLB.setText("");
        id = dataTable2.getValueAt(dataTable2.getSelectedRow(), 0).toString();
        System.out.println(id);

        chiTietSanPhamDialogForBanHang.setIdSanPham((Integer) dataTable2.getValueAt(dataTable2.getSelectedRow(), 0));

        chiTietSanPhamDialogForBanHang.setVisible(true);


    }//GEN-LAST:event_btnChiTietMouseClicked
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
    public static String id;

    public void hoaDonTable() {
        double giamGia, khachCanTra, tienKhachDua, tienThua;
        DefaultTableModel t = (DefaultTableModel) dataTable1.getModel();
        DefaultTableModel t2 = (DefaultTableModel) dataTable2.getModel();

        double total = 0;
        double tienTungMon = 0;
        for (int i = 0; i < t.getRowCount(); i++) {
            total = total + (Double.parseDouble(t.getValueAt(i, 3).toString()) * Double.parseDouble(t.getValueAt(i, 2).toString()));
            txtTongTien.setText(Double.toString(total));

        }
        // lấy phần trăm khuyến mãi theo đúng tên khuyến mãi
        KhuyenMai khuyenMai = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
        Integer phanTramKM = khuyenMai.getPhanTramKhuyenMai();

        giamGia = Double.parseDouble(phanTramKM.toString());
        khachCanTra = total - total * giamGia / 100;

        txtCanTra.setText(Double.toString(khachCanTra));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChiTiet;
    private javax.swing.JButton btnHienThi;
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
    private javax.swing.JButton txtTienThua1;
    private javax.swing.JButton txtTongTien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, dataTable2);
    }

    @Override
    public void setColumnNames(String[] columnNames) {
        ViewImp.setColumnNames(columnNames, dataTable2);
    }

    private HoaDonController hoaDonController;

    @Override
    public void setController(AbsController controller) {
        hoaDonController = (HoaDonController) hoaDonController;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
