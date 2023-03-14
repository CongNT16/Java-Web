/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class addMovie extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String moviename = req.getParameter("moviename");
        String detail = req.getParameter("detail");
        String thoiluong = req.getParameter("thoiluong");
        String loai = req.getParameter("loai");
        String trailer = req.getParameter("trailer");
        String poster = req.getParameter("poster");
        String daodien = req.getParameter("daodien");
        String actor = req.getParameter("actor");

        movie s = new movie();
        s.insert(moviename, detail, thoiluong, loai, daodien, trailer, poster, actor);
        ArrayList<movie> list = s.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("addfilm.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        movie s = new movie();
        ArrayList<movie> list = s.getAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("addfilm.jsp").forward(req, resp);
        req.getRequestDispatcher("book1.jsp").forward(req, resp);
    }

}
