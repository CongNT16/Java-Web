/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class User extends DBContext{
    
    String studentId, password, name , gender, dob,address, campus, email, enroll;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

   
   

    public User(String studentId, String password, String name, String gender, String dob, String address, String campus, String email, String enroll) {
        this.studentId = studentId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.campus = campus;
        this.email = email;
        this.enroll = enroll;
    }

  

    public User() {
        connectDB();
    }

    public User(String studentId, String password, String name, String gender, String dob, String address, String campus, String email) {
        this.studentId = studentId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.campus = campus;
        this.email = email;
        connectDB();
    }

    
    
    public User(String studentId, String password, String name, String gender, String dob, String address, String campus) {
        this.studentId = studentId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.campus = campus;
        connectDB();
    }

    public User(String studentId, String password) {
        this.studentId = studentId;
        this.password = password;
        connectDB();
    }

    public User(String studentId, String password, String campus) {
        this.studentId = studentId;
        this.password = password;
        this.campus = campus;
        connectDB();
    }

    public User(String studentId, String password, String campus, String enroll) {
        this.studentId = studentId;
        this.password = password;
        this.campus = campus;
        this.enroll = enroll;
        connectDB();
    }

    
    
  

    
    
    
  
    
//Khai bao cac thanh phan xu li DB
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

    public boolean checklogin() {

  try {
            String strSelect="select * from  Students "
                    +"where studentId = ? and  "
                    +"password =? and "
                    +"campus = ? ";
            pstm =cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            pstm.setString(2, password);
            pstm.setString(3, campus);
            rs=pstm.executeQuery();
            while (rs.next())
                //Tai khoan khong ton tai
                return true;
        } catch (Exception e) {
            System.out.println("Login err:"+e.getMessage());
        }
        return false;
    }

    public boolean checkUser(String studentId, String dob) {
         try {
            String strSelect="select * from  Students "
                    +"where studentId = ? and  "
                    +"DoB =?";
            pstm =cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
             pstm.setString(2, dob);
            rs=pstm.executeQuery();
            while (rs.next())
                //Tai khoan khong ton tai
                return true;
        } catch (Exception e) {
            System.out.println("Login err:"+e.getMessage());
        }
        return false;
    
    }
     public boolean checkUser(String studentId) {
         try {
            String strSelect="select * from  Students "
                    +"where studentId = ?" ;
            pstm =cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            
            rs=pstm.executeQuery();
            while (rs.next())
                //Tai khoan khong ton tai
                return true;
        } catch (Exception e) {
            System.out.println("Login err:"+e.getMessage());
        }
        return false;
    
    }

    public void update(String studentId, String newpass) {
         try {
            String strSelect="update Students "
                    +"set password=? "
                    +"where studentId = ? ";
            pstm =cnn.prepareStatement(strSelect);
            pstm.setString(1, newpass);
             pstm.setString(2, studentId);
            pstm.execute();
                //Tai khoan khong ton tai
              
        } catch (Exception e) {
            System.out.println("Update err:"+e.getMessage());
        }
    }
    public void create(String studentId,String password, String name ,String gender, String dob, String address, String campus){
        try {
                String strSelect="insert into Students " 
                    + "values(?,?,?,?,?,?,?) ";

              pstm =cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            pstm.setString(2, password);
            pstm.setString(3, name);
            pstm.setString(4, gender);
            pstm.setString(5, dob);
            pstm.setString(6, address);
            pstm.setString(7, campus);
            pstm.execute();
        } catch (Exception e) {
              System.out.println("Create err:"+e.getMessage());
        }
    }

    
    public boolean checkUser2(String studentId, String password) {
        try{
            String strSelect="select * from Students " 
                    + "where studentId= ? and "      
                    + "password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);           
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while(rs.next()){
                //tài khoản tồn tại
                return true;
            }
            
            
        }catch(Exception e){
            System.out.println("check error : " + e.getMessage());     
            
        }
        
        return false;
    }
public ArrayList <User> getAll(){
    ArrayList <User> list =  new ArrayList<User>();
    try {
        String strSelect ="select  studentId,campus from Students ";
      pstm = cnn.prepareStatement(strSelect);
      rs = pstm.executeQuery();
      while(rs.next()){
      String studentId =rs.getString(1);
      String campus =rs.getString(2);
      User u = new User(studentId, campus);
      list.add(u);
              }
    } catch (Exception e) {
         System.out.println("GetAll error : " + e.getMessage()); 
    }
    return list;
}

    public void getDetail(String studentId) {
       try {
            String strSelect = "select * from Students where studentId=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                this.studentId = rs.getString(1);
                this.password = rs.getString(2);
                this.name = rs.getString(3);
                this.gender = rs.getString(4);
                this.dob = rs.getString(5);
                this.address = rs.getString(6);
                this.campus = rs.getString(7);
                this.email = rs.getString(8);
                this.enroll = rs.getString(9);
               
                System.out.println("Thanh cong");
            }
        } catch (Exception e) {
            System.err.println("Get all error" + e.getMessage());
        }
    }
        
}
