/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.ImageDAO;
import DataAccess.PostDAO;
import DataAccess.TopicDAO;
import DataAccess.UserDAO;
import Models.Categories;
import Models.Images;
import Models.Posts;
import Models.Topics;
import Models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


/**
 *
 * @author nguye
 */
public class PostController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String getpostid = req.getParameter("postid");
        PostDAO p = new PostDAO();
        ImageDAO i = new ImageDAO();
        TopicDAO t = new TopicDAO();
        CategoryDAO c = new CategoryDAO();
        UserDAO u = new UserDAO();
        
        
        Posts postDetail = p.getPost(getpostid);
        Images imageWithPost = i.getImage(getpostid);
        Topics topicWithpost = t.getTopic(getpostid);
        Categories categoryWithTopic = c.getCategory(postDetail.getTopic_id());
        Users userInforAuthor = u.getUserInfor(postDetail.getPost_author_id());
        
        req.setAttribute("post_id", postDetail.getPost_id());
        req.setAttribute("post_title", postDetail.getPost_title());
        req.setAttribute("topic_id", postDetail.getTopic_id());
        req.setAttribute("post_body", postDetail.getPost_body());
        req.setAttribute("post_author_id", postDetail.getPost_author_id());
        req.setAttribute("post_create_date", postDetail.getPost_create_date());
        
        req.setAttribute("imagename", imageWithPost.getImg_filename());
        
        req.setAttribute("topic", topicWithpost.getTopic_name());
        
        req.setAttribute("category", categoryWithTopic.getCategory_name());
        
        req.setAttribute("avatar_author", userInforAuthor.getUser_avatar());
        String fullname_author = userInforAuthor.getUser_firstname() +" "+ userInforAuthor.getUser_lastname();
        req.setAttribute("name_author", fullname_author);

        req.getRequestDispatcher("post.jsp").forward(req, resp);
    }
    
    
    
}
