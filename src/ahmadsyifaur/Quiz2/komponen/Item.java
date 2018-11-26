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
public class Item {
    private String nama;
    private float harga;
    private int jumlah;
    
    //constuctor
    public Item(String nama, float harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }
    //mengambil nama
    public String getNama() {
        return nama;
    }
    //meng-set nama
    public void setNama(String nama) {
        this.nama = nama;
    }
    //mengambil harga
    public float getHarga() {
        return harga;
    }
    //meng-set harga
    public void setHarga(float harga) {
        this.harga = harga;
    }
    //mengambil jumlah
    public int getJumlah() {
        return jumlah;
    }
    //meng-set jumlah
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    //mengambil total akhir
    public float getTotal() {
        return this.harga*this.jumlah;
    }
}
