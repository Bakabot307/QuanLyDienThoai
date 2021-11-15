package com.raven.form;

import Controller.AbsController;
import Controller.SanPhamController;
import VIEW.ViewImp;
import java.awt.Color;
import java.util.Date;
import VIEW.ViewInterface;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.constraint.Length;

public class BanHangPanel extends javax.swing.JPanel implements ViewInterface {
    private themxoasua themxoasua;
    public BanHangPanel() {
        initComponents();
        SanPhamController sanPhamController = new SanPhamController(this);
        time();
        setOpaque(false);
//         themxoasua abc = new themxoasua();
//        add(abc);
//        abc.setVisible(true);
//        
    }

    private void time() {
        Thread timeThread = new Thread(() -> {
            while (true) {
                Date date = new Date();
                String time = date.getHours() + "h : " + date.getMinutes() + "p : " + date.getSeconds() + "s";
                try {
                    lbTime.setText(" Time: " + time);
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {

                }
            }
        });
        timeThread.start();

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShow = new javax.swing.JPanel();
        thaoTac = new javax.swing.JPanel();
        lbTime = new javax.swing.JLabel();
        kButton1 = new com.raven.swing.KButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable2 = new com.raven.swing.TableColumn();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataTable = new com.raven.swing.TableColumn();
        jPanel3 = new javax.swing.JPanel();

        setBackground(new Color(0,0,0,0));
        setLayout(new java.awt.BorderLayout());

        panelShow.setBorder(new javax.swing.border.MatteBorder(null));
        panelShow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        thaoTac.setBorder(new javax.swing.border.MatteBorder(null));

        lbTime.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 255, 255));
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTime.setText("  ");

        kButton1.setText("Thanh toán");
        kButton1.setFont(new java.awt.Font("UTM Avo", 0, 18)); // NOI18N
        kButton1.setkEndColor(new java.awt.Color(0, 153, 153));

        jLabel1.setText("Tiền thừa trả khách");

        jLabel3.setText("Khách thanh toán");

        jLabel4.setText("Giảm giá");

        jLabel5.setText("Tổng tiền hàng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Khách cần trả");

        jButton1.setText("  ");
        jButton1.setEnabled(false);

        jButton2.setText("  ");
        jButton2.setEnabled(false);

        jButton3.setText("  ");
        jButton3.setEnabled(false);

        jButton4.setText("  ");
        jButton4.setEnabled(false);

        jButton5.setText("  ");
        jButton5.setEnabled(false);

        jButton6.setText("them");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout thaoTacLayout = new javax.swing.GroupLayout(thaoTac);
        thaoTac.setLayout(thaoTacLayout);
        thaoTacLayout.setHorizontalGroup(
            thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thaoTacLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thaoTacLayout.createSequentialGroup()
                        .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thaoTacLayout.createSequentialGroup()
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
            .addGroup(thaoTacLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(thaoTacLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(thaoTacLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        thaoTacLayout.setVerticalGroup(
            thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thaoTacLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(thaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        panelShow.add(thaoTac, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 300, 560));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setBorder(null);

        dataTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(dataTable2);

        panelShow.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 654, 248));

        jScrollPane2.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane2.setBorder(null);

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(dataTable);

        panelShow.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 512, 286));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelShow.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 760, -1));

        add(panelShow, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

//TableModel model1 = dataTable.getModel();
//int indexs[] = dataTable.getSelectedRows();
//     dataTable3t[] row = new Object[7];
//   dataTable3aultTableModel model2 = (DefaultTableModel) dataTable2.getModel();
//        
//for(int i = 0; i < indexs.length; i++)
//{
//row[0] = model1.getValueAt(indexs[i], 0);
//row[1] = model1.getValueAt(indexs[i], 1);
//row[2] = model1.getValueAt(indexs[i], 2);
//row[3] = model1.getValueAt(indexs[i], 3);
//row[4] = model1.getValueAt(indexs[i], 4);
//row[5] = model1.getValueAt(indexs[i], 5);
//row[6] = model1.getValueAt(indexs[i], 6);
//
//
//    model2.addRow(row);



    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.TableColumn dataTable;
    private com.raven.swing.TableColumn dataTable2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private com.raven.swing.KButton kButton1;
    private javax.swing.JLabel lbTime;
    private javax.swing.JPanel panelShow;
    private javax.swing.JPanel thaoTac;
    // End of variables declaration//GEN-END:variables

    AbsController controller;

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, dataTable);
    }

//    @Override
//    public void setColumnNames(String[dataTable3ames) {
//        ViewImp.setColumnNames(columnNames, dataTable);
//    }

    private SanPhamController sanPhamController;


    public void setController(AbsController controller) {
        sanPhamController = (SanPhamController) controller;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColumnNames(String[] columnNames) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
