package com.raven.form;

import Controller.AbsController;
import Controller.BanHangChiTietHoaDonController;
import Controller.BanHangController;
import Controller.ChiTietHoaDonController;
import Controller.ChuyenDoi;
import Controller.HoaDonBanHangController;
import Controller.HoaDonController;
import MODEL.KhachHang;
import MODEL.KhuyenMai;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import duan.dialog.HandleGioHangDal;
import duan.dialog.HandleTangSoLuongDal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.oval.ConstraintViolation;

public class BanHangPanel extends javax.swing.JPanel implements ViewInterface {

    private int tongSoLuong = 0;
    private HandleTangSoLuongDal tangSoLuongDal = null;
    private ChiTietHoaDonController chiTietHoaDonController;
    private HoaDonController hoaDonController;

    public BanHangPanel() {
        initComponents();
        setOpaque(false);
        BanHangController banHangController = new BanHangController(this);
        init();
        dataTable2.removeColumn(dataTable2.getColumnModel().getColumn(0));
        dataTable1.removeColumn(dataTable1.getColumnModel().getColumn(0));

        DefaultComboBoxModel<KhuyenMai> modle = (DefaultComboBoxModel<KhuyenMai>) cbbKhuyenMai.getModel();
        modle.removeAllElements();
        List<KhuyenMai> khuyenMais = banHangController.layCbbKhuyenMai();
        modle.addAll(khuyenMais);
        modle.setSelectedItem(khuyenMais.get(0));

        DefaultComboBoxModel<KhachHang> modle2 = (DefaultComboBoxModel<KhachHang>) cbbKhachHang.getModel();
        modle2.removeAllElements();
        List<KhachHang> khachHangs = banHangController.layCbbKhachHang();
        modle2.addAll(khachHangs);
        modle2.setSelectedItem(khachHangs.get(0));

        DecimalFormat df = new DecimalFormat("###.#");
//        dataTable2.getColumn("button").setCellRenderer(new ButtonRenderer());
//        dataTable2.getColumn("button").setCellEditor(
//            new ButtonEditor(new JCheckBox()));
        tangSoLuongDal = new HandleTangSoLuongDal(null, true);
        dataTable2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {

                    tangSoLuongDal.setVisible(true);
                    if (tangSoLuongDal == null) {
                        tangSoLuongDal = new HandleTangSoLuongDal(null, true);
                        tangSoLuongDal.txtSoLuong.setText("");
                    }
                };
            }
        });
        tangSoLuongDal.btnOk.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clicked!");
                if (dataTable1.getRowCount() == 0) {
                    TableModel model2 = dataTable2.getModel();
                    int[] indexs = dataTable2.getSelectedRows();
                    Object[] rows = new Object[6];
                    DefaultTableModel model1 = (DefaultTableModel) dataTable1.getModel();
                    for (int i = 0; i < indexs.length; i++) {
                        rows[0] = model2.getValueAt(indexs[i], 0);
                        rows[1] = model2.getValueAt(indexs[i], 1);
                        rows[2] = model2.getValueAt(indexs[i], 2);
                        rows[3] = model2.getValueAt(indexs[i], 3);
                        rows[4] = df.format(ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText()));
                        rows[5] = model2.getValueAt(indexs[i], 5);
//                            ID Sản Phẩm", "ID Chi Tiết", "Tên Sản Phẩm","Giá" ,"Số Lương", "Đơn Vị Tính"};
                        model1.addRow(rows);
                        System.out.println(rows[0]);

                    }
                } else {
                    double soLuong;
                    double t2RowID = Integer.parseInt(dataTable2.getModel().getValueAt(dataTable2.getSelectedRow(), 1).toString());
                    Object[] columnData = new Object[dataTable1.getColumnCount()];
                    Object[] rowData = new Object[dataTable1.getRowCount()];
                    for (int i = 0; i < dataTable1.getRowCount(); i++) {
                        if (t2RowID == Integer.parseInt(dataTable2.getModel().getValueAt(i, 1).toString())) {
                            System.out.println(Integer.parseInt(dataTable2.getModel().getValueAt(i, 1).toString()));
//                                soLuong = Integer.parseInt(dataTable2.getModel().getValueAt(dataTable2.getSelectedRow(), 6).toString());
                            soLuong = ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 3).toString()) + ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText());
                            dataTable1.getModel().setValueAt(df.format(soLuong), i, 4);
                            System.out.println("đã thêm số lượng");
                            return;
                        } else {
                            if (i != dataTable1.getRowCount() - 1) {
                                continue;
                            } else if (i == dataTable1.getRowCount() - 1) {
                                TableModel model2 = dataTable2.getModel();
                                int[] indexs = dataTable2.getSelectedRows();
                                Object[] rows = new Object[6];
                                DefaultTableModel model1 = (DefaultTableModel) dataTable1.getModel();
                                for (int j = 0; j < indexs.length; j++) {
                                    rows[0] = model2.getValueAt(indexs[j], 0);
                                    rows[1] = model2.getValueAt(indexs[j], 1);
                                    rows[2] = model2.getValueAt(indexs[j], 2);
                                    rows[3] = model2.getValueAt(indexs[j], 3);
                                    rows[4] = df.format(ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText()));
                                    rows[5] = model2.getValueAt(indexs[j], 5);
//                            ID Sản Phẩm", "ID Chi Tiết", "Tên Sản Phẩm","Giá" ,"Số Lương", "Đơn Vị Tính"};
                                    model1.addRow(rows);
                                    System.out.println(rows[0]);
                                    System.out.println("đã thêm cột mới");
                                }
                            }
                        }
                    }
                }
            }
        }
        );

        dataTable1.getModel().addTableModelListener(
                new TableModelListener() {
            public void tableChanged(TableModelEvent evt) {
                System.out.print("aa");
                hoaDonTable();
            }
        });

    }

    private void init() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchText1 = new com.raven.swing.SearchText();
        cbbDungLuong = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtThanhToan = new com.raven.swing.KButton();
        cbbKhuyenMai = new javax.swing.JComboBox<>();
        txtTienThua1 = new javax.swing.JButton();
        txtCanTra = new javax.swing.JButton();
        txtTongTien = new javax.swing.JButton();
        btnHienThi = new javax.swing.JButton();
        txtKhachDua = new javax.swing.JTextField();
        btnGioHang = new javax.swing.JLabel();
        btnChiTiet1 = new javax.swing.JLabel();
        btnGioHang1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbHinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        dataTable2 = new com.raven.swing.TableColumn();
        scrollBar2 = new com.raven.swing.ScrollBar();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dataTable1 = new com.raven.swing.TableColumn();
        scrollBar1 = new com.raven.swing.ScrollBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1043, 680));

        searchText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText1ActionPerformed(evt);
            }
        });
        searchText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchText1KeyReleased(evt);
            }
        });

        cbbDungLuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12GB", "60GB", "8GB" }));
        cbbDungLuong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbDungLuongItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cbbDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel5.setText("Tổng tiền hàng");

        jLabel4.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel4.setText("Giảm giá");

        jLabel6.setFont(new java.awt.Font("UTM Avo", 1, 13)); // NOI18N
        jLabel6.setText("Khách cần trả");

        jLabel3.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel3.setText("Khách thanh toán");

        jLabel1.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel1.setText("Tiền thừa trả khách");

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
        txtTienThua1.setEnabled(false);
        txtTienThua1.setRequestFocusEnabled(false);

        txtCanTra.setFont(new java.awt.Font("UTM Avo", 2, 14)); // NOI18N
        txtCanTra.setForeground(new java.awt.Color(0, 51, 51));
        txtCanTra.setEnabled(false);

        txtTongTien.setFont(new java.awt.Font("UTM Avo", 2, 14)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(0, 51, 51));
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

        btnGioHang.setBackground(new java.awt.Color(0, 153, 153));
        btnGioHang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnGioHang.setForeground(new java.awt.Color(255, 255, 255));
        btnGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/key.png"))); // NOI18N
        btnGioHang.setText("Giỏ Hàng");
        btnGioHang.setOpaque(true);
        btnGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGioHangMouseClicked(evt);
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

        btnGioHang1.setBackground(new java.awt.Color(0, 153, 153));
        btnGioHang1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnGioHang1.setForeground(new java.awt.Color(255, 255, 255));
        btnGioHang1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGioHang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/key.png"))); // NOI18N
        btnGioHang1.setText("Giỏ Hàng");
        btnGioHang1.setOpaque(true);
        btnGioHang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGioHang1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel2.setText("Hình thức thanh toán");

        cbbHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển khoản" }));
        cbbHinhThucThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbHinhThucThanhToanItemStateChanged(evt);
            }
        });
        cbbHinhThucThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbHinhThucThanhToanMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbbHinhThucThanhToanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbHinhThucThanhToanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbbHinhThucThanhToanMouseReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel7.setText("Khách hàng");

        cbbKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhachHangItemStateChanged(evt);
            }
        });
        cbbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKhachHangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbbKhachHangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbKhachHangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbbKhachHangMouseReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel8.setText("Ghi Chú");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChiTiet1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGioHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbHinhThucThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKhachDua)
                            .addComponent(txtTienThua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbbKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGhiChu))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
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
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnChiTiet1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGioHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane4.setBorder(null);
        jScrollPane4.setVerticalScrollBar(scrollBar2);

        dataTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Sản Phẩm", "Id Chi Tiết", "Tên Sản Phẩm", "Giá", "Số Lượng", "ĐVT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable2.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 250));
        jScrollPane4.setViewportView(dataTable2);

        jPanel6.add(jScrollPane4);
        jPanel6.add(scrollBar2);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane3.setBorder(null);
        jScrollPane3.setVerticalScrollBar(scrollBar1);

        dataTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Sản Phẩm", "Id Chi Tiết", "Tên Sản Phẩm", "Giá", "Số Lượng", "ĐVT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable1.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 250));
        jScrollPane3.setViewportView(dataTable1);

        jPanel7.add(jScrollPane3);
        jPanel7.add(scrollBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhToanActionPerformed
        BanHangController banHangController = new BanHangController(this);
        HoaDonBanHangController hoaDonBanHangController = new HoaDonBanHangController(this);
        BanHangChiTietHoaDonController banHangChiTietHoaDonController = new BanHangChiTietHoaDonController(this);
        KhuyenMai khuyenMai = (KhuyenMai) cbbKhuyenMai.getSelectedItem();

        Integer idKM = khuyenMai.getId();
        System.out.println(idKM);
        Integer idNV = DangNhapPnl.ID;
        java.sql.Timestamp now = new Timestamp((new java.util.Date()).getTime());
        double tongTien = Double.parseDouble(txtTongTien.getText());

        hoaDonBanHangController.ThemHD(1, idNV, idKM, tongSoLuong, tongTien, now, cbbHinhThucThanhToan.getSelectedItem().toString(), txtGhiChu.getText());
        hoaDonBanHangController.loadList();
        dataTable2.removeColumn(dataTable2.getColumnModel().getColumn(0));

        System.out.println(banHangController.idHoaDon());
        int row = dataTable2.getModel().getRowCount();
        int column = dataTable2.getModel().getColumnCount();
        System.out.println(row);
        System.out.println(column);

        int idSanPham = 0, SoLuong = 0, idHoaDon;
        String tenSanPham = "";
        double Gia = 0;
        for (int i = 0; i < row; i++) {
            idHoaDon = banHangController.idHoaDon();
            idSanPham = Integer.valueOf(dataTable1.getModel().getValueAt(i, 0).toString());
            tenSanPham = dataTable1.getValueAt(i, 1).toString();
            SoLuong = Integer.valueOf(dataTable1.getValueAt(i, 5).toString());
            Gia = ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 4).toString());
