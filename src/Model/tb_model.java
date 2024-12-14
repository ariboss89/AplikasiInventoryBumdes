/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariramadhan
 */
public class tb_model {
    public void SetTabel(JTable tabel, String [][] data, String [] namaKolom, int jmlKolom, int [] lebar){
        tabel.setModel(new DefaultTableModel(data, namaKolom));
        for (int i = 0; i<jmlKolom; i++)
            tabel.getColumnModel().getColumn(i).setPreferredWidth(lebar[i]);
    }
}
