
package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Pembelian {
    private String kode_pb;
    private String kode_tk;
    private String ktp;
    private String tgl_pb;
    private String harga;
    private String des;
    private String jenis_kendaraan;
    
    public String getKode_pb() {
        return kode_pb;
    }

    public void setKode_pb(String kode_pb) {
        this.kode_pb = kode_pb;
    }

    public String getKode_tk() {
        return kode_tk;
    }

    public void setKode_tk(String kode_tk) {
        this.kode_tk = kode_tk;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getTgl_pb() {
        return tgl_pb;
    }

    public void setTgl_pb(String tgl_pb) {
        this.tgl_pb = tgl_pb;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getJenis_kendaraan() {
        return jenis_kendaraan;
    }

    public void setJenis_kendaraan(String jenis_kendaraan) {
        this.jenis_kendaraan = jenis_kendaraan;
    }
    
    
    
    public boolean SimpanPembelian(Pembelian data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="INSERT INTO pembelian (kode_pb, kode_tk, ktp, tgl_pb, harga, des, jenis_kendaraan) VALUE(?, ?, ?, ?, ?, ?, ?)";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getKode_pb());
            pstm.setString(2, data.getKode_tk());
            pstm.setString(3, data.getKtp());
            pstm.setString(4, data.getTgl_pb());
            pstm.setString(5, data.getHarga());
            pstm.setString(6, data.getDes());
            pstm.setString(7, data.getJenis_kendaraan());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public boolean UpdatePembelian(Pembelian data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="UPDATE pembelian SET kode_pb=?, kode_tk=?, ktp=?, tgl_pb=?, harga=?, des=?, jenis_kendaraan=?   WHERE kode_pb=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getKode_pb());
            pstm.setString(2, data.getKode_tk());
            pstm.setString(3, data.getKtp());
            pstm.setString(4, data.getTgl_pb());
            pstm.setString(5, data.getHarga());
            pstm.setString(6, data.getDes());
            pstm.setString(7, data.getJenis_kendaraan());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public boolean HapusPembelian(Pembelian data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="DELETE FROM pembelian WHERE kode_pb=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getKode_pb());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }    
    
}
