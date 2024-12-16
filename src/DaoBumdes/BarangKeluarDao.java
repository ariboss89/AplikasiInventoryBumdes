/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoBumdes;

import Koneksi.Koneksi;
import static Koneksi.Koneksi.Connect;
import Model.dt_barangkeluar;
import Model.tb_barangkeluar;
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
public class BarangKeluarDao extends dt_barangkeluar {

    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;

    public void UpdateStok(int stok, int id) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "update tb_barang set stok='" + stok + "' where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Stok barang gagal di ubah");
        }
    }

    public void AddToCart(int idBarang, String idKeluar, String barang, Date tanggal, int jumlah, double harga, double subtotal) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "insert into dt_barangkeluar(idbarang, idbarang_keluar,  nama_barang, tanggal_keluar, jumlah, harga_barang, subtotal)"
                    + "values('" + idBarang + "', '" + idKeluar + "', '" + barang + "', '" + tanggal + "', '" + jumlah + "','" + harga + "', '" + subtotal + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Barang ditambahkan ke keranjang !!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Barang gagal ditambahkan ke keranjang !!");
        }
    }

    public void SelesaiBelanja(String Id, double jmlBarang, double totBayar, double bayar, double kembali, Date tanggal, String kasir) {
        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            query = "insert into tb_barangkeluar(Id, jumlah_barang,  total_bayar, bayar, kembali, tanggal, kasir)"
                    + "values('" + Id + "', '" + jmlBarang + "', '" + totBayar + "', '" + bayar + "', '" + kembali + "','" + tanggal + "', '"+kasir+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Orderan Selesai");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Orderan Gagal di Selesaikan !!");
        }
    }

    public String[][] ShowDataBarang(String idPesanan) {
        res = null;
        String[][] data = null;
        con = new Koneksi();
        Connect();
        int jumlahBaris = 0;
        try {
            st = Connect().createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM dt_barangkeluar WHERE idbarang_keluar='" + idPesanan + "'";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from dt_barangkeluar WHERE idbarang_keluar='" + idPesanan + "'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][7];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("idbarang");
                data[r][2] = res.getString("nama_barang");
                data[r][3] = res.getString("tanggal_keluar");
                data[r][4] = res.getString("jumlah");
                data[r][5] = res.getString("harga_barang");
                data[r][6] = res.getString("subtotal");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][7];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 7; c++) {
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

    public ArrayList<String> ListBarang() {
        ArrayList<String> dataBarang = new ArrayList<>();
        con = new Koneksi();
        try {
            st = Connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_barang");
            while (res.next()) {
                dataBarang.add(res.getString("nama"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di request !!");
        }

        return dataBarang;
    }

    public void Delete(int id) {
        con = new Koneksi();
        Connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_barangkeluar where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }

    public String IdPesanan() {

        String idPesanan = "";
        int id = 0;

        con = new Koneksi();
        Connect();
        try {
            st = Connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_config where config_key = 'pemesanan'");
            while (res.next()) {
                id = res.getInt("config_value");
                id++;
            }

            idPesanan = "ORDER-" + String.format("%06d", id);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }

        return idPesanan;

    }

    public void UpdateIdPesanan() {
        con = new Koneksi();
        Connect();

        int id = 0;

        try {
            st = Connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_config where config_key = 'pemesanan'");
            while (res.next()) {
                id = res.getInt("config_value");
                id++;
            }

            query = "update tb_config set config_value='" + id + "' where config_key = 'pemesanan'";

            st.executeUpdate(query);
            st.close();
            con.conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Stok barang gagal di ubah");
        }
    }

}
