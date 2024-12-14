/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Koneksi.Koneksi;
import static Koneksi.Koneksi.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ariramadhan
 */
public class PenggunaDao {
    
    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;
    
    public void SavePengguna(String username, String password, String role, String nama, String kontak) {
       con = new Koneksi();
        Connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_pengguna(username, password, role, nama, kontak)values('" + username + "', MD5 ('"+password+"'), '"+role+"', '"+nama+"', '"+kontak+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data pengguna berhasil di tambahkan");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Data pengguna gagal di tambahkan");
        }
    }
    
    public void UpdatePengguna(String password, String nama, String kontak, String username) {
        con = new Koneksi();
        Connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_pengguna set password= MD5('" + password + "'), nama='"+nama+"', kontak='"+kontak+"' where username = '" + username + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data pengguna berhasil di ubah");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Data pengguna gagal di ubah");
        }
    }
    
    public void DeletePengguna(String username) {
        con = new Koneksi();
        Connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_pengguna where ysername = '" + username + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data pengguna berhasil di hapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data pengguna gagal di hapus");
        }
    }

    public String[][] ShowDataPengguna() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        Connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(username) AS Jumlah FROM tb_pengguna";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_pengguna";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][4];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("username");
                data[r][1] = res.getString("role");
                data[r][2] = res.getString("nama");
                data[r][3] = res.getString("kontak");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][4];
            for (r = 0; r < jmlBaris; r++) {
                for(int c = 0; c < 4; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
}
