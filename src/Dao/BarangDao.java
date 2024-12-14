/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Koneksi.Koneksi;
import static Koneksi.Koneksi.Connect;
import Model.tb_barang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ariramadhan
 */
public class BarangDao extends tb_barang{
    
    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;
    
    public void SaveBarang(String nama, String kategori, int harga, String satuan) {
        con = new Koneksi();
        Connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_barang(nama, kategori, harga, stok, satuan)values('" + nama + "', '"+kategori+"', '"+harga+"', '0', '"+satuan+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data barang berhasil di tambahkan");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Data barang gagal di tambahkan");
        }
    }
    
    public void UpdateBarang(String nama, String kategori, int harga, String satuan, int id) {
        con = new Koneksi();
        Connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_barang set nama='" + nama + "', kategori='"+kategori+"', harga='"+harga+"', satuan='"+satuan+"' where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data barang berhasil di ubah");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Data barang gagal di ubah");
        }
    }
    
    public void Delete(int id) {
        con = new Koneksi();
        Connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_barang where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data barang berhasil di hapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data barang gagal di hapus");
        }
    }

    public String[][] ShowDataBarang() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        Connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_barang";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_barang";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("nama");
                data[r][2] = res.getString("kategori");
                data[r][3] = res.getString("harga");
                data[r][4] = res.getString("satuan");
                data[r][5] = res.getString("stok");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][6];
            for (r = 0; r < jmlBaris; r++) {
                for(int c = 0; c < 6; c++) {
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
    
    public ArrayList<String> ListKategori(){
        ArrayList<String> dataKategori = new ArrayList<>();
        con= new Koneksi();
        try{
            st = Connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_kategori");
            while(res.next()){
                dataKategori.add(res.getString("nama_kategori"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data kategori gagal di request !!");
        }
        
        return dataKategori;
    }
    
    public ArrayList<String> ListSatuan(){
        ArrayList<String> dataSatuan = new ArrayList<>();
        con= new Koneksi();
        try{
            st = Connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_satuan");
            while(res.next()){
                dataSatuan.add(res.getString("nama_satuan"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data satuan gagal di request !!");
        }
        
        return dataSatuan;
    }
    
}
