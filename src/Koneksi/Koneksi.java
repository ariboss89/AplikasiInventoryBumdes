/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ariramadhan
 */
public class Koneksi {

    public java.sql.Connection conn;

    private static Connection connection;

    public static Connection Connect() {

        if (connection == null) {
            try {

                String url = "jdbc:mysql://localhost:3306/bumdesbarang?" + "autoReconnect=true&useSSL=false";
                //String url = "jdbc:mysql://localhost:3306/bumdesbarang";
                String user = "root";
                String password = "";

                DriverManager.registerDriver(new com.mysql.jdbc.Driver());

                connection = (Connection) DriverManager.getConnection(url, user, password);

                System.out.println("Koneksi sukses");

                //JOptionPane.showMessageDialog(null, "Koneksi Berhasil");

            } catch (SQLException e) {

                //System.out.println("Koneksi gagal dilakukan");
                //JOptionPane.showMessageDialog(null, e.toString());

                JOptionPane.showMessageDialog(null, "Error dikit");

            }
        }

        return connection;
    }
}
