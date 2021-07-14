
package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Pelanggan extends Connector{
    private String ktp;
    private String nama;
    private String alamat;
    private String jk;
    private String umur;

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }
    
    public boolean SimpanPelanggan(Pelanggan data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="INSERT INTO pelanggan (ktp, nama, alamat, jk, umur) VALUE(?, ?, ?, ?, ?)";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getKtp());
            pstm.setString(2, data.getNama());
            pstm.setString(3, data.getAlamat());
            pstm.setString(4, data.getJk());
            pstm.setString(5, data.getUmur());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public boolean UpdatePelanggan(Pelanggan data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="UPDATE pelanggan SET ktp=?, nama=?, alamat=?, jk=?, umur=? WHERE ktp=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getKtp());
            pstm.setString(2, data.getNama());
            pstm.setString(3, data.getAlamat());
            pstm.setString(4, data.getJk());
            pstm.setString(5, data.getUmur());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public boolean HapusPelanggan(Pelanggan data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="DELETE FROM pelanggan WHERE ktp=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getKtp()); 
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }    
    
}
