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
import java.util.*;
public class Transaksi {
    private String code;
    private ArrayList<Item> items = new ArrayList<>();
    private float total;
//konstruktor
    public Transaksi(String code, ArrayList<Item> items) {
        this.code = code;
        this.items=items;
    }
//mengambil Item
    public ArrayList<Item> getItems() {
        return items;
    }
//meng-set Item yang akan dimasukkan kedalam tabel
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
//mengambil total
    public float getTotal() {
        return total;
    }
//meng-set total Akhir 
    public void setTotal() {
        float totalAkhir=0;
        for (Item item : this.items) {
            totalAkhir+=item.getTotal();
        }
        this.total=totalAkhir;
    }
//Menampilkan detail transaksi menjadi popup window
    public String transDetail() { 
        setTotal();
        String str = "";
        str += "Kode\t\t: "+ this.code +"\n";
        str += "Daftar Belanja : \n";
        for(Item item : this.items) {
               str += "\t"+ item.getNama() +"(x"+ item.getJumlah() +") : "+ item.getTotal() +"\n";
        }
        str += "Total\t\t: "+ this.total;
        return str;
    }
}
