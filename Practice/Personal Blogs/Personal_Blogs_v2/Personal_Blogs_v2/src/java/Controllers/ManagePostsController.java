/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.ImageDAO;
import DataAccess.PostDAO;
import DataAccess.TagDAO;
import DataAccess.TopicDAO;
import DataAccess.UserDAO;
import Models.Categories;
import Models.Images;
import Models.Posts;
import Models.Tags;
import Models.Topics;
import Models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class ManagePostsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String thread = req.getParameter("thread");

        PostDAO p = new PostDAO();
        TagDAO t = new TagDAO();
        UserDAO u = new UserDAO();
        ImageDAO i = new ImageDAO();
        CategoryDAO c = new CategoryDAO();
        TopicDAO tp = new TopicDAO();
        String mess = "";

        if (thread.equals("1")) {

            //gettotalpost
            int totalPost = p.getTotalPost();

            ArrayList<Posts> ListPost = (ArrayList<Posts>) p.getAllPost();
            ArrayList<Tags> listPostTag = (ArrayList<Tags>) t.getPostTag();
            ArrayList<Users> listUser = (ArrayList<Users>) u.getAllUser();
            ArrayList<Images> listImages = (ArrayList<Images>) i.getPostImage();

            req.setAttribute("listpost", ListPost);
            req.setAttribute("listPostTag", listPostTag);
            req.setAttribute("listuser", listUser);
            req.setAttribute("listimages", listImages);
            req.setAttribute("toltalpost", totalPost);
            req.setAttribute("thread", thread);

            req.getRequestDispatcher("manage_posts.jsp").forward(req, resp);
        }

        if (thread.equals("2")) {

            String getcategoryid = req.getParameter("getcategoryid");

            ArrayList<Topics> listTopicWithCategoryId = (ArrayList<Topics>) tp.getTopicWithCategoryId(getcategoryid);
            req.setAttribute("listtopic", listTopicWithCategoryId);

            ArrayList<Tags> listTag = (ArrayList<Tags>) t.getListTag();
            req.setAttribute("listtag", listTag);

            req.setAttribute("thread", thread);

            req.getRequestDispatcher("manage_posts.jsp").forward(req, resp);

        }

        if (thread.equals("3")) {
            String idpostdel = req.getParameter("idpostdel");
            p.deletePostByPostId(idpostdel);

            int totalPost = p.getTotalPost();

            ArrayList<Posts> ListPost = (ArrayList<Posts>) p.getAllPost();
            ArrayList<Tags> listPostTag = (ArrayList<Tags>) t.getPostTag();
            ArrayList<Users> listUser = (ArrayList<Users>) u.getAllUser();
            ArrayList<Images> listImages = (ArrayList<Images>) i.getPostImage();

            req.setAttribute("listpost", ListPost);
            req.setAttribute("listPostTag", listPostTag);
            req.setAttribute("listuser", listUser);
            req.setAttribute("listimages", listImages);
            req.setAttribute("toltalpost", totalPost);
            req.setAttribute("thread", 1);

            req.getRequestDispatcher("manage_posts.jsp").forward(req, resp);

        }

        if (thread.equals("4")) {
            String idpostedit = req.getParameter("idpostedit");
            ArrayList<Topics> listTopic = (ArrayList<Topics>) tp.getListTopic();
            req.setAttribute("listtopic", listTopic);

            ArrayList<Tags> posttag = (ArrayList<Tags>) t.getPostTag();
            req.setAttribute("posttag", posttag);
            
            ArrayList<Tags> listTag = (ArrayList<Tags>) t.getListTag();
            req.setAttribute("listtag", listTag);

            Posts postWithPostId = p.getPost(idpostedit);
            Images imageWithPostId = i.getImage(idpostedit);
            Topics topicWithTPostId = tp.getTopic(idpostedit);

            req.setAttribute("post_topicname", topicWithTPostId.getTopic_name());
            req.setAttribute("post_title", postWithPostId.getPost_title());
            req.setAttribute("post_detail", postWithPostId.getPost_body());
            req.setAttribute("post_image", imageWithPostId.getImg_filename());

//            req.setAttribute("post_tag", postWithPostId.getPost_title());
            req.setAttribute("idpostedit", idpostedit);
            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_posts.jsp").forward(req, resp);

        }

        if (thread.equals("5")) {
            ArrayList<Categories> listCategory = (ArrayList<Categories>) c.getListCategory();
            req.setAttribute("listcategory", listCategory);

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_posts.jsp").forward(req, resp);

        }

        if (thread.equals("6")) {
            String topic_id = req.getParameter("post_topic");
            String post_title = req.getParameter("post_title");
            String post_detail = req.getParameter("post_detail");
            String image_filename = req.getParameter("post_image");
            String post_author_id = req.getParameter("post_author_id");
            String[] post_tag = req.getParameterValues("post_tag");

            //Tạo 1 id mới
            String post_id = "";

            while (p.checkPostId(post_id) == false) {

                long rannum = (long) Math.floor(Math.random() * (9999999999L - 1000000000L + 1) + 1000000000L);
                post_id = String.valueOf(rannum);

                //get time local
                LocalDate getdate = LocalDate.now();
                LocalTime gettime = LocalTime.now();
                String createdate = String.valueOf(getdate);
                String createtime = String.valueOf(gettime);

                p.insertCreatePost(post_id, post_title, topic_id, createdate, createtime, post_detail, post_author_id);
                if (p.checkPostId(post_id)) {
                    i.insertImagePost(post_id, image_filename);

                    if (post_tag != null) {
                        for (String tag_id : post_tag) {
                            t.insertPostTag(post_id, tag_id);
                            //resp.getWriter().println(tag_id + " " + post_id);
                        }
                    }
                }
                break;
            }

            //gettotalpost
            int totalPost = p.getTotalPost();

            ArrayList<Posts> ListPost = (ArrayList<Posts>) p.getAllPost();
            ArrayList<Tags> listPostTag = (ArrayList<Tags>) t.getPostTag();
            ArrayList<Users> listUser = (ArrayList<Users>) u.getAllUser();
            ArrayList<Images> listImages = (ArrayList<Images>) i.getPostImage();

            req.setAttribute("listpost", ListPost);
            req.setAttribute("listPostTag", listPostTag);
            req.setAttribute("listuser", listUser);
            req.setAttribute("listimages", listImages);
            req.setAttribute("toltalpost", totalPost);

            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_posts.jsp").forward(req, resp);

        }

        if (thread.equals("7")) {
            String post_id = req.getParameter("idpostedit");
            String topic_id = req.getParameter("post_topic");
            String post_title = req.getParameter("post_title");
            String post_detail = req.getParameter("post_detail");
            String image_filename = req.getParameter("post_image");
            String post_author_id = req.getParameter("post_author_id");
            String[] post_tag = req.getParameterValues("post_tag");

            p.updateEditPost(post_id, post_title, topic_id, post_detail, post_author_id);
            i.updateEditImage(post_id, image_filename);
            t.deleteEditTag(post_id);

            if (post_tag != null) {
                for (String tag_id : post_tag) {
                    t.insertPostTag(post_id, tag_id);
                    //resp.getWriter().println(tag_id + " " + post_id);
                }
            }
            
            //gettotalpost
            int totalPost = p.getTotalPost();

            ArrayList<Posts> ListPost = (ArrayList<Posts>) p.getAllPost();
            ArrayList<Tags> listPostTag = (ArrayList<Tags>) t.getPostTag();
            ArrayList<Users> listUser = (ArrayList<Users>) u.getAllUser();
            ArrayList<Images> listImages = (ArrayList<Images>) i.getPostImage();

            req.setAttribute("listpost", ListPost);
            req.setAttribute("listPostTag", listPostTag);
            req.setAttribute("listuser", listUser);
            req.setAttribute("listimages", listImages);
            req.setAttribute("toltalpost", totalPost);

            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_posts.jsp").forward(req, resp);

        }

    }

}
