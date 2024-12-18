/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoBumdes;

import Koneksi.Koneksi;
import static Koneksi.Koneksi.Connect;
import Model.tb_kategori;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ariramadhan
 */
public class KategoriDao extends tb_kategori {
    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;
    
    public void SaveKategori(String nama) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "insert into tb_kategori(nama_kategori)values('" + nama + "')";
            st.executeUpdate(query);
            st.close();
//            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data kategori berhasil di tambahkan");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Data kategori gagal di tambahkan");
        }
    }
    
    public void UpdateKategori(String nama, int id) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "update tb_kategori set nama_kategori='" + nama + "' where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            //con.conn.close();
            JOptionPane.showMessageDialog(null, "Data kategori berhasil di ubah");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Data kategori gagal di ubah");
        }
    }
    
    public void Delete(int id) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "delete from tb_kategori where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            //con.conn.close();
            JOptionPane.showMessageDialog(null, "Data kategori berhasil di hapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data kategori gagal di hapus");
        }
    }

    public String[][] ShowDataKategori() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        Connect();
        int jumlahBaris = 0;
        try {
            st = Connect().createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_kategori";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_kategori";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][2];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("nama_kategori");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][2];
            for (r = 0; r < jmlBaris; r++) {
                for(int c = 0; c < 2; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
//            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
}
