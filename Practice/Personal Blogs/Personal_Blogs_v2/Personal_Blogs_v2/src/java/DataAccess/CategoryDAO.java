/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class CategoryDAO extends ConnectDB_Blog{
    
    public CategoryDAO(){
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
        
        
    }
    
    
    public boolean checkCategoryId(String category_id) {
        try {
            String strSelect = "select * from Categories "
                           + "where category_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, category_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        return false;
    }

    
    public ArrayList<Categories> getAllCategory(){
        ArrayList<Categories> listTopicCategory = new ArrayList<Categories>();
        try {
            String strSelect = "Select c.*,t.topic_id from Categories c\n" +
                                    "join Topics t on  c.category_id = t.category_id" ;
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String category_id = rs.getString(1);
                String category_name = rs.getString(2);
                String topic_id = rs.getString(3);
                
                
                Categories c = new Categories(category_id, category_name, topic_id);
                
                listTopicCategory.add(c);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return listTopicCategory;
        
    }
    
    
    public ArrayList<Categories> getListCategory(){
        ArrayList<Categories> listCategory = new ArrayList<Categories>();
        try {
            String strSelect = "Select * from Categories ";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String category_id = rs.getString(1);
                String category_name = rs.getString(2);
                
                
                Categories c = new Categories(category_id, category_name);
                
                listCategory.add(c);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return listCategory;
        
    }
    
    
    
    public Categories getCategory(String gettopicid){
        Categories categoryWithTopicid = new Categories();
        try {
            String strSelect = "Select c.*,t.topic_id from Categories c\n" +
                                "join Topics t on  c.category_id = t.category_id\n" +
                                  "where topic_id = ?" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,gettopicid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String category_id = rs.getString(1);
                String category_name = rs.getString(2);
                String topic_id = rs.getString(3);
                 
                Categories c = new Categories(category_id, category_name, topic_id);
                
                categoryWithTopicid = c;
                
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        
        return categoryWithTopicid;
        
    }

    public void insertCategory(String category_id, String category_name) {
        try {

            String strSelect = "INSERT INTO [Categories] (category_id, category_name)\n"
                    + "VALUES (?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, category_id);
            pstm.setString(2, category_name);
            

            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }
    }

    public void deleteCategoryByCategoryId(String categoryid) {
       
        try {
            String strSelect = "DELETE FROM Categories WHERE category_id= ?\n" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, categoryid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }
        
        
    }

    public Categories getCategoryWithCategoryID(String categoryid) {
        Categories category = new Categories();
        try {
            String strSelect = "Select * from Categories \n" +
                                  "where category_id = ?" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,categoryid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String category_id = rs.getString(1);
                String category_name = rs.getString(2);
                 
                Categories c = new Categories(category_id, category_name);
                
                category = c;
                
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return category;
        
    }

    public void updateEditCategory(String category_id, String category_name) {
        
        try {
            String strSelect = "UPDATE Categories\n" +
                                "SET category_name =? \n" +
                                "WHERE category_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, category_name);
            pstm.setString(2, category_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }
       
    }
    
}
