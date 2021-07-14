/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Connector;
import model.Pelanggan;
import view.FormPelanggan;
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

public class ControllerPelanggan implements ActionListener, MouseListener{
    Pelanggan data;
    FormPelanggan form;
    
    public ControllerPelanggan(Pelanggan data, FormPelanggan form){
        this.data = data;
            this.form = form;
            this.form.btnSimpan.addActionListener(this);
            this.form.btnTambah.addActionListener(this);
            this.form.btnEdit.addActionListener(this);
            this.form.btnHapus.addActionListener(this);
            this.form.tabelPelanggan.addMouseListener(this);
    }
    
    public void KosongFormPelanggan(){
            form.txtNoKtp.setText(null);
            form.txtNamaPelanggan.setText(null);
            form.txtAlamat.setText(null);
            form.txtUmur.setText(null);
            form.cmbJk.setSelectedItem(null);
        }
    public void TampilDataFormPelanggan(){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No KTP Pelanggan");
            model.addColumn("Nama Pelanggan");
            model.addColumn("Alamat");
            model.addColumn("Umur");
            model.addColumn("Jenis Kelamin");
            // Menampilkan data pada database ke dalam tabel
            try{
                int no=1;
                String sql="SELECT * FROM pelanggan";
                java.sql.Connection conn=(Connection)Connector.configDB();
                java.sql.Statement stm=conn.createStatement();
                java.sql.ResultSet res=stm.executeQuery(sql);
                
                while(res.next()){
                    model.addRow(new Object[]{
                        no++,
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),});
                }
                form.tabelPelanggan.setModel(model);
            }catch(SQLException e){
                System.out.println("Error "+e.getMessage());
            }
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==form.btnTambah){
            KosongFormPelanggan();
        }else if(ae.getSource()==form.btnSimpan){
            data.setKtp(form.txtNoKtp.getText());
            data.setNama(form.txtNamaPelanggan.getText());
            data.setAlamat(form.txtAlamat.getText());
            data.setUmur(form.txtUmur.getText());
            data.setJk((String) form.cmbJk.getSelectedItem());
            
            try {
                if(data.SimpanPelanggan(data)){
                    JOptionPane.showMessageDialog(null, "Data Telah Disimpan");
                    KosongFormPelanggan();
                    TampilDataFormPelanggan();
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }else if(ae.getSource()==form.btnEdit){
            data.setKtp(form.txtNoKtp.getText());
            data.setNama(form.txtNamaPelanggan.getText());
            data.setAlamat(form.txtAlamat.getText());
            data.setUmur(form.txtUmur.getText());
            data.setJk((String) form.cmbJk.getSelectedItem());
            
            try {
                if(data.UpdatePelanggan(data)){
                    JOptionPane.showMessageDialog(null, "Update Anda Berhasil");
                    KosongFormPelanggan();
                    TampilDataFormPelanggan();
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }else {
            data.setKtp(form.txtNoKtp.getText());
            
            try {
                if(data.HapusPelanggan(data)){
                    JOptionPane.showMessageDialog(null, "Berhasil Menghapus");
                    KosongFormPelanggan();
                    TampilDataFormPelanggan();
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==form.tabelPelanggan){
            form.txtNoKtp.setEditable(false);
            
            int baris=form.tabelPelanggan.rowAtPoint(me.getPoint());
            String no_ktp=form.tabelPelanggan.getValueAt(baris, 1).toString();
            form.txtNoKtp.setText(no_ktp);
            String nama=form.tabelPelanggan.getValueAt(baris, 3).toString();
            form.txtNamaPelanggan.setText(nama);
            String alamat=form.tabelPelanggan.getValueAt(baris, 4).toString();
            form.txtAlamat.setText(alamat);
            String umur=form.tabelPelanggan.getValueAt(baris, 5).toString();
            form.txtUmur.setText(umur);
            String Jenis_kelamin=form.tabelPelanggan.getValueAt(baris, 6).toString();
            form.cmbJk.setSelectedItem(Jenis_kelamin);
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
