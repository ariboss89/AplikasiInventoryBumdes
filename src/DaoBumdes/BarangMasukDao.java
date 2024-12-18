/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoBumdes;

import Koneksi.Koneksi;
import static Koneksi.Koneksi.Connect;
import Model.tb_barangmasuk;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ariramadhan
 */
public class BarangMasukDao extends tb_barangmasuk{
    
    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;
    
     public void UpdateStok(int stok, int id) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "update tb_barang set stok='"+stok+"' where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            //con.conn.close();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Stok barang gagal di ubah");
        }
    }
    
     
     public void SaveBarangMasuk(String barang, Date tanggal, int jumlah, String namaSupplier) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "insert into tb_barangmasuk(barang, tanggal, jumlah, nama_supplier)values('" + barang + "', '"+tanggal+"', '"+jumlah+"', '"+namaSupplier+"')";
            st.executeUpdate(query);
            st.close();
            //con.conn.close();
            JOptionPane.showMessageDialog(null, "Data barang berhasil di tambahkan");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Data barang gagal di tambahkan");
        }
    }
     
     
      public String[][] ShowDataBarang() {
        res = null;
        String[][] data = null;
        con = new Koneksi();
        Connect();
        int jumlahBaris = 0;
        try {
            st = Connect().createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_barangmasuk";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_barangmasuk";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][5];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("barang");
                data[r][2] = res.getString("tanggal");
                data[r][3] = res.getString("jumlah");
                data[r][4] = res.getString("nama_supplier");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][5];
            for (r = 0; r < jmlBaris; r++) {
                for(int c = 0; c < 5; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            //con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
      
      public ArrayList<String> ListBarang(){
        ArrayList<String> dataBarang = new ArrayList<>();
        con= new Koneksi();
        try{
            st = Connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_barang");
            while(res.next()){
                dataBarang.add(res.getString("nama"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal di request !!");
        }
        
        return dataBarang;
    }
      
      public ArrayList<String> ListSupplier(){
        ArrayList<String> dataSupplier = new ArrayList<>();
        con= new Koneksi();
        try{
            st = Connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_supplier");
            while(res.next()){
                dataSupplier.add(res.getString("nama_supplier"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal di request !!");
        }
        
        return dataSupplier;
    }
      
      public void Delete(int id) {
       con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "delete from tb_barangmasuk where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            //con.conn.close();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }
}
