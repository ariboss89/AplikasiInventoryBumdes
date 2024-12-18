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
public class tb_barangkeluar {
     
    
    private int totalItem;
    private double totalBayar;
    private double kembalian;
    private double bayar;
    private String kasir;
    private double totalModal;
    
    private static String idOrder;

    public static String getIdOrder() {
        return idOrder;
    }

    public static void setIdOrder(String idOrder) {
        tb_barangkeluar.idOrder = idOrder;
    }
    
    

    public double getTotalModal() {
        return totalModal;
    }

    public void setTotalModal(double totalModal) {
        this.totalModal = totalModal;
    }
    
    

    public String getKasir() {
        return kasir;
    }

    public void setKasir(String kasir) {
        this.kasir = kasir;
    }
    
    

    public double getBayar() {
        return bayar;
    }

    public void setBayar(double bayar) {
        this.bayar = bayar;
    }

    public double getKembalian() {
        return kembalian;
    }

    public void setKembalian(double kembalian) {
        this.kembalian = kembalian;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }
   
}
