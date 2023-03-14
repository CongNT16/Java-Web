/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class movie extends DBContext {
   int movieID;
    String moviename, detail, thoiluong, loai, daodien, trailer, poster,actor;

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(String thoiluong) {
        this.thoiluong = thoiluong;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getDaodien() {
        return daodien;
    }

    public void setDaodien(String daodien) {
        this.daodien = daodien;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public movie(int movieID,String moviename, String detail, String thoiluong, String loai, String daodien, String trailer, String poster, String actor) {
        this.moviename = moviename;
        this.detail = detail;
        this.thoiluong = thoiluong;
        this.loai = loai;
        this.daodien = daodien;
        this.trailer = trailer;
        this.poster = poster;
        this.actor = actor;
        this.movieID = movieID;
    }
    

    

   
    
    public movie() {
        connectDB();
    }

    //Khai bao cac thanh phan xu ly DB
    Connection cnn;//Ket noi DB
    Statement stm;//Thuc hien cau lenh sql
    ResultSet rs;//Luu tru va xu ly du lieu
    PreparedStatement pstm;

    private void connectDB() {
        try {
            cnn = super.connection;
            System.out.println("Connect success");
        } catch (Exception e) {
            System.out.println("Connect error:" + e.getMessage());
        }
    }
      public void deleteProduct(String movieID) {
        try {
            String strSelect = "delete  from movie "                   
                    +"where movieID=?";
            pstm = cnn.prepareStatement(strSelect);
            
            pstm.setString(1, movieID);
            
            pstm.executeUpdate();
            System.out.println("Xoa thanh cong");
        } catch (Exception e) {
            System.out.println("Delete error:" + e.getMessage());
        }
    }
    
     public void insert(String moviename, String detail, String thoiluong,String loai, String daodien, String trailer, String poster,String actor) {
        try {
            String strSelect = "INSERT INTO movie (moviename, detail, thoiluong, loai, daodien, trailer, poster, actor) VALUES (?,?,?,?,?,?,?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, moviename);
            pstm.setString(2, detail);
            pstm.setString(3, thoiluong);
            
            pstm.setString(4, loai);
            pstm.setString(5, daodien);
            pstm.setString(6, trailer);
            pstm.setString(7, poster);
            pstm.setString(8, actor);
            
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Insert error:" + e.getMessage());
        }

    }
     public boolean Delete(String id) {
        try {
            String strSelect = "DELETE FROM movie WHERE moviename=?";
            pstm = cnn.prepareStatement(strSelect);         
            pstm.setString(1, moviename);          
            pstm.executeUpdate();
            System.out.println("Xóa vao thanh cong");
            return true;
        } catch (SQLException e) {
            System.out.println("Create error : " + e.getMessage());
            return false;
            
        }
        
        
    }
    public ArrayList<movie> getAll() {
        ArrayList<movie> list = new ArrayList<movie>();
        try {
            String strSelect = "select * from movie";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int movieID = rs.getInt(1);
                String moviename = rs.getString(2);
                String detail = rs.getString(3);
                String thoiluong = rs.getString(4);
                String loai = rs.getString(5);
                String daodien = rs.getString(6);
                String trailer = rs.getString(7);
                String poster = rs.getString(8);
               
                String actor = rs.getString(10);
                movie s = new movie(movieID,moviename, detail, thoiluong, loai, daodien, trailer, poster, actor);
                list.add(s);
            }
        } catch (Exception e) {
            System.out.print("getAll error ???" + e.getMessage());
        }
        return list;
    }

    public ArrayList<movie> Search(String search) {
        ArrayList<movie> list = new ArrayList<movie>();
        try {
            String strSelect = "select * from movie where loai like ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%"+search+"%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int movieID = rs.getInt(1);
                String moviename = rs.getString(2);
                String detail = rs.getString(3);
                String thoiluong = rs.getString(4);
                String loai = rs.getString(5);
                String daodien = rs.getString(6);
                String trailer = rs.getString(7);
                String poster = rs.getString(8);
               
                String actor = rs.getString(10);
                System.out.println(moviename);
                movie m = new movie(movieID,moviename, detail, thoiluong, loai, daodien, trailer, poster, actor);
                list.add(m);
            }
        } catch (Exception e) {
            System.out.print("getAll error search: " + e.getMessage());
        }
        return list;
    }


    
}
