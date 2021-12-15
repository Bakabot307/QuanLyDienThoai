package com.raven.form;

import Controller.AbsController;
import Controller.BanHangChiTietHoaDonController;
import Controller.BanHangController;
import Controller.ChiTietHoaDonController;
import Controller.ChuyenDoi;
import Controller.HoaDonBanHangController;
import Controller.HoaDonController;
import MODEL.ChiTietSanPham;
import MODEL.HoaDon;
import MODEL.KhachHang;
import MODEL.KhuyenMai;
import MODEL.SanPham;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import static com.raven.form.ThongKe.tableData;
import duan.dialog.HandleGioHangDal;
import duan.dialog.HandleKhachHangDal;
import duan.dialog.HandleTangSoLuongDal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.oval.ConstraintViolation;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class BanHangPanel extends javax.swing.JPanel implements ViewInterface {

    private HandleKhachHangDal khachHangDialog = null;
    private int tongSoLuong = 0;
    private HandleTangSoLuongDal tangSoLuongDal = null;
    private ChiTietHoaDonController chiTietHoaDonController;
    private HoaDonController hoaDonController;

    public BanHangPanel() {

        initComponents();
        setOpaque(false);
        txtGhiChu.setLineWrap(true);
        txtGhiChu.setWrapStyleWord(true);
        BanHangController banHangController = new BanHangController(this);
        if (khachHangDialog == null) {
            khachHangDialog = new HandleKhachHangDal(null, true);
            khachHangDialog.addBT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //validate

                    if (khachHangDialog.txtTen.getText().trim().equals("")) {
                        khachHangDialog.errorlb.setText("Vui lòng điền tên khách hàng ! ");
                        return;
                    }
                    if (khachHangDialog.txtSdt.getText().trim().equals("")) {
                        khachHangDialog.errorlb.setText("Vui lòng điền số điện thoại ! ");
                        return;
                    }
                    if (!khachHangDialog.txtSdt.getText().matches("^\\d{10}$")) {
                        khachHangDialog.errorlb.setText("Số điện thoại không hợp lệ ! ");
                        return;
                    }

                    if (khachHangDialog.txtDiaChi.getText().trim().equals("")) {
                        khachHangDialog.errorlb.setText("Vui lòng điền địa chỉ ! ");
                        return;
                    }
                    if (khachHangDialog.txtCMND.getText().trim().equals("")) {
                        khachHangDialog.errorlb.setText("Vui lòng điền số CMND ! ");
                        return;
                    }
                    if (khachHangDialog.txtEmail.getText().trim().equals("")) {
                        khachHangDialog.errorlb.setText("Vui lòng điền email ! ");
                        return;
                    }
                    if (!khachHangDialog.txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                        khachHangDialog.errorlb.setText("Email không hợp lệ ! ");
                        return;
                    }

                    String gioiTinh;
//                    Object[] values = new Object[8];
//                    values[0] = 0;
//                    values[1] = khachHangDialog.txtTen.getText();
//                    values[2] = khachHangDialog.txtSdt.getText();
//                    values[3] = khachHangDialog.txtDiaChi.getText();
//                    values[4] = khachHangDialog.txtCMND.getText();
//                    values[5] = khachHangDialog.txtGhiChu.getText();
                    if (khachHangDialog.cbNam.isSelected()) {
                        gioiTinh = "Nam";
                    } else if (!khachHangDialog.cbNu.isSelected() && !khachHangDialog.cbNam.isSelected()) {
                        khachHangDialog.errorlb.setText("Vui lòng chọn giới tính ! ");
                        return;
                    } else {
                        gioiTinh = "Nữ";
                    }
//                    values[7] = khachHangDialog.txtEmail.getText();
//                    banHangController.insert(values);

                    banHangController.themKH(khachHangDialog.txtTen.getText(), khachHangDialog.txtSdt.getText(), khachHangDialog.txtDiaChi.getText(),
                            khachHangDialog.txtCMND.getText(), khachHangDialog.txtGhiChu.getText(), "nam", khachHangDialog.txtEmail.getText());
                    DefaultComboBoxModel<KhachHang> modle2 = (DefaultComboBoxModel<KhachHang>) cbbKhachHang.getModel();
                    modle2.removeAllElements();
                    List<KhachHang> khachHangs = banHangController.layCbbKhachHang();
                    modle2.addAll(khachHangs);
                    modle2.setSelectedItem(khachHangs.get(0));
                    System.out.println(cbbKhachHang.getItemCount());
                    cbbKhachHang.setSelectedIndex(cbbKhachHang.getItemCount() - 1);
                    AutoCompleteDecorator.decorate(cbbKhachHang);
                

                }
            });
        }
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
        AutoCompleteDecorator.decorate(cbbKhachHang);
        DecimalFormat df = new DecimalFormat("###.#");
