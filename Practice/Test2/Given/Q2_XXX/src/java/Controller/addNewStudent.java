/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Department;
import Model.Employee;
import Model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class addNewStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student s = new Student();
        Department d = new Department();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String did = req.getParameter("did");
        
        s.insertStudent(id,name,gender,did);
        
        ArrayList<Department> listDepartment = (ArrayList<Department>) d.getAllDeparment();
        req.setAttribute("listDepartment", listDepartment);

        ArrayList<Student> listStudent = (ArrayList<Student>) s.getAllStudent();
        req.setAttribute("listStudent", listStudent);
                
        req.getRequestDispatcher("addNewStudent.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Department d = new Department();
        Employee e = new Employee();
        Student s = new Student();

        ArrayList<Department> listDepartment = (ArrayList<Department>) d.getAllDeparment();
        req.setAttribute("listDepartment", listDepartment);

        ArrayList<Student> listStudent = (ArrayList<Student>) s.getAllStudent();
        req.setAttribute("listStudent", listStudent);

        
        req.getRequestDispatcher("addNewStudent.jsp").forward(req, resp);
    }

}
