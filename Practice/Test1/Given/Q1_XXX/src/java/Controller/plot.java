/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.MyPoint;

/**
 *
 * @author nguye
 */
public class plot extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numx = Integer.parseInt(req.getParameter("num"));
        
        MyPoint p = new MyPoint();
        
        ArrayList<MyPoint> datas = (ArrayList<MyPoint>) p.getRandomPoint(numx);
        
//        ArrayList<MyPoint> datas = new ArrayList<>(5);
//        MyPoint p1 = new MyPoint();
//        p1.setX(80);
//        p1.setY(59);
//        datas.add(p1);
//        MyPoint p2 = new MyPoint();
//        p2.setX(140);
//        p2.setY(326);
//        datas.add(p2);
//        MyPoint p3 = new MyPoint();
//        p3.setX(260);
//        p3.setY(194);
//        datas.add(p3);
//        MyPoint p4 = new MyPoint();
//        p4.setX(290);
//        p4.setY(329);
//        datas.add(p4);
//        MyPoint p5 = new MyPoint();
//        p5.setX(260);
//        p5.setY(347);
//        datas.add(p5);
        
        req.setAttribute("data", datas);
        req.getRequestDispatcher("display.jsp").forward(req, resp);
    }
    
    
    
}
