/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Article;

/**
 *
 * @author nguye
 */
public class articleDAO extends DBContext{
    public articleDAO() {
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
    
    public ArrayList<Article> getListArticleByName(String username){
        ArrayList<Article> list = new ArrayList<Article>();
        try{
            String strSelect = "select * from Article where created_by = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String title = rs.getString(2);
                String created_date = rs.getString(3);
                String created_by = rs.getString(4);
                
                Article ar = new Article(id, title, created_date, created_by);
                list.add(ar);
            }
        }catch(Exception e){
            System.out.println("GetAll error :" +e.getMessage());
        }
        return list;
    }
    
    public ArrayList<Article> getListArticle(){
        ArrayList<Article> list = new ArrayList<Article>();
        try{
            String strSelect = "select * from Article";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String title = rs.getString(2);
                String created_date = rs.getString(3);
                String created_by = rs.getString(4);
                
                Article ar = new Article(id, title, created_date, created_by);
                list.add(ar);
            }
        }catch(Exception e){
            System.out.println("GetAll error :" +e.getMessage());
        }
        return list;
    }
    
}
