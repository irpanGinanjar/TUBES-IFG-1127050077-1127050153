

package MstrSantri;

import Class.DbKoneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Class.MstrSantri;
public class List extends javax.swing.JFrame {
    private DefaultTableModel _Tampung_tabel_mstr_santri;
    Connection _Cnn;
    String _User;
    
    public List() {
    initComponents();
        String[] kolom = {"Id","Nama","Tempat Lahir","Tanggal Lahir","Jenis Kelamin","Nama Ibu","Nama Bpk","Nomor Telepon","Alamat Tinggal","Tahun Masuk"};
        _Tampung_tabel_mstr_santri = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class, 
               java.lang.String.class,
               java.lang.String.class,
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
                int cola = _Tampung_tabel_mstr_santri.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        Tabel_santri.setModel(_Tampung_tabel_mstr_santri);
        LoadData();
        
    }
    public void HapusTabel(){
        int row = _Tampung_tabel_mstr_santri.getRowCount();
        for (int i = 0;i < row;i++){
            _Tampung_tabel_mstr_santri.removeRow(0);
        }
    }
    private void LoadData(){
        try{
            _Cnn = null;
            DbKoneksi getCnn = new DbKoneksi();
            _Cnn = getCnn.getConnection();
            HapusTabel();
            String sql = "" +
                    "   SELECT id_santri,nama_santri,tpt_lahir,tgl_lahir,jenkel,nama_ibu,nama_bpk,no_telepon,alamat_tinggal,tgl_daftar " +
                    "   FROM santri" +
                    "   WHERE id_santri LIKE'%"+ txt_Search.getText() +"%' " +
                    "         OR nama_santri LIKE'%"+ txt_Search.getText() +"%'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String id_santri = res.getString(1);
                String nama_santri = res.getString(2);
                String tpt_lahir = res.getString(3);
                String tgl_lahir = res.getString(4);
                String jenkel = res.getString(5);
                String nama_ibu = res.getString(6);
                 String nama_bpk = res.getString(7);
                 String no_telepon = res.getString(8);
                  String alamat_tinggal = res.getString(9);
                   String tgl_daftar = res.getString(10);
                  
                   
                Object[] data = {id_santri,nama_santri,tpt_lahir,tgl_lahir,jenkel,nama_ibu,nama_bpk,no_telepon,alamat_tinggal,tgl_daftar};
                _Tampung_tabel_mstr_santri.addRow(data);
            }
            Tabel_santri.getColumnModel().getColumn(0).setPreferredWidth(10);
            Tabel_santri.getColumnModel().getColumn(1).setPreferredWidth(50);
            Tabel_santri.getColumnModel().getColumn(2).setPreferredWidth(50);
            Tabel_santri.getColumnModel().getColumn(3).setPreferredWidth(50);
            Tabel_santri.getColumnModel().getColumn(4).setPreferredWidth(50);
            Tabel_santri.getColumnModel().getColumn(5).setPreferredWidth(50);
            Tabel_santri.getColumnModel().getColumn(6).setPreferredWidth(50);
            Tabel_santri.getColumnModel().getColumn(7).setPreferredWidth(50);
            Tabel_santri.getColumnModel().getColumn(8).setPreferredWidth(150);
            Tabel_santri.getColumnModel().getColumn(9).setPreferredWidth(50);
            
            
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
                    timer.stop();
                }
            };
            timer = new javax.swing.Timer(100, al);
            timer.start();
        } catch(Exception ex) {
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_santri = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_Search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BtnTambah = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jXTitledPanel1.setTitle("Data Santri");

        Tabel_santri.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tabel_santri);

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnTambah.setText("Tambah");
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        BtnEdit.setText("Edit");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        BtnHapus.setText("Hapus");
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        jButton5.setText("Cetak");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnHapus)
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnHapus)
                        .addComponent(BtnEdit)
                        .addComponent(BtnTambah))
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        Entry f;
    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        try{
            f = new Entry("", "", "Add");
            f.setVisible(true);
            f.BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    LoadData();
                }
            });
            f.BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Refresh();
                }
            });
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
         try{
            String kode = Tabel_santri.getValueAt(Tabel_santri.getSelectedRow(), 0).toString();
            f = new Entry("", kode, "Edit");
            f.setVisible(true);
            f.BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    LoadData();
                }
            });
            f.BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Refresh();
                }
            });
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
                          
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
       String kode = Tabel_santri.getValueAt(Tabel_santri.getSelectedRow(), 0).toString();
        int jawab = JOptionPane.showConfirmDialog(this,"Hapus ? Data Santri : "+kode,"Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION){
            MstrSantri x = new MstrSantri();
            x.Delete(kode);
            LoadData();
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
           LoadData();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JTable Tabel_santri;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JTextField txt_Search;
    // End of variables declaration//GEN-END:variables
}
