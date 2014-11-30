/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import java.sql.*;

public class DbKoneksi {
    public DbKoneksi() { }
    public Connection getConnection() throws SQLException {
        Connection cn = null;
        try {
            String server = "jdbc:mysql://localhost:3306/dbsip3";
            String drever = "com.mysql.jdbc.Driver";
            Class.forName(drever);
            cn = DriverManager.getConnection (server, "root","");
            return cn;
        } catch (SQLException se) {
            System.out.println(se.toString());
            return null;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
