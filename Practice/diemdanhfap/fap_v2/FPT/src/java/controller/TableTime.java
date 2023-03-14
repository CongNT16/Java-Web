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
 * @author nguye
 */
public class TableTime extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Contain c = new Contain();
        String studentId = String.valueOf(session.getAttribute("studentId"));
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        
        ArrayList<Contain> listTime = (ArrayList<Contain>) c.getTimebyStudentId(studentId);
        req.setAttribute("listTime", listTime);
        
        ArrayList<Contain> Timetable = (ArrayList<Contain>) c.getTimeTable(studentId, start, end);
        req.setAttribute("Timetable", Timetable);
        
        req.getRequestDispatcher("Timetable.jsp").forward(req, resp);
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Contain c = new Contain();
        String studentId = String.valueOf(session.getAttribute("studentId"));
        
        ArrayList<Contain> listTime = (ArrayList<Contain>) c.getTimebyStudentId(studentId);
        req.setAttribute("listTime", listTime);
        
        req.getRequestDispatcher("Timetable.jsp").forward(req, resp);
        
    }
    
    
    
    
    
}
