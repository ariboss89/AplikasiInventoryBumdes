/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoBumdes;

import Koneksi.Koneksi;
import static Koneksi.Koneksi.Connect;
import Model.tb_kategori;
import Model.tb_supplier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ariramadhan
 */
public class SupplierDao extends tb_supplier {
    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;
    
    public void SaveSupplier(String nama, String kontak) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "insert into tb_supplier(nama_supplier, kontak_supplier )values('" + nama + "', '"+kontak+"')";
            st.executeUpdate(query);
            st.close();
//            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data supplier berhasil di tambahkan");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Data supplier gagal di tambahkan");
        }
    }
    
    public void UpdateSupplier(String nama, String kontak, int id) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "update tb_supplier set nama_supplier='" + nama + "', kontak_supplier= '"+kontak+"' where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            //con.conn.close();
            JOptionPane.showMessageDialog(null, "Data supplier berhasil di ubah");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Data supplier gagal di ubah");
        }
    }
    
    public void Delete(int id) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "delete from tb_supplier where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            //con.conn.close();
            JOptionPane.showMessageDialog(null, "Data supplier berhasil di hapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data supplier gagal di hapus");
        }
    }

    public String[][] ShowDataSupplier() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        Connect();
        int jumlahBaris = 0;
        try {
            st = Connect().createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_supplier";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_supplier";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][3];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("nama_supplier");
                data[r][2] = res.getString("kontak_supplier");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][3];
            for (r = 0; r < jmlBaris; r++) {
                for(int c = 0; c < 3; c++) {
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
