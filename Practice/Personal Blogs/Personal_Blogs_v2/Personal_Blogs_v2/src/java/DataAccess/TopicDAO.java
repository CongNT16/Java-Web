/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Categories;
import Models.Topics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class TopicDAO extends ConnectDB_Blog{
    
    public TopicDAO(){
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
        TopicDAO t = new TopicDAO();
        CategoryDAO c = new CategoryDAO();
        ArrayList<Topics> listPostTopic = (ArrayList<Topics>)t.getAllPostTopic();
        
        for (Topics topic : listPostTopic) {
            System.out.println(topic.getTopic_name());
        }
        
        Topics topicWithTopicId = t.getTopicWithTopicID("8719");
        Categories categoryWithCategoryId = c.getCategoryWithCategoryID(topicWithTopicId.getCategory_id());
        
        System.out.println(topicWithTopicId.getCategory_id() +""+categoryWithCategoryId.getCategory_name());
        
    }
    
    public boolean checkTopicId(String topic_id) {
        try {
            String strSelect = "select * from Topics "
                           + "where topic_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topic_id);
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
    
    public ArrayList<Topics> getAllPostTopic(){
        ArrayList<Topics> listPostTopic = new ArrayList<Topics>();
        try {
            String strSelect = "Select t.*,p.post_id from Topics t\n" +
                                "join Posts p on t.topic_id = p.topic_id" ;
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                String topic_name = rs.getString(2);
                String category_id = rs.getString(3);
                String post_id = rs.getString(4);
                
                
                Topics t = new Topics(topic_id, topic_name, post_id, category_id);
                
                listPostTopic.add(t);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return listPostTopic;
        
    }
    
    public Topics getTopic(String getpostid){
        Topics topicWithPostId = new Topics();
        try {
            String strSelect = "Select t.*,p.post_id from Topics t\n" +
                                "join Posts p on t.topic_id = p.topic_id\n" +
                                    "where post_id = ?" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,getpostid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                String topic_name = rs.getString(2);
                String category_id = rs.getString(3);
                String post_id = rs.getString(4);
                
                Topics t = new Topics(topic_id, topic_name, post_id, category_id);
                
                topicWithPostId = t;
                
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        
        return topicWithPostId;
        
    }
    
    public ArrayList<Topics> getTopicWithCategoryId(String getcategoryid){
        ArrayList<Topics> listTopicWithCategoryId = new ArrayList<Topics>();
        try {
            String strSelect = "Select t.*,p.post_id from Topics t\n" +
                                "left join Posts p on t.topic_id = p.topic_id\n" +
                                    "where category_id = ?" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,getcategoryid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                String topic_name = rs.getString(2);
                String category_id = rs.getString(3);
                String post_id = rs.getString(4);
                
                Topics t = new Topics(topic_id, topic_name, post_id, category_id);
                
                listTopicWithCategoryId.add(t);
                
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        
        return listTopicWithCategoryId;
        
    }
    
    public ArrayList<Topics> getListTopic(){
        ArrayList<Topics> listTopic = new ArrayList<Topics>();
        try {
            String strSelect = "Select * from Topics" ;
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                String topic_name = rs.getString(2);
                String category_id = rs.getString(3);
                
                Topics t = new Topics(topic_id, topic_name, category_id);
                
                listTopic.add(t);
                
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        
        return listTopic;
        
    }

    public void insertTopic(String topic_id, String topic_name, String category_id) {
        try {

            String strSelect = "INSERT INTO [Topics] (topic_id, topic_name , category_id)\n"
                    + "VALUES (?,?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topic_id);
            pstm.setString(2, topic_name);
            pstm.setString(3, category_id);
            

            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }
    }

    public void deleteTopicByTopicId(String topicid) {
        
        try {
            String strSelect = "DELETE FROM Topics WHERE topic_id= ?\n" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topicid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }
        
        
    }

    public Topics getTopicWithTopicID(String topicid) {
        Topics topic = new Topics();
        try {
            String strSelect = "Select * from Topics \n" +
                                  "where topic_id = ?" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,topicid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                String topic_name = rs.getString(2);
                String category_id = rs.getString(3);
                 
                Topics t = new Topics(topic_id,topic_name, category_id);
                
                topic = t;
                
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return topic;
        
    }

    public void updateEditTopic(String topic_id, String topic_name, String category_id) {
        try {
            String strSelect = "UPDATE Topics\n" +
                                "SET topic_name =? , category_id = ?\n" +
                                "WHERE topic_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topic_name);
            pstm.setString(2, category_id);
            pstm.setString(3, topic_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }
    }

    
    
    
}
