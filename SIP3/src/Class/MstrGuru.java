package Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Suhendar
 */
public class MstrGuru {
     Connection _Cnn;
  DbKoneksi getCn = new DbKoneksi();
  public String id_guru,nama,jenkel,no_telepon,alamat;
  public String _Akses = "";

  public void Search(String id){
      try {
        _Cnn = null;
        _Akses = "";
        _Cnn = getCn.getConnection();
        String SQL = "select * from guru where id_guru='"+ id +"'";
        Statement stat = _Cnn.createStatement();
        ResultSet res = stat.executeQuery(SQL);
        while(res.next()){
              _Akses = "-";
              this.id_guru  = res.getString(1);
              this.nama  = res.getString(2);
              this.jenkel  = res.getString(3);
              this.no_telepon  = res.getString(4);
              this.alamat  = res.getString(5);
              
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
        sql = "INSERT INTO guru VALUES(?,?,?,?,?)";
        PreparedStatement stat = _Cnn.prepareStatement(sql);
        stat.setString(1,this.id_guru);
        stat.setString(2,this.nama);
        stat.setString(3,this.jenkel);
        stat.setString(4,this.no_telepon);
        stat.setString(5,this.alamat);
       
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
        sql = "UPDATE guru SET id_guru=?,nama_guru=?,jenkel=?,no_telepon=?,alamat=? WHERE id_guru='"+ id_guru +"'";
        PreparedStatement stat = _Cnn.prepareStatement(sql);
        stat.setString(1,this.id_guru);
        stat.setString(2,this.nama);
        stat.setString(3,this.jenkel);
        stat.setString(4,this.no_telepon);
        stat.setString(5,this.alamat);
        
        stat.executeUpdate();
        stat.close();
      } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }

  public void Delete(String id) {
      try {
          _Cnn = getCn.getConnection();
          String sql = "DELETE FROM guru WHERE id_guru='"+ id +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
          stat.executeUpdate();
          stat.close();
      } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }
}

