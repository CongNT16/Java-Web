/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

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
public class ManageCommentsController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String thread = req.getParameter("thread");

        if (thread.equals("1")) {

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_comments.jsp").forward(req, resp);
        }

        if (thread.equals("2")) {

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_comments.jsp").forward(req, resp);

        }

        if (thread.equals("3")) {

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_comments.jsp").forward(req, resp);

        }

        if (thread.equals("4")) {

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_comments.jsp").forward(req, resp);

        }
    }
    
    
    
}
