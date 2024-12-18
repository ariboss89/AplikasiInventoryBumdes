/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ariramadhan
 */
public class dt_barangkeluar {
    private int Id;
    private int idBarang;
    private String IdBarangKeluar;
    private int CurrentStok;
    private String nama;
    private Date tanggal;
    private int jumlah;
    private double harga;
    private double subtotal;
    private double modal;
    
    private double hargaBeli;

    public double getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }
    
    

    public double getModal() {
        return modal;
    }

    public void setModal(double modal) {
        this.modal = modal;
    }
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getIdBarangKeluar() {
        return IdBarangKeluar;
    }

    public void setIdBarangKeluar(String IdBarangKeluar) {
        this.IdBarangKeluar = IdBarangKeluar;
    }

    public int getCurrentStok() {
        return CurrentStok;
    }

    public void setCurrentStok(int CurrentStok) {
        this.CurrentStok = CurrentStok;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
