/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.Contain;

/**
 *
 * @author Admin
 */
public class CourseAtten extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String studentId = String.valueOf(session.getAttribute("studentId"));
        String  courseId = req.getParameter("courseId");
        Contain c = new Contain();
        ArrayList<Contain> d = c.getCourse1(courseId,studentId);
        c.getbyStudentId(studentId);
        req.setAttribute("d", d);
        req.setAttribute("courseId", courseId);
        req.getRequestDispatcher("Attendance.jsp").forward(req, resp);
   }
    
    
}
