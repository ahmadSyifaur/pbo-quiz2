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
public class ComboBoxModel {
    private HashMap<String,Float> items= new HashMap<>();
    //konstruktor
    public ComboBoxModel() {
        this.items.put("Gula", new Float(20000));
        this.items.put("Kopi", new Float(15000));
        this.items.put("Susu", new Float(30000));
    }
    //menyimpan nama kedalam Array List
    public ArrayList<String> getNama(){
        ArrayList<String> brg = new ArrayList<>();
        for (String item : this.items.keySet()) {
            brg.add(item);
            
        }
        return brg;
    }
    //menyimpan harga kedalam Arraylist
    public ArrayList<Float> getHarga(){
        ArrayList<Float> hrg =new ArrayList<>();
        for (Float item : this.items.values()) {
            hrg.add(item);
        }
        return hrg;
    }
    //menambahkan Item ke dalam tabel
    public void addItems(String nama, Float harga){
        this.items.put(nama, harga);
    }
    
    
}
