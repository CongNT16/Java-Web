/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Course extends DBContext{
    String courseID,  coursename , credit , fee;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Course(String courseID, String coursename, String credit, String fee) {
        this.courseID = courseID;
        this.coursename = coursename;
        this.credit = credit;
        this.fee = fee;
        connectDB();
    }

    public Course() {
        connectDB();
    }
    
    
    
     Connection cnn; //Ket noi DB
    Statement  stm;//Thuc hien cau lenh SQL
    
    ResultSet rs;//Luu TRu va xu li du lieu
    PreparedStatement pstm;
    private void connectDB() {
        try {
            cnn =super.connection;
            System.out.println("Conncet success");
        } catch (Exception e) {
            System.out.println("Connect err: " +e.getMessage());
        }
    }
    
    public ArrayList<Course> getAll() {
        ArrayList<Course> list = new ArrayList<Course>();  
        try {
            String strSelect = "select * from Course";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String courseID = rs.getString(1);
                String coursename = rs.getString(2);
                String credit = rs.getString(3);
                String fee = rs.getString(4);
          
                Course c = new Course(courseID, coursename, credit, fee);
                list.add(c);
            }
        } catch (Exception e) {
            System.err.println("Get all error" + e.getMessage());
        }
        return list;
    }
}
