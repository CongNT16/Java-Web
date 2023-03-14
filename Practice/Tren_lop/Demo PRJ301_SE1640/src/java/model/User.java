/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import javax.xml.transform.Result;
//import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author nguye
 */
public class User extends DBContext{
    String account,password,name,gender,dob,address;

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    public User() {
        connectDB();
    }

    public User(String account, String password, String name, String gender, String dob, String address) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
        connectDB();
    }
    
    //Khai bao cac thanh phan xu ly
    
    Connection cmn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;
    
    private void connectDB(){
        try {
            
            cmn=super.connection;
            System.out.println("Connect success");
            
        } catch (Exception e) {
            System.out.println("Connect error : " + e.getMessage());
        }
    }

    public boolean checklogin() {
//        try{
//            String strSelect="select * from Users " 
//                    + "where account= '"+account+"' and "
//                    + "password='"+password+"'";
//            stm = cmn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            rs = stm.executeQuery(strSelect);
//            while(rs.next()){
//                //tài khoản tồn tại
//                return true;
//            }
//            
//            
//        }catch(Exception e){
//            System.out.println("Login error : " + e.getMessage());     
//            
//        }
//        return false;

        try{
            String strSelect="select * from Users " 
                    + "where account= ? and "
                    + "password= ?";
            pstm = cmn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while(rs.next()){
                //tài khoản tồn tại
                return true;
            }
            
            
        }catch(Exception e){
            System.out.println("Login error : " + e.getMessage());     
            
        }
        
        return false;
    }

    public boolean checkUser(String account, String dob) {
        try{
            String strSelect="select * from Users " 
                    + "where account= ? and "      
                    + "dateofbirth=?";
            pstm = cmn.prepareStatement(strSelect);
            pstm.setString(1, account);           
            pstm.setString(2, dob);
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
    
    public boolean checkUser2(String account, String pass) {
        try{
            String strSelect="select * from Users " 
                    + "where account= ? and "      
                    + "password=?";
            pstm = cmn.prepareStatement(strSelect);
            pstm.setString(1, account);           
            pstm.setString(2, pass);
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

    public void update(String account, String newpass) {
        try{
            String strSelect="update Users " 
                    + "set password= ? "
                    + "where account= ?";
            pstm = cmn.prepareStatement(strSelect);
            pstm.setString(1, newpass);
            pstm.setString(2, account);
            pstm.execute();
            
            
            
        }catch(Exception e){
            System.out.println("update error : " + e.getMessage());     
            
        }
        
        
    }

    public void insert(String account, String pass, String name, String gender, String address, String dob) {
        try{
            String strSelect="insert into Users " 
                    + "values(?,?,?,?,?,?) ";
            pstm = cmn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, pass);
            pstm.setString(3, name);
            pstm.setString(4, gender);
            pstm.setString(5, address);
            pstm.setString(6, dob);
            pstm.execute();
            
            
            
        }catch(Exception e){
            System.out.println("update error : " + e.getMessage());     
            
        }
    }
    
    
//    public ArrayList <User> getAll(){
//        
//        ArrayList<User> list = new ArrayList<User>();
//        
//        try{
//            String strSelect = "select * from Users";
//            pstm = cmn.prepareStatement(strSelect);
//            rs = pstm.executeQuery();
//            while(rs.next()){
//                
//                String account = rs.getString(1);
//                String pass = rs.getString("password");
//                String name = rs.getString(3);
//                String gender = "Male";
//                if(!rs.getBoolean(4)){
//                    gender = "Female";
//                }
//                
//                String address = rs.getString(5);
//                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
//                String dob = "";
//                if(rs.getDate(6)!=null){
//                     dob = f.format(rs.getDate(6));
//                }
//                
//                User u = new User(account, pass, name, gender, dob, address);
//                list.add(u);
//                
//                
//                
//            }
//            
//        }catch(Exception e){
//            System.out.println("GetAll error :" +e.getMessage());
//        }
//        return list;
//    }
    
     public ArrayList<User> getAll(){
        ArrayList<User> list = new ArrayList<User>();
        try{
            String strSelect = "select * from Users";
            pstm = cmn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while(rs.next()){
                String account = rs.getString(1);
                String pass = rs.getString("password");
                String name = rs.getString(3);
                String gender = "Male";
                if(!rs.getBoolean(4)){
                    gender = "Female";
                }
                String address = rs.getString(5);
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                String dob = "";
                if(rs.getDate(6) != null){
                    dob = f.format(rs.getDate(6));
                }
                User u = new User(account, pass, name, gender, dob, address);
                list.add(u);
            }
        }catch(Exception e){
            System.out.println("GetAll error :" +e.getMessage());
        }
        return list;
    }
    
    
}
