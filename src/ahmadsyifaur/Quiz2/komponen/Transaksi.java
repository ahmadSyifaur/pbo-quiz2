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

    public Transaksi(String code, ArrayList<Item> items) {
        this.code = code;
        this.items=items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal() {
        float totalAkhir=0;
        for (Item item : this.items) {
            total+=item.getTotal();
        }
        this.total=totalAkhir;
    }
    
    
    
    
    
    
}
