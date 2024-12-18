/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ariramadhan
 */
public class tb_pelanggan {
    private int Id;
    private String nama_pelanggan;
    private String kontak_pelanggan;
    
    private static String nama;
    private static int idPelanggan;

    public static int getIdPelanggan() {
        return idPelanggan;
    }

    public static void setIdPelanggan(int idPelanggan) {
        tb_pelanggan.idPelanggan = idPelanggan;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        tb_pelanggan.nama = nama;
    }
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getKontak_pelanggan() {
        return kontak_pelanggan;
    }

    public void setKontak_pelanggan(String kontak_pelanggan) {
        this.kontak_pelanggan = kontak_pelanggan;
    }
    
    
}
