

package sip3;

import com.infosys.closeandmaxtabbedpane.CloseAndMaxTabbedPane;
import com.infosys.closeandmaxtabbedpane.CloseListener;
import com.infosys.closeandmaxtabbedpane.MaxListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import sip3.FormLogin;
import MstrPetugas.FormPetugas;

public class FormMainMenu extends javax.swing.JFrame {
    
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    public FormMainMenu() {
        initComponents();
        tabbedPane = new CloseAndMaxTabbedPane(true);
        tabbedPane.setBounds(new Rectangle(0,0, Layar.getWidth(),Layar.getHeight()));
        Layar.getContentContainer().add(tabbedPane);
        tabbedPane.addCloseListener(new CloseListener() {
            public void closeOperation(MouseEvent e) {
                tabbedPane.remove(tabbedPane.getOverTabIndex());
            }
        });

        tabbedPane.addMaxListener(new MaxListener() {
            public void maxOperation(MouseEvent e) {
                tabbedPane.detachTab(tabbedPane.getOverTabIndex());
                tabbedPane.firePopupOutsideTabEvent(e);
            }
        });
        //tabbedPane.setSize(dimensi.width-5,dimensi.height-130);
        tabbedPane.setSize(dimensi.width-190,dimensi.height-135);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setIconImage (getToolkit().getImage("img/icon.png"));
    }
    