//idSanPham, idHoaDon, TenSanPham, SoLuong, Gia, TongTien

            double TongTien = ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 4).toString()) * ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 5).toString());
            System.out.println(idSanPham);
            System.out.println(idHoaDon);
            System.out.println(tenSanPham);
            System.out.println(SoLuong);
            System.out.println(Gia);
            System.out.println(tongTien);
            DecimalFormat df = new DecimalFormat("###.#");
            Object[] data = new Object[6];
            data[0] = 0;
            data[1] = idSanPham;
            data[2] = idHoaDon;
            data[3] = SoLuong;
            data[4] = Gia;
            data[5] = tongTien;

//                chiTietHoaDonController.ThemCTHD(idSanPham, idHoaDon, tenSanPham, SoLuong, Gia, TongTien);
            banHangChiTietHoaDonController.insertNoLoadList(data);

        }

    }//GEN-LAST:event_txtThanhToanActionPerformed

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
        String dau = txtKhachDua.getText();
        double chuyen = ChuyenDoi.SoDouble(dau);
        txtKhachDua.setText(ChuyenDoi.SoString(chuyen));

        double tienKhachDua, tienCanTra, tienThua;
        tienCanTra = ChuyenDoi.SoDouble(txtCanTra.getText());
        tienKhachDua = ChuyenDoi.SoDouble(txtKhachDua.getText());
        tienThua = tienKhachDua - tienCanTra;
        txtTienThua1.setText(ChuyenDoi.SoString(tienThua));
    }//GEN-LAST:event_txtKhachDuaKeyReleased

    private void btnGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGioHangMouseClicked
        // TODO add your handling code here:
        int i = 1;
        HandleGioHangDal giohangDal = new HandleGioHangDal(null, true);
        if (i == 1) {
            giohangDal.setVisible(true);
            i = 0;
        } else {
            giohangDal.setVisible(false);
            i = 1;
        }

        //        chiTietSanPhamDialog.errorLB.setText("");

    }//GEN-LAST:event_btnGioHangMouseClicked

    private void btnChiTiet1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChiTiet1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChiTiet1MouseClicked

    private void btnGioHang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGioHang1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGioHang1MouseClicked

    private void searchText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText1ActionPerformed

    private void cbbHinhThucThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbHinhThucThanhToanItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhThucThanhToanItemStateChanged

    private void cbbHinhThucThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbHinhThucThanhToanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhThucThanhToanMouseClicked

    private void cbbHinhThucThanhToanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbHinhThucThanhToanMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhThucThanhToanMouseExited

    private void cbbHinhThucThanhToanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbHinhThucThanhToanMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhThucThanhToanMousePressed

    private void cbbHinhThucThanhToanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbHinhThucThanhToanMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhThucThanhToanMouseReleased

    private void cbbKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhachHangItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangItemStateChanged

    private void cbbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhachHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangMouseClicked

    private void cbbKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhachHangMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangMouseExited

    private void cbbKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhachHangMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangMousePressed

    private void cbbKhachHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhachHangMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangMouseReleased

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased
        // TODO add your handling code here:

        BanHangController banHangController = new BanHangController(this);

        String ten = "%" + searchText1.getText() + "%";
        System.out.println(ten);
        banHangController.search(ten);
        dataTable2.removeColumn(dataTable2.getColumnModel().getColumn(0));

    }//GEN-LAST:event_searchText1KeyReleased

    private void cbbDungLuongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDungLuongItemStateChanged
        // TODO add your handling code here:
        BanHangController banHangController = new BanHangController(this);
        String dungLuong = "%" + cbbDungLuong.getSelectedItem().toString() + "%";

        String ten = "%" + searchText1.getText() + "%";
        System.out.println(ten);

        System.out.println(dungLuong);

        if (searchText1.getText().trim().equals("")) {
            banHangController.searchDungLuong(dungLuong);
            dataTable2.removeColumn(dataTable2.getColumnModel().getColumn(0));
        } else {
            banHangController.searchDungLuongTheoTen(ten, dungLuong);
            dataTable2.removeColumn(dataTable2.getColumnModel().getColumn(0));
        }

    }//GEN-LAST:event_cbbDungLuongItemStateChanged
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

        double total = 0;
        double tienTungMon = 0;
        for (int i = 0; i < dataTable1.getRowCount(); i++) {
            total = total + (ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 2).toString()) * ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 3).toString()));
            txtTongTien.setText(ChuyenDoi.SoString(total));
            tongSoLuong = Integer.parseInt(dataTable1.getValueAt(i, 3).toString());
        }
        // lấy phần trăm khuyến mãi theo đúng tên khuyến mãi
        KhuyenMai khuyenMai = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
        Integer phanTramKM = khuyenMai.getPhanTramKhuyenMai();

        giamGia = ChuyenDoi.SoDouble(phanTramKM.toString());
        khachCanTra = total - total * giamGia / 100;

        txtCanTra.setText(ChuyenDoi.SoString(khachCanTra));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChiTiet1;
    private javax.swing.JLabel btnGioHang;
    private javax.swing.JLabel btnGioHang1;
    private javax.swing.JButton btnHienThi;
    private javax.swing.JComboBox<String> cbbDungLuong;
    private javax.swing.JComboBox<String> cbbHinhThucThanhToan;
    private javax.swing.JComboBox<KhachHang> cbbKhachHang;
    private javax.swing.JComboBox<KhuyenMai> cbbKhuyenMai;
    private com.raven.swing.TableColumn dataTable1;
    private com.raven.swing.TableColumn dataTable2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.ScrollBar scrollBar2;
    private com.raven.swing.SearchText searchText1;
    private javax.swing.JButton txtCanTra;
    private javax.swing.JTextField txtGhiChu;
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

    private BanHangController banHangController;

    @Override
    public void setController(AbsController controller) {
        banHangController = (BanHangController) banHangController;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
