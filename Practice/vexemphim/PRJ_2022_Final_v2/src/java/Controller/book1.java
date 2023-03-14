/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import Model.ticket;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class book1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String account = req.getParameter("account");
        String movieName = req.getParameter("select-movie");
        String cinema = req.getParameter("select_item");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String chu = req.getParameter("seat-a");
        String so = req.getParameter("seat-1");
        String seatName = chu + so;
        LocalDate getdate = LocalDate.now();
        LocalTime gettime = LocalTime.now();
        String bookingdate = String.valueOf(getdate);
        String bookingtime = String.valueOf(gettime);

        System.out.println(movieName);

        ticket t = new ticket();
        t.insert1(account, cinema, time, movieName, date, seatName , bookingdate, bookingtime);
        ArrayList<ticket> list = t.getAll();
        req.setAttribute("list", list);

        HttpSession session = req.getSession();

        session.setAttribute("movieName", movieName);
        session.setAttribute("cinema", cinema);
        session.setAttribute("date", date);
        session.setAttribute("time", time);
        session.setAttribute("seatName", seatName);

        req.getRequestDispatcher("book4.jsp").forward(req, resp);

    }

}
