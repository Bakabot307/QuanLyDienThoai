/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duan.dialog;

import Controller.ChuyenDoi;
import com.raven.swing.MImage;
import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Admin
 */
public class HandleTangSoLuongDal extends javax.swing.JDialog {

    /**
     * Creates new form KhachHangDialog
     */
    double soLuong= 0;
    
    
    public HandleTangSoLuongDal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setIconImage(MImage.getAppIcon());
        
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnTang1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnOk = new javax.swing.JLabel();
        btnGiam = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnTang1.setBackground(new java.awt.Color(0, 153, 153));
        btnTang1.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnTang1.setForeground(new java.awt.Color(255, 255, 255));
        btnTang1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/arrow-up.png"))); // NOI18N
        btnTang1.setText("   Tăng");
        btnTang1.setOpaque(true);
        btnTang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTang1MouseClicked(evt);
            }
        });

        title.setFont(new java.awt.Font("UTM Avo", 1, 15)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title.setText("Số lượng");

        txtSoLuong.setFont(new java.awt.Font("UTM Avo", 1, 14)); // NOI18N
        txtSoLuong.setText("1");
        txtSoLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });

        btnOk.setBackground(new java.awt.Color(102, 102, 102));
        btnOk.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/save-as-16.png"))); // NOI18N
        btnOk.setText("  OK");
        btnOk.setOpaque(true);
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOkMouseClicked(evt);
            }
        });

        btnGiam.setBackground(new java.awt.Color(0, 153, 153));
        btnGiam.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        btnGiam.setForeground(new java.awt.Color(255, 255, 255));
        btnGiam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGiam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/arrow-down.png"))); // NOI18N
        btnGiam.setText("   Giảm");
        btnGiam.setOpaque(true);
        btnGiam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGiamMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTang1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 222, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnTang1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnOkMouseClicked

    private void btnGiamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGiamMouseClicked
         soLuong=soLuong-1; 
            txtSoLuong.setText(ChuyenDoi.SoString(soLuong));
            
//             NumberFormat format = NumberFormat.getInstance();
//    NumberFormatter formatter = new NumberFormatter(format);
//    formatter.setValueClass(Integer.class);
//    formatter.setMinimum(0);
//    formatter.setMaximum(Integer.MAX_VALUE);
//    formatter.setAllowsInvalid(false);
//    // If you want the value to be committed on each keystroke instead of focus lost
//    formatter.setCommitsOnValidEdit(true);
//    JFormattedTextField field = new JFormattedTextField(formatter);
//
//
//
//    // getValue() always returns something valid
//    System.out.println(field.getValue(txtSoLuong.getText()));
    }//GEN-LAST:event_btnGiamMouseClicked

    private void btnTang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTang1MouseClicked
         soLuong=soLuong+1;
           txtSoLuong.setText(ChuyenDoi.SoString(soLuong));
       
    }//GEN-LAST:event_btnTang1MouseClicked

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
         String dau = txtSoLuong.getText();
        double chuyen = ChuyenDoi.SoDouble(dau);
        txtSoLuong.setText(ChuyenDoi.SoString(chuyen));
        soLuong=(int) ChuyenDoi.SoDouble(txtSoLuong.getText());
    }//GEN-LAST:event_txtSoLuongKeyReleased

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
       /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(KhachHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(KhachHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(KhachHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(KhachHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

       /* Create and display the dialog */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HandleTangSoLuongDal dialog = new HandleTangSoLuongDal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnGiam;
    public javax.swing.JLabel btnOk;
    public javax.swing.JLabel btnTang1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel title;
    public javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
