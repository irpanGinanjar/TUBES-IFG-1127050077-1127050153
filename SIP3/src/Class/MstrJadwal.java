

package Class;

/**
 *
 * @author Irfan Ginanjar
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MstrJadwal {
  Connection _Cnn;
  DbKoneksi getCn = new DbKoneksi();
  public String id_jadwal,nama_mata,jam_belajar,hari,tempat,nama_pengajar;
  public String _Akses = "";

  public void Search(String id){
      try {
        
        _Akses = "";
        _Cnn = getCn.getConnection();
        String SQL = "select * from jadwal where id='"+ id +"'";
        Statement stat = _Cnn.createStatement();
        ResultSet res = stat.executeQuery(SQL);
        while(res.next()){
              _Akses = "-";
              this.id_jadwal = res.getString(1);
              this. nama_mata = res.getString(2);
              this.jam_belajar = res.getString(3);
              this.hari = res.getString(4);
              this.tempat  = res.getString(5);
              this.nama_pengajar  = res.getString(6);
              
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
        sql = "INSERT INTO jadwal VALUES(?,?,?,?,?,?)";
        PreparedStatement stat = _Cnn.prepareStatement(sql);
        stat.setString(1,this.id_jadwal);
        stat.setString(2,this.nama_mata);
        stat.setString(3,this.jam_belajar);
        stat.setString(4,this.hari);
        stat.setString(5,this.tempat);
        stat.setString(6,this.nama_pengajar);
       
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
        sql = "UPDATE jadwal SET id=?,mata_pelajaran=?,jam_belajar=?,hari=?,tempat=?,nama_pengajar=? WHERE id='"+ id_jadwal +"'";
        PreparedStatement stat = _Cnn.prepareStatement(sql);
        stat.setString(1,this.id_jadwal);
        stat.setString(2,this.nama_mata);
        stat.setString(3,this.jam_belajar);
        stat.setString(4,this.hari);
        stat.setString(5,this.tempat);
        stat.setString(6,this.nama_pengajar);
        
        stat.executeUpdate();
        stat.close();
      } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }

  public void Delete(String id) {
      try {
          _Cnn = getCn.getConnection();
          String sql = "DELETE FROM jadwal WHERE id='"+ id +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
          stat.executeUpdate();
          stat.close();
      } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }
}

