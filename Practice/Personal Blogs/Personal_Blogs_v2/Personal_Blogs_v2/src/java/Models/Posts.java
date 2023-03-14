/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Posts {
    
    
    private String post_id;
    private String post_title;   
    private String topic_id;   
    private String post_create_date;
    private String post_create_time;
    private String post_body;
    private String post_author_id;
    
    
    private String tag_id;
    private String tag_name;
    
    private String topic_name;
    
    private String category_id;
    private String category_name;
    
    private String img_id;
    private String img_filename;

    
    
    public String getPost_id() {
        return post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public String getPost_create_date() {
        return post_create_date;
    }

    public String getPost_create_time() {
        return post_create_time;
    }

    public String getPost_body() {
        return post_body;
    }

    public String getPost_author_id() {
        return post_author_id;
    }

    public String getTag_id() {
        return tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getImg_id() {
        return img_id;
    }

    public String getImg_filename() {
        return img_filename;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public void setPost_create_date(String post_create_date) {
        this.post_create_date = post_create_date;
    }

    public void setPost_create_time(String post_create_time) {
        this.post_create_time = post_create_time;
    }

    public void setPost_body(String post_body) {
        this.post_body = post_body;
    }

    public void setPost_author_id(String post_author_id) {
        this.post_author_id = post_author_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }

    public void setImg_filename(String img_filename) {
        this.img_filename = img_filename;
    }

    public Posts() {
    }

    public Posts(String post_id, String post_title, String topic_id, String post_create_date, String post_create_time, String post_body, String post_author_id) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.topic_id = topic_id;
        this.post_create_date = post_create_date;
        this.post_create_time = post_create_time;
        this.post_body = post_body;
        this.post_author_id = post_author_id;
    }

    public Posts(String tag_id, String tag_name) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }

    public Posts(String topic_id, String topic_name, String category_id) {
        this.topic_id = topic_id;
        this.topic_name = topic_name;
        this.category_id = category_id;
    }

    public Posts(String post_id, String post_title, String topic_id, String post_create_date, String post_create_time, String post_body, String post_author_id, String topic_name, String category_id, String category_name) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.topic_id = topic_id;
        this.post_create_date = post_create_date;
        this.post_create_time = post_create_time;
        this.post_body = post_body;
        this.post_author_id = post_author_id;
        this.topic_name = topic_name;
        this.category_id = category_id;
        this.category_name = category_name;
    }

    
    
    
    

    
}


