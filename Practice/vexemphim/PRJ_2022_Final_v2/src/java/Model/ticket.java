/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import context.DBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class ticket extends DBContext {

    String ticketID, account, cinemaName, time, movieName, date, seatName, bookingdate, bookingtime;
    
    public static void main(String[] args) {
        ticket t = new ticket();
        ArrayList<ticket> listHistoryBooking = (ArrayList<ticket>) t.getListHistoryBooking("user0");
        
        for(ticket list : listHistoryBooking){
        System.out.println(list.getAccount());
        }
        
        
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getTime() {
        return time;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public String getBookingtime() {
        return bookingtime;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public void setBookingtime(String bookingtime) {
        this.bookingtime = bookingtime;
    }

    public ticket() {
        connectDB();
    }
    

    public ticket(String ticketID, String account, String cinemaName, String time, String movieName, String date, String seatName) {
        this.ticketID = ticketID;
        this.seatName = seatName;
        this.account = account;
        this.movieName = movieName;
        this.date = date;
        this.cinemaName = cinemaName;
        this.seatName = seatName;
        connectDB();
    }

    public ticket(String ticketID, String account, String cinemaName, String time, String movieName, String date, String seatName, String bookingdate, String bookingtime) {
        this.ticketID = ticketID;
        this.account = account;
        this.cinemaName = cinemaName;
        this.time = time;
        this.movieName = movieName;
        this.date = date;
        this.seatName = seatName;
        this.bookingdate = bookingdate;
        this.bookingtime = bookingtime;
        connectDB();
    }

    Connection cnn;//Ket noi DB
    Statement stm;//Thuc hien cau lenh sql
    ResultSet rs;//Luu tru va xu ly du lieu
    PreparedStatement pstm;

    private void connectDB() {
        try {
            cnn = super.connection;
            System.out.println("Connect success");
        } catch (Exception e) {
            System.out.println("Connect error:" + e.getMessage());
        }
    }

    public void insert1(String account, String cinemaName, String time, String movieName, String date, String seat, String bookingdate, String bookingtime) {
        try {
            String strSelect = "INSERT INTO ticket (account,cinemaName, time, movieName, date, seatName, booking_date, booking_time) VALUES (?,?,?,?,?,?,?,?)";
            pstm = cnn.prepareStatement(strSelect);

            pstm.setString(1, account);
            pstm.setString(2, cinemaName);
            pstm.setString(3, time);
            pstm.setString(4, movieName);
            pstm.setString(5, date);
            pstm.setString(6, seat);
            pstm.setString(7, bookingdate);
            pstm.setString(8, bookingtime);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Insert1 error:" + e.getMessage());
        }

    }

    public void insert2(String account, String cinemaName, String time, String movieName, String date, String seat) {
        try {
            String strSelect = "INSERT INTO ticket (account,cinemaName, time, movieName, date, seatName) VALUES (?,?,?,?,?,?)";
            pstm = cnn.prepareStatement(strSelect);

            pstm.setString(1, account);
            pstm.setString(2, cinemaName);
            pstm.setString(3, time);
            pstm.setString(4, movieName);
            pstm.setString(5, date);
            pstm.setString(6, seat);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Insert2 error:" + e.getMessage());
        }

    }

    public ArrayList<ticket> getAll() {
        ArrayList<ticket> list = new ArrayList<ticket>();
        try {
            String strSelect = "select * from ticket";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ticketID = rs.getString(1);
                String account = rs.getString(2);
                String cinemaName = rs.getString(3);
                String time = rs.getString(4);
                String movieName = rs.getString(5);
                String date = rs.getString(6);
                String seatName = rs.getString(7);
                ticket s = new ticket(ticketID, account, cinemaName, time, movieName, date, seatName);
                list.add(s);
            }
        } catch (Exception e) {
            System.out.print("getAllTicket error" + e.getMessage());
        }
        return list;
    }

    public ArrayList<ticket> getListHistoryBooking(String getaccount) {
        ArrayList<ticket> list = new ArrayList<ticket>();
        try {
            String strSelect = "select * from ticket\n"
                    + "  where account = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, getaccount);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ticketID = rs.getString(1);
                String account = rs.getString(2);
                String cinemaName = rs.getString(3);
                String time = rs.getString(4);
                String movieName = rs.getString(5);
                String date = rs.getString(6);
                String seatName = rs.getString(7);
                String bookingdate = rs.getString(8);
                String bookingtime = rs.getString(9);
                ticket s = new ticket(ticketID, account, cinemaName, time, movieName, date, seatName, bookingdate, bookingtime);
                list.add(s);
            }
        } catch (Exception e) {
            System.out.print("getAllTicket error" + e.getMessage());
        }
        return list;
    }

}
