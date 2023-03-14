/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Images;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class ImageDAO extends ConnectDB_Blog{
    
    public ImageDAO(){
        connectDB();
    }
    
    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect success");

        } catch (Exception e) {
            System.out.println("Connect error : " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        ImageDAO i = new ImageDAO();
        
        Images imagesdetail = i.getImage("1526374657");
        
        System.out.println(imagesdetail.getImg_filename());
        
    }
    
    
    public ArrayList<Images> getPostImage(){
        ArrayList<Images> listImages = new ArrayList<Images>();
        try {
            String strSelect = "Select * from Images " ;
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String img_filename = rs.getString(2);  
                
                Images i = new Images(post_id, img_filename);
                
                listImages.add(i);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return listImages;
        
    }
    
    
    public Images getImage(String getpostid){
        Images imageWithPostId = new Images();
        try {
            String strSelect = "Select * from Images \n" +
                                "where post_id = ?" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,getpostid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString("post_id");
                String img_filename = rs.getString("img_filename");  
                
                Images i = new Images(post_id, img_filename);
                
                imageWithPostId = i;
                
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        
        return imageWithPostId;
        
    }

    public void insertImagePost(String post_id, String image_filename) {
        try {

            String strSelect = "INSERT INTO [Images] (post_id, img_filename)\n"
                    + "VALUES (?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_id);
            pstm.setString(2, image_filename);
            

            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }
    }

    public void updateEditImage(String post_id, String image_filename) {
        try {
            String strSelect = "UPDATE Images\n" +
                                "SET img_filename = ?\n" +
                                "WHERE post_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, image_filename);
            pstm.setString(2, post_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }
    }
    
    

    
}