    Component rf;
    private CloseAndMaxTabbedPane tabbedPane = null;
    private DefaultMutableTreeNode createNodes(DefaultMutableTreeNode parent, String childList) {
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(childList);
        parent.add(child);
        return child;
    }
    private void linkSantri(){
                try{
            rf = new MstrSantri.List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab("..::.. SANTRI ..::..", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
   private void linkGuru(){
                try{
            rf = new MstrGuru.List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab("..::.. PENGAJAR ..::..", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
   private void linkJadwal(){
                try{
            rf = new MstrJadwal.List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab("..::.. JADWAL ..::..", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    private void linkKasMasuk(){
                try{
            rf = new MstrKasMasuk.List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab("..::.. KAS MASUK ..::..", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btn_petugas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jXTaskPane1 = new org.jdesktop.swingx.JXTaskPane();
        jXHyperlink3 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink4 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink1 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink2 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink5 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink6 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink7 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink8 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink11 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink12 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink13 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink14 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink16 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink9 = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink15 = new org.jdesktop.swingx.JXHyperlink();
        Layar = new org.jdesktop.swingx.JXTitledPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        MenuItem_jadwal = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btn_petugas.setText("Petugas");
        btn_petugas.setFocusable(false);
        btn_petugas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_petugas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_petugasActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_petugas);

        jButton2.setText("Log Out");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setText("Keluar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jXTitledPanel1.setTitleDarkBackground(new java.awt.Color(0, 0, 255));

        jXTaskPane1.setBackground(new java.awt.Color(204, 228, 255));
        jXTaskPane1.setTitle("Menu");
        jXTaskPane1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXHyperlink3.setText("Guru");
        jXHyperlink3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHyperlink3ActionPerformed(evt);
            }
        });
        jXTaskPane1.getContentPane().add(jXHyperlink3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 10, 132, -1));

        jXHyperlink4.setText("--------------------------------");
        jXTaskPane1.getContentPane().add(jXHyperlink4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 26, 132, -1));

        jXHyperlink1.setText("Santri");
        jXHyperlink1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHyperlink1ActionPerformed(evt);
            }
        });
        jXTaskPane1.getContentPane().add(jXHyperlink1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 42, 132, -1));

        jXHyperlink2.setText("--------------------------------");
        jXTaskPane1.getContentPane().add(jXHyperlink2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 58, 132, -1));

        jXHyperlink5.setText("Kas Masuk");
        jXHyperlink5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHyperlink5ActionPerformed(evt);
            }
        });
        jXTaskPane1.getContentPane().add(jXHyperlink5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 74, 132, -1));

        jXHyperlink6.setText("--------------------------------");
        jXTaskPane1.getContentPane().add(jXHyperlink6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 90, 132, -1));

        jXHyperlink7.setText("Kas Keluar");
        jXHyperlink7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHyperlink7ActionPerformed(evt);
            }
        });
        jXTaskPane1.getContentPane().add(jXHyperlink7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 106, 132, -1));

        jXHyperlink8.setText("--------------------------------");
        jXTaskPane1.getContentPane().add(jXHyperlink8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 122, 132, -1));

        jXHyperlink11.setText("--------------------------------");
        jXTaskPane1.getContentPane().add(jXHyperlink11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 154, 132, -1));

        jXHyperlink12.setText("--------------------------------");
        jXTaskPane1.getContentPane().add(jXHyperlink12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 154, 132, -1));

        jXHyperlink13.setText("--------------------------------");
        jXTaskPane1.getContentPane().add(jXHyperlink13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 154, 132, -1));

        jXHyperlink14.setText("--------------------------------");
        jXTaskPane1.getContentPane().add(jXHyperlink14, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 154, 132, -1));

        jXHyperlink16.setText("Log_Out");
        jXHyperlink16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHyperlink16ActionPerformed(evt);
            }
        });
        jXTaskPane1.getContentPane().add(jXHyperlink16, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 138, 132, -1));

        jXHyperlink9.setText("Keluar");
        jXHyperlink9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHyperlink9ActionPerformed(evt);
            }
        });
        jXTaskPane1.getContentPane().add(jXHyperlink9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 132, -1));

        jXHyperlink15.setBackground(new java.awt.Color(204, 204, 255));
        jXHyperlink15.setForeground(new java.awt.Color(204, 204, 255));
        jXHyperlink15.setText("--------------------------------");
        jXTaskPane1.getContentPane().add(jXHyperlink15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 132, -1));

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTaskPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addComponent(jXTaskPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Layar.setTitleDarkBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout LayarLayout = new javax.swing.GroupLayout(Layar.getContentContainer());
        Layar.getContentContainer().setLayout(LayarLayout);
        LayarLayout.setHorizontalGroup(
            LayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );
        LayarLayout.setVerticalGroup(
            LayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Petugas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Log_Out");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Keluar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Master");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Santri");
        jMenu2.add(jMenuItem2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Guru");
        jMenu2.add(jMenuItem5);

        MenuItem_jadwal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        MenuItem_jadwal.setText("Jadwal");
        MenuItem_jadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_jadwalActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItem_jadwal);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Transaksi");

        jMenuItem7.setText("Kas  Masuk");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem6.setText("Kas Keluar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Help");

        jMenuItem8.setText("Penggunaan");
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Layar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Layar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jXHyperlink7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHyperlink7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXHyperlink7ActionPerformed

    private void jXHyperlink9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHyperlink9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXHyperlink9ActionPerformed

    private void jXHyperlink16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHyperlink16ActionPerformed
       this.dispose();
        FormLogin x = new FormLogin();
        x.setVisible(true);
    }//GEN-LAST:event_jXHyperlink16ActionPerformed

    private void jXHyperlink3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHyperlink3ActionPerformed
         linkGuru();
    }//GEN-LAST:event_jXHyperlink3ActionPerformed

    private void jXHyperlink1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHyperlink1ActionPerformed
        linkSantri();
    }//GEN-LAST:event_jXHyperlink1ActionPerformed

    private void btn_petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_petugasActionPerformed
        FormPetugas x = new FormPetugas();
        x.setVisible(true);
    }//GEN-LAST:event_btn_petugasActionPerformed

    private void jXHyperlink5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHyperlink5ActionPerformed
     linkKasMasuk();
    }//GEN-LAST:event_jXHyperlink5ActionPerformed

    private void MenuItem_jadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem_jadwalActionPerformed
     linkJadwal();
    }//GEN-LAST:event_MenuItem_jadwalActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTitledPanel Layar;
    private javax.swing.JMenuItem MenuItem_jadwal;
    private javax.swing.JButton btn_petugas;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink1;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink11;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink12;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink13;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink14;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink15;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink16;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink2;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink3;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink4;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink5;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink6;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink7;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink8;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink9;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    // End of variables declaration//GEN-END:variables
}
