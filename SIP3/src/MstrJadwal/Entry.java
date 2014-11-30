/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MstrJadwal;
/**
 *
 * @author Suhendar
 */
import Class.DbKoneksi;
import Class.MstrJadwal;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;
import java.sql.ResultSet;
import java.sql.Statement;

public class Entry extends javax.swing.JFrame {
    Connection _Cnn;
    DbKoneksi getCnn = new DbKoneksi();
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    String _ID; // untuk primarykey
    String _Status; // save atau delete
    String _Jadwal; 
    public Entry() {
        initComponents();
    }
public Entry(String jadwal,String id,String status) {
        initComponents();
        _ID = id;
        if(status.equals("edit")){
            btn_simpan.setText("Update");
        }
        _Status = status;
        _Jadwal = jadwal;
        ListPengajar();
        Search();
        this.setLocation(dimensi.width/2 - this.getWidth()/2,dimensi.height/2 - this.getHeight()/2);
    }
    private void Search(){
        try {
            MstrJadwal x = new MstrJadwal();
            x.Search(_ID);
            if(x._Akses.equals("-")){
                txt_id.setText(x.id_jadwal);
                txt_mapel.setText(x.nama_mata);
                txt_jam.setText(x.jam_belajar);
                cmb_hari.setSelectedItem(x.hari);
                txt_tempat.setText(x.tempat);
                cmb_nama_pengajar.setSelectedItem(x.nama_pengajar);
                txt_id.setEditable(false);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_jam = new javax.swing.JTextField();
        cmb_hari = new javax.swing.JComboBox();
        txt_mapel = new javax.swing.JTextField();
        txt_tempat = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cmb_nama_pengajar = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btn_batal = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(50, 149, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Entry Data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jXTitledPanel1.setTitle("+ Manipulasi Jadwal");

        jLabel2.setText("Id ");

        jLabel3.setText("Mata Pelajaran");

        jLabel4.setText("Jam Belajar");

        jLabel5.setText("Hari ");

        jLabel11.setText("Tempat ");

        txt_jam.setText("00:00 - 00:00");

        cmb_hari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SENIN", "SELASA", "RABU", "KAMIS", "JUM'AT", "SABTU" }));

        jLabel14.setText("Nama Pengajar");

        cmb_nama_pengajar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_nama_pengajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_nama_pengajarActionPerformed(evt);
            }
        });
        cmb_nama_pengajar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                cmb_nama_pengajarCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addGap(44, 44, 44)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tempat, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_hari, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_mapel)
                        .addComponent(txt_jam, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                    .addComponent(cmb_nama_pengajar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_mapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_jam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_hari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(27, 27, 27))
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tempat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmb_nama_pengajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
        );

        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_simpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_keluar)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batal)
                    .addComponent(btn_keluar)
                    .addComponent(btn_simpan))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
      try{
            MstrJadwal x = new MstrJadwal();
            x.Search(txt_id.getText());
            x.id_jadwal =  txt_id.getText();
            x.nama_mata =  txt_mapel.getText();
            x.jam_belajar =  txt_jam.getText();
            x.hari =  cmb_hari.getSelectedItem().toString();
            x.tempat =  txt_tempat.getText();
            x.nama_pengajar =  cmb_nama_pengajar.getSelectedItem().toString();
           
            if(x._Akses.equals("-")){
                x.UpdateData();
                txt_id.setEditable(false);
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
            }else{
                x.SaveData();
                txt_id.setEditable(false);
                JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
            }
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
                     
                                 
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void cmb_nama_pengajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_nama_pengajarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_nama_pengajarActionPerformed

    private void cmb_nama_pengajarCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmb_nama_pengajarCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_nama_pengajarCaretPositionChanged

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    public javax.swing.JButton btn_keluar;
    public javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox cmb_hari;
    private javax.swing.JComboBox cmb_nama_pengajar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_jam;
    private javax.swing.JTextField txt_mapel;
    private javax.swing.JTextField txt_tempat;
    // End of variables declaration//GEN-END:variables

 String[] KeyPengajar;
    private void ListPengajar(){
        try{
             _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "" +
                    "   SELECT id_guru,nama_guru " +
                    "   FROM guru";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            cmb_nama_pengajar.removeAllItems();
            int i = 0;
            while(res.next()){
                cmb_nama_pengajar.addItem(res.getString(2));
                i++;
            }
            res.first();
            KeyPengajar = new String[i+1];
            for(Integer x = 0;x < i;x++){
                KeyPengajar[x] = res.getString(1);
                res.next();
            }
        } catch (Exception ex){
        }
    }
}