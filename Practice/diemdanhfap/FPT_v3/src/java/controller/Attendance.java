/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Contain;

/**
 *
 * @author Admin
 */
public class Attendance extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("id");
        String course = req.getParameter("course");
        Contain c = new Contain();
        ArrayList<Contain> a = c.getbyStudentId(studentId);
        ArrayList<Contain> b = c.getCourse();
        req.setAttribute("b", b);
        req.setAttribute("ab", a);
        req.getRequestDispatcher("Attendance.jsp").forward(req, resp);

    }

}
