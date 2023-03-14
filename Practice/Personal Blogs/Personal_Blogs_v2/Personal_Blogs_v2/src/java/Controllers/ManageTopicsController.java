/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.TopicDAO;
import Models.Categories;
import Models.Topics;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class ManageTopicsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String thread = req.getParameter("thread");
        TopicDAO t = new TopicDAO();
        CategoryDAO c = new CategoryDAO();

        if (thread.equals("1")) {
            ArrayList<Topics> listTopic = (ArrayList<Topics>)t.getListTopic();
            req.setAttribute("listTopic", listTopic);
            
            ArrayList<Categories> listCategory = (ArrayList<Categories>)c.getListCategory();
            req.setAttribute("listCategory", listCategory);
            
            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_topics.jsp").forward(req, resp);
        }

        if (thread.equals("2")) {
            ArrayList<Categories> listCategory = (ArrayList<Categories>)c.getListCategory();
            req.setAttribute("listCategory", listCategory);

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_topics.jsp").forward(req, resp);

        }

        if (thread.equals("3")) {
            String idtopicdel = req.getParameter("idtopicdel");
            t.deleteTopicByTopicId(idtopicdel);
            
            ArrayList<Topics> listTopic = (ArrayList<Topics>)t.getListTopic();
            req.setAttribute("listTopic", listTopic);
            
            ArrayList<Categories> listCategory = (ArrayList<Categories>)c.getListCategory();
            req.setAttribute("listCategory", listCategory);

            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_topics.jsp").forward(req, resp);

        }

        if (thread.equals("4")) {
            String idtopicedit = req.getParameter("idtopicedit");
            
            Topics topicWithTopicId = t.getTopicWithTopicID(idtopicedit);
            Categories categoryWithCategoryId = c.getCategoryWithCategoryID(topicWithTopicId.getCategory_id());
            
            req.setAttribute("categoryname", categoryWithCategoryId.getCategory_name());
            
            ArrayList<Categories> listCategory = (ArrayList<Categories>)c.getListCategory();
            req.setAttribute("listCategory", listCategory);
            
            req.setAttribute("idtopicedit", idtopicedit);
            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_topics.jsp").forward(req, resp);

        }
        
        if(thread.equals("6")){
            String topic_name = req.getParameter("topic_name"); 
            String category_id = req.getParameter("topic_category"); 
            
             //Tạo 1 id mới
            String topic_id="";
            
            while(t.checkTopicId(topic_id) == false){
                
            Random generator = new Random();
            topic_id = String.valueOf(generator.nextInt((9999 - 1000) + 1) + 1000);
            
            t.insertTopic(topic_id,topic_name,category_id);
            break;
            }
            
            ArrayList<Topics> listTopic = (ArrayList<Topics>)t.getListTopic();
            req.setAttribute("listTopic", listTopic);
            
            ArrayList<Categories> listCategory = (ArrayList<Categories>)c.getListCategory();
            req.setAttribute("listCategory", listCategory);
            
            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_topics.jsp").forward(req, resp);
            
        }
        if(thread.equals("7")){
            String topic_id = req.getParameter("idcategoryedit"); 
            String topic_name = req.getParameter("topic_name"); 
            String category_id = req.getParameter("topic_category"); 
            
             
            t.updateEditTopic(topic_id,topic_name,category_id);
            
            
            ArrayList<Topics> listTopic = (ArrayList<Topics>)t.getListTopic();
            req.setAttribute("listTopic", listTopic);
            
            ArrayList<Categories> listCategory = (ArrayList<Categories>)c.getListCategory();
            req.setAttribute("listCategory", listCategory);
            
            req.setAttribute("thread", 1);
            req.getRequestDispatcher("manage_topics.jsp").forward(req, resp);
            
        }
        
    }

}