//        dataTable2.getColumn("button").setCellRenderer(new ButtonRenderer());
//        dataTable2.getColumn("button").setCellEditor(
//            new ButtonEditor(new JCheckBox()));
        tangSoLuongDal = new HandleTangSoLuongDal(null, true);
        dataTable2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                //set dialog visible
                if (me.getClickCount() == 2) {
                    tangSoLuongDal.txtSoLuong.setText(ChuyenDoi.SoString(0));
                    tangSoLuongDal.setVisible(true);
                    if (tangSoLuongDal == null) {
                        
                        tangSoLuongDal = new HandleTangSoLuongDal(null, true);
                        
                    }
                };
            }
        });
        //double click event
        tangSoLuongDal.btnOk.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //if table 1 is null, add new row
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
                        System.out.println("added new row if null, quanity: " + df.format(ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText())));
                    }

                } else {
                    double soLuong;
                    double t2RowID = ChuyenDoi.SoDouble(dataTable2.getModel().getValueAt(dataTable2.getSelectedRow(), 1).toString());
                    for (int i = 0; i < dataTable1.getRowCount(); i++) {
                        //else check if the id  exists. true: add quantity   
                        if (t2RowID == Integer.parseInt(dataTable1.getModel().getValueAt(i, 1).toString())) {
                            System.out.println(Integer.parseInt(dataTable2.getModel().getValueAt(i, 1).toString()));
                            soLuong = ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 3).toString()) + ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText());
                            dataTable1.getModel().setValueAt(df.format(soLuong), i, 4);
                            System.out.println("increased quantity");
                            return;
                            //false: add new row    
                        } else {
                            if (i == dataTable1.getRowCount() - 1) {
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
                                    System.out.println("added new row if exist, quanlity: " + df.format(ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText())));
                                    rows[5] = model2.getValueAt(indexs[j], 5);
//                            ID Sản Phẩm", "ID Chi Tiết", "Tên Sản Phẩm","Giá" ,"Số Lương", "Đơn Vị Tính"};
                                    model1.addRow(rows);
                                    return;
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
    AutoCompleteDecorator.decorate(cbbHinhThucThanhToan);
                     AutoCompleteDecorator.decorate(cbbKhuyenMai);
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
        jLabel2 = new javax.swing.JLabel();
        cbbHinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnThemKh = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
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
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cbbDungLuong))
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

        btnThemKh.setBackground(new java.awt.Color(0, 153, 153));
        btnThemKh.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        btnThemKh.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThemKh.setText("+");
        btnThemKh.setOpaque(true);
        btnThemKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemKhMouseClicked(evt);
            }
        });

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jSeparator1)
                        .addGap(226, 226, 226))
                    .addGroup(jPanel3Layout.createSequentialGroup()
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbHinhThucThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKhachDua)
                            .addComponent(txtTienThua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThemKh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel6)))
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
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
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
                false, false, false, false, false, false
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
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
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
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
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
        double tongTien = ChuyenDoi.SoDouble(txtTongTien.getText());

        hoaDonBanHangController.ThemHD(1, idNV, idKM, tongSoLuong, tongTien, now, cbbHinhThucThanhToan.getSelectedItem().toString(), txtGhiChu.getText());
        hoaDonBanHangController.loadList();

        System.out.println(banHangController.idHoaDon());
        int row = dataTable2.getModel().getRowCount();
        int column = dataTable2.getModel().getColumnCount();
        System.out.println(row);
        System.out.println(column);

        int idSanPham = 0, SoLuong = 0, idHoaDon;
        String tenSanPham = "";
        double Gia = 0;
        for (int i = 0; i < dataTable1.getRowCount(); i++) {
            idHoaDon = banHangController.idHoaDon();
            idSanPham = Integer.valueOf(dataTable1.getModel().getValueAt(i, 0).toString());

            tenSanPham = dataTable1.getValueAt(i, 1).toString();
            Gia = ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 2).toString());
            SoLuong = Integer.valueOf(dataTable1.getValueAt(i, 3).toString());

