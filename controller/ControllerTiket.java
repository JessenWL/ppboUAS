/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Connector;
import model.Tiket;
import view.FormTiket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerTiket implements ActionListener, MouseListener{
    Tiket data;
    FormTiket form;
    
    public ControllerTiket(Tiket data, FormTiket form){
        this.data = data;
            this.form = form;
            this.form.btnSimpan.addActionListener(this);
            this.form.btnTambah.addActionListener(this);
            this.form.btnEdit.addActionListener(this);
            this.form.btnHapus.addActionListener(this);
            this.form.tabelTiket.addMouseListener(this);
    }
    
    public void KosongFormTiket(){
            form.txtNoTiket.setText(null);
            form.cmbKelas.setSelectedItem(null);
            form.txtHarga.setText(null);
            form.txtDes.setText(null);
            form.txtKet.setText(null);
            form.cmbKendaraan.setSelectedItem(null);
        }
    public void TampilDataFormTiket(){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Kelas");
            model.addColumn("Harga");
            model.addColumn("Destinasi");
            model.addColumn("Keterangan");
            model.addColumn("Jenis Kendaraan");
            // Menampilkan data pada database ke dalam tabel
            try{
                int no=1;
                String sql="SELECT * FROM tiket";
                java.sql.Connection conn=(Connection)Connector.configDB();
                java.sql.Statement stm=conn.createStatement();
                java.sql.ResultSet res=stm.executeQuery(sql);
                
                while(res.next()){
                    model.addRow(new Object[]{
                        no++,
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5),});
                }
                form.tabelTiket.setModel(model);
            }catch(SQLException e){
                System.out.println("Error "+e.getMessage());
            }
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==form.btnTambah){
            KosongFormTiket();
        }else if(ae.getSource()==form.btnSimpan){
            data.setKode_tk(form.txtNoTiket.getText());
            data.setKelas((String) form.cmbKelas.getSelectedItem());
            data.setHarga(form.txtHarga.getText());
            data.setDes(form.txtDes.getText());
            data.setKet(form.txtKet.getText());
            data.setSupp((String) form.cmbKendaraan.getSelectedItem());
            
            try {
                if(data.SimpanTiket(data)){
                    JOptionPane.showMessageDialog(null, "Yeay!!! Berhasil Menyimpan");
                    KosongFormTiket();
                    TampilDataFormTiket();
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }else if(ae.getSource()==form.btnEdit){
            data.setKode_tk(form.txtNoTiket.getText());
            data.setKelas((String) form.cmbKelas.getSelectedItem());
            data.setHarga(form.txtHarga.getText());
            data.setDes(form.txtDes.getText());
            data.setKet(form.txtKet.getText());
            data.setSupp((String) form.cmbKendaraan.getSelectedItem());
            
            try {
                if(data.UpdateTiket(data)){
                    JOptionPane.showMessageDialog(null, "Update Anda Berhasil");
                    KosongFormTiket();
                    TampilDataFormTiket();
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }else {
            data.setKode_tk(form.txtNoTiket.getText());
            
            try {
                if(data.HapusTiket(data)){
                    JOptionPane.showMessageDialog(null, "Berhasil Menghapus");
                    KosongFormTiket();
                    TampilDataFormTiket();
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==form.tabelTiket){
            form.txtNoTiket.setEditable(false);
            
            int baris=form.tabelTiket.rowAtPoint(me.getPoint());
            String no_tiket=form.tabelTiket.getValueAt(baris, 1).toString();
            form.txtNoTiket.setText(no_tiket);
            String kelas=form.tabelTiket.getValueAt(baris, 2).toString();
            form.cmbKelas.setSelectedItem(kelas);
            String harga_tiket=form.tabelTiket.getValueAt(baris, 3).toString();
            form.txtHarga.setText(harga_tiket);
            String des=form.tabelTiket.getValueAt(baris, 4).toString();
            form.txtDes.setText(des);
            String ket=form.tabelTiket.getValueAt(baris, 5).toString();
            form.txtKet.setText(ket);
            String supp=form.tabelTiket.getValueAt(baris, 6).toString();
            form.cmbKendaraan.setSelectedItem(supp);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
     
}
