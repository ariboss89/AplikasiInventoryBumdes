/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ariramadhan
 */
public class tb_barang {
    private int Id;
    private String nama;
    private String kategori;
    private int stok;
    private int harga;
    
    private static int IdBarang;
    private static String NamaBarang;

    public static int getIdBarang() {
        return IdBarang;
    }

    public static void setIdBarang(int IdBarang) {
        tb_barang.IdBarang = IdBarang;
    }

    public static String getNamaBarang() {
        return NamaBarang;
    }

    public static void setNamaBarang(String NamaBarang) {
        tb_barang.NamaBarang = NamaBarang;
    }

    
    
    
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    
}
