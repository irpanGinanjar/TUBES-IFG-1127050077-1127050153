/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MstrKasMasuk;

import Class.DbKoneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Class.MstrKasMasuk;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import Class.FrmViewReport;
import Class.print_kas_masuk;
public class List extends javax.swing.JFrame {
private DefaultTableModel _Tampung_tabel_mstr_KasMasuk;
    Connection _Cnn;
    
    
    public List() {
    initComponents();

        String[] kolom = {"No","Tgl Masuk","Keterangan Masuk","Jumlah Uang"};
        _Tampung_tabel_mstr_KasMasuk = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
               
               
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _Tampung_tabel_mstr_KasMasuk.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        tabel_kas_masuk.setModel(_Tampung_tabel_mstr_KasMasuk);
        LoadData();
        LoadData2();
    }
     public void HapusTabel(){
        int row = _Tampung_tabel_mstr_KasMasuk.getRowCount();
        for (int i = 0;i < row;i++){
            _Tampung_tabel_mstr_KasMasuk.removeRow(0);
        }
    }
    
     private void LoadData(){
        try{
            _Cnn = null;
            Double ttl=0.0;
            Double a;
            DbKoneksi getCnn = new DbKoneksi();
            _Cnn = getCnn.getConnection();
            HapusTabel();
            SimpleDateFormat t2 = new SimpleDateFormat("yyyy-MM-dd");
            String ttg = t2.format(txt_Awal.getDate());

            SimpleDateFormat t3 = new SimpleDateFormat("yyyy-MM-dd");
            String ttg1 = t3.format(txt_Akhir.getDate());
            String sql = "" +
                    "   SELECT id,tgl_masuk,ket_masuk,jumlah_uang" +
                    "   FROM kas_masuk" +
                     "   WHERE tgl_masuk >= '"+ ttg +" 00:00:00' AND tgl_masuk <='"+ ttg1 +" 00:00:00'";
                     
                 
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String id = res.getString(1);
                SimpleDateFormat ta = new SimpleDateFormat("d MMMM yyyy");
                String tta = ta.format(res.getDate(2));
                String tgl = tta;
                String ket = res.getString(3);
                Double jum_uang = res.getDouble(4);
                ttl=+ttl+jum_uang;
                Object[] data = {id,tgl,ket,jum_uang};
                _Tampung_tabel_mstr_KasMasuk.addRow(data);
            }
            txt_jumlah.setValue(ttl);
            tabel_kas_masuk.getColumnModel().getColumn(0).setPreferredWidth(5);
            tabel_kas_masuk.getColumnModel().getColumn(1).setPreferredWidth(10);
            tabel_kas_masuk.getColumnModel().getColumn(2).setPreferredWidth(400);
            tabel_kas_masuk.getColumnModel().getColumn(3).setPreferredWidth(15);
            
            
         
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
    }
     ActionListener actionListener;
    private javax.swing.Timer timer = new javax.swing.Timer(100, actionListener);
    private void Refresh(){
        try {
            ActionListener al = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    LoadData();
                    LoadData2();
                    timer.stop();
                }
            };
            timer = new javax.swing.Timer(100, al);
            timer.start();
        } catch(Exception ex) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tabel_Kas_Masuk = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_kas_masuk = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_Awal = new org.jdesktop.swingx.JXDatePicker();
        txt_Akhir = new org.jdesktop.swingx.JXDatePicker();
        jPanel2 = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JFormattedTextField();
        txt_total_sisa = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabel_Kas_Masuk.setTitle("Data Kas Masuk");

        tabel_kas_masuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel_kas_masuk);

        javax.swing.GroupLayout Tabel_Kas_MasukLayout = new javax.swing.GroupLayout(Tabel_Kas_Masuk.getContentContainer());
        Tabel_Kas_Masuk.getContentContainer().setLayout(Tabel_Kas_MasukLayout);
        Tabel_Kas_MasukLayout.setHorizontalGroup(
            Tabel_Kas_MasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        Tabel_Kas_MasukLayout.setVerticalGroup(
            Tabel_Kas_MasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        );

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tanggal");

        txt_Awal.setDate(new java.util.Date(1417148249000L));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txt_Awal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Akhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Awal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Akhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        jButton5.setText("Cetak");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(27, 27, 27)
                .addComponent(btn_tambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hapus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setEnabled(false);

        jLabel2.setText("Total Sisa Uang Rp.");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel1.setText("jumlah Uang Rp.");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total_sisa, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_total_sisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabel_Kas_Masuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Tabel_Kas_Masuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     Entry f;
    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
      try{
            f = new Entry("", "", "Add");
            f.setVisible(true);
            f.btn_keluar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    LoadData();
                    LoadData2();
                }
            });
            f.btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Refresh();
                }
            });
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
         try{
            String kode = tabel_kas_masuk.getValueAt(tabel_kas_masuk.getSelectedRow(), 0).toString();
            f = new Entry("", kode, "Edit");
            f.setVisible(true);
            f.btn_keluar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    LoadData();
                    LoadData2();
                }
            });
            f.btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Refresh();
                }
            });
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
       String kode = tabel_kas_masuk.getValueAt(tabel_kas_masuk.getSelectedRow(), 0).toString();
        int jawab = JOptionPane.showConfirmDialog(this,"Hapus ? Data Kas Masuk : "+kode,"Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION){
            MstrKasMasuk x = new MstrKasMasuk();
            x.Delete(kode);
            x.Delete2(kode);
            LoadData();
            LoadData2();
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        try{
           LoadData();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }        
    }//GEN-LAST:event_AddActionPerformed
   
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         try{
            HashMap param = new HashMap();
            param.put("jumlah",txt_jumlah.getValue());

            print_kas_masuk bku = new print_kas_masuk(_Tampung_tabel_mstr_KasMasuk);
            String fileName = "src/print/kas_masuk.jasper";
            FrmViewReport viewer = new FrmViewReport(bku,fileName,param);
            viewer.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showConfirmDialog(this, ex);
        }
            
    }//GEN-LAST:event_jButton5ActionPerformed
    private void LoadData2(){
        try{
            _Cnn = null;
            Double total=0.0;
            DbKoneksi getCnn = new DbKoneksi();
            _Cnn = getCnn.getConnection();
            HapusTabel();
            String sql = "" +
                    "   SELECT total from kas_detail" ;    
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
            Double a= res.getDouble(1);
            total=+total+a;
            }
            
            txt_total_sisa.setValue(total);
              
         
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private org.jdesktop.swingx.JXTitledPanel Tabel_Kas_Masuk;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_kas_masuk;
    private org.jdesktop.swingx.JXDatePicker txt_Akhir;
    private org.jdesktop.swingx.JXDatePicker txt_Awal;
    private javax.swing.JFormattedTextField txt_jumlah;
    private javax.swing.JFormattedTextField txt_total_sisa;
    // End of variables declaration//GEN-END:variables
}
