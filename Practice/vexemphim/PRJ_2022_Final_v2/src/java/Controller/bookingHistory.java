/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ticket;
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
public class bookingHistory extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ticket t = new ticket();
        String account = String.valueOf(session.getAttribute("account"));
        
        ArrayList<ticket> listHistoryBooking = (ArrayList<ticket>) t.getListHistoryBooking(account);
        req.setAttribute("listHistoryBooking", listHistoryBooking);
        
        req.setAttribute("account", account);
        req.getRequestDispatcher("historyBooking.jsp").forward(req, resp);
        
    }
    
    
    
}