//idSanPham, idHoaDon, TenSanPham, SoLuong, Gia, TongTien
            double TongTien = ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 2).toString()) * ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 3).toString());
            System.out.println("cthd");
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

            banHangChiTietHoaDonController.insertNoLoadList(data);

        }
        //update soLuong data for SanPham 
        
        ArrayList<SanPham> list = banHangChiTietHoaDonController.DSSanPham();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < dataTable1.getRowCount(); j++) {
                int idSP = Integer.valueOf(dataTable1.getModel().getValueAt(j, 0).toString());
                if (list.get(i).getId() == idSP) {
                    int SoLuongSPDaMua = 0;
                    SoLuongSPDaMua = SoLuongSPDaMua + Integer.parseInt(dataTable1.getValueAt(j, 3).toString());
                    int soLuongConLai = list.get(i).getSoLuong() - SoLuongSPDaMua;
                    System.out.println(soLuongConLai);
                    banHangChiTietHoaDonController.editSoLuongSanPham(soLuongConLai, idSP);
                }
            }
        }

        
        ArrayList<ChiTietSanPham> listCTSP = banHangChiTietHoaDonController.DSCTSP();
        for (int i = 0; i < listCTSP.size(); i++) {
            for (int j = 0; j < dataTable1.getRowCount(); j++) {
                int idCTSP = Integer.valueOf(dataTable1.getModel().getValueAt(j, 1).toString());
                if (listCTSP.get(i).getId() == idCTSP) {
                    int SoLuongCTSPDaMua = 0;
                    SoLuongCTSPDaMua = SoLuongCTSPDaMua + Integer.parseInt(dataTable1.getValueAt(j, 3).toString());
                    int soLuongConLai = listCTSP.get(i).getSoLuong() - SoLuongCTSPDaMua;
                    System.out.println(soLuongConLai);
                    banHangChiTietHoaDonController.editSoLuongChiTiet(soLuongConLai, idCTSP);
                }
            }
        }
hoaDonBanHangController.loadList();
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
        hoaDonTable();
        

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

    private void btnThemKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemKhMouseClicked
        // TODO add your handling code here:
        khachHangDialog.errorlb.setText("");
        khachHangDialog.txtTen.setText("");
        khachHangDialog.txtSdt.setText("");
        khachHangDialog.txtDiaChi.setText("");
        khachHangDialog.txtCMND.setText("");
        khachHangDialog.txtGhiChu.setText("");
        khachHangDialog.txtEmail.setText("");
        khachHangDialog.cbNam.setSelected(false);
        khachHangDialog.cbNu.setSelected(false);
        khachHangDialog.title.setText("Thêm Khách Hàng ");
        khachHangDialog.setVisible(true);
    }//GEN-LAST:event_btnThemKhMouseClicked
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
    private javax.swing.JButton btnHienThi;
    private javax.swing.JLabel btnThemKh;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.ScrollBar scrollBar2;
    private com.raven.swing.SearchText searchText1;
    private javax.swing.JButton txtCanTra;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtKhachDua;
    private com.raven.swing.KButton txtThanhToan;
    private javax.swing.JButton txtTienThua1;
    private javax.swing.JButton txtTongTien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, dataTable2);
        if (khachHangDialog != null) {
            khachHangDialog.setVisible(false);
        }
    }

    @Override
    public void setColumnNames(String[] columnNames) {

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
