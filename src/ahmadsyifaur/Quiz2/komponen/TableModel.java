/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmadsyifaur.Quiz2.komponen;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
import javax.swing.table.*;
public class TableModel extends DefaultTableModel{
    private final String[] namaKolom;

    public TableModel() {
        this.namaKolom = new String[] {
            "Nama",
            "Harga",
            "Jumlah"
        };
    }

    public String[] getNamaKolom() {
        return this.namaKolom;
    }
    
    
}
