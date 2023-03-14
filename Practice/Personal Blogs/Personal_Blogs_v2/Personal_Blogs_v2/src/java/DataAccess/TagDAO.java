/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Posts;
import Models.Tags;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class TagDAO extends ConnectDB_Blog {

    public TagDAO() {
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

        TagDAO t = new TagDAO();
        PostDAO p = new PostDAO();

        ArrayList<Posts> listpost = (ArrayList<Posts>) p.getAllPost();
        ArrayList<Tags> listPostTag = (ArrayList<Tags>) t.getPostTag();
        for (Posts post : listpost) {
            for (Tags tag : listPostTag) {

                if (post.getPost_id().equals(tag.getPost_id())) {
                    System.out.println(tag.getTag_name());
                }

            }
        }

    }

    public ArrayList<Tags> getPostTag() {
        ArrayList<Tags> listPostTag = new ArrayList<Tags>();
        try {
            String strSelect = "Select ta.*, pt.post_id from Tags ta\n"
                    + "join PostTag pt on ta.tag_id = pt.tag_id";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String tag_id = rs.getString(1);
                String tag_name = rs.getString(2);
                String post_id = rs.getString(3);

                Tags t = new Tags(post_id, tag_id, tag_name);

                listPostTag.add(t);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return listPostTag;

    }

    public ArrayList<Tags> getListTag() {
        ArrayList<Tags> listPostTag = new ArrayList<Tags>();
        try {
            String strSelect = "Select * from Tags ";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String tag_id = rs.getString(1);
                String tag_name = rs.getString(2);

                Tags t = new Tags(tag_id, tag_name);

                listPostTag.add(t);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return listPostTag;

    }

    public void insertPostTag(String post_id, String tag_id) {
        try {

            String strSelect = "INSERT INTO [PostTag] (post_id, tag_id)\n"
                    + "VALUES (?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_id);
            pstm.setString(2, tag_id);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }
    }

    public void deleteEditTag(String post_id) {

        try {

            String strSelect = "DELETE FROM PostTag WHERE post_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_id);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("delete error : " + e.getMessage());

        }

    }

    public boolean checkTagId(String tag_id) {
        try {
            String strSelect = "select * from Tags "
                           + "where tag_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, tag_id);
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

    public void insertTag(String tag_id, String tag_name) {
        try {

            String strSelect = "INSERT INTO [Tags] (tag_id, tag_name)\n"
                    + "VALUES (?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, tag_id);
            pstm.setString(2, tag_name);
            

            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }
    }

    public void deleteTagByTagId(String tag_id) {
        try {
            String strSelect = "DELETE FROM PostTag WHERE tag_id= ?\n" +
                                "DELETE FROM Tags WHERE tag_id= ?" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, tag_id);
            pstm.setString(2, tag_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }
    }

    public Tags getTagWithTagId(String tagid) {
        Tags tag = new Tags();
        try {
            String strSelect = "Select * from Tags \n" +
                                  "where tag_id = ?" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,tagid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String tag_id = rs.getString(1);
                String tag_name = rs.getString(2);
                 
                Tags t = new Tags(tag_id, tag_name);
                
                tag = t;
                
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return tag;
    }

    public void updateEditTag(String tag_id, String tag_name) {
        try {
            String strSelect = "UPDATE Tags\n" +
                                "SET tag_name =? \n" +
                                "WHERE tag_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, tag_name);
            pstm.setString(2, tag_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }
    }

}
