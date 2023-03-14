/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import jakarta.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Contain extends DBContext {

    String id, studentId, courseId, semester, time, slot, attendance, classed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getClassed() {
        return classed;
    }

    public void setClassed(String classed) {
        this.classed = classed;
    }

    public Contain(String id, String courseId, String time, String slot, String attendance, String classed) {
        this.id = id;
        this.courseId = courseId;
        this.time = time;
        this.slot = slot;
        this.attendance = attendance;
        this.classed = classed;
        connectDB();
    }

    public Contain() {
        connectDB();
    }

    public Contain(String courseId, String time, String slot, String attendance, String classed) {
        this.courseId = courseId;
        this.time = time;
        this.slot = slot;
        this.attendance = attendance;
        this.classed = classed;
        connectDB();
    }

    public Contain(String id, String studentId, String courseId, String semester, String time, String slot, String attendance, String classed) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
        this.time = time;
        this.slot = slot;
        this.attendance = attendance;
        this.classed = classed;
        connectDB();
    }

    public Contain(String studentId, String time, String slot) {
        this.studentId = studentId;
        this.time = time;
        this.slot = slot;
        connectDB();
    }

    public Contain(String time, String slot, String attendance, String classed) {
        this.time = time;
        this.slot = slot;
        this.attendance = attendance;
        this.classed = classed;
        connectDB();
    }

    public Contain(String courseId) {
        this.courseId = courseId;
        connectDB();
    }

    public Contain(String courseId, String time) {
        this.courseId = courseId;
        this.time = time;
        connectDB();
    }

    Connection cnn; //Ket noi DB
    Statement stm;//Thuc hien cau lenh SQL

    ResultSet rs;//Luu TRu va xu li du lieu
    PreparedStatement pstm;

    private void connectDB() {
        try {
            cnn = super.connection;
            System.out.println("Conncet success");
        } catch (Exception e) {
            System.out.println("Connect err: " + e.getMessage());
        }
    }

    public ArrayList<Contain> getbyStudentId(String studentId) {
        ArrayList<Contain> list = new ArrayList<>();
        try {
            String strSelect = "select * from Contain where studentId = ?  ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String studentid = rs.getString(2);
                String courseId = rs.getString(3);
                String semester = rs.getString(4);
                String time = rs.getString(5);
                String slot = rs.getString(6);
                String attendance = rs.getString(7);
                String classed = rs.getString(8);

                Contain c = new Contain(id, studentid, courseId, semester, time, slot, attendance, classed);
                list.add(c);

            }
        } catch (Exception e) {
            System.err.println("Get all error" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Contain> getTimebyStudentId(String studentId) {
        ArrayList<Contain> list = new ArrayList<>();
        try {
            String strSelect = "select distinct time, studentId from Contain where studentId = ?  \n"
                    + "order by time";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String time = rs.getString(1);
                String studentid = rs.getString(2);

                Contain c = new Contain(studentid, time);
                list.add(c);

            }
        } catch (Exception e) {
            System.err.println("Get all error" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Contain> getTimeTable(String studentId, String start, String end) {
        ArrayList<Contain> list = new ArrayList<>();
        try {
            String strSelect = "select * from Contain \n"
                    + "where studentId = ?\n"
                    + "and time BETWEEN ? AND ?\n"
                    + "order by time , slot ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            pstm.setString(2, start);
            pstm.setString(3, end);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String studentid = rs.getString(2);
                String courseId = rs.getString(3);
                String semester = rs.getString(4);
                String time = rs.getString(5);
                String slot = rs.getString(6);
                String attendance = "attended";
                if (!rs.getBoolean(7)) {
                    attendance = "absent";
                }
                String classed = rs.getString(8);

                Contain c = new Contain(id, studentid, courseId, semester, time, slot, attendance, classed);
                list.add(c);

            }
        } catch (Exception e) {
            System.err.println("Get all error" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Contain> getbyCourse(String course) {
        ArrayList<Contain> list = new ArrayList<>();
        try {
            String strSelect = "select * from Contain where courseId  = ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, courseId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                this.id = rs.getString(1);
                this.studentId = rs.getString(2);
                this.courseId = rs.getString(3);
                this.semester = rs.getString(4);
                this.time = rs.getString(5);
                this.slot = rs.getString(6);
                this.attendance = rs.getString(7);
                this.classed = rs.getString(8);

                Contain c = new Contain(time, slot, attendance, classed);
                list.add(c);

            }
        } catch (Exception e) {
            System.err.println("Get all error" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Contain> getbyClassed(String classed) {
        ArrayList<Contain> list = new ArrayList<>();
        try {
            String strSelect = "select * from Contain where classed = ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, classed);
            rs = pstm.executeQuery();
            while (rs.next()) {
                this.id = rs.getString(1);
                this.studentId = rs.getString(2);
                this.courseId = rs.getString(3);
                this.semester = rs.getString(4);
                this.time = rs.getString(5);
                this.slot = rs.getString(6);
                this.attendance = rs.getString(7);

                Contain c = new Contain(studentId, time, slot);
                list.add(c);

            }
        } catch (Exception e) {
            System.err.println("Get all error" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Contain> getCourse() {
        ArrayList<Contain> list = new ArrayList<Contain>();
        try {
            String strSelect = "Select DISTINCT courseID from Contain ";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String courseId = rs.getString(1);

                Contain p = new Contain(courseId);
                list.add(p);
            }
        } catch (Exception e) {
            System.err.println("Get all error" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Contain> getCourse1(String courseId,String studentId) {
        ArrayList<Contain> list = new ArrayList<>();
        try {
            String strSelect = "select courseID,[time], [slot], [attendance],[classed] from Contain \n"
                    + "where courseId = ? and studentId = ?  ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, courseId);
            pstm.setString(2, studentId);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String course = rs.getString(1);
                String time = rs.getString(2);
                String slot = rs.getString(3);
                String attendance = rs.getString(4);
                String classed = rs.getString(5);

                Contain p = new Contain(course, time, slot, attendance, classed);
                list.add(p);
            }
        } catch (Exception e) {
            System.err.println("Get category error" + e.getMessage());
        }
        return list;

    }

}
