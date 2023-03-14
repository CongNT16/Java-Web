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

/**
 *
 * @author Admin
 */
public class Parent extends DBContext {
    String id , name , phonenummber,address,email,job,placeWork;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenummber() {
        return phonenummber;
    }

    public void setPhonenummber(String phonenummber) {
        this.phonenummber = phonenummber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }

    public Parent(String id, String name, String phonenummber, String address, String email, String job) {
        this.id = id;
        this.name = name;
        this.phonenummber = phonenummber;
        this.address = address;
        this.email = email;
        this.job = job;
        connectDB();
    }

    public Parent() {
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
}
