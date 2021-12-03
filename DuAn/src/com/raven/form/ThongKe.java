package com.raven.form;

import Controller.AbsController;
import Controller.ChuyenDoi;
import Controller.HoaDonController;

import VIEW.ViewInterface;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import net.sf.oval.ConstraintViolation;

public class ThongKe extends javax.swing.JPanel implements ViewInterface {

    public ThongKe() throws ParseException {
        initComponents();
        setOpaque(false);
        init();
    }

    private void init() throws ParseException {
        HoaDonController hoaDonController = new HoaDonController(this);
        List<Object[]> data = hoaDonController.loadMonth();
           for (int i = 0; i < data.size(); i++) {
//            System.out.println(Double.parseDouble(String.valueOf(Arrays.toString(data.get(i)))));
               System.out.println(Arrays.toString(data.get(i)).replaceAll("\\D+",""));
          chart.addData(new ModelChart("June", new double[]{ChuyenDoi.SoDouble(Arrays.toString(data.get(i)).replaceAll("\\D+","")), 500000, 700000, 1000000}));
                    chart.addData(new ModelChart("July", new double[]{ChuyenDoi.SoDouble(Arrays.toString(data.get(i)).replaceAll("\\D+","")), 500000, 700000, 1000000}));
        }
      
        

//        List<Integer> ok = hoaDonController.loadMonth();
//        for (int i = 0; i < ok.size(); i++) {
//            System.out.println(ok.get(i));
//        }
        chart.addLegend("Income", new Color(245, 189, 135));
        chart.addLegend("Expense", new Color(135, 189, 245));
        chart.addLegend("Profit", new Color(189, 135, 245));
        chart.addLegend("Cost", new Color(139, 229, 222));
  
//        chart.addData(new ModelChart("June", new double[]{190, 500, 700, 1000}));
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.addRow(new Object[]{1, "Thang", "Nam", "30", "Thang1@gmail.com", "+0374984567"});
        model.addRow(new Object[]{1, "Thang", "Nam", "30", "Thang1@gmail.com", "+0374984567"});
        model.addRow(new Object[]{1, "Thang", "Nam", "30", "Thang1@gmail.com", "+0374984567"});
        model.addRow(new Object[]{1, "Thang", "Nam", "30", "Thang1@gmail.com", "+0374984567"});
        model.addRow(new Object[]{1, "Thang", "Nam", "30", "Thang1@gmail.com", "+0374984567"});
        model.addRow(new Object[]{1, "Thang", "Nam", "30", "Thang1@gmail.com", "+0374984567"});
        model.addRow(new Object[]{2, "Thang", "Nam", "30", "Thang1@gmail.com", "+0374984567"});
        model.addRow(new Object[]{3, "Thang", "Nam", "30", "Thang1@gmail.com", "+0374984567"});

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new com.raven.swing.PanelRound();
        chart = new com.raven.chart.Chart();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new com.raven.swing.TableColumn();
        jLabel2 = new javax.swing.JLabel();
        scrollBar1 = new com.raven.swing.ScrollBar();

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
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
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

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(79, 79, 79));
        jLabel2.setText("Table Data");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 1, 1));

        scrollBar1.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(scrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.chart.Chart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelRound panelRound1;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.TableColumn table;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {

    }

    @Override
    public void setColumnNames(String[] columnNames) {

    }

    @Override
    public void setController(AbsController controller) {

    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
