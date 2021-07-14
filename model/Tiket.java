
package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Tiket extends Connector{
    private String kode_tk;
    private String supp;
    private String kelas;
    private String harga;
    private String ket;
    private String des;

    public String getKode_tk() {
        return kode_tk;
    }

    public void setKode_tk(String kode_tk) {
        this.kode_tk = kode_tk;
    }

    public String getSupp() {
        return supp;
    }

    public void setSupp(String supp) {
        this.supp = supp;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
    public boolean SimpanTiket(Tiket data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="INSERT INTO tiket (kode_tk, supp, kelas, harga, ket, des) VALUE(?, ?, ?, ?, ?, ?)";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getKode_tk());
            pstm.setString(2, data.getSupp());
            pstm.setString(3, data.getKelas());
            pstm.setString(4, data.getHarga());
            pstm.setString(5, data.getKet());
            pstm.setString(6, data.getDes());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public boolean UpdateTiket(Tiket data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="UPDATE tiket SET kode_tk=?, supp=?, kelas=?, harga=?, ket=?, des=? WHERE kode_tk=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getKode_tk());
            pstm.setString(2, data.getSupp());
            pstm.setString(3, data.getKelas());
            pstm.setString(4, data.getHarga());
            pstm.setString(5, data.getKet());
            pstm.setString(6, data.getDes());
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public boolean HapusTiket(Tiket data) throws SQLException{
        PreparedStatement pstm=null;
        Connection conn=(Connection)Connector.configDB();
        
        String sql="DELETE FROM tiket WHERE kode_tk=?";
        
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, data.getKode_tk()); 
            pstm.execute();
            return true;
        }catch(HeadlessException | SQLException e){
            System.err.println(e);
            return false;
        }
    }    
    
    
}
