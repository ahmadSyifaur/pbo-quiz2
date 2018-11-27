/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmadsyifaur.Quiz2;

import ahmadsyifaur.Quiz2.komponen.ComboBoxModel;
import ahmadsyifaur.Quiz2.komponen.Item;
import ahmadsyifaur.Quiz2.komponen.TableModel;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public class Main extends javax.swing.JFrame {
    //digunakan untuk memberikan nomor pada transaksi
    private int id=0;
    //digunakan untuk menyimpan code transaksi
    private String code;
    //jComboBox model
    private DefaultComboBoxModel comBoxModel;
    //jTable Model
    private DefaultTableModel tableModel;
    //digunakan untuk menyimpan item yang dibeli
    private final ArrayList<Item> items =new ArrayList<>();
    /**
     * Creates new form Main
     */
 
    public Main() {
        ComboBoxModel cbModel =new ComboBoxModel();
        //meng-set Combobox item
        this.comBoxModel=new DefaultComboBoxModel<>(cbModel.getNama().toArray());
        TableModel tbModel= new TableModel();
        //meng-set nama kolom pada tabel transaksi
        this.tableModel=new DefaultTableModel(tbModel.getNamaKolom(), 0);
        initComponents();
    }
    //digunakan untuk menambahkan nomor baru
    private void tambahID(){
        this.id+=1;
    }
    // digunakan untuk menghapus/ mengurangi nomor
    private void kurangID(){
        this.id-=1;
    }
    //meng-set code transaksi yang sesuai dengan tanggal sekarang 
    private String setCode(){
        this.tambahID();
        String tgl = new SimpleDateFormat("yyMMdd").format(new Date());
        this.code = String.format(tgl+"%02d", this.id);
        return code;
    }
    
    private Object[] addItem(String nama , int jumlah){
        float harga=0;
        ComboBoxModel items=new ComboBoxModel();
        for (int i = 0; i < items.getNama().size(); i++) {
            if (nama.equalsIgnoreCase(items.getNama().get(i))) {
                harga = items.getHarga().get(i);
            }
        }
        Object[] item={
            nama,
            harga,
            jumlah
        };
        return item;
    }
    //mengupdate jumlah
    private void updateJumlah(String nama, int tambah) {
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++){
            item.add(tableModel.getValueAt(i, 0).toString());
        }
        for(int i = 0; i < item.size(); i++) {
            if(item.get(i).equals(nama)) {
                int jumlah = new Integer(tableModel.getValueAt(i, 2).toString());
                tableModel.setValueAt(jumlah+tambah, i, 2);
            } 
        }
    }
    //melakukan pengecekan apakah barang yang dipilih sudah ada pada tabel atau belum
    private boolean cekBrgSudahAda(String nama) {
        boolean hasil = false;
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++){
            item.add(tableModel.getValueAt(i, 0).toString());
        }
        for(String i : item) {
            if(i.equals(nama)) {
                hasil = true;
            } 
        }
        return hasil;
    } 
    //pengecekan apakah table masih kosong
    private boolean isEmpty() {
        return this.ItemTabel.getModel().getRowCount()<=0;
    }
    
    //mendisable tombol save dan remove ketika table masih kosong
    private void cekItem() {
        if(isEmpty()) {
            this.saveButton.setEnabled(false);
            this.removeButton.setEnabled(false);
        } else {
            this.saveButton.setEnabled(true);
            this.removeButton.setEnabled(true);
        }
    }
    // melakukan transaksi baru ketika transaksi sebelumnya telah sukses
    private void TransBaru() {
        this.jumlahText.setText("");
        this.codeText.setText("");
        this.newButton.setEnabled(true);
        this.saveButton.setEnabled(false);
        this.cancelButton.setEnabled(false);
        this.addButton.setEnabled(false);
        this.removeButton.setEnabled(false);
        this.jumlahText.setEnabled(false);
        this.itemComboBox.setEnabled(false);
        this.tableModel.setRowCount(0);
        this.items.clear();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codeText = new javax.swing.JTextField();
        itemComboBox = new javax.swing.JComboBox<>();
        jumlahText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemTabel = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Code");

        jLabel2.setText("Items");

        codeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeTextActionPerformed(evt);
            }
        });

        itemComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gula", "Susu", "Kopi" }));
        itemComboBox.setSelectedIndex(-1);

        ItemTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama", "Harga", "Jumlah"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ItemTabel);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(codeText, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jumlahText)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(saveButton)
                            .addGap(28, 28, 28)
                            .addComponent(cancelButton))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newButton))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void codeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemTabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField codeText;
    private javax.swing.JComboBox<String> itemComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahText;
    private javax.swing.JButton newButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
