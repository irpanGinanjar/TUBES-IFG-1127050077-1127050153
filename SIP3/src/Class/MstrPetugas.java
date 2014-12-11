/**
 *
 * @author Suhendar
 */

package Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MstrPetugas {
     Connection _Cnn;
  DbKoneksi getCn = new DbKoneksi();
  public String id_petugas,nama,no_telepon,password;
  public String _Akses = "";

  public void Search(String id){
      try {
        _Cnn = null;
        _Akses = "";
        _Cnn = getCn.getConnection();
        String SQL = "select * from petugas where id_petugas='"+ id +"'";
        Statement stat = _Cnn.createStatement();
        ResultSet res = stat.executeQuery(SQL);
        while(res.next()){
              _Akses = "-";
              this.id_petugas  = res.getString(1);
              this.nama  = res.getString(2);
              this.no_telepon  = res.getString(3);
              this.password  = res.getString(4);
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
        sql = "INSERT INTO petugas VALUES(?,?,?,?)";
        PreparedStatement stat = _Cnn.prepareStatement(sql);
        stat.setString(1,this.id_petugas);
        stat.setString(2,this.nama);
        stat.setString(3,this.no_telepon);
        stat.setString(4,this.password);
       
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
        sql = "UPDATE petugas SET id_petugas=?,nama=?,no_telepon=?,password=? WHERE id_petugas='"+ id_petugas +"'";
        PreparedStatement stat = _Cnn.prepareStatement(sql);
        stat.setString(1,this.id_petugas);
        stat.setString(2,this.nama);
        stat.setString(3,this.no_telepon);
        stat.setString(4,this.password);
        
        stat.executeUpdate();
        stat.close();
      } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }

  public void Delete(String id) {
      try {
          _Cnn = getCn.getConnection();
          String sql = "DELETE FROM petugas WHERE id_petugas='"+ id +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
          stat.executeUpdate();
          stat.close();
      } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }
}

