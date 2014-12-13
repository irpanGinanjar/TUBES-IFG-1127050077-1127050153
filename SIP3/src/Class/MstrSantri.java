/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class MstrSantri {
     Connection _Cnn;
  DbKoneksi getCn = new DbKoneksi();
  public String id_santri,nama_santri,tpt_lahir,tgl_lahir,jenkel,nama_ibu,nama_bpk,no_telepon,alamat_tinggal,tgl_daftar;
  public String _Akses = "";

  public void Search(String id){
      try {
        _Cnn = null;
        _Akses = "";
        _Cnn = getCn.getConnection();
        String SQL = "select * from santri where id_santri='"+ id +"'";
        Statement stat = _Cnn.createStatement();
        ResultSet res = stat.executeQuery(SQL);
        while(res.next()){
              _Akses = "-";
              this.id_santri  = res.getString(1);
              this.nama_santri  = res.getString(2);
              this.tpt_lahir  = res.getString(3);
              this.tgl_lahir  = res.getString(4);
              this.jenkel  = res.getString(5);
              this.nama_ibu = res.getString(6);
              this.nama_bpk  = res.getString(7);
              this.no_telepon = res.getString(8);
              this.alamat_tinggal = res.getString(9);
              this.tgl_daftar = res.getString(10);
              
              
              
          }
          stat.close();
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, ex);
      }
  }

  public void SaveData(){
    try{
        String sql ="";
        _Cnn = getCn.getConnection();
        sql = "INSERT INTO santri VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stat = _Cnn.prepareStatement(sql);
        stat.setString(1,this.id_santri);
        stat.setString(2,this.nama_santri);
        stat.setString(3,this.tpt_lahir);
        stat.setString(4,this.tgl_lahir);
        stat.setString(5,this.jenkel);
        stat.setString(6,this.nama_ibu);
        stat.setString(7,this.nama_bpk);
        stat.setString(8,this.no_telepon);
        stat.setString(9,this.alamat_tinggal);
        stat.setString(10,this.tgl_daftar);
        
        
        
        
        stat.executeUpdate();
        stat.close();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "ERROR : " +ex);
    }
  }

  public void UpdateData(){
      try {
        String sql ="";
        _Cnn = getCn.getConnection();
        sql = "UPDATE santri SET id_santri=?,nama_santri=?,tpt_lahir=?,tgl_lahir=?,jenkel=?,nama_ibu=?,nama_bpk=?,no_telepon=?,alamat_tinggal=?,tgl_daftar=? WHERE id_santri='"+ id_santri +"'";
        PreparedStatement stat = _Cnn.prepareStatement(sql);
        stat.setString(1,this.id_santri);
        stat.setString(2,this.nama_santri);
        stat.setString(3,this.tpt_lahir);
        stat.setString(4,this.tgl_lahir);
        stat.setString(5,this.jenkel);
        stat.setString(6,this.nama_ibu);
        stat.setString(7,this.nama_bpk);
        stat.setString(8,this.no_telepon);
        stat.setString(9,this.alamat_tinggal);
        stat.setString(10,this.tgl_daftar);
        
        stat.executeUpdate();
        stat.close();
      } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }

  public void Delete(String id) {
      try {
          _Cnn = getCn.getConnection();
          String sql = "DELETE FROM santri WHERE id_santri='"+ id +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
          stat.executeUpdate();
          stat.close();
      } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }
}
