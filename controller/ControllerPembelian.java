
package controller;

import model.Connector;
import model.Pembelian;
import view.FormPembelian;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControllerPembelian implements ActionListener, MouseListener{
    Pembelian data;
    FormPembelian form;
    
    public ControllerPembelian(Pembelian data, FormPembelian form){
        this.data = data;
            this.form = form;
            this.form.btnSimpan.addActionListener(this);
            this.form.btnTambah.addActionListener(this);
            this.form.btnEdit.addActionListener(this);
            this.form.btnHapus.addActionListener(this);
            this.form.tabelPembelian.addMouseListener(this);
    }
    
    public void KosongFormPembelian(){
            form.txtPembelian.setText(null);
            form.txtTiket.setText(null);
            form.txtNoKtp.setText(null);
            form.txtHarga.setText(null);
            form.txtDes.setText(null);
            form.datePembelian.setDate(null);
            form.cmbKendaraan.setSelectedItem(null);
        }
    public void TampilDataFormPembelian(){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Kode Pembelian");
            model.addColumn("Kode Tiket");
            model.addColumn("No KTP Pelanggan");
            model.addColumn("Harga");
            model.addColumn("Destinasi");
            model.addColumn("Tanggal Pembelian");
            model.addColumn("Kendaraan");
            // Menampilkan data pada database ke dalam tabel
            try{
                int no=1;
                String sql="SELECT * FROM pembelian";
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
                        res.getString(5),
                        res.getString(6),
                        res.getString(7),});
                }
                form.tabelPembelian.setModel(model);
            }catch(SQLException e){
                System.out.println("Error "+e.getMessage());
            }
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==form.btnTambah){
            KosongFormPembelian();
        }else if(ae.getSource()==form.btnSimpan){
            data.setKode_pb(form.txtPembelian.getText());
            data.setKode_tk(form.txtTiket.getText());
            data.setKtp(form.txtNoKtp.getText());
            data.setHarga(form.txtHarga.getText());
            data.setDes(form.txtDes.getText());
            String sql="SELECT * FROM pembelian";
            data.setTgl_pb(form.datePembelian.getDate());
            data.setJenis_kendaraan((String) form.cmbKendaraan.getSelectedItem());
            
            try {
                if(data.SimpanPembelian(data)){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                    KosongFormPembelian();
                    TampilDataFormPembelian();
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }else if(ae.getSource()==form.btnEdit){
            data.setKode_pb(form.txtPembelian.getText());
            data.setKode_tk(form.txtTiket.getText());
            data.setKtp(form.txtNoKtp.getText());
            data.setHarga(form.txtHarga.getText());
            data.setDes(form.txtDes.getText());
            data.setTgl_pb(form.datePembelian.getDate());
            data.setJenis_kendaraan((String) form.cmbKendaraan.getSelectedItem());
            
            try {
                if(data.UpdatePembelian(data)){
                    JOptionPane.showMessageDialog(null, "Update Anda Berhasil");
                    KosongFormPembelian();
                    TampilDataFormPembelian();
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }else {
            data.setKode_pb(form.txtPembelian.getText());
            
            try {
                if(data.HapusPembelian(data)){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    KosongFormPembelian();
                    TampilDataFormPembelian();
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==form.tabelPembelian){
            form.txtPembelian.setEditable(false);
            int baris=form.tabelPembelian.rowAtPoint(me.getPoint());
            String no_pembelian=form.tabelPembelian.getValueAt(baris, 1).toString();
            form.txtPembelian.setText(no_pembelian);
            String kode_tiket=form.tabelPembelian.getValueAt(baris, 2).toString();
            form.txtTiket.setText(kode_tiket);
            String ktp=form.tabelPembelian.getValueAt(baris, 3).toString();
            form.txtNoKtp.setText(ktp);
            String harga=form.tabelPembelian.getValueAt(baris, 4).toString();
            form.txtHarga.setText(harga);
            String des=form.tabelPembelian.getValueAt(baris, 5).toString();
            form.txtDes.setText(des);
            String tanggal=(String)form.tabelPembelian.getModel().getValueAt(baris, 6);
            try{
            SimpleDateFormat tgls = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date tanggals=tgls.parse(tanggal);
            form.datePembelian.setDate(tanggals);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            String kendaraan=form.tabelPembelian.getValueAt(baris, 7).toString();
            form.cmbKendaraan.setSelectedItem(kendaraan);
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
