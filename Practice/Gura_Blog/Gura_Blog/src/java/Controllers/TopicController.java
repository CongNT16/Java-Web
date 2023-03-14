/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.PostDAO;
import DataAccess.TopicDAO;
import DataAccess.UserDAO;
import DataAccess.WebDAO;
import Models.Categories;
import Models.Posts;
import Models.Topics;
import Models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class TopicController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gettopicid = req.getParameter("gettopicid");
        
        PostDAO p = new PostDAO();
        UserDAO u = new UserDAO();
        TopicDAO t = new TopicDAO();
        CategoryDAO c = new CategoryDAO();
        WebDAO w = new WebDAO();

        String notifi = w.getNotifi();
        
        Topics topicWithId = t.getTopicWithTopicID(gettopicid);
        req.setAttribute("topicName", topicWithId.getTopic_name());
        req.setAttribute("topicID", topicWithId.getTopic_id());
        
        
        ArrayList<Posts> listPost = (ArrayList<Posts>) p.getListPost();
        req.setAttribute("listPost", listPost);

//        //gettotalpost
//        int totalPost = p.getTotalPost();
//        int endPage = totalPost / 7;
//        if (totalPost % 7 != 0) {
//            endPage++;
//        }
//        req.setAttribute("endPage", endPage);
//
//        String indexPage = req.getParameter("index");
//        if (indexPage == null) {
//            indexPage = "1";
//        }
//        int index = Integer.parseInt(indexPage);
//
//        ArrayList<Posts> listPagePost = (ArrayList<Posts>) p.getPagePost(index);
//        req.setAttribute("listPagePost", listPagePost);
//        req.setAttribute("tagPage", index);

        

        ArrayList<Users> listUser = (ArrayList<Users>) u.getListUser();
        req.setAttribute("listuser", listUser);

        ArrayList<Topics> listPostTopic = (ArrayList<Topics>) t.getAllPostTopic();
        req.setAttribute("listtopic", listPostTopic);

        ArrayList<Categories> listTopicCategory = (ArrayList<Categories>) c.getAllCategory();
        req.setAttribute("listcategory", listTopicCategory);
        

        ArrayList<Categories> listbarCategory = (ArrayList<Categories>) c.getListCategory();
        req.setAttribute("listbarCategory", listbarCategory);

        ArrayList<Categories> numberTopic = (ArrayList<Categories>) c.getNumberTopic();
        req.setAttribute("numberTopic", numberTopic);

        req.setAttribute("notifi", notifi);

        req.getRequestDispatcher("topic.jsp").forward(req, resp);
        
    }
    
    
    
}
