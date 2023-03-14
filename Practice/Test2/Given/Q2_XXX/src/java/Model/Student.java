/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Student extends DBContext{
    public String id;
    public String name;
    public String gender;
    public String did;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDid() {
        return did;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public Student() {
        connectDB();
    }

    public Student(String id, String name, String gender, String did) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.did = did;
    }
    
    //Khai bao cac thanh phan xu ly
    
    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;
    
    private void connectDB(){
        try {
            
            cnn=super.connection;
            System.out.println("Connect success");
            
        } catch (Exception e) {
            System.out.println("Connect error : " + e.getMessage());
        }
    }
    
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> liststudent = new ArrayList<Student>();
        try {
            String strSelect = "select * from Student";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String gender = "true";
                if (!rs.getBoolean(3)) {
                    gender = "false";
                }
                String did = rs.getString(4);
                Student s = new Student(id, name, gender, did);
                liststudent.add(s);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return liststudent;
    }

    public void insertStudent(String id, String name, String gender, String did) {
        try{
            String strSelect="insert into Student " 
                    + "values(?,?,?,?) ";
            pstm = cnn.prepareStatement(strSelect);
            
            pstm.setString(1, id);
            pstm.setString(2, name);
            pstm.setString(3, gender);
            pstm.setString(4, did);
            pstm.execute();
            
            
            
        }catch(Exception e){
            System.out.println("update error : " + e.getMessage());     
            
        }
    }
    
}
