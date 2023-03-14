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

import java.util.ArrayList;



/**
 *
 * @author nguye
 */
public class HomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PostDAO p = new PostDAO();
        ImageDAO i = new ImageDAO();
        UserDAO u = new UserDAO();
        TopicDAO t = new TopicDAO();
        CategoryDAO c = new CategoryDAO();

        //gettotalpost
        int totalPost = p.getTotalPost();
        int endPage = totalPost / 7;
        if (totalPost % 7 != 0) {
            endPage++;
        }
        session.setAttribute("endPage", endPage);

        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        
        
        ArrayList<Posts> listPagePost = (ArrayList<Posts>) p.getPagePost(index);
        req.setAttribute("listPagePost", listPagePost);
        req.setAttribute("tagPage", index);
        
        ArrayList<Images> listImages = (ArrayList<Images>)i.getPostImage();
        req.setAttribute("listimages", listImages);
        
        ArrayList<Users> listUser = (ArrayList<Users>)u.getAllUser();
        req.setAttribute("listuser", listUser);
        
        
        ArrayList<Topics> listPostTopic = (ArrayList<Topics>)t.getAllPostTopic();
        req.setAttribute("listtopic", listPostTopic);
        
        ArrayList<Categories> listTopicCategory = (ArrayList<Categories>)c.getAllCategory();
        req.setAttribute("listcategory", listTopicCategory);
        

        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }

}
