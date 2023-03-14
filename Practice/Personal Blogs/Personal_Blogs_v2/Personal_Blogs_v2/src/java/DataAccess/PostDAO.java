/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Posts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class PostDAO extends ConnectDB_Blog {

    public PostDAO() {
        connectDB();

    }

    public static void main(String[] args) {
        PostDAO p = new PostDAO();
//        ArrayList<Posts> listpost = (ArrayList<Posts>)p.getAllPost();
//        for (Posts post : listpost) {
//            System.out.println(post.getPost_create_date());}

        ArrayList<Posts> listpost = (ArrayList<Posts>) p.getAllPost();
        for (Posts post : listpost) {
            System.out.println(post.getPost_title());
        }

        long rannum = (long) Math.floor(Math.random() * (9999999999L - 1000000000L + 1) + 1000000000L);
        System.out.println(rannum);

        int count = p.getTotalPost();
        System.out.println(count);

        Posts postDetail = p.getPost("1263748920");
        System.out.println(postDetail.getPost_title());
    }

    //Khai bao cac thanh phan xu ly
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

    public boolean checkPostId(String post_id) {
        try {
            String strSelect = "select * from Posts "
                    + "where post_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_id);
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

    public ArrayList<Posts> getAllPost() {
        ArrayList<Posts> listpost = new ArrayList<Posts>();
        try {
            String strSelect = "Select p.*, tp.topic_name,c.category_id,c.category_name from Posts p join Topics tp on p.topic_id = tp.topic_id join Categories c on c.category_id = tp.category_id";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);               
                String topic_id = rs.getString(3);
                
                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));
                
                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);
                String topic_name = rs.getString(8);
                String category_id = rs.getString(9); 
                String category_name = rs.getString(10); 

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id, topic_name, category_id, category_name);
                
                listpost.add(p);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return listpost;
    }

    public Posts getPost(String getPostid) {
        Posts postDetail = new Posts();
        try {
            String strSelect = "select * from Posts "
                            + "where post_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, getPostid);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);               
                String topic_id = rs.getString(3);
                
                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));
                
                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id);

                postDetail = p;
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return postDetail;
    }

//đếm số lượng post trong database
    public int getTotalPost() {

        try {

            String strSelect = "select count(*) from Posts ";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return 0;
    }

    public ArrayList<Posts> getPagePost(int index) {
        ArrayList<Posts> listPagePost = new ArrayList<Posts>();
        try {
            String strSelect = "SELECT * FROM Posts \n"
                    + "Order by post_create_date DESC,post_create_time DESC \n"
                    + "OFFSET ? ROWS FETCH NEXT 7 ROWS ONLY ;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (index - 1) * 7);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);               
                String topic_id = rs.getString(3);
                
                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));
                
                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);  

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id);

                listPagePost.add(p);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return listPagePost;
    }
    
    
    public String getTopicName(String topic_id){
        String topic_name ="";
        try {
            String strSelect = "select [topic_name] from Topics "
                    + "where topic_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topic_id);

            rs = pstm.executeQuery();
            while (rs.next()) {
                topic_name = rs.getString(1);

            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        
        return topic_name;
    
    }
    
    
    public String getCategoryId(String topic_id){
        String category_id ="";
        try {
            String strSelect = "select [category_id] from Topics "
                    + "where topic_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topic_id);

            rs = pstm.executeQuery();
            while (rs.next()) {
                category_id = rs.getString(1);

            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        
        return category_id;
    
    }
    
    
    public String getCategoryName(String category_id){
        String category_name ="";
        try {
            String strSelect = "select [category_name] from Categories "
                    + "where category_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, category_id);

            rs = pstm.executeQuery();
            while (rs.next()) {
                category_name = rs.getString(1);

            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        
        return category_name;
    
    }
    
    
    
    
    

    public void insertCreatePost(String post_id, String post_title, String topic_id, String post_create_date, String post_create_time, String post_body, String post_author_id) {
        try {

            String strSelect = "INSERT INTO [dbo].[Posts] ([post_id],[post_title],[topic_id],[post_create_date],[post_create_time],[post_body],[post_author_id])\n"
                    + "VALUES (?,?,?,?,?,?,?)";
//            String role = "4";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_id);
            pstm.setString(2, post_title);
            pstm.setString(3, topic_id);
            pstm.setString(4, post_create_date);
            pstm.setString(5, post_create_time);
            pstm.setString(6, post_body);
            pstm.setString(7, post_author_id);
            

            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }
    }

    public void deletePostByPostId(String post_id) {
       try {
            String strSelect = "DELETE FROM PostTag WHERE post_id= ?\n" +
                                "DELETE FROM Images WHERE post_id= ?\n" +
                                "DELETE FROM Comments WHERE post_id= ?\n" +
                                "DELETE FROM Posts WHERE post_id= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_id);
            pstm.setString(2, post_id);
            pstm.setString(3, post_id);
            pstm.setString(4, post_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }
    }

    public void updateEditPost(String post_id,String post_title, String topic_id, String post_detail, String post_author_id) {
        
        try {
            String strSelect = "UPDATE Posts\n" +
                                "SET post_title =?,topic_id =?,post_body =?,post_author_id =?\n" +
                                "WHERE post_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_title);
            pstm.setString(2, topic_id);
            pstm.setString(3, post_detail);
            pstm.setString(4, post_author_id);
            pstm.setString(5, post_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }
        
    }

}
